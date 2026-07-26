package com.auditService.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void shouldRejectInvalidRequest() throws Exception {
		
		
		mockMvc.perform(post("/audit").contentType(MediaType.APPLICATION_JSON).content("""
				{
				    
				}
				""")).andExpect(status().isBadRequest());
		
		mockMvc.perform(post("/audit").contentType(MediaType.APPLICATION_JSON).content("""
				{
				    demo text
				}
				""")).andExpect(status().isBadRequest());
		
		
		
		mockMvc.perform(post("/audit").contentType(MediaType.APPLICATION_JSON).content("""
				{
				    "url":null
				}
				""")).andExpect(status().isBadRequest());
		
		
		mockMvc.perform(post("/audit").contentType(MediaType.APPLICATION_JSON).content("""
				{
				    "url":""
				}
				""")).andExpect(status().isBadRequest());
		
		mockMvc.perform(post("/audit").contentType(MediaType.APPLICATION_JSON).content("""
				{
				    "url":"        "
				}
				""")).andExpect(status().isBadRequest());
		
		
		mockMvc.perform(post("/audit").contentType(MediaType.APPLICATION_JSON).content("""
				{
				    "url":"google"
				}
				""")).andExpect(status().isBadRequest());
		
		
		mockMvc.perform(post("/audit").contentType(MediaType.APPLICATION_JSON).content("""
				{
				    "url":"ftp://abc.com"
				}
				""")).andExpect(status().isBadRequest());
		
		
		
	}
}
