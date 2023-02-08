package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.maincas.maincasapi.catalogs.model.PartNumberUserComment;

public interface PartNumberUserCommentRepository extends PagingAndSortingRepository<PartNumberUserComment, Long> {
  List<PartNumberUserComment> findByPartNumberId(Long partNumberId);
}
