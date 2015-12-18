package com.jing.svg.element;


import com.jing.svg.dataType.SVGMatrix;
import com.jing.svg.dataType.SVGRect;

public interface SVGLocatable {
    SVGRect getBBox();
    SVGMatrix getCTM();
    SVGMatrix getScreenCTM();
    SVGMatrix getTransformToElement(SVGBaseElement element);
}