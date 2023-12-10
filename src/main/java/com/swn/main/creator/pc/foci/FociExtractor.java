package com.swn.main.creator.pc.foci;

import com.swn.main.tooltip.ToolTipExtractor;
import org.springframework.stereotype.Component;

@Component
public class FociExtractor extends ToolTipExtractor {

    @Override
    protected String filePath() {
        return "/creator/pc/foci/";
    }
}
