package com.umssonline.proymgt.services;


import com.umssonline.proymgt.feign.UsersFeignClient;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.repositories.ProjectRepository;
import com.umssonline.proymgt.repositories.UserRepository;
import com.umssonline.proymgt.services.api.ProjectService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Project Service specification")
@SpringBootTest
public class ProjectServiceSpec {

    //region Test Properties
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UsersFeignClient usersFeignClient;


    @InjectMocks
    private ProjectService projectService;

    private Project validProject;
    //endregion


    //region Test Setup
    //endregion


    //region Unit Tests
    @DisplayName("When all properties of a project are configured correctly, " +
            "it should return a non null project that contains an ID")
    @Test
    public void aProjectEntityIsReturnedWhenEverythingIsValid() {
        Project project = projectService.save(validProject);

        assertNotNull(project,
                "Project should not be null when all its " +
                        "properties are correctly configured");
    }
    //endregion
}
