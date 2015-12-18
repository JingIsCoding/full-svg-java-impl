package com.jing.svg.element;


import com.jing.svg.dataType.SVGMatrix;
import com.jing.svg.dataType.SVGRect;

public class SVGLocatableImpl implements SVGLocatable{
    private SVGBaseElement nearestViewportElement;
    private SVGBaseElement farthestViewportElement;
    private SVGElement svgElement;

    SVGLocatableImpl(SVGElement svgElement){
        this.svgElement = svgElement;
    }

    public SVGRect getBBox(){
        return null;
    }
    public SVGMatrix getCTM(){
        return null;
    }
    public SVGMatrix getScreenCTM(){
        return null;
    }
    public SVGMatrix getTransformToElement(SVGBaseElement element) {
        return null;
    }
}