package com.jing.svg.element;


import com.jing.svg.dataType.SVGMatrix;
import com.jing.svg.dataType.SVGRect;

public class SVGLocatable {
    private SVGElement nearestViewportElement;
    private SVGElement farthestViewportElement;

    public SVGRect getBBox(){
        return null;
    }
    public SVGMatrix getCTM(){
        return null;
    }
    public SVGMatrix getScreenCTM(){
        return null;
    }
    public SVGMatrix getTransformToElement(SVGElement element) {
        return null;
    }
}