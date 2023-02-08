package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.MaterialUserComment;

public interface MaterialUserCommentRepository extends PagingAndSortingRepository<MaterialUserComment, Long> {
  List<MaterialUserComment> findByMaterialId(Long materialId);
}
