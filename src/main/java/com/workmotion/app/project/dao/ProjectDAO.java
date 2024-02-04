package com.workmotion.app.project.dao;

import com.workmotion.app.project.model.MemberDTO;
import com.workmotion.app.project.model.ProjectDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.workmotion.app.project.dao.ProjectDAO.";

    public int createProject(ProjectDTO projectDTO) {
        return sqlSession.insert(NAMESPACE + "createProject", projectDTO);
    }

    public List<ProjectDTO> getProjectList(MemberDTO memberDTO) {
        return sqlSession.selectList(NAMESPACE + "getProjectList", memberDTO);
    }

    public ProjectDTO getProjectDetail(ProjectDTO projectDTO) {
        return sqlSession.selectOne(NAMESPACE + "getProjectDetail", projectDTO);
    }

    public int deleteProject(ProjectDTO projectDTO) {
        return sqlSession.delete(NAMESPACE + "deleteProject", projectDTO);
    }

    public int updateProject(ProjectDTO projectDTO) {
        return sqlSession.update(NAMESPACE + "updateProject", projectDTO);
    }
}
