package com.swn.main.rest;

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

    @GetMapping("/world")
    @ResponseBody
    public ResponseEntity<String> generateWorld(){
        return ResponseEntity.ok(worldCreator.getWorld());
    }
}
