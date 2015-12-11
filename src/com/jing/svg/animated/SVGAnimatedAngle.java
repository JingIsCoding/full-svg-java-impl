package com.jing.svg.animated;

import com.jing.svg.dataType.SVGAngle;

public class SVGAnimatedAngle {

    private SVGAngle baseVal;
    private SVGAngle animVal;

    public SVGAnimatedAngle(SVGAngle baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(SVGAngle baseVal){
        this.baseVal = baseVal;
    }

    public SVGAngle getBaseVal(){
        return baseVal;
    }

    public SVGAngle getAnimVal(){
        return animVal;
    }
}
