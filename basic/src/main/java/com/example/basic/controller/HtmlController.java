package com.example.basic.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.basic.model.NightPharmacy;
import com.example.basic.repository.NightPharmacyRepository;
import com.example.basic.vo.Any;

@Controller
public class HtmlController {
	@Autowired
	NightPharmacyRepository nightPharmacyRepository;

	@GetMapping("/html/night/{page}")
	public String htmlNight(
			@PathVariable int page,
			Model model) {
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		
		List<Order> orders = new ArrayList<>();
		Order order = Order.desc("id");
		orders.add(order); 
		sort = Sort.by(orders);
		
		Pageable p = PageRequest.of(page - 1, 10, sort);
		
		Page<NightPharmacy> result = 
		    nightPharmacyRepository.findAll(p);
		List<NightPharmacy> nightPharmacyList = result.getContent();
		
		model.addAttribute("list", nightPharmacyList);

		return "html/night";
	}

	// 공통 : 사용자의 요청 파라미터를 뷰 템플릿에서 넘겨서 출력
	// 요청 파라미터 : 1-name, 2-age
	// 1. Model 사용
	@GetMapping("/html/req1")
	public String req1(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "html/req1";
	}

	// 2. ModelAttribute 사용
	@GetMapping("/html/req2")
	public String req2(@RequestParam int page, @ModelAttribute("any") Any any) {
		System.out.println(any);
		// any.name getter가 동작
		// Any@29dfj3e toString이 동작
		return "html/req2";
	}

	@GetMapping("/html/exam")
	public String htmlExam() {
		return "html/exam";
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("number", new Random().nextInt(10));
		return "html/string";
	}

	@GetMapping("html/void")
	public void htmlVoid() {
	}

	@GetMapping("html/model_and_view")
	public ModelAndView htmlModel() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("html/model_and_view");
		return mav;
	}
}
