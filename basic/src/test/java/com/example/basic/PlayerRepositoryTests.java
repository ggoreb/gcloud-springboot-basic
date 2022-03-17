package com.example.basic;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.model.Player;
import com.example.basic.model.Team;
import com.example.basic.repository.PlayerRepository;

@SpringBootTest
class PlayerRepositoryTests {
	
  @Autowired
	PlayerRepository playerRepository;

  @Test
  void 조회연습() {
    Optional<Player> opt = playerRepository.findById(3L);
    Player player = opt.get();
    
    String teamName = player.getTeam().getName(); // Join
    System.out.println(teamName);
  }
  
	@Test
	void 입력연습() {
	  Player player = new Player();
	  player.setName("Player 1");
	  Team team = new Team();
	  team.setId(1L);
	  player.setTeam(team);
	  playerRepository.save(player);
	}
	
}








