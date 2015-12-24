package com.jing.svg.animated;

import com.jing.svg.dataType.SVGPreserveAspectRatio;


public class SVGAnimatedPreserveAspectRatio {
    private SVGPreserveAspectRatio baseVal;
    private SVGPreserveAspectRatio animVal;

    public SVGAnimatedPreserveAspectRatio(SVGPreserveAspectRatio baseVal){
        this.baseVal = baseVal;
    }

    public SVGPreserveAspectRatio getAnimVal() {
        return animVal;
    }

    public SVGPreserveAspectRatio getBaseVal() {
        return baseVal;
    }
}
