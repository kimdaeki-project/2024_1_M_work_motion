package com.workmotion.app.project.crew;

import com.workmotion.app.project.MemberDTO;
import com.workmotion.app.project.ProjectDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CrewDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.workmotion.app.project.crew.CrewDAO.";

    public List<MemberDTO> getCrewList(ProjectDTO projectDTO) throws Exception {
        return sqlSession.selectList(NAMESPACE + "getCrewList", projectDTO);
    }

    public int addCrew(Map<String, Object> map) throws Exception {
        return sqlSession.insert(NAMESPACE + "addCrew", map);
    }

    public int removeCrew(Map<String, Object> map) throws Exception {
        return sqlSession.delete(NAMESPACE + "removeCrew", map);
    }

}
