package com.jing.svg.dataType.animated;

public class SVGAnimatedInteger {

    private int baseVal;
    private int animVal;

    public SVGAnimatedInteger(int baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(int baseVal){
        this.baseVal = baseVal;
    }

    public int getBaseVal(){
        return baseVal;
    }

    public int getAnimVal(){
        return animVal;
    }
}
