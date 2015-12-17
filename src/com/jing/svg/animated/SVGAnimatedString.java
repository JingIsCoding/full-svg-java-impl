package com.jing.svg.animated;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGAnimatedString {
    private String baseVal;
    private String animVal;

    public SVGAnimatedString(String baseVal){
        this(baseVal,null);
    }

    public SVGAnimatedString(String baseVal,String animVal){
        this.baseVal= baseVal;
        this.animVal = animVal;
    }

    public String getAnimVal() {
        return animVal;
    }

    public String getBaseVal() {
        return baseVal;
    }
}
