package com.workmotion.app.project.crew;

import com.workmotion.app.project.MemberDTO;
import com.workmotion.app.project.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CrewController {

    @Autowired
    private CrewService crewService;


    @GetMapping("/projects/{project_id}/crews")
    public ResponseEntity<List<MemberDTO>> getCrewList(@PathVariable Long project_id, ProjectDTO projectDTO) throws Exception {
        projectDTO.setId(project_id);
        return new ResponseEntity<>(crewService.getCrewList(projectDTO), HttpStatus.OK);
    }

    @PostMapping("/projects/{project_id}/crews")
    public ResponseEntity<?> addCrew(@PathVariable Long project_id, Long[] member_id, ProjectDTO projectDTO) throws Exception {
        System.out.println(member_id.length);
        int result = crewService.addCrew(project_id, member_id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/projects/{project_id}/crews/{crew_id}")
    public ResponseEntity<?> removeCrew(@PathVariable Long project_id, @PathVariable Long crew_id, ProjectDTO projectDTO) throws Exception {
        int result = crewService.removeCrew(project_id, crew_id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/projects/{project_id}/crews/memberList")
    public ResponseEntity<List<MemberDTO>> getMemberList(@PathVariable Long project_id, ProjectDTO projectDTO) throws Exception {
        projectDTO.setId(project_id);
        List<MemberDTO> list = crewService.getMemberList(projectDTO);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
