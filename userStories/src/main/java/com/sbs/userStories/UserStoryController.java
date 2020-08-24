package com.sbs.userStories;
import com.sbs.contracts.dto.TaskDTO;
import com.sbs.contracts.dto.UserStoryDTO;
import java.util.List;

public interface UserStoryController {

    /**
     * Gets all the User Stories created
     * @return the DTO User Stories Objects
     */
    Iterable<UserStoryDTO> getAllUsersStories();

    /**
     * Gets all the Users Stories that match within the <code>ids</code>
     * list
     * @param ids the list of required IDs
     * @return the DTO User Stories Objects
     */
    Iterable<UserStoryDTO> getUserStoriesByIds( List<Long> ids);

    /**
     * Get the User Story by his <code>userStoryId</code>
     * @param userStoryId the requested User Story
     * @return the DTO User Story Object
     */
    UserStoryDTO getUserStory(Long userStoryId);

    /**
     * Creates the User Story
     * @param UserStoryDTO the DTO Object to store
     * @return the DTO User Story Object
     */
    UserStoryDTO createUserStory(UserStoryDTO UserStoryDTO);

    /**
     * Updates the User Story with the <code>userStoryId</code> with the new
     * data from <code>userStoryDTO</code>
     * @param userStoryDTO  the DTO Object with te new data
     * @param userStoryId   the requested User Story ID to be updated
     * @return the uptated DTO User Story Object
     */
    UserStoryDTO updateUserStory(UserStoryDTO userStoryDTO, Long userStoryId);

    /**
     * Deletes the User Story with the <code>userStor</code>
     * @param userStoryId the resquested User Story ID to be deleted
     */
    void deleteUserStory(Long userStoryId);

    /**
     * Gets all the Tasks related to a User Story by its <code>userStoryId</code>
     * @param userStoryId the requested User Story ID related to the tasks
     * @return the related DTO Tasks Objects
     */
    Iterable<TaskDTO> getAllTaks(Long userStoryId);

    /**
     * Gets the User Story's Task with the specified <code>taskId</code>
     * @param userStoryId the requested User Story ID related to the tasks
     * @param taskId the requested Task ID to be fetched
     * @return the DTO Task Object
     */
    TaskDTO getTask(Long userStoryId, Long taskId);

    /**
     * Creates a new Task related to a UserStory identified by <code>userStoryId</code>
     * @param userStoryId the requested User Story ID related to the tasks
     * @param TaskDTO the DTO Object with the data to be created
     * @return the created DTO Task object
     */
    TaskDTO createTask(Long userStoryId, TaskDTO TaskDTO);

    /**
     * Updates the attributes of the Task with the <code>taskId</code>
     * with the <code>TaskDTO</code> new set of data
     * @param userStoryId the requested User Story ID related to the tasks
     * @param taskId the requested Task ID to be updated
     * @param TaskDTO the DTO Object to with the new data
     * @return the updated DTO Task Object
     */
    TaskDTO updateTask(Long userStoryId, Long taskId, TaskDTO TaskDTO);

    /**
     * Deletes the specified Task with the <code>taskId</code>
     * @param userStoryId the requested User Story ID related to the tasks
     * @param taskId the requested Task ID to be deleted
     */
    void deleteTask(Long userStoryId,Long taskId);
}
