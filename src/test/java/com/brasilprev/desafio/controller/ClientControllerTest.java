package com.brasilprev.desafio.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.brasilprev.desafio.DesafioApplication;
import com.brasilprev.desafio.dto.Client;
import com.brasilprev.desafio.util.SiteUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DesafioApplication.class)
public class ClientControllerTest {

	private MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void cadastro() throws Exception {
		String uri = "/clients";

		Client clienteIn = new Client();
		clienteIn.setCpf("68690744029");
		clienteIn.setName("Usuario");
		clienteIn.setAddress("Endereco");

		String inputJson = SiteUtil.mapToJson(clienteIn);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String uriDelete = "/clients/68690744029";
		MvcResult mvcResultDelet = mvc.perform(MockMvcRequestBuilders.delete(uriDelete)).andReturn();
		int statusDelete = mvcResultDelet.getResponse().getStatus();
		assertEquals(200, statusDelete);
	}

	@Test
	public void cadastroErroEntrada() throws Exception {
		String uri = "/clients";

		String inputJson = "";

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}

	@Test
	public void cadastroCpfInvalido() throws Exception {
		String uri = "/clients";

		Client clienteIn = new Client();
		clienteIn.setName("Usuario");
		clienteIn.setAddress("Endereco");

		String inputJson = SiteUtil.mapToJson(clienteIn);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}

	@Test
	public void cadastroNomeInvalido() throws Exception {
		String uri = "/clients";

		Client clienteIn = new Client();
		clienteIn.setCpf("68690744029");
		clienteIn.setAddress("Endereco");

		String inputJson = SiteUtil.mapToJson(clienteIn);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}

	@Test
	public void cadastroAddressInvalido() throws Exception {
		String uri = "/clients";

		Client clienteIn = new Client();
		clienteIn.setCpf("68690744029");
		clienteIn.setName("Usuario");

		String inputJson = SiteUtil.mapToJson(clienteIn);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
	}

}
