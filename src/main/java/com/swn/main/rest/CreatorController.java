package com.swn.main.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class CreatorController {



    @GetMapping("/pc/stat-block")
    @ResponseBody
    public ResponseEntity<String> generatePcAttributes() {
        return ResponseEntity.ok("This will contain the PC stat-block");
    }

}
