package com.workmotion.app.project;

import com.workmotion.app.project.crew.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private CrewService crewService;
    private MemberDTO memberDTO = new MemberDTO();

    {
        memberDTO.setId(7L);
    }

    @PostMapping("/projects")
    public ResponseEntity<ProjectDTO> createProject(ProjectDTO projectDTO, Long[] member_ids) throws Exception {
        projectDTO.setOwner_id(memberDTO.getId());
        int result = projectService.createProject(projectDTO);
        result = crewService.addCrew(projectDTO.getId(), member_ids);
        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }

    @GetMapping("/projects/{project_id}")
    public ResponseEntity<ProjectDTO> getProjectDetail(@PathVariable Long project_id, ProjectDTO projectDTO) throws Exception {
        projectDTO.setId(project_id);
        projectDTO = projectService.getProjectDetail(projectDTO);
        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }

    @GetMapping("/projects")
    public String getProjectList(ProjectDTO projectDTO, Model model) throws Exception {

        List<ProjectDTO> list = projectService.getProjectList(memberDTO);
        model.addAttribute("page", "project/index");
        model.addAttribute("list", list);
        return "index";
    }

    @PutMapping("/projects/{project_id}")
    public ResponseEntity<?> updateProject(@PathVariable Long project_id, ProjectDTO projectDTO) throws Exception {
        projectDTO.setId(project_id);
        int result = projectService.updateProject(projectDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/projects/{project_id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long project_id, ProjectDTO projectDTO) throws Exception {
        projectDTO.setId(project_id);
        int result = projectService.deleteProject(projectDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
