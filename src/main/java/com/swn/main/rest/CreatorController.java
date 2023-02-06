package com.swn.main.rest;

import com.swn.main.creator.pc.origin.OriginCreator;
import com.swn.main.creator.pc.origin.OriginDetailsCollection;
import com.swn.main.creator.pc.skill.FurtherChoices;
import com.swn.main.creator.pc.skill.RollSkills;
import com.swn.main.creator.pc.skill.SkillCreator;
import com.swn.main.creator.pc.skill.SkillSet;
import com.swn.main.creator.pc.statblock.PropertyNameBlock;
import com.swn.main.creator.pc.statblock.StatBlockCreator;
import com.swn.main.creator.pc.statblock.properties.StatPropertyBlock;
import com.swn.main.property.PropertyBlock;
import com.swn.main.property.PropertyInfo;
import com.swn.main.table.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/create")
public class CreatorController {

    @Autowired StatBlockCreator statBlock;
    @Autowired OriginCreator origin;
    @Autowired SkillCreator skill;
    @Autowired RollController roll;

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

    @PostMapping("/pc/skills/generate")
    @ResponseBody
    public ResponseEntity<FurtherChoices> generateSkills(@RequestBody RollSkills rollSkills){
        PropertyInfo body = roll.rollTable(new Table(rollSkills.name(), rollSkills.table())).getBody();
        assert body != null;
        return ResponseEntity.ok(skill.findRollFurtherChoices(new SkillSet(rollSkills.chosen(), body.details(), new HashSet<>())));
    }
}
