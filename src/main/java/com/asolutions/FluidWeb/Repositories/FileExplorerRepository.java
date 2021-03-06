package com.asolutions.FluidWeb.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asolutions.FluidWeb.Entities.FileExplorer;
import com.asolutions.FluidWeb.Entities.FileExplorerPK;

@Repository
public interface FileExplorerRepository extends CrudRepository<FileExplorer, FileExplorerPK> {

	List<FileExplorer> findByIdPid(String pid);
	List<FileExplorer> findByIdPidAndParentId(String pid, String parentId);
	FileExplorer findByIdPidAndId_itemId(String pid, String itemId);
	@Transactional
	@Modifying
    @Query(value = "SELECT c.id , c.path , c.type , c.name FROM FileExplorer c WHERE UPPER(c.path) like %:path% and c.id.pid = :pid")
	List<Object[]> findByIdPidAndPath(@Param("path") String path, @Param("pid") String pid);
	@Transactional
	@Modifying
    @Query(value = "SELECT c.id , c.path , c.type , c.name FROM FileExplorer c WHERE UPPER(c.path) like %:path% and c.type =:type and c.id.pid = :pid")
	List<Object[]> findByIdPidAndTypeAndPath(@Param("pid") String pid, @Param("type") String type, @Param("path") String path);	
}
