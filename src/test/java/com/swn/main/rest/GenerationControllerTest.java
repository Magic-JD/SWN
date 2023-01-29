package com.swn.main.rest;

import com.swn.main.encounter.urban.properties.UrbanEncounterPropertyCreator;
import com.swn.main.encounter.wilderness.properties.WildernessEncounterPropertyCreator;
import com.swn.main.npc.patron.properties.PatronNpcPropertyCreator;
import com.swn.main.npc.standard.properties.StandardNpcPropertyCreator;
import com.swn.main.world.properties.WorldPropertyCreator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenerationControllerTest {

    @Autowired GenerationController controller;
    @Autowired List<WorldPropertyCreator> worldProperties;
    @Autowired List<StandardNpcPropertyCreator> standardNpcProperties;
    @Autowired List<PatronNpcPropertyCreator> patronNpcProperties;
    @Autowired List<UrbanEncounterPropertyCreator> urbanEncounterProperties;
    @Autowired List<WildernessEncounterPropertyCreator> wildernessEncounterProperties;

    @Test
    public void shouldGenerateWorldWithAllProperties(){
        ResponseEntity<String> response = controller.generateWorld();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(worldProperties.isEmpty());
        for(WorldPropertyCreator creator : worldProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(response.getBody().contains(simpleName));
        }
    }

    @Test
    public void shouldGenerateStandardNpcWithAllProperties(){
        ResponseEntity<String> response = controller.generateStandardNpc();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(standardNpcProperties.isEmpty());
        for(StandardNpcPropertyCreator creator : standardNpcProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(response.getBody().contains(simpleName), "Does not contain property " + simpleName);
        }
    }

    @Test
    public void shouldGeneratePatronNpcWithAllProperties(){
        ResponseEntity<String> response = controller.generatePatronNpc();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(patronNpcProperties.isEmpty());
        for(PatronNpcPropertyCreator creator : patronNpcProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(response.getBody().contains(simpleName), "Does not contain property " + simpleName);
        }
    }

    @Test
    public void shouldGenerateUrbanEncounterWithAllProperties(){
        ResponseEntity<String> response = controller.generateEncounterUrban();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(urbanEncounterProperties.isEmpty());
        for(UrbanEncounterPropertyCreator creator : urbanEncounterProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(response.getBody().contains(simpleName), "Does not contain property " + simpleName);
        }
    }


    @Test
    public void shouldGenerateWildernessEncounterWithAllProperties(){
        ResponseEntity<String> response = controller.generateEncounterWilderness();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(wildernessEncounterProperties.isEmpty());
        for(WildernessEncounterPropertyCreator creator : wildernessEncounterProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(response.getBody().contains(simpleName), "Does not contain property " + simpleName);
        }
    }
}