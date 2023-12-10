package com.swn.main.creator.pc.origin;

import com.swn.main.tooltip.ToolTipExtractor;
import org.springframework.stereotype.Component;

@Component
public class OriginToolTipExtractor extends ToolTipExtractor {

    @Override
    protected String filePath() {
        return "./src/main/resources/tooltip/pc/origin/";
    }
}
