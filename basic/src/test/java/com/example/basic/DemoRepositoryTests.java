package com.example.basic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.model.Demo;
import com.example.basic.repository.DemoRepository;

@SpringBootTest
class DemoRepositoryTests {
	@Autowired
	DemoRepository demoRepository;

	@Test
	public void USER대충찾기() {
		List<Demo> list = 
				demoRepository.findByUserContaining("A");
		System.out.println( list );
	}
	
	@Test
	public void USER찾기() {
		List<Demo> list = 
				demoRepository.findByUser("A");
		System.out.println( list );
	}

	@Test // 기본키를 미리 지정 후 데이터 입력 -> save()
	public void update2() {
		Demo demo = new Demo();
		demo.setSeq(4L);
		demo.setUser("DDD222");
		demoRepository.save( demo );
	}
	
	@Test // 데이터 조회 후 수정 -> save()
	public void update() {
		Demo demo = demoRepository.findById(4L).get();
		demo.setUser("DDD");
		demoRepository.save( demo );
	}
	
	@Test
	public void insert() {
		Demo demo = new Demo();
		demo.setSeq(4L);
		demoRepository.save( demo );
	}

	@Test
	public void select() {
		System.out.println( 
				demoRepository.findAll() 
				);
	}
}





