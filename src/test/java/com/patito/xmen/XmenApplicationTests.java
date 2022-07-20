package com.patito.xmen;

import com.patito.xmen.Controller.BDController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class XmenApplicationTests {

	@Autowired
	private BDController bdController;

	@Test
	void contextLoads() {
		assertThat(bdController).isNotNull();
	}

}
