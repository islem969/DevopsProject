package com.example.intershipmanagement;

import com.example.intershipmanagement.Servise.ServiseOffreS;
import com.example.intershipmanagement.entities.Demandes;
import com.example.intershipmanagement.entities.OffresStages;
import com.example.intershipmanagement.entities.Technologies;
import com.example.intershipmanagement.repositories.OffreRepository;
import com.example.intershipmanagement.repositories.TechRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiseOffreSTest {

    @Mock
    private OffreRepository offreRepository;

    @Mock
    private TechRepository technologiesRepository;

    @InjectMocks
    private ServiseOffreS serviseOffreS;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAjouterOffresStage() {
        OffresStages offresStages = new OffresStages();
        when(offreRepository.save(offresStages)).thenReturn(offresStages);

        OffresStages result = serviseOffreS.ajouterOffresStage(offresStages);

        assertNotNull(result);
        verify(offreRepository, times(1)).save(offresStages);
    }

    @Test
    void testCreatOffresStage() {
        OffresStages offre = new OffresStages();
        Long techId = 1L;
        Technologies technology = new Technologies();
        technology.setId(techId);

        Set<Long> technologyIds = new HashSet<>();
        technologyIds.add(techId);

        when(technologiesRepository.findById(techId)).thenReturn(Optional.of(technology));
        when(offreRepository.save(offre)).thenReturn(offre);

        OffresStages result = serviseOffreS.creatOffresStage(offre, technologyIds);

        assertNotNull(result);
        assertTrue(result.getTechnologies().contains(technology)); // Correct method name
        verify(offreRepository, times(1)).save(offre);
        verify(technologiesRepository, times(1)).findById(techId);
    }

    @Test
    void testUpdateOffresStage_ExistingId() {
        OffresStages offresStages = new OffresStages();
        offresStages.setIdoff(1L);
        when(offreRepository.existsById(offresStages.getIdoff())).thenReturn(true);
        when(offreRepository.save(offresStages)).thenReturn(offresStages);

        OffresStages result = serviseOffreS.updateOffresStage(offresStages);

        assertNotNull(result);
        verify(offreRepository, times(1)).save(offresStages);
    }

    @Test
    void testUpdateOffresStage_NonExistingId() {
        OffresStages offresStages = new OffresStages();
        offresStages.setIdoff(1L);
        when(offreRepository.existsById(offresStages.getIdoff())).thenReturn(false);

        OffresStages result = serviseOffreS.updateOffresStage(offresStages);

        assertNull(result);
        verify(offreRepository, never()).save(offresStages);
    }

    @Test
    void testUpdateRating() {
        Long id = 1L;
        int newRating = 5;
        OffresStages offresStages = new OffresStages();
        offresStages.setIdoff(id);

        when(offreRepository.findById(id)).thenReturn(Optional.of(offresStages));
        when(offreRepository.save(offresStages)).thenReturn(offresStages);

        OffresStages result = serviseOffreS.updateRating(id, newRating);

        assertNotNull(result);
        assertEquals(newRating, result.getStarRating());
        verify(offreRepository, times(1)).save(offresStages);
    }

    @Test
    void testFindByEtat() {
        String etat = "En Court";
        List<OffresStages> offresList = new ArrayList<>();
        when(offreRepository.findByEtat(etat)).thenReturn(offresList);

        List<OffresStages> result = serviseOffreS.findByEtat(etat);

        assertNotNull(result);
        verify(offreRepository, times(1)).findByEtat(etat);
    }

    @Test
    void testGetOffresStageById() {
        Long id = 1L;
        OffresStages offresStages = new OffresStages();
        when(offreRepository.findById(id)).thenReturn(Optional.of(offresStages));

        OffresStages result = serviseOffreS.getOffresStageById(id);

        assertNotNull(result);
        verify(offreRepository, times(1)).findById(id);
    }

    @Test
    void testDeleteOffresStage() {
        Long id = 1L;

        serviseOffreS.deleteOffresStage(id);

        verify(offreRepository, times(1)).deleteById(id);
    }

    @Test
    void testArchiverOffre() {
        Long id = 1L;
        OffresStages offresStages = new OffresStages();
        when(offreRepository.findById(id)).thenReturn(Optional.of(offresStages));

        serviseOffreS.archiverOffre(id);

        assertEquals("Archiver", offresStages.getEtat()); // Vérifie l'état correct
        verify(offreRepository, times(1)).save(offresStages);
    }
}
