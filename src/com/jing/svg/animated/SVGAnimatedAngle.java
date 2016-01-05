package com.jing.svg.animated;

import com.jing.svg.dataType.SVGAngle;
import com.jing.svg.dataType.SVGLengthList;

public class SVGAnimatedAngle extends AnimatedItemList<SVGAngle>{

    public SVGAnimatedAngle(SVGAngle baseVal) {
        super(baseVal);
    }

    public SVGAnimatedAngle(SVGAngle baseVal, SVGAngle animVal){
        super(baseVal,animVal);
    }
}
