package com.workmotion.app.project.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskDAO taskDAO;

    public int createTask(TaskDTO taskDTO) throws Exception {
        return taskDAO.createTask(taskDTO);
    }

    public TaskDTO getTaskDetail(TaskDTO taskDTO) throws Exception {
        return taskDAO.getTaskDetail(taskDTO);
    }

    public List<TaskDTO> getTaskList(TaskDTO taskDTO) throws Exception {
        return taskDAO.getTaskList(taskDTO);
    }

    public int updateTask(TaskDTO taskDTO) throws Exception {
        return taskDAO.updateTask(taskDTO);
    }

    public int deleteTask(TaskDTO taskDTO) throws Exception {
        return taskDAO.deleteTask(taskDTO);
    }
}
