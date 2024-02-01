package com.workmotion.app.project.task;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.workmotion.app.project.task.TaskDAO.";


    public int createTask(TaskDTO taskDTO) throws Exception {
        return sqlSession.insert(NAMESPACE + "createTask", taskDTO);
    }

    public TaskDTO getTaskDetail(TaskDTO taskDTO) throws Exception {
        return sqlSession.selectOne(NAMESPACE + "getTaskDetail", taskDTO);
    }

    public List<TaskDTO> getTaskList(TaskDTO taskDTO) throws Exception {
        return sqlSession.selectList(NAMESPACE + "getTaskList", taskDTO);
    }

    public int updateTask(TaskDTO taskDTO) throws Exception {
        return sqlSession.update(NAMESPACE + "updateTask", taskDTO);
    }

    public int deleteTask(TaskDTO taskDTO) throws Exception {
        return sqlSession.delete(NAMESPACE + "deleteTask", taskDTO);
    }
}
