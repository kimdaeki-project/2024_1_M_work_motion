package com.workmotion.app.member;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.workmotion.app.tosspayment.TossPaymentDTO;
import com.workmotion.app.tosspayment.TossPaymentService;


@Controller
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private TossPaymentService tossPaymentService;

	@ResponseBody
	@PostMapping("pwCheck")
	public int pwCheck(HttpSession session, String pass, MemberDTO memberDTO) throws Exception {
		MemberDTO m = (MemberDTO) session.getAttribute("member");
		m = memberService.getlogin(m);
		StringTokenizer tokenizer = new StringTokenizer(pass, ",");
		memberDTO.setPassword(tokenizer.nextToken());
		int result = 0;
		if (BCrypt.checkpw(memberDTO.getPassword(), m.getPassword())) {
			result = 1;
		}
		return result;
	}

	@ResponseBody
	@GetMapping("emailcheck")
	public int getemailcheck(MemberDTO memberDTO, Model model) throws Exception {
		int result = 0;
		memberDTO = memberService.emailCheck(memberDTO);
		if (memberDTO == null) {
			result = 1;
		}
		return result;
	}

	@GetMapping("agree")
	public void getagree() throws Exception {
	}

	@GetMapping("logout")
	public String getlogout(HttpSession session) throws Exception {
		session.invalidate();
		return "/member/login";
	}

	@GetMapping("login")
	public void getlogin() throws Exception {
	}

	@PostMapping("login")
	public String getlogin(MemberDTO memberDTO, HttpSession session, Model model) throws Exception {
		MemberDTO m = memberService.getlogin(memberDTO);
		if (m != null) {
			if (BCrypt.checkpw(memberDTO.getPassword(), m.getPassword())) {
				m.setPassword(null);
				session.setAttribute("member", m);
				System.out.println(m.getId());
				TossPaymentDTO tossPaymentDTO = new TossPaymentDTO();
				tossPaymentDTO.setCompany_id(m.getCompany_id());
				tossPaymentDTO = tossPaymentService.getTossPaymentDetail(tossPaymentDTO);
				System.out.println(tossPaymentDTO);
				if(tossPaymentDTO != null) { 
				String tossdate = tossPaymentDTO.getCreate_dt();		
				System.out.println(tossPaymentDTO);
				String [] ar = tossdate.split(" ");
				String [] setDate = ar[0].split("-");
				String [] setDate1 = ar[1].split(":");
				System.out.println(setDate[0]);
				System.out.println(setDate[1]);
				System.out.println(setDate[2]);
				System.out.println(setDate1[0]);
				System.out.println(setDate1[1]);
				System.out.println(setDate1[2]);
				LocalDateTime startDt = LocalDateTime.now();
				LocalDateTime lastDt = LocalDateTime.of(Integer.parseInt(setDate[0]), Integer.parseInt(setDate[1]), Integer.parseInt(setDate[2]), Integer.parseInt(setDate1[0]), Integer.parseInt(setDate1[1]));
				System.out.println("startDt : "+startDt);
				System.out.println(tossPaymentDTO.getPeriod());
				lastDt = lastDt.plusDays(tossPaymentDTO.getPeriod());
				System.out.println("lastDt : "+lastDt);
				Long getdate = ChronoUnit.MILLIS.between(startDt, lastDt);
				System.out.println(getdate);
				
				if (tossPaymentDTO != null || getdate < 0) {
					session.setAttribute("check", "yse");
				}
				
				}
				model.addAttribute("page", "home");
				return "index";
			} else {
				// 비번이 다른경우
				model.addAttribute("msg", "비밀번호를 확인해주세요");
				return "member/login";
			}
		} else {
			// 아이디가 다른경우
			model.addAttribute("msg", "아이디를 확인해주세요");
			return "member/login";
		}

	}

	@GetMapping("join")
	public String getjoin(Model model) throws Exception {
		model.addAttribute("page", "member/join");
		return "member/join";
	}

	@GetMapping("mypage")
	public String mypage(HttpSession session, Model model) throws Exception {
		MemberDTO m = (MemberDTO) session.getAttribute("member");
		if (m == null) {
			model.addAttribute("page", "home");
		} else {
			MemberDTO memberDTO = memberService.detailMember(m);
			model.addAttribute("dto", memberDTO);
			model.addAttribute("page", "member/mypage");
		}
		return "index";
	}

	@PostMapping("update")
	public String getupdate(MemberDTO memberDTO, Model model, MultipartFile picture) throws Exception {
		if (picture != null) {
			memberService.setFileDelete(memberDTO);
			memberService.setFileAdd(memberDTO, picture);
		}
		if (memberDTO.getPassword() != null) {
			String hashpassword = BCrypt.hashpw(memberDTO.getPassword(), BCrypt.gensalt());
			memberDTO.setPassword(hashpassword);
		}
		int result = memberService.updateMember(memberDTO);
		model.addAttribute("page", "home");
		return "index";
	}

    @PostMapping("join")
    public String getjoin(MemberDTO memberDTO, Model model) throws Exception {
        String hashpassword = BCrypt.hashpw(memberDTO.getPassword(), BCrypt.gensalt());
        memberDTO.setPassword(hashpassword);
        int result = memberService.getjoin(memberDTO);
        memberService.setFileAdd(memberDTO);
        System.out.println(memberDTO.getId());
        return "member/login";
    }


}
