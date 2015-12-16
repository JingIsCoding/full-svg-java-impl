package com.jing.svg.element;


import com.jing.svg.dataType.SVGMatrix;
import com.jing.svg.dataType.SVGRect;

public class SVGLocatable {
    private SVGElementImpl nearestViewportElement;
    private SVGElementImpl farthestViewportElement;

    public SVGRect getBBox(){
        return null;
    }
    public SVGMatrix getCTM(){
        return null;
    }
    public SVGMatrix getScreenCTM(){
        return null;
    }
    public SVGMatrix getTransformToElement(SVGElementImpl element) {
        return null;
    }
}