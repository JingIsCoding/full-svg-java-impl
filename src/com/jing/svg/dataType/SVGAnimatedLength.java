package com.jing.svg.dataType;


public class SVGAnimatedLength {
    private SVGLength baseVal;
    private SVGLength animVal;

    public SVGAnimatedLength(SVGLength baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(SVGLength baseVal){
        this.baseVal = baseVal;
    }

    public SVGLength getBaseVal(){
        return baseVal;
    }

    public SVGLength getAnimVal(){
        return animVal;
    }
}
