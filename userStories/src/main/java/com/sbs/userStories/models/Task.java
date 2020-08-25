package com.sbs.userStories.models;

import com.sbs.contracts.dto.TaskDTO;

import javax.persistence.*;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, precision = 1)
    private Double duration;
    @ManyToOne
    @JoinColumn(name = "userstory_id")
    private UserStory userStory;

    public Task() {
    }

    public Task(TaskDTO task) {
        this.id = task.getId();
        this.description = task.getDescription();
        this.duration = task.getDuration();
    }


    public Task(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }

    /**
     * Transforms the Task Entity to the TaskDTO Object
     * @return the DTO Task Object
     */
    public TaskDTO toDTO() {
        return new TaskDTO.Builder()
                .withId(this.id)
                .withDescription(this.description)
                .withDuration(this.duration)
                .build();
    }

    /**
     * Sets the mock relationship between the the Task and the User Story
     * @param userStoryId the User Story related id
     */
    public void setIsolatedUserStory(Long userStoryId) {
        UserStory userStory = new UserStory();
        userStory.setId(userStoryId);
        this.userStory = userStory;
    }
}
