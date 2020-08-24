package com.sbs.projects;

import com.sbs.contracts.dto.ProjectDTO;
import com.sbs.contracts.dto.SprintDTO;
import com.sbs.contracts.dto.UserStoryDTO;

public interface ProjectController {

    Iterable<ProjectDTO> getAllProjects(Boolean withSprints);

    ProjectDTO getProjectById(Long projectId,Boolean withSprints);

    ProjectDTO createProject(ProjectDTO project);

    ProjectDTO updateProject(Long projectId, ProjectDTO project);

    void deleteProject(Long projectId);

    Iterable<SprintDTO> getAllSprints(Long projectId);

    SprintDTO getSprint(Long projectId, Long sprintId);

    SprintDTO createSprint(Long projectId, SprintDTO sprint);

    SprintDTO updateSprint(Long projectId, Long sprintId, SprintDTO sprint);

    void deleteSprint(Long projectId, Long sprintId);

    Iterable<UserStoryDTO> getProjectUserStories(Long projectId);

    UserStoryDTO createProjectUserStory(Long projectId, UserStoryDTO userStoryDTO);

    void deleteProjectUserStory(Long projectId, Long userStoryId);
}
