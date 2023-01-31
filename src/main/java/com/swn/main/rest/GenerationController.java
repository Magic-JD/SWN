package com.swn.main.rest;

import com.swn.main.creator.beast.BeastCreator;
import com.swn.main.creator.encounter.EncounterCreator;
import com.swn.main.creator.npc.NpcCreator;
import com.swn.main.creator.world.WorldCreator;
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

    @GetMapping("/world")
    @ResponseBody
    public ResponseEntity<String> generateWorld() {
        return ResponseEntity.ok(world.displayProperties());
    }

    @GetMapping("/npc/standard")
    @ResponseBody
    public ResponseEntity<String> generateStandardNpc() {
        return ResponseEntity.ok(npc.createStandard());
    }

    @GetMapping("/npc/patron")
    @ResponseBody
    public ResponseEntity<String> generatePatronNpc() {
        return ResponseEntity.ok(npc.createPatron());
    }

    @GetMapping("/encounter/wilderness")
    @ResponseBody
    public ResponseEntity<String> generateEncounterWilderness() {
        return ResponseEntity.ok(encounter.createWildernessEncounter());
    }

    @GetMapping("/encounter/urban")
    @ResponseBody
    public ResponseEntity<String> generateEncounterUrban() {
        return ResponseEntity.ok(encounter.createUrbanEncounter());
    }

    @GetMapping("/beast")
    @ResponseBody
    public ResponseEntity<String> generateBeast() {
        return ResponseEntity.ok(beast.createBeast());
    }
}
