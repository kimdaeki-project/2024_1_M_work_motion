package com.workmotion.app.project.controller;

import com.workmotion.app.project.model.CustomResponse;
import com.workmotion.app.project.model.ProjectDTO;
import com.workmotion.app.project.model.TaskDTO;
import com.workmotion.app.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks/*")
public class TaskController {
    @Autowired
    private TaskService taskService;
    private final CustomResponse customResponse = new CustomResponse();

    @GetMapping("create")
    public String create(Model model, ProjectDTO projectDTO) throws Exception {
        model.addAttribute("page", "project/createTask");
        model.addAttribute("project", projectDTO);
        return "index";
    }

    @PostMapping("create")
    public String create(Model model, TaskDTO taskDTO) throws Exception {
        taskDTO.setWriter_id(7L);
        int result = taskService.createTask(taskDTO);
        System.out.println(taskDTO.getCharge());
        result = taskService.addCharge(taskDTO, taskDTO.getCharge());
        customResponse.setResult(result);
        customResponse.setMessage("업무 생성");
        customResponse.setRedirectUrl("/projects/detail?id=" + taskDTO.getProject_id());
        model.addAttribute("response", customResponse);
        model.addAttribute("page", "project/result");
        return "index";
    }

    @GetMapping("setting")
    public String setting(Model model, TaskDTO taskDTO) throws Exception {
        model.addAttribute("task", taskDTO);
        model.addAttribute("page", "project/editTask");
        return "index";
    }

    @PostMapping("update")
    public String update(Model model, TaskDTO taskDTO) throws Exception {
        int result = taskService.updateTask(taskDTO);
        customResponse.setResult(result);
        customResponse.setMessage("업무 수정");
        customResponse.setRedirectUrl("/projects/detail?id=" + taskDTO.getProject_id());
        model.addAttribute("response", customResponse);
        model.addAttribute("page", "project/result");
        return "index";
    }

    @GetMapping("delete")
    public String delete(Model model, TaskDTO taskDTO) throws Exception {
        int result = taskService.deleteTask(taskDTO);
        customResponse.setResult(result);
        customResponse.setMessage("업무 삭제");
        customResponse.setRedirectUrl("/projects/detail?id=" + taskDTO.getProject_id());
        model.addAttribute("page", "project/result");
        model.addAttribute("response", customResponse);
        return "index";
    }
}
