package com.example.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.mapper.DemoMapper;

@SpringBootTest
class DemoMapperTests {
	@Autowired
	DemoMapper demoMapper;

	@Test
	public void insert() {
		Map<String, Object> map = new HashMap<>();
		map.put("seq", 100);
		map.put("user", "ZZZ");
		int z = demoMapper.insert(map);
		System.out.println(z);
	}
	
	@Test
	public void select() {
		List<Map<String, Object>> result = demoMapper.select();
		System.out.println(result);
	}
}