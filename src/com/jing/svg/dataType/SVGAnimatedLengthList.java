package com.jing.svg.dataType;


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
