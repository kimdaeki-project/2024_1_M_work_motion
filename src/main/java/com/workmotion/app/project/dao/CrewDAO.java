package com.workmotion.app.project.dao;

import com.workmotion.app.project.model.MemberDTO;
import com.workmotion.app.project.model.ProjectDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrewDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.workmotion.app.project.dao.CrewDAO.";

    public List<MemberDTO> getCrewList(ProjectDTO projectDTO) {
        return sqlSession.selectList(NAMESPACE + "getCrewList", projectDTO);
    }
}
