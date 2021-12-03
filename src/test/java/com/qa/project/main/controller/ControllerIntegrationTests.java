package com.qa.project.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.project.main.model.Student;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:test-schema.sql", "classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class ControllerIntegrationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void getAllStudentsTest() throws Exception {
		String listOfStudentsAsJSON = this.mapper.writeValueAsString(List.of(
				new Student(1, 123456789, "Tom", "London"),
				new Student(2, 112233445, "Harry", "Birmingham")
				));
		
		RequestBuilder request = get("/student");
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(listOfStudentsAsJSON);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}

	@Test
	void createStudentTest() throws Exception {
		String testStudentAsJson = this.mapper.writeValueAsString(new Student(null, 176754342, "Fred", "Manchester"));
		String testStudentAsJsonResponse = this.mapper.writeValueAsString(new Student(3, 176754342, "Fred", "Manchester"));
		
		RequestBuilder request = post("/student/create").contentType(MediaType.APPLICATION_JSON).content(testStudentAsJson);
		
		ResultMatcher status = MockMvcResultMatchers.status().isCreated();
		ResultMatcher content = MockMvcResultMatchers.content().json(testStudentAsJsonResponse);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	
	@Test
	void deleteStudentTest() throws Exception {
		this.mvc.perform(delete("/student/delete/1")).andExpect(status().isOk());
		
	}
	
	@Test 
	void updateStudentTest() throws Exception {
		String updatedCarAsJson = this.mapper.writeValueAsString(new Student(2, 176754342, "Fred", "Manchester"));
		
		RequestBuilder req = put("/student/update/2").contentType(MediaType.APPLICATION_JSON).content(updatedCarAsJson);;
		
		ResultMatcher status = status().isAccepted();
		ResultMatcher content = MockMvcResultMatchers.content().json(updatedCarAsJson);
		
		this.mvc.perform(req).andExpect(status).andExpect(content);
	}
}
