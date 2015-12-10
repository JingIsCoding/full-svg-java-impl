package com.jing.svg.dataType.animated;

import com.jing.svg.dataType.SVGRect;

/**
 * Created by jguo on 12/9/2015.
 */
public class SVGAnimatedRect {
    private SVGRect baseVal;
    private SVGRect animVal;

    public SVGAnimatedRect(SVGRect baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(SVGRect baseVal){
        this.baseVal = baseVal;
    }

    public SVGRect getBaseVal(){
        return baseVal;
    }

    public SVGRect getAnimVal(){
        return animVal;
    }
}
