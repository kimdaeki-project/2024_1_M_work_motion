package com.workmotion.app.project.crew;

import com.workmotion.app.project.MemberDTO;
import com.workmotion.app.project.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrewService {
    @Autowired
    private CrewDAO crewDAO;

    public List<MemberDTO> getCrewList(ProjectDTO projectDTO) throws Exception {
        return crewDAO.getCrewList(projectDTO);
    }

    public int addCrew(Long project_id, Long[] member_ids) throws Exception {
        int result = 0;
        Map<String, Object> map = new HashMap<>();
        map.put("project_id", project_id);
        for (Long member_id : member_ids) {
            map.put("member_id", member_id);
            result = crewDAO.addCrew(map);
        }
        return result;
    }

    public int removeCrew(Long projectId, Long member_id) throws Exception {
        int result = 0;
        Map<String, Object> map = new HashMap<>();
        map.put("project_id", projectId);
        map.put("member_id", member_id);
        result = crewDAO.removeCrew(map);
        return result;
    }

    public List<MemberDTO> getMemberList(ProjectDTO projectDTO) {
        return crewDAO.getMemberList(projectDTO);
    }
}
