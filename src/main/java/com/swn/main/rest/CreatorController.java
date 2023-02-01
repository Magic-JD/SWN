package com.swn.main.rest;

import com.swn.main.creator.pc.origin.OriginCreator;
import com.swn.main.creator.pc.origin.OriginDisplayProperties;
import com.swn.main.creator.pc.statblock.StatBlockCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create")
public class CreatorController {

    @Autowired StatBlockCreator statBlock;
    @Autowired OriginCreator origin;

    @GetMapping("/pc/stat-block")
    @ResponseBody
    public ResponseEntity<String> generatePcStatBlock() {
        return ResponseEntity.ok(statBlock.displayProperties());
    }

    @GetMapping("/pc/origin")
    @ResponseBody
    public ResponseEntity<String> generatePcOrigin() {
        return ResponseEntity.ok(origin.createOrigin());
    }

    @GetMapping("/pc/tooltip/origin/{origin}")
    @ResponseBody
    public ResponseEntity<String> generateOriginTooltip(@PathVariable String origin) {
        return ResponseEntity.ok(this.origin.originTooltip(origin));
    }

}
