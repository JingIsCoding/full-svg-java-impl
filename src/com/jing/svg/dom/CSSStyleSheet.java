package com.jing.svg.dom;

import com.jing.svg.SVGSVGElement;

import java.util.ArrayList;
import java.util.List;

public class CSSStyleSheet {
    private List<CSSStyleRule> cssStyleRules;

    public CSSStyleSheet(String style){
        cssStyleRules = new ArrayList<>();
        parseStyle(style);
    }

    private void parseStyle(String style) {
        String cleanStyle = style.replaceAll("//.*|/\\*((.|\\n)(?!=*/))+\\*/", "");
        String[] parts = cleanStyle.split("}");
        for(String part : parts){
            String[] selectorAndRules = part.split("\\{");
            cssStyleRules.add(new CSSStyleRule(selectorAndRules[0].trim(),selectorAndRules[1].trim(), null, this));
        }
    }


    public List<CSSStyleRule> getCssStyleRules() {
        return cssStyleRules;
    }

    public void apply(SVGSVGElement ownerSVGElement) {

    }
}
