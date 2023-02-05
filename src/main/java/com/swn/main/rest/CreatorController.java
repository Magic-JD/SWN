package com.swn.main.rest;

import com.swn.main.creator.pc.origin.OriginCreator;
import com.swn.main.creator.pc.origin.OriginDetailsCollection;
import com.swn.main.creator.pc.skill.FurtherChoices;
import com.swn.main.creator.pc.skill.SkillCreator;
import com.swn.main.creator.pc.skill.SkillSet;
import com.swn.main.creator.pc.statblock.PropertyNameBlock;
import com.swn.main.creator.pc.statblock.StatBlockCreator;
import com.swn.main.creator.pc.statblock.properties.StatPropertyBlock;
import com.swn.main.property.PropertyBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create")
public class CreatorController {

    @Autowired StatBlockCreator statBlock;
    @Autowired OriginCreator origin;
    @Autowired SkillCreator skill;

    @GetMapping("/pc/stat-block")
    @ResponseBody
    public ResponseEntity<StatPropertyBlock> generatePcStatBlock() {
        return ResponseEntity.ok(new StatPropertyBlock(statBlock.getStatBlockInfo()));
    }

    @GetMapping("/pc/stat-block/names")
    @ResponseBody
    public ResponseEntity<PropertyNameBlock> getAllStats() {
        return ResponseEntity.ok(new PropertyNameBlock(statBlock.getAllPropertyNames()));
    }

    @GetMapping("/pc/origin")
    @ResponseBody
    public ResponseEntity<PropertyBlock> generatePcOrigin() {
        return ResponseEntity.ok(new PropertyBlock(origin.createOrigin()));
    }

    @GetMapping("/pc/origin/all")
    @ResponseBody
    public ResponseEntity<OriginDetailsCollection> allOriginDetails() {
        return ResponseEntity.ok(new OriginDetailsCollection(origin.getAllOriginDetails()));
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

    @PostMapping("/pc/skills/update")
    @ResponseBody
    public ResponseEntity<FurtherChoices> updateSkills(@RequestBody SkillSet skillSet){
        return ResponseEntity.ok(skill.findFurtherChoices(skillSet));
    }

}
