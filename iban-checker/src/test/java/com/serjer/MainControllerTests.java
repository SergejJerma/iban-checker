package com.serjer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.serjer.iban.controller.MainController;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private MainController mainController;
	
	@Test
	void testController() {
		assertThat(mainController).isNotNull();
	}
	
	@Test
	void mainContextLoads() throws Exception {
		this.mockMvc.perform(get("/"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello, guest!")));
	}
	
	@Test
	void singleFormLoads() throws Exception {
		this.mockMvc.perform(get("/single"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	void listFormLoads() throws Exception {
		this.mockMvc.perform(get("/list"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
}
