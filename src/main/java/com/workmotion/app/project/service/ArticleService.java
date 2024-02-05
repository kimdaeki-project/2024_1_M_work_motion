package com.workmotion.app.project.service;


import com.workmotion.app.project.dao.ArticleDAO;
import com.workmotion.app.project.model.ArticleDTO;
import com.workmotion.app.project.model.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    public int createArticle(ArticleDTO articleDTO) throws Exception {
        return articleDAO.createArticle(articleDTO);
    }

    public List<ArticleDTO> getArticleList(ProjectDTO projectDTO) throws Exception {
        return articleDAO.getArticleList(projectDTO);
    }

    public int updateArticle(ArticleDTO articleDTO) throws Exception {
        return articleDAO.updateArticle(articleDTO);
    }

    public int deleteArticle(ArticleDTO articleDTO) throws Exception {
        return articleDAO.deleteArticle(articleDTO);
    }
}
