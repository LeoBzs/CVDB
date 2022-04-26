package com.curriculum.curriculum.controller;

import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;

import com.curriculum.curriculum.model.Cv;
import com.curriculum.curriculum.service.CvServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Cv Controller Test")
class CvControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CvServiceImpl cvService;

    String id = "d1516d33-ff6f-4dc9-aedf-9316421096cb";
    Cv cv = Cv.builder()
            .id(UUID.randomUUID())
            .nome("joão")
            .cargo("programador")
            .conhecimentos("nodeJS")
            .email("joao@email.com")
            .idioma("ingles")
            .status(Cv.LanguageLevel.INTERMEDIATE)
            .build();

    @Test
    @DisplayName("Teste do POST/Sucesso do Controller")
    public void deveRetornarSucesso_QuandoCriarJogador() throws Exception {

        when(cvService.saveCv(any(Cv.class))).thenReturn(cv);

        ObjectMapper mapper = new ObjectMapper();
        String cvComoJSON = mapper.writeValueAsString(cv);

        mockMvc.perform(MockMvcRequestBuilders.post("/cv/").content(cvComoJSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated()).andExpect(content().json(cvComoJSON));

    }

    @Test
    @DisplayName("Teste do POST/Error do Controller")
    public void deveRetornarErro_QuandoCriarJogadorInvalido() throws Exception {

        when(cvService.saveCv(any(Cv.class))).thenReturn(cv);

        mockMvc.perform(MockMvcRequestBuilders.post("/cv/").accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest());

    }

    @Test
    @DisplayName("Teste do PUT/Sucesso do Controller")
    public void deveRetornarSucesso_QuandoAtualizarJogador() throws Exception {

        given(cvService.changeCv(cv,cv.getId())).willReturn(Optional.of(cv));

        ObjectMapper mapper = new ObjectMapper();
        String cvParaAtualizarComoJSON = mapper.writeValueAsString(cv);

        mockMvc.perform(MockMvcRequestBuilders.put("/cv/").content(cvParaAtualizarComoJSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(content().json(cvParaAtualizarComoJSON));

    }

    @Test
    @DisplayName("Teste do PUT/Error ID NULL do Controller")
    public void deveRetornarErro_QuandoAtualizarJogadorIdNull() throws Exception {

        Cv jogadore = Cv.builder()
                .id(null)
                .nome("joão")
                .cargo("programador")
                .conhecimentos("nodeJS")
                .email("joao@email.com")
                .idioma("ingles")
                .status(Cv.LanguageLevel.INTERMEDIATE)
                .build();
        given(cvService.changeCv(cv,cv.getId())).willReturn(Optional.of(cv));

        ObjectMapper mapper = new ObjectMapper();
        String cvParaAtualizarComoJSON = mapper.writeValueAsString(jogadore);

        mockMvc.perform(MockMvcRequestBuilders.put("/cv/").content(cvParaAtualizarComoJSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());


    }

    @Test
    @DisplayName("Teste PUT/Error ID não Encontrado do Controller")
    public void deveRetornarErro_QuandoAtualizarJogador() throws Exception {

        Cv cvAtualizar = Cv.builder()
                .id(UUID.randomUUID())
                .nome("joão")
                .cargo("programador")
                .conhecimentos("nodeJS")
                .email("joao@email.com")
                .idioma("ingles")
                .status(Cv.LanguageLevel.INTERMEDIATE)
                .build();
        given(cvService.changeCv(cvAtualizar,cvAtualizar.getId())).willReturn(Optional.of(cv));

        ObjectMapper mapper = new ObjectMapper();
        String cvParaAtualizarComoJSON = mapper.writeValueAsString(cv);

        mockMvc.perform(MockMvcRequestBuilders.put("/cv/").content(cvParaAtualizarComoJSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());

    }

    @Test
    @DisplayName("Teste do GET do Controller do Jogador")
    public void deveRetornarSucesso_QuandoBuscar() throws Exception {

        given(cvService.findById(cv.getId())).willReturn(cv);

        ObjectMapper mapper = new ObjectMapper();
        String cvComoJSON = mapper.writeValueAsString(cv);

        mockMvc.perform(get("/cv/" + cv.getId()).content(cvComoJSON)
                        .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(content().json(cvComoJSON));

    }
}