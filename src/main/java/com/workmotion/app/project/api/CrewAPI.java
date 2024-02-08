package com.workmotion.app.project.api;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.project.model.ProjectDTO;
import com.workmotion.app.project.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/projects/*")
public class CrewAPI {
    @Autowired
    private CrewService crewService;

    private MemberDTO memberDTO = new MemberDTO();

    {
        memberDTO.setId(15L);
    }

    @PostMapping("{project_id}/crews")
    public ResponseEntity<?> addCrew(@PathVariable Long project_id, String member_ids) throws Exception {
        int result = crewService.addCrew(project_id, member_ids);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{project_id}/crews")
    public ResponseEntity<List<MemberDTO>> getCrewList(@PathVariable Long project_id, ProjectDTO projectDTO) throws Exception {
        projectDTO.setId(project_id);
        List<MemberDTO> memberDTOs = crewService.getCrewList(projectDTO);
        return new ResponseEntity<>(memberDTOs, HttpStatus.OK);
    }

    @GetMapping("{project_id}/owner")
    public ResponseEntity<MemberDTO> getOwner(@PathVariable Long project_id) throws Exception {
        MemberDTO memberDTO = crewService.getOwner(new ProjectDTO(project_id));
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }

    @GetMapping("{project_id}/crews/{member_id}")
    public ResponseEntity<MemberDTO> getCrew(@PathVariable Long project_id, @PathVariable Long member_id) throws Exception {
        MemberDTO memberDTO = crewService.getCrewDetail(project_id, member_id);
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }

    @DeleteMapping("{project_id}/crews/{member_ids}")
    public ResponseEntity<?> removeCrew(@PathVariable Long project_id, @PathVariable String member_ids) throws Exception {
        int result = crewService.removeCrew(project_id, member_ids);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{project_id}/members")
    public ResponseEntity<List<MemberDTO>> getMemberList(@PathVariable Long project_id, ProjectDTO projectDTO) throws Exception {
        projectDTO.setId(project_id);
        List<MemberDTO> memberDTOs = crewService.getMemberList(projectDTO);
        return new ResponseEntity<>(memberDTOs, HttpStatus.OK);
    }

    @GetMapping("members")
    public ResponseEntity<List<MemberDTO>> getALLMemberList() throws Exception {
        List<MemberDTO> memberDTOs = crewService.getAllMemberList(memberDTO);
        return new ResponseEntity<>(memberDTOs, HttpStatus.OK);
    }
}
