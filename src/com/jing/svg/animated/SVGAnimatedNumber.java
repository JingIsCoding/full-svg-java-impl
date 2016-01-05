package com.jing.svg.animated;

import com.jing.svg.dataType.SVGLengthList;

public class SVGAnimatedNumber extends AnimatedItemList<Double>{

    public SVGAnimatedNumber(double baseVal) {
        super(baseVal);
    }

    public SVGAnimatedNumber(double baseVal, double animVal){
        super(baseVal,animVal);
    }
}
