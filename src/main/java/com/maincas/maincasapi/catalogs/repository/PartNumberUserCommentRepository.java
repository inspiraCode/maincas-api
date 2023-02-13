package com.maincas.maincasapi.catalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maincas.maincasapi.catalogs.model.PartNumberUserComment;

public interface PartNumberUserCommentRepository extends JpaRepository<PartNumberUserComment, Long> {
  List<PartNumberUserComment> findByPartNumberId(Long partNumberId);
}
