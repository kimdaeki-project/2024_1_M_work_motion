package com.workmotion.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects/")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
}
