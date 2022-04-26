package com.curriculum.curriculum.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import com.curriculum.curriculum.model.Cv;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@DisplayName("CV Service Test")
class CvServiceImplTest {

    private final Iterable<Cv> cvArrayList = new ArrayList<>();

    @Mock
    private CvServiceImpl cvService;

    Cv cv= Cv.builder()
            .id(UUID.randomUUID())
            .nome("joão")
            .cargo("programador")
            .conhecimentos("nodeJS")
            .email("joao@email.com")
            .idioma("ingles")
            .status(Cv.LanguageLevel.INTERMEDIATE)
            .build();

    @Test
    @DisplayName("Teste do SAVE/Successo do ServiceImpl")
    public void testPostJogador() throws Exception {

        when(cvService.saveCv(cv)).thenReturn(cv);

        assertEquals(cv, cvService.saveCv(cv));

    }
    @Test
    @DisplayName("Teste do SAVE/Error do ServiceImpl")
    public void testPostErrorJogador() throws Exception {

        when(cvService.saveCv(null)).thenReturn(null);

        assertNull(cvService.saveCv(null));

    }

    @Test
    @DisplayName("Teste do PUT/Sucesso do ServiceImpl")
    public void testPutSucessoJogador() throws Exception {

        when(cvService.changeCv(cv,cv.getId())).thenReturn(Optional.ofNullable(cv));

        assertEquals(Optional.of(cv), cvService.changeCv(cv,cv.getId()));

    }

    @Test
    @DisplayName("Teste do PUT/Error do ServiceImpl")
    public void testPutErrorJogador() throws Exception {

        cv.setId(null);

        when(cvService.changeCv(cv,cv.getId())).thenReturn(Optional.ofNullable(cv));

        assertEquals(Optional.of(cv), cvService.changeCv(cv,cv.getId()));

    }

    @Test
    @DisplayName("Teste do FindAll do ServiceImpl")
    public void testFindAll() throws Exception {

        when(cvService.findAll()).thenReturn(cvArrayList);

        assertEquals(cvArrayList, cvService.findAll());

    }
}

