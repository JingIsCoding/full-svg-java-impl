package com.jing.svg.animated;

import com.jing.svg.dataType.SVGAngle;

public class SVGAnimatedBoolean extends AnimatedItemList<Boolean> {

    public SVGAnimatedBoolean(boolean baseVal) {
        super(baseVal);
    }

    public SVGAnimatedBoolean(boolean baseVal, boolean animVal){
        super(baseVal,animVal);
    }
}
