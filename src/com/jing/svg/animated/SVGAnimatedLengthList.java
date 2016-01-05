package com.jing.svg.animated;


import com.jing.svg.dataType.SVGLengthList;

public class SVGAnimatedLengthList extends AnimatedItemList<SVGLengthList>{

    public SVGAnimatedLengthList(SVGLengthList baseVal) {
        super(baseVal);
    }

    public SVGAnimatedLengthList(SVGLengthList baseVal, SVGLengthList animVal){
        super(baseVal,animVal);
    }
}
