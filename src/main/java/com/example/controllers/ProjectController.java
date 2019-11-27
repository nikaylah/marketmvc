package com.example.controllers;

import com.example.domain.Project;
import com.example.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping("/project/list")
    public String listProjects(Model model){
        model.addAttribute("projects", projectService.listAll());
        return "project/list";
    }

    @RequestMapping("/project/show/{id}")
    public String getProject(@PathVariable Integer id, Model model){
        model.addAttribute("project", projectService.getById(id));
        return "project/show";
    }

    @RequestMapping("project/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("project", projectService.getById(id));
        return "project/projectform";
    }

    @RequestMapping("/project/new")
    public String newProject(Model model){
        model.addAttribute("project", new Project());
        return "project/projectform";
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public String saveOrUpdateProject(Project project){
        Project savedProject = projectService.saveOrUpdate(project);
        return "redirect:/project/show/" + savedProject.getId();
    }

    @RequestMapping("/project/delete/{id}")
    public String delete(@PathVariable Integer id){
        projectService.delete(id);
        return "redirect:/project/list";
    }
}