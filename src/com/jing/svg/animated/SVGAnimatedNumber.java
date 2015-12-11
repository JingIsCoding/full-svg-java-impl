package com.jing.svg.animated;

public class SVGAnimatedNumber {
    private double baseVal;
    private double animVal;

    public SVGAnimatedNumber(double baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(double baseVal){
        this.baseVal = baseVal;
    }

    public double getBaseVal(){
        return baseVal;
    }

    public double getAnimVal(){
        return animVal;
    }
}
