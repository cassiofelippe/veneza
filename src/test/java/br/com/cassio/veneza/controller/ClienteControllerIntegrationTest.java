package br.com.cassio.veneza.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

//@Disabled
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ClienteControllerIntegrationTest extends ControllerIntegration {

    @Test
    public void testIndex() throws Exception {
        final MvcResult result = getMockMvc()
                .perform(get("/cadastros")
                .header("Authorization", token))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

}
