package com.swn.main.rest;

import com.swn.main.npc.NpcCreator;
import com.swn.main.world.WorldCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
public class GenerationController {

    @Autowired WorldCreator worldCreator;
    @Autowired NpcCreator npcCreator;

    @GetMapping("/world")
    @ResponseBody
    public ResponseEntity<String> generateWorld(){
        return ResponseEntity.ok(worldCreator.displayProperties());
    }

    @GetMapping("/npc/standard")
    @ResponseBody
    public ResponseEntity<String> generateStandardNpc() {
        return ResponseEntity.ok(npcCreator.createStandard());
    }

    @GetMapping("/npc/patron")
    @ResponseBody
    public ResponseEntity<String> generatePatronNpc() {
        return ResponseEntity.ok(npcCreator.createPatron());
    }
}
