package com.swn.main.rest;

import com.swn.main.generator.beast.BeastCreator;
import com.swn.main.generator.encounter.EncounterCreator;
import com.swn.main.generator.npc.NpcCreator;
import com.swn.main.generator.problem.ProblemCreator;
import com.swn.main.generator.world.WorldCreator;
import com.swn.main.property.PropertyBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
public class GenerationController {

    @Autowired WorldCreator world;
    @Autowired NpcCreator npc;
    @Autowired EncounterCreator encounter;
    @Autowired BeastCreator beast;
    @Autowired ProblemCreator problem;

    @GetMapping("/world")
    @ResponseBody
    public ResponseEntity<PropertyBlock> generateWorld() {
        return ResponseEntity.ok(new PropertyBlock(world.displayPropertyInfo()));
    }

    @GetMapping("/npc/standard")
    @ResponseBody
    public ResponseEntity<PropertyBlock> generateStandardNpc() {
        return ResponseEntity.ok(new PropertyBlock(npc.createStandard()));
    }

    @GetMapping("/npc/patron")
    @ResponseBody
    public ResponseEntity<PropertyBlock> generatePatronNpc() {
        return ResponseEntity.ok(new PropertyBlock(npc.createPatron()));
    }

    @GetMapping("/encounter/wilderness")
    @ResponseBody
    public ResponseEntity<PropertyBlock> generateEncounterWilderness() {
        return ResponseEntity.ok(new PropertyBlock(encounter.createWildernessEncounter()));
    }

    @GetMapping("/encounter/urban")
    @ResponseBody
    public ResponseEntity<PropertyBlock> generateEncounterUrban() {
        return ResponseEntity.ok(new PropertyBlock(encounter.createUrbanEncounter()));
    }

    @GetMapping("/beast")
    @ResponseBody
    public ResponseEntity<PropertyBlock> generateBeast() {
        return ResponseEntity.ok(new PropertyBlock(beast.createBeast()));
    }

    @GetMapping("/problem")
    @ResponseBody
    public ResponseEntity<PropertyBlock> generateProblem() {
        return ResponseEntity.ok(new PropertyBlock(problem.displayPropertyInfo()));
    }
}
