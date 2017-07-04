package net.j33r.example.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import net.j33r.example.test.config.SpringContextTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { SpringContextTestConfiguration.class })
public class IntegrationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() throws Exception {
		mockMvc = webAppContextSetup(context).build();
	}

	@Test
	public void calcSuccessul() throws Exception {
		final MockHttpServletResponse response = postCalculation("{\"A\":3,\"B\":4}");

		assertEquals(HttpStatus.OK.value(), response.getStatus());

		final String jsonData = response.getContentAsString();
		final JSONObject json = new JSONObject(jsonData);

		assertEquals(7, json.getInt("RESULTADO"));
	}

	@Test
	public void calcSuccessfulTextualParam() throws Exception {
		final MockHttpServletResponse response = postCalculation("{\"A\":\"3\",\"B\":\"6\"}");

		assertEquals(HttpStatus.OK.value(), response.getStatus());

		final String jsonData = response.getContentAsString();
		final JSONObject json = new JSONObject(jsonData);

		assertEquals(9, json.getInt("RESULTADO"));
	}

	@Test
	public void missingParams() throws Exception {
		final MockHttpServletResponse response = postCalculation("{\"A\":3,\"b\":4}");

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}

	@Test
	public void invalidParams() throws Exception {
		final MockHttpServletResponse response = postCalculation("{\"A\":3,\"B\":\"E\"}");

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}

	private MockHttpServletResponse postCalculation(String json) throws Exception {
		final ResultActions action = mockMvc.perform(
				post("/calculation/add/result").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json));

		return action.andReturn().getResponse();

	}
}
