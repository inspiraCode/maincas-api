package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.MaterialUserComment;

public interface MaterialUserCommentRepository extends JpaRepository<MaterialUserComment, Long> {
  List<MaterialUserComment> findByMaterialId(Long materialId);
}
