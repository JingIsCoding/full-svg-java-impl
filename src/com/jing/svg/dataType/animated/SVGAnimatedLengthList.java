package com.jing.svg.dataType.animated;


import com.jing.svg.dataType.SVGLengthList;

public class SVGAnimatedLengthList {
    private SVGLengthList baseVal;
    private SVGLengthList animVal;

    public SVGAnimatedLengthList(SVGLengthList baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(SVGLengthList baseVal){
        this.baseVal = baseVal;
    }

    public SVGLengthList getBaseVal(){
        return baseVal;
    }

    public SVGLengthList getAnimVal(){
        return animVal;
    }
}
