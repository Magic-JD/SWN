package com.swn.main.rest;

import com.swn.main.generator.beast.BeastPropertySupplier;
import com.swn.main.generator.encounter.urban.UrbanEncounterPropertySupplier;
import com.swn.main.generator.encounter.wilderness.WildernessEncounterPropertySupplier;
import com.swn.main.generator.npc.patron.PatronNpcPropertySupplier;
import com.swn.main.generator.npc.NpcPropertySupplier;
import com.swn.main.generator.npc.standard.StandardNpcPropertySupplier;
import com.swn.main.generator.npc.universal.UniversalNpcPropertySupplier;
import com.swn.main.generator.problem.ProblemPropertySupplier;
import com.swn.main.generator.world.WorldPropertySupplier;
import com.swn.main.property.PropertyBlock;
import com.swn.main.property.PropertyInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
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
    @Autowired List<UniversalNpcPropertySupplier> universalNpcProperties;
    @Autowired List<ProblemPropertySupplier> problemProperties;

    @Test
    public void shouldGenerateWorldWithAllProperties(){
        ResponseEntity<PropertyBlock> response = controller.generateWorld();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        PropertyBlock block = response.getBody();
        List<PropertyInfo> infos = block.properties();
        assertFalse(worldProperties.isEmpty());
        for(WorldPropertySupplier creator : worldProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(infos.stream().anyMatch(p -> p.name().equals(simpleName)));
        }
    }

    @Test
    public void shouldGenerateStandardNpcWithAllProperties(){
        ResponseEntity<PropertyBlock> response = controller.generateStandardNpc();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        PropertyBlock block = response.getBody();
        List<PropertyInfo> infos = block.properties();
        assertFalse(standardNpcProperties.isEmpty());
        List<NpcPropertySupplier> suppliers = Stream.concat(universalNpcProperties.stream(), standardNpcProperties.stream()).toList();

        for(NpcPropertySupplier creator : suppliers){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(infos.stream().anyMatch(p -> p.name().equals(simpleName)));
        }
    }

    @Test
    public void shouldGeneratePatronNpcWithAllProperties(){
        ResponseEntity<PropertyBlock> response = controller.generatePatronNpc();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        PropertyBlock block = response.getBody();
        List<PropertyInfo> infos = block.properties();
        assertFalse(patronNpcProperties.isEmpty());
        List<NpcPropertySupplier> suppliers = Stream.concat(universalNpcProperties.stream(), Stream.concat(patronNpcProperties.stream(), standardNpcProperties.stream())).toList();
        for(NpcPropertySupplier creator : suppliers){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(infos.stream().anyMatch(p -> p.name().equals(simpleName)));
        }
    }

    @Test
    public void shouldGenerateUrbanEncounterWithAllProperties(){
        ResponseEntity<PropertyBlock> response = controller.generateEncounterUrban();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        PropertyBlock block = response.getBody();
        List<PropertyInfo> infos = block.properties();
        assertFalse(urbanEncounterProperties.isEmpty());
        for(UrbanEncounterPropertySupplier creator : urbanEncounterProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(infos.stream().anyMatch(p -> p.name().equals(simpleName)));
        }
    }


    @Test
    public void shouldGenerateWildernessEncounterWithAllProperties(){
        ResponseEntity<PropertyBlock> response = controller.generateEncounterWilderness();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        PropertyBlock block = response.getBody();
        List<PropertyInfo> infos = block.properties();
        assertFalse(wildernessEncounterProperties.isEmpty());
        for(WildernessEncounterPropertySupplier creator : wildernessEncounterProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(infos.stream().anyMatch(p -> p.name().equals(simpleName)));
        }
    }

    @Test
    public void shouldGenerateBeastWithAllProperties(){
        ResponseEntity<PropertyBlock> response = controller.generateBeast();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        PropertyBlock block = response.getBody();
        List<PropertyInfo> infos = block.properties();
        assertFalse(beastProperties.isEmpty());
        for(BeastPropertySupplier creator : beastProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(infos.stream().anyMatch(p -> p.name().equals(simpleName)));
        }
    }

    @Test
    public void shouldGenerateProblemWithAllProperties(){
        ResponseEntity<PropertyBlock> response = controller.generateProblem();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        PropertyBlock block = response.getBody();
        List<PropertyInfo> infos = block.properties();
        assertFalse(problemProperties.isEmpty());
        for(ProblemPropertySupplier creator : problemProperties){
            String simpleName = creator.getClass().getSimpleName();
            System.out.println("Testing: " + simpleName);
            assertTrue(infos.stream().anyMatch(p -> p.name().equals(simpleName)));
        }
    }
}