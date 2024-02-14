package com.workmotion.app.project.controller;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.project.model.CustomResponse;
import com.workmotion.app.project.model.ProjectDTO;
import com.workmotion.app.project.service.CrewService;
import com.workmotion.app.project.service.ProjectService;
import com.workmotion.app.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects/*")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private CrewService crewService;
    private final CustomResponse customResponse = new CustomResponse();
    private final MemberDTO memberDTO = new MemberDTO();

    {
        memberDTO.setId(15L);
    }

    @GetMapping("create")
    public String createProject(Model model) throws Exception {
        List<MemberDTO> memberDTOList = crewService.getAllMemberList(memberDTO);
        model.addAttribute("members", memberDTOList);
        model.addAttribute("member", memberDTO);
        model.addAttribute("page", "project/createProject");
        return "index";
    }

    @PostMapping("create")
    public String createProject(ProjectDTO projectDTO, Model model) throws Exception {
        projectDTO.setOwner_id(memberDTO.getId());

        int result = projectService.createProject(projectDTO);
        if (!projectDTO.getCrew().isEmpty()) {
            result = crewService.addCrew(projectDTO.getId(), projectDTO.getCrew());
        }

        customResponse.setResult(result);
        customResponse.setMessage("프로젝트 생성");
        customResponse.setRedirectUrl("/projects/detail?id=" + projectDTO.getId());
        model.addAttribute("response", customResponse);
        model.addAttribute("page", "project/result");
        return "index";
    }

    @GetMapping("list")
    public String getProjectList(Model model) throws Exception {
        model.addAttribute("myProjects", projectService.getMyProjectList(memberDTO));
        model.addAttribute("includeProjects", projectService.getProjectList(memberDTO));
        List<ProjectDTO> dtos = projectService.getMyProjectList(memberDTO);
        for (ProjectDTO project : dtos) {
            System.out.println(project.getCrews().size());
            for (MemberDTO memberDTO1 : project.getCrews()) {
                System.out.println(memberDTO1.getName());
            }
        }
        model.addAttribute("page", "project/index");
        return "index";
    }

    @GetMapping("detail")
    public String getProjectDetail(Model model, ProjectDTO projectDTO) throws Exception {
        model.addAttribute("project", projectService.getProjectDetail(projectDTO));
        //model.addAttribute("tasks", taskService.getTaskList(projectDTO));
        model.addAttribute("crews", crewService.getCrewList(projectDTO));
        model.addAttribute("owner", crewService.getOwner(projectDTO));
        model.addAttribute("page", "project/task");
        return "index";
    }

    @GetMapping("setting")
    public String settingProject(Model model, ProjectDTO projectDTO) throws Exception {
        model.addAttribute("project", projectService.getProjectDetail(projectDTO));
        model.addAttribute("crews", crewService.getCrewList(projectDTO));
        model.addAttribute("page", "project/editProject");
        return "index";
    }

    @PostMapping("update")
    public String updateProject(Model model, ProjectDTO projectDTO) throws Exception {
        int result = projectService.updateProject(projectDTO);
        customResponse.setResult(result);
        customResponse.setRedirectUrl("/projects/setting?id=" + projectDTO.getId());
        customResponse.setMessage("프로젝트 수정");
        model.addAttribute("response", customResponse);
        model.addAttribute("page", "project/result");
        return "index";
    }

    @PostMapping("delete")
    public String deleteProject(Model model, ProjectDTO projectDTO) throws Exception {
        int result = projectService.deleteProject(projectDTO);
        customResponse.setResult(result);
        customResponse.setRedirectUrl("/projects/list");
        customResponse.setMessage("프로젝트 삭제");
        model.addAttribute("response", customResponse);
        model.addAttribute("page", "project/result");
        return "index";
    }
}
