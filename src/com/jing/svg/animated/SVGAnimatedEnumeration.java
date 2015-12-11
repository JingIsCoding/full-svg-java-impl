package com.jing.svg.animated;

public class SVGAnimatedEnumeration {
    private short baseVal;
    private short animVal;

    public SVGAnimatedEnumeration(short baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(short baseVal){
        this.baseVal = baseVal;
    }

    public short getBaseVal(){
        return baseVal;
    }

    public short getAnimVal(){
        return animVal;
    }
}
