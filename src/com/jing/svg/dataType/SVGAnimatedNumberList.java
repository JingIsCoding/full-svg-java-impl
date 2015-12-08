package com.jing.svg.dataType;


public class SVGAnimatedNumberList {
    private SVGNumberList baseVal;
    private SVGNumberList animVal;

    public SVGAnimatedNumberList(SVGNumberList baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(SVGNumberList baseVal){
        this.baseVal = baseVal;
    }

    public SVGNumberList getBaseVal(){
        return baseVal;
    }

    public SVGNumberList getAnimVal(){
        return animVal;
    }
}
