package com.jing.svg;


import com.jing.svg.element.SVGElement;
import com.jing.svg.element.SVGElementImpl;

import static com.jing.svg.dataType.Constants.TagName.DEFS;

public class SVGDefsElement {
    private SVGElement svgElement = new SVGElementImpl(DEFS);

    public SVGElement getElementById(String id){
        return svgElement.getElementById(id);
    }
}
