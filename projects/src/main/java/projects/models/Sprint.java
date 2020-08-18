package projects.models;

import com.sbs.contracts.dto.SprintDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Basic
    @Column(nullable = false)
    private LocalDate startDate;
    @Basic
    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Sprint() {
    }

    public Sprint(SprintDTO sprint) {
        this.id = sprint.getId();
        this.name = sprint.getName();
        this.startDate = sprint.getStartDate();
        this.endDate = sprint.getEndDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public SprintDTO toDTO() {
        return new SprintDTO.Builder()
                .withId(this.id)
                .withName(this.name)
                .withStartDate(this.startDate)
                .withEndDate(this.endDate)
                .build();
    }

    public void setIsolatedProject(Long projectId) {
        Project project = new Project();
        project.setId(projectId);
        this.project = project;
    }
}
