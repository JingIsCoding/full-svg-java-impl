package com.jing.svg.animated;

public class SVGAnimatedInteger extends AnimatedItemList<Integer> {

    public SVGAnimatedInteger(int baseVal) {
        super(baseVal);
    }

    public SVGAnimatedInteger(int baseVal, int animVal){
        super(baseVal,animVal);
    }
}
