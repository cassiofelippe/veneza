package br.com.cassio.veneza.controller;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@TestInstance(PER_METHOD)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ControllerIntegration {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    protected String json = "";

    protected static String token;

    @BeforeEach
    void setUp()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    protected MockMvc getMockMvc() {
        return mockMvc;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
