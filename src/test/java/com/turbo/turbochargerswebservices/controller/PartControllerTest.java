package com.turbo.turbochargerswebservices.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turbo.turbochargerswebservices.model.dto.part.PartDto;
import com.turbo.turbochargerswebservices.service.PartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PartControllerTest extends IntegrationTestsBase {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PartService partService;

    ObjectMapper mapper = new ObjectMapper();

    private final String entitiesUrl = "/parts";
    private final String entityIdUrl = "/44";

    private final String partName = "Koło zamachowe";


    @Test
    void whenGetPart_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(entitiesUrl + entityIdUrl)
                .with(httpBasic(authenticatedUser.getUsername(), authenticatedUser.getPassword()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void whenGetParts_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(this.entitiesUrl)
                .with(httpBasic(authenticatedUser.getUsername(), authenticatedUser.getPassword()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void whenPostParts_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(this.entitiesUrl)
                .with(httpBasic(notAuthenticatedUser.getUsername(), notAuthenticatedUser.getPassword()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void whenPostParts_thenStatus201() throws Exception {

        PartDto partDto = new PartDto();
        partDto.setName(partName);
        String partAsJsonString = mapper.writeValueAsString(partDto);

        when(partService.save(any(PartDto.class))).thenReturn(partDto);

        mockMvc.perform(MockMvcRequestBuilders.post(this.entitiesUrl)
                .with(httpBasic(authenticatedUser.getUsername(), authenticatedUser.getPassword()))
                .contentType(MediaType.APPLICATION_JSON)
                .content(partAsJsonString))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentType("application/json"))
                .andExpect(jsonPath("$.name").value(partDto.getName()));
    }

    @Test
    void whenPutPart_thenStatus200() throws Exception {

        PartDto partDto = new PartDto();
        partDto.setName(partName);
        String partAsJsonString = mapper.writeValueAsString(partDto);

        when(partService.save(any(PartDto.class))).thenReturn(partDto);

        mockMvc.perform(MockMvcRequestBuilders.put(entitiesUrl + entityIdUrl)
                .with(httpBasic(authenticatedUser.getUsername(), authenticatedUser.getPassword()))
                .contentType(MediaType.APPLICATION_JSON)
                .content(partAsJsonString))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType("application/json"))
                .andExpect(jsonPath("$.name").value(partDto.getName()));
    }

    @Test
    void whenDeletePart_thenStatus200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete(entitiesUrl + entityIdUrl)
                .with(httpBasic(authenticatedUser.getUsername(), authenticatedUser.getPassword()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
