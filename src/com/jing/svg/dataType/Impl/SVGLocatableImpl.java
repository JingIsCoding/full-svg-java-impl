package com.jing.svg.dataType.Impl;

import com.jing.svg.dataType.SVGElement;
import com.jing.svg.dataType.SVGLocatable;
import com.jing.svg.dataType.SVGMatrix;
import com.jing.svg.dataType.SVGRect;

public class SVGLocatableImpl implements SVGLocatable{
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