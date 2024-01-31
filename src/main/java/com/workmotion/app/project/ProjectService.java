package com.workmotion.app.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectDAO projectDAO;

    public List<ProjectDTO> getProjectList(MemberDTO memberDTO) throws Exception {
        return projectDAO.getProjectList(memberDTO);
    }
    public ProjectDTO getProjectDetail(ProjectDTO projectDTO) throws Exception {
        return projectDAO.getProjectDetail(projectDTO);
    }

    public int updateProject(ProjectDTO projectDTO) throws Exception {
        return projectDAO.updateProject(projectDTO);
    }

    public int deleteProject(ProjectDTO projectDTO) throws Exception {
        return projectDAO.deleteProject(projectDTO);
    }

    public int createProject(ProjectDTO projectDTO) throws Exception {
        return projectDAO.createProject(projectDTO);
    }
}
