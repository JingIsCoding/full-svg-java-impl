package com.jing.svg.animated;

public class SVGAnimatedString extends AnimatedItemList<String>{
    public SVGAnimatedString(String baseVal) {
        super(baseVal);
    }

    public SVGAnimatedString(String baseVal, String animVal){
        super(baseVal,animVal);
    }
}
