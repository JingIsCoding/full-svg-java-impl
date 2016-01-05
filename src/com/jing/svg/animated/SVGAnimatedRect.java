package com.jing.svg.animated;

import com.jing.svg.dataType.SVGRect;

public class SVGAnimatedRect extends AnimatedItemList<SVGRect>{
    public SVGAnimatedRect(SVGRect baseVal) {
        super(baseVal);
    }

    public SVGAnimatedRect(SVGRect baseVal, SVGRect animVal){
        super(baseVal,animVal);
    }
}
