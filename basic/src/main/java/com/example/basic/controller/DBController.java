package com.example.basic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.dao.HolidayParkingDAO;
import com.example.basic.dao.SunbyulDAO;
import com.example.basic.mapper.DemoMapper;
import com.example.basic.mapper.PollMapper;
import com.example.basic.mapper.SunbyulMapper;
import com.example.basic.model.Demo;
import com.example.basic.model.NightPharmacy;
import com.example.basic.repository.AnyRepository;
import com.example.basic.repository.DemoRepository;
import com.example.basic.repository.NightPharmacyRepository;
import com.example.basic.vo.Any;

@RestController
public class DBController {
	@Autowired
	JdbcTemplate jt;

	@Autowired
	DemoMapper demoMapper;

	@Autowired
	PollMapper pollMapper;

	@Autowired
	SunbyulMapper sunbyulMapper;

	@Autowired
	DemoRepository demoRepository;

	@Autowired
	AnyRepository anyRepository;
	
	@Autowired
	NightPharmacyRepository nightPharmacyRepository;
	
	@GetMapping("/jpa/night/{page}")
	public List<NightPharmacy> jpaNight2(
			@PathVariable("page") int page) {
		// Ascending 오름차순
		Sort sort = Sort.by("roadAddress");
		
		// Descending 내림차순
		sort = Sort.by(Sort.Direction.DESC, "id");
		
		//                      시작번호는 0 부터
		Pageable p = PageRequest.of(page-1, 10, sort);
		
		Page<NightPharmacy> result = 
				nightPharmacyRepository.findAll( p );
		
		List<NightPharmacy> nightPharmacyList = 
				result.getContent();
		
		return nightPharmacyList;
	}
	
	@GetMapping("/jpa/night")
	public List<NightPharmacy> jpaNight() {
		Pageable p = PageRequest.of(1, 5);
		return nightPharmacyRepository.findByRoadAddressContainingOrJibunAddressContainingOrderByIdDesc(
				"대전", "대전", p);
//		return nightPharmacyRepository.findAll();
	}
	
	@GetMapping("/jpa/any")
	public List<Any> jpaAny() {
		return anyRepository.findAll();
	}

	@GetMapping("/jpa/demo")
	public List<Demo> jpaDemo() {
//		Sort sort = Sort.by(Sort.Direction.DESC, "id");
//		Pageable p = PageRequest.of(0, 10, sort);
//		return demoRepository.findAll(p);

		Pageable p = PageRequest.of(0, 3);
		return demoRepository.findByOrderByUserDesc(p);
	}
	
	@GetMapping("mybatis/sunbyul")
	public List<Map<String, Object>> mybatisSunbyul() {
		return sunbyulMapper.select();
	}

	@GetMapping("mybatis/poll")
	public String mybatisPoll(@RequestParam Map<String, Object> map) {
		pollMapper.insert(map);
		return "ok";
	}

	// 1. 클래스 영역에 명령문(코드) 작성 X
	// List list;
	// list.add(1);

	@GetMapping("mybatis/demo")
	public List<Map<String, Object>> mybatisDemo() {
		return demoMapper.select();
	}

	@GetMapping("/jdbc/demo")
	public List<Map<String, Object>> jdbcDemo() {

		// const a = 10;
		// let b = 10;
		// int i = 10;
		// String s = "aa";

		// 2. 지역변수는 반드시 초기화 수행 후 활용
		// List<Integer> list = null;
		// list.add("aaa");
		// list.add(1);

		return jt.queryForList("select * from demo");
	}

	@GetMapping("/jdbc/demo2")
	public Demo jdbcDemo2() {
		Demo demo = jt.queryForObject("select * from demo", Demo.class);
		System.out.println(demo);
		return demo;
	}

	@Autowired
	HolidayParkingDAO hDAO;

	@GetMapping("/jdbc/parking")
	public List<Map<String, Object>> jdbcParking(@RequestParam(value = "page", defaultValue = "0") int page) {
		int startRow = page * 10 - 10;
		return hDAO.select(startRow);
	}

	@Autowired
	SunbyulDAO sDAO;

	@GetMapping("/jdbc/sunbyul")
	public List<Map<String, Object>> jdbcSunbyul(@RequestParam(value = "page", defaultValue = "1") int page) {
		int startRow = page * 10 - 10;
		return sDAO.select(startRow);
	}
}