package com.workmotion.app.project.api;

import com.workmotion.app.member.MemberDTO;
import com.workmotion.app.project.model.ArticleDTO;
import com.workmotion.app.project.model.ProjectDTO;
import com.workmotion.app.project.service.ArticleService;
import com.workmotion.app.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/v1/projects/*")
public class ArticleAPI {
    @Autowired
    private ArticleService articleService;


    @PostMapping("{project_id}/articles")
    public ResponseEntity<?> createArticle(ArticleDTO articleDTO, HttpSession session) throws Exception {
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        articleDTO.setWriter_id(memberDTO.getId());
        int result = articleService.createArticle(articleDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{project_id}/articles")
    public ResponseEntity<List<ArticleDTO>> getArticleList(@PathVariable Long project_id, Pager pager) throws Exception {
        return new ResponseEntity<>(articleService.getArticleList(new ProjectDTO(project_id), pager), HttpStatus.OK);
    }

    @PutMapping("{project_id}/articles/{article_id}")
    public ResponseEntity<?> updateArticle(@PathVariable Long project_id, @PathVariable Long article_id, @RequestBody ArticleDTO articleDTO) throws Exception {
        articleDTO.setProject_id(project_id);
        articleDTO.setId(article_id);
        int result = articleService.updateArticle(articleDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("{project_id}/articles/{article_id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long project_id, @PathVariable Long article_id) throws Exception {
        int result = articleService.deleteArticle(new ArticleDTO(article_id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
