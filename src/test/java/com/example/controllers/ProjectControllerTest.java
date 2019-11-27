package com.example.controllers;

import com.example.domain.Project;
import com.example.services.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class ProjectControllerTest {

    @Mock //Mockito Mock object
    private ProjectService projectService;

    @InjectMocks //setups up controller, and injects mock objects into it.
    private ProjectController projectController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this); //initilizes controller and mocks

        mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
    }

    @Test
    public void testList() throws Exception{

        List<Project> projects = new ArrayList<>();
        projects.add(new Project());
        projects.add(new Project());

        //specific Mockito interaction, tell stub to return list of products
        when(projectService.listAll()).thenReturn((List) projects); //need to strip generics to keep Mockito happy.

        mockMvc.perform(get("/project/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("project/list"))
                .andExpect(model().attribute("projects", hasSize(2)));
    }

    @Test
    public void testShow() throws Exception{
        Integer id = 1;

        //tells Mockito stub to return new product for Id 1
        when(projectService.getById(id)).thenReturn(new Project());

        mockMvc.perform(get("/project/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("project/show"))
                .andExpect(model().attribute("project", instanceOf(Project.class)));
    }

    @Test
    public void testEdit() throws Exception{
        Integer id = 1;

        //Tell Mockito stub to return new product for ID 1
        when(projectService.getById(id)).thenReturn(new Project());

        mockMvc.perform(get("/project/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("project/projectform"))
                .andExpect(model().attribute("project", instanceOf(Project.class)));
    }

    @Test
    public void testNewProject() throws Exception {

        //should not call service
        verifyZeroInteractions(projectService);

        mockMvc.perform(get("/project/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("project/projectform"))
                .andExpect(model().attribute("project", instanceOf(Project.class)));
    }

    @Test
    public void testSaveOfUpdate() throws Exception {
        Integer id = 1;
        String description = "Test Description";
        BigInteger maxBudget = new BigInteger("100");
        String imageUrl = "example.com";

        Project returnProject = new Project();
        returnProject.setId(id);
        returnProject.setDescription(description);
        returnProject.setMaxBudget(maxBudget);
        returnProject.setImageUrl(imageUrl);

        when(projectService.saveOrUpdate(any())).thenReturn(returnProject);

        mockMvc.perform(post("/project")
                .param("id", "1")
                .param("description", description)
                .param("maxBudget", "100")
                .param("imageUrl", "example.com"))
                        .andExpect(status().is3xxRedirection())
                        .andExpect(view().name("redirect:/project/show/1"))
                        .andExpect(model().attribute("project", instanceOf(Project.class)))
                        .andExpect(model().attribute("project", hasProperty("id", is(id))))
                        .andExpect(model().attribute("project", hasProperty("description", is(description))))
                        .andExpect(model().attribute("project", hasProperty("maxBudget", is(maxBudget))))
                        .andExpect(model().attribute("project", hasProperty("imageUrl", is(imageUrl))));

                //verify properties of bound object
                ArgumentCaptor<Project> boundProduct = ArgumentCaptor.forClass(Project.class);
                verify(projectService).saveOrUpdate(boundProduct.capture());

                assertEquals(id, boundProduct.getValue().getId());
                assertEquals(description, boundProduct.getValue().getDescription());
                assertEquals(maxBudget, boundProduct.getValue().getMaxBudget());
                assertEquals(imageUrl, boundProduct.getValue().getImageUrl());
    }

    @Test
    public void testDelete() throws Exception{
        Integer id = 1;


        mockMvc.perform(get("/project/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/project/list"));

        verify(projectService, times(1)).delete(id);
    }

}
