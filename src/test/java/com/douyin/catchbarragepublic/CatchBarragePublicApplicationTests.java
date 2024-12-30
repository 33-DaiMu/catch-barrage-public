package com.douyin.catchbarragepublic;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatchBarragePublicApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CatchBarragePublicApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("123");
	}

}
