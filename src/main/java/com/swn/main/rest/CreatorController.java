package com.swn.main.rest;

import com.swn.main.creator.pc.origin.OriginCreator;
import com.swn.main.creator.pc.statblock.StatBlockCreator;
import com.swn.main.property.PropertyBlock;
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
    public ResponseEntity<PropertyBlock> generatePcStatBlock() {
        return ResponseEntity.ok(new PropertyBlock(statBlock.displayPropertyInfo()));
    }

    @GetMapping("/pc/origin")
    @ResponseBody
    public ResponseEntity<PropertyBlock> generatePcOrigin() {
        return ResponseEntity.ok(new PropertyBlock(origin.createOrigin()));
    }

    @GetMapping("/pc/origin/{origin}")
    @ResponseBody
    public ResponseEntity<PropertyBlock> findPcOrigin(@PathVariable String origin) {
        return ResponseEntity.ok(new PropertyBlock(this.origin.findOrigin(origin)));
    }

    @GetMapping("/pc/tooltip/origin/{origin}")
    @ResponseBody
    public ResponseEntity<String> generateOriginTooltip(@PathVariable String origin) {
        return ResponseEntity.ok(this.origin.originTooltip(origin));
    }

}
