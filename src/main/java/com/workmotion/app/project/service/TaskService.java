package com.workmotion.app.project.service;

import com.workmotion.app.project.dao.TaskDAO;
import com.workmotion.app.project.model.ProjectDTO;
import com.workmotion.app.project.model.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskDAO taskDAO;

    public List<TaskDTO> getTaskList(ProjectDTO projectDTO) {
        return taskDAO.getTaskList(projectDTO);
    }
}
