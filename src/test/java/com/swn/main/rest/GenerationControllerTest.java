package com.swn.main.rest;

import com.swn.main.beast.properties.BeastPropertySupplier;
import com.swn.main.encounter.urban.properties.UrbanEncounterPropertySupplier;
import com.swn.main.encounter.wilderness.properties.WildernessEncounterPropertySupplier;
import com.swn.main.npc.patron.properties.PatronNpcPropertySupplier;
import com.swn.main.npc.properties.NpcPropertySupplier;
import com.swn.main.npc.standard.properties.StandardNpcPropertySupplier;
import com.swn.main.property.supplier.PropertySupplier;
import com.swn.main.world.properties.WorldPropertySupplier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenerationControllerTest {

    @Autowired GenerationController controller;
    @Autowired List<WorldPropertySupplier> worldProperties;
    @Autowired List<StandardNpcPropertySupplier> standardNpcProperties;
    @Autowired List<PatronNpcPropertySupplier> patronNpcProperties;
    @Autowired List<UrbanEncounterPropertySupplier> urbanEncounterProperties;
    @Autowired List<WildernessEncounterPropertySupplier> wildernessEncounterProperties;
    @Autowired List<BeastPropertySupplier> beastProperties;

    @Test
    public void shouldGenerateWorldWithAllProperties(){
        ResponseEntity<String> response = controller.generateWorld();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(worldProperties.isEmpty());
        for(WorldPropertySupplier creator : worldProperties){
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
        for(StandardNpcPropertySupplier creator : standardNpcProperties){
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
        List<NpcPropertySupplier> suppliers = Stream.concat(patronNpcProperties.stream(), standardNpcProperties.stream()).toList();
        for(NpcPropertySupplier creator : suppliers){
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
        for(UrbanEncounterPropertySupplier creator : urbanEncounterProperties){
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
        for(WildernessEncounterPropertySupplier creator : wildernessEncounterProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(response.getBody().contains(simpleName), "Does not contain property " + simpleName);
        }
    }

    @Test
    public void shouldGenerateBeastWithAllProperties(){
        ResponseEntity<String> response = controller.generateBeast();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(beastProperties.isEmpty());
        for(BeastPropertySupplier creator : beastProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(response.getBody().contains(simpleName), "Does not contain property " + simpleName);
        }
    }
}