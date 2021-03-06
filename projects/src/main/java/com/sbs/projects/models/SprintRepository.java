package com.sbs.projects.models;

import org.springframework.data.repository.CrudRepository;

public interface SprintRepository extends CrudRepository<Sprint, Long> {

    Iterable<Sprint> findByProjectId(Long projectId);
}
