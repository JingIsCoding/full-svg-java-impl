package com.jing.svg.animated;


import com.jing.svg.dataType.SVGLength;

public class SVGAnimatedLength extends AnimatedItemList<SVGLength>{

    public SVGAnimatedLength(SVGLength baseVal) {
        super(baseVal);
    }

    public SVGAnimatedLength(SVGLength baseVal, SVGLength animVal){
        super(baseVal,animVal);
    }
}
