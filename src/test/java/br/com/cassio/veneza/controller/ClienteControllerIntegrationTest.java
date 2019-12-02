package br.com.cassio.veneza.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ClienteControllerIntegrationTest extends ControllerIntegration {

    @Test
    public void testIndex() throws Exception {
        final MvcResult result = getMockMvc().perform(get("/clientes"))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        System.err.println(">> "+result.getResponse().getContentAsString());
    }

}
