package com.juanvictordev.vuttrapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.juanvictordev.vuttrapi.entity.Tools;

public interface ToolsRepository extends JpaRepository<Tools, Integer>{
  
  // METODO COM QUERY PERSONALIZADA, PARA TRAZER TODAS AS TOOLS QUE POSSUEM UMA DETERMINADA TAG 
  // QUANDO SE USA SQL NATIVO PARA PAGINATION, PRECISA COLOCAR O PARAMETRO NATIVEQUERY
  // COM A CONTAGEM DE DADOS PARA EVITAR BUG AO PASSAR VALORES COMO PARAMETRO NA URL
  @Query(
    value = 
      "SELECT tools.* FROM tools INNER JOIN tool_tag " +
      "ON tools.tool_id = tool_tag.tool_id WHERE tool_tag.tag_name = :tag",
    countQuery = 
      "SELECT count(*) FROM tools INNER JOIN tool_tag " + 
      "ON tools.tool_id = tool_tag.tool_id WHERE tool_tag.tag_name = :tag",
    nativeQuery = true
  )
  Page<Tools> findByTagName(@Param("tag") String tag, Pageable pageable);
}
