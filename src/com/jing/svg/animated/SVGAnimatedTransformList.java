package com.jing.svg.animated;

import com.jing.svg.dataType.SVGTransformList;

public class SVGAnimatedTransformList {

    private SVGTransformList baseVal;
    private SVGTransformList animVal;

    public SVGAnimatedTransformList(SVGTransformList baseVal) {
        this.baseVal = baseVal;
    }

    public void setBaseVal(SVGTransformList baseVal){
        this.baseVal = baseVal;
    }

    public SVGTransformList getBaseVal(){
        return baseVal;
    }

    public SVGTransformList getAnimVal(){
        return animVal;
    }
}
