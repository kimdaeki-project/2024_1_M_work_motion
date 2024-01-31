package com.workmotion.app.project;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.workmotion.app.project.ProjectDAO.";

    public List<ProjectDTO> getProjectList(MemberDTO memberDTO) throws Exception {
        return sqlSession.selectList(NAMESPACE + "getProjectList", memberDTO);
    }

    public ProjectDTO getProjectDetail(ProjectDTO projectDTO) throws Exception {
        return sqlSession.selectOne(NAMESPACE + "getProjectDetail", projectDTO);
    }

    public int updateProject(ProjectDTO projectDTO) throws Exception {
        return sqlSession.update(NAMESPACE + "updateProject", projectDTO);
    }

    public int deleteProject(ProjectDTO projectDTO) throws Exception {
        return sqlSession.delete(NAMESPACE + "deleteProject", projectDTO);
    }

    public int createProject(ProjectDTO projectDTO) throws Exception {
        return sqlSession.insert(NAMESPACE + "createProject", projectDTO);
    }
}
