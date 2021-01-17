package com.umssonline.projmgt.services;


import com.umssonline.projmgt.exceptions.InvalidResourceException;
import com.umssonline.projmgt.feign.UsersFeignClient;
import com.umssonline.projmgt.models.entity.Backlog;
import com.umssonline.projmgt.models.entity.Project;
import com.umssonline.projmgt.models.entity.User;
import com.umssonline.projmgt.repositories.CommonRepository;
import com.umssonline.projmgt.repositories.ProjectRepository;
import com.umssonline.projmgt.repositories.SprintRepository;
import com.umssonline.projmgt.repositories.UserRepository;
import com.umssonline.projmgt.services.api.ProjectService;
import com.umssonline.projmgt.services.impl.ProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Project Service specification")
@SpringBootTest
public class ProjectServiceSpec {


    //region Constants
    private final String VALID_PROJECT_BACKLOG_DESCRIPTION = "Taller de programacion 335";
    private final int VALID_PROJECT_BACKLOG_INITIAL_AMOUNT_OF_STORIES = 0;
    private final LocalDateTime VALID_PROJECT_CREATED_UPDATED_AT = LocalDateTime.now();
    private final LocalDate VALID_PROJECT_COMPLETE_ESTIMATION = LocalDateTime.now().plusDays(10).toLocalDate();
    private final Long VALID_PROJECT_SAVED_ID = 10L;
    //endregion

    //region Test Properties
    private ProjectRepository projectRepository = mock(ProjectRepository.class);
    private UserRepository userRepository = mock(UserRepository.class);
    private CommonRepository commonRepository = mock(CommonRepository.class);
    private SprintRepository sprintRepository = mock(SprintRepository.class);
    private UsersFeignClient usersFeignClient = mock(UsersFeignClient.class);

    private ProjectService projectService;

    private Project validSavedProject;
    //endregion

    //region Test Setup
    @BeforeEach
    void setup() {
        this.projectService = new ProjectServiceImpl(projectRepository, userRepository, commonRepository, sprintRepository, usersFeignClient);
        this.validSavedProject = getValidProjectParameter();
        this.validSavedProject.setId(VALID_PROJECT_SAVED_ID);
    }
    //endregion

    //region Unit Tests

    //region Save Project Unit Tests
    @Nested
    @DisplayName("Unit Tests for Save Project feature")
    class SaveOperationSpec {

        @Test
        @DisplayName("When all properties of a project are configured correctly, " +
                     "it should return a non null project that contains an ID")
        void aProjectEntityIsReturnedWhenEverythingIsValid() {
            when(usersFeignClient.findById(getCreatedBy().getId())).thenReturn(getCreatedBy());
            when(userRepository.save(getCreatedBy())).thenReturn(getCreatedBy());
            when(projectRepository.save(getValidProjectParameter())).thenReturn(validSavedProject);

            Project project = projectService.save(getValidProjectParameter());

            assertAll(
                    () -> assertNotNull(project,
                            "Project should not be null when all its " +
                                    "properties are correctly configured"),
                    () -> assertEquals(VALID_PROJECT_SAVED_ID,
                            project.getId(),
                            "Saved project should contain an ID generated by database"),
                    () -> assertEquals(VALID_PROJECT_BACKLOG_INITIAL_AMOUNT_OF_STORIES,
                            project.getBacklog().getAmountOfUserStories(),
                            "When a project is recently created, it should not have any user stories"),
                    () -> assertEquals(VALID_PROJECT_BACKLOG_DESCRIPTION,
                            project.getBacklog().getDescription(),
                            "Once a new project is saved, it should contain: " + VALID_PROJECT_BACKLOG_DESCRIPTION)
            );
        }

        @Test
        @DisplayName("If the user that is creating the project does not exist, an exception is thrown.")
        void throwsExceptionWhenUserDoesNotExist() {

            InvalidResourceException throwException = assertThrows(
                    InvalidResourceException.class,
                    () -> projectService.save(getValidProjectParameter())
            );

            assertEquals("User with the specified ID could not be found.",
                    throwException.getMessage(),
                    "An exception should be thrown when a user that is creating the project does not exist.");
        }
    }
    //endregion

    //region FindById Unit Tests
    @Nested
    @DisplayName("Unit Tests for FindById feature")
    class FindByIdOperationSpec {

        @Test
        @DisplayName("When a project with the specified ID does not exist, an exception is thrown.")
        void throwsExceptionWhenSpecifiedIdDostNotExist() {
            Long someProjectId = 100L;

            EntityNotFoundException throwException = assertThrows(
                EntityNotFoundException.class,
                () -> projectService.findById(someProjectId)
            );

            assertEquals(
                "Project with specified ID does not exist.",
                throwException.getMessage(),
                "An exception should be thrown when a project with the specified ID does not exist."
            );
        }

        @Test
        @DisplayName("When the specified project ID is correct, then a Project Entity is returned.")
        void projectEntityIsReturnedWhenTheSpecifiedIdIsCorrect() {
            when(projectRepository.existsById(VALID_PROJECT_SAVED_ID)).thenReturn(true);
            when(projectRepository.getOne(VALID_PROJECT_SAVED_ID)).thenReturn(validSavedProject);

            Project project = projectService.findById(VALID_PROJECT_SAVED_ID);

            assertAll(
                () -> assertNotNull(project, "Project should not be null when ID is correct."),
                () -> assertEquals(VALID_PROJECT_SAVED_ID, project.getId(), "The project ID should be the specified one.")
            );
        }
    }
    //endregion
    //endregion

    //region Utilities
    private Project getValidProjectParameter() {
        Project project = Project.builder()
                .name("Project1")
                .completedDateEstimation(VALID_PROJECT_COMPLETE_ESTIMATION)
                .backlog(getBacklogForValidProject())
                .build();

        project.setIsDeleted(false);
        project.setCreatedAt(VALID_PROJECT_CREATED_UPDATED_AT);
        project.setUpdatedAt(VALID_PROJECT_CREATED_UPDATED_AT);
        project.setCreatedBy(getCreatedBy());
        project.setUpdatedBy(getCreatedBy());

        return project;
    }

    private Backlog getBacklogForValidProject() {
        Backlog backlog = Backlog.builder()
                .description(VALID_PROJECT_BACKLOG_DESCRIPTION)
                .amountOfUserStories(VALID_PROJECT_BACKLOG_INITIAL_AMOUNT_OF_STORIES)
                .build();

        backlog.setIsDeleted(false);
        backlog.setCreatedAt(VALID_PROJECT_CREATED_UPDATED_AT);
        backlog.setUpdatedAt(VALID_PROJECT_CREATED_UPDATED_AT);
        return backlog;
    }

    private User getCreatedBy() {
        return User.builder()
                .id(1L)
                .isDeleted(false)
                .build();
    }
    //endregion
}