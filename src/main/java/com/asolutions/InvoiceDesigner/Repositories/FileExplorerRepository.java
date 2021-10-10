package com.asolutions.InvoiceDesigner.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asolutions.InvoiceDesigner.Entities.FileExplorer;
import com.asolutions.InvoiceDesigner.Entities.FileExplorerPK;

@Repository
public interface FileExplorerRepository extends CrudRepository<FileExplorer, FileExplorerPK> {

	List<FileExplorer> findByIdPid(String pid);
	List<FileExplorer> findByIdPidAndParentId(String pid, String parentId);
}
