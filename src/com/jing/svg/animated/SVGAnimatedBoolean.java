package com.jing.svg.animated;

public class SVGAnimatedBoolean {

    private boolean baseVal;
    private boolean animVal;

    public SVGAnimatedBoolean(boolean baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(boolean baseVal){
        this.baseVal = baseVal;
    }

    public boolean getBaseVal(){
        return baseVal;
    }

    public boolean getAnimVal(){
        return animVal;
    }
}
