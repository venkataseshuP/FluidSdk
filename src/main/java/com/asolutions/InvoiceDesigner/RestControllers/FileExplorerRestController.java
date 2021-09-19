package com.asolutions.InvoiceDesigner.RestControllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asolutions.InvoiceDesigner.Entities.FileExplorer;
import com.asolutions.InvoiceDesigner.Entities.FileExplorerPK;
import com.asolutions.InvoiceDesigner.Repositories.FileExplorerRepository;

@RestController
@CrossOrigin(origins = "*")
public class FileExplorerRestController {
	
	@Autowired
	private FileExplorerRepository fileExplorerRepository;
	
	@PostMapping(value="/{pid}/file",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public FileExplorer createFile(@RequestBody FileExplorer fileExplorer, @PathVariable String pid){
		FileExplorerPK fileExplorerPK =  new FileExplorerPK();
		fileExplorerPK.setPid(pid);
        UUID uuid = UUID.randomUUID();
		fileExplorerPK.setItemId(uuid.toString());
		fileExplorer.setId(fileExplorerPK);
		return fileExplorerRepository.save(fileExplorer);
	}
	
	@GetMapping(value="/{pid}/files",
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Iterable<FileExplorer> getFiles(@PathVariable String pid){
		return  fileExplorerRepository.findByIdPid(pid);	
	}
	
	@GetMapping(value="/{pid}/file/{itemId}")
	public Optional<FileExplorer> getFileById(@PathVariable String itemId,@PathVariable String pid) {
		FileExplorerPK explorerPK =  new FileExplorerPK();
		explorerPK.setPid(pid);
		explorerPK.setItemId(itemId);
		return fileExplorerRepository.findById(explorerPK);
		
	}
	
	@PostMapping(value="/{pid}/files",
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public String createFiles(@RequestBody FileExplorer[] fileExplorers) {
		for(FileExplorer fileExplorer:fileExplorers) {
			fileExplorerRepository.save(fileExplorer);
		}
		return "success";
	}
	
	@PutMapping(value="/{pid}/file",
			produces= {MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public FileExplorer updateFile(@RequestBody FileExplorer fileExplorer) {
		return fileExplorerRepository.save(fileExplorer);
	}
	
	@DeleteMapping(value="/{pid}/file/{itemId}",			
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, String> deleteFile(@PathVariable String itemId, @PathVariable String pid) {
		Map<String, String> output =  new HashMap<String, String>();
		try {
			FileExplorerPK explorerPK =  new FileExplorerPK();
			explorerPK.setItemId(itemId);
			explorerPK.setPid(pid);
			fileExplorerRepository.deleteById(explorerPK);
			output.put("status", "success") ;
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed") ;
		}		
		return output;
	}
	
	@GetMapping(value="/{pid}/file/path/{itemId}",			
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, String> getFilePath(@PathVariable String pid, @PathVariable String itemId ){
		Map<String, String> output =  new HashMap<String, String>();
		StringBuilder path = new StringBuilder();
		try {
			path.append(getFileFullPath(itemId, pid));			
			output.put("status", "success") ;
			output.put("path", path.toString());
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed") ;
		}		
		return output;
		
	}
	
	private String getFileFullPath(String itemId, String pid) {
		StringBuilder path =  new StringBuilder();
		
		if(itemId!= null && pid != null) {
			Optional<FileExplorer> explorer = null;
			FileExplorerPK explorerPK = new FileExplorerPK();
			explorerPK.setItemId(itemId);
			explorerPK.setPid(pid);
			explorer = fileExplorerRepository.findById(explorerPK);
			if(explorer.isPresent() && explorer.get().getParentId() != null) {
				path.append(getFileFullPath(explorer.get().getParentId(), pid));
			}
			path.append("/");
			path.append(explorer.get().getName());						
		}
		
		return path.toString();
		
	}
	

}
