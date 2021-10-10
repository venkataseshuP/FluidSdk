package com.asolutions.InvoiceDesigner.RestControllers;

import java.util.HashMap;
import java.util.List;
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
import com.asolutions.InvoiceDesigner.Entities.Template;
import com.asolutions.InvoiceDesigner.Repositories.FileExplorerRepository;

@RestController
@CrossOrigin(origins = "*")
public class FileExplorerRestController {
	
	@Autowired
	private FileExplorerRepository fileExplorerRepository;
	
	@Autowired
	private SwaggerSpecController swaggerSpecController;
	
	@Autowired
	private TemplateRestController templateRestController;
	
	@Autowired
	private FavouriteRestController favouriteRestController; 
	
	@PostMapping(value="/{pid}/file",
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public FileExplorer createFile(@RequestBody FileExplorer fileExplorer, @PathVariable String pid){
		FileExplorerPK fileExplorerPK =  new FileExplorerPK();
		fileExplorerPK.setPid(pid);
        UUID uuid = UUID.randomUUID();
		fileExplorerPK.setItemId(uuid.toString());
		fileExplorer.setId(fileExplorerPK);
		String path = getFileFullPath(fileExplorer.getParentId(), pid)+"/"+fileExplorer.getName()+getFileExtensionsByType(fileExplorer.getType());
		fileExplorer.setPath(path);
		createFileByType(fileExplorer);
		return fileExplorerRepository.save(fileExplorer);
	}
	
	private void createFileByType(FileExplorer file) {
		if(file == null) return;
		switch (file.getType()) {
		case "2":
			Template template =  new Template();
			template.setTemplateId(file.getId().getItemId());
			this.templateRestController.createTemplate(template);
			break;
		default:
			break;
		}
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
		String path = getFileFullPath(fileExplorer.getParentId(), fileExplorer.getId().getPid())+"/"+fileExplorer.getName()+getFileExtensionsByType(fileExplorer.getType());
		fileExplorer.setPath(path);
		fileExplorerRepository.save(fileExplorer);
		if(fileExplorer.getType().equals("1")) {
			updatePaths(fileExplorer);
		}
		return (fileExplorer);
	}
	
	@DeleteMapping(value="/{pid}/file/{itemId}",			
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, String> deleteFile(@PathVariable String itemId, @PathVariable String pid) {
		Map<String, String> output =  new HashMap<String, String>();
		try {
			FileExplorerPK explorerPK =  new FileExplorerPK();
			explorerPK.setItemId(itemId);
			explorerPK.setPid(pid);
			deleteFavourites(explorerPK);			
			fileExplorerRepository.deleteById(explorerPK);			
			deleteFileByType(fileExplorerRepository.findById(explorerPK).get());
			output.put("status", "success") ;
		} catch (Exception e) {
			// TODO: handle exception
			output.put("status", "failed") ;
		}		
		return output;
	}
	
	private void deleteFavourites(FileExplorerPK explorerPK) {
		favouriteRestController.deleteFavouriteByItemId(explorerPK.getPid(), explorerPK.getItemId());		
	}
		
	private void deleteFileByType(FileExplorer file) {
		if(file == null) return;
		switch (file.getType()) {
		case "4":
			this.swaggerSpecController.deleteFile(file.getId().getItemId(), file.getId().getPid());
			break;
		default:
			break;
		}
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
		if(!path.isEmpty()) {
			path.append(getfileExtenstion(itemId,pid));
		}
		return path.toString();
		
	}
	
	private String getfileExtenstion(String itemId, String pid) {

		Optional<FileExplorer> explorer = null;
		FileExplorerPK explorerPK = new FileExplorerPK();
		explorerPK.setItemId(itemId);
		explorerPK.setPid(pid);
		explorer = fileExplorerRepository.findById(explorerPK);
		return getFileExtensionsByType(explorer.get().getType());
	}
	
	private String getFileExtensionsByType(String type) {
		switch (type) {
		case "2":
			return ".dt";
		case "4":
			return ".spec";
		}
		return "";
	}
	
	@GetMapping(value="/{pid}/file/parent/{itemId}",			
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public Optional<FileExplorer> getFileParentDetails(@PathVariable String pid, @PathVariable String itemId ){
		try {
			Optional<FileExplorer> explorer =  Optional.empty();
			FileExplorerPK explorerPK =  new FileExplorerPK();
			explorerPK.setItemId(itemId);
			explorerPK.setPid(pid);
			explorer = fileExplorerRepository.findById(explorerPK);
			if(explorer.isEmpty()) {
				return null;
			}
			explorerPK.setItemId(explorer.get().getParentId());
			return fileExplorerRepository.findById(explorerPK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;		
		
	}
	
	private void updatePaths(FileExplorer fileExplorer) {
		if(fileExplorer.getType().equals("1")) {			
			List<FileExplorer> childcFiles =  fileExplorerRepository.findByIdPidAndParentId(fileExplorer.getId().getPid(),fileExplorer.getId().getItemId());
			for(FileExplorer explorer: childcFiles) {			
				updatePaths(explorer);
			}
		}
		String path = getFileFullPath(fileExplorer.getParentId(), fileExplorer.getId().getPid())+"/"+fileExplorer.getName()+getFileExtensionsByType(fileExplorer.getType());
		fileExplorer.setPath(path);
		fileExplorerRepository.save(fileExplorer);
		return;
	}
	
	
	@PostMapping(value="/{pid}/filesByPath")
	public List<Object[]> getFilesBySamplePath(@RequestBody String samplepath,@PathVariable String pid) {
		return fileExplorerRepository.findByIdPidAndPath(samplepath, pid);
		
	}

}
