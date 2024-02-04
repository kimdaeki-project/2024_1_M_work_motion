package com.workmotion.app.project.service;

import com.workmotion.app.project.dao.CrewDAO;
import com.workmotion.app.project.model.MemberDTO;
import com.workmotion.app.project.model.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewService {
    @Autowired
    private CrewDAO crewDAO;

    public List<MemberDTO> getCrewList(ProjectDTO projectDTO) {
        return crewDAO.getCrewList(projectDTO);
    }
}
