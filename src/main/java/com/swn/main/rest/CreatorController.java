package com.swn.main.rest;

import com.swn.main.creator.pc.statblock.StatBlockCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class CreatorController {

    @Autowired StatBlockCreator statBlock;

    @GetMapping("/pc/stat-block")
    @ResponseBody
    public ResponseEntity<String> generatePcStatBlock() {
        return ResponseEntity.ok(statBlock.displayProperties());
    }

}
