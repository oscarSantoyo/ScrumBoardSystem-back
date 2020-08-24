package com.sbs.userStories;

import com.sbs.contracts.dto.TaskDTO;
import com.sbs.contracts.dto.UserStoryDTO;
import com.sbs.userStories.services.TaskService;
import com.sbs.userStories.services.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserStoryControllerImpl implements UserStoryController{

  @Autowired
  private UserStoryService userStoryService;

  @Autowired
  private TaskService taskService;


  @GetMapping(value = "/userstories", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public Iterable<UserStoryDTO> getAllUsersStories() {
    return userStoryService.getAllUserStories();
  }

  @GetMapping(value = "/userstories", produces = MediaType.APPLICATION_JSON_VALUE, params = {"ids"})
  @Override
  public Iterable<UserStoryDTO> getUserStoriesByIds(@RequestParam List<Long> ids) {
    return userStoryService.getByIds(ids);
  }

  @GetMapping(value = "/userstories/{userStoryId}")
  @Override
  public UserStoryDTO getUserStory(@PathVariable Long userStoryId) {
    return userStoryService.getUserStoryById(userStoryId);
  }

  @PostMapping(value = "/userstories")
  @Override
  public UserStoryDTO createUserStory(@RequestBody UserStoryDTO UserStoryDTO) {
    return userStoryService.createUserStory(UserStoryDTO);
  }

  @PutMapping(value = "/userstories/{userStoryId}")
  @Override
  public UserStoryDTO updateUserStory(@RequestBody UserStoryDTO userStoryDTO, @PathVariable Long userStoryId) {
    return userStoryService.updateUserStory(userStoryDTO, userStoryId);
  }

  @DeleteMapping(value = "/userstories/{userStoryId}")
  @Override
  public void deleteUserStory(@PathVariable Long userStoryId) {
    userStoryService.deleteUserStoById(userStoryId);
  }

  @GetMapping(value = "/userstories/{userStoryId}/tasks")
  @Override
  public Iterable<TaskDTO> getAllTaks(@PathVariable Long userStoryId) {
    return taskService.getAll(userStoryId);
  }

  @GetMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
  @Override
  public TaskDTO getTask(@PathVariable Long userStoryId, @PathVariable Long taskId) {
    return taskService.getById(userStoryId, taskId);
  }

  @PostMapping(value = "/userstories/{userStoryId}/tasks")
  @Override
  public TaskDTO createTask(@PathVariable Long userStoryId, @RequestBody TaskDTO TaskDTO) {
    return taskService.create(userStoryId, TaskDTO);
  }

  @PutMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
  @Override
  public TaskDTO updateTask(@PathVariable Long userStoryId, @PathVariable Long taskId, @RequestBody TaskDTO TaskDTO) {
    return taskService.updateUserStoryTask(userStoryId, taskId, TaskDTO);
  }

  @DeleteMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
  @Override
  public void deleteTask(@PathVariable Long userStoryId, @PathVariable Long taskId) {
    taskService.deleteById(userStoryId, taskId);
  }
}
