package com.workmotion.app.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workmotion.app.category.CategoryDTO;
import com.workmotion.app.util.Pager;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("list")
	public String getBoardList(CategoryDTO categoryDTO, Pager pager, Model model)throws Exception {
		System.out.println(categoryDTO.getName());
		List<Map<String, Object>> dtos = boardService.getBoardList(categoryDTO, pager);
		dtos.forEach(m -> m.forEach((k,v)->System.out.println("key = " + k + " , " + "value = " + v)));
		model.addAttribute("list", dtos);
		model.addAttribute("pager", pager);
		model.addAttribute("page", "board/list");
		
		return "index";
	}
	@GetMapping("detail")
	public void getBoardDetail(BoardDTO boardDTO, Model model)throws Exception {
		boardDTO = boardService.getBoardDetail(boardDTO);
		
		model.addAttribute("detail", boardDTO);
		model.addAttribute("page", "board/detail");
		
	}
	
}
