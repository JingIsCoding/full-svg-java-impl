package com.jing.svg.animated;

import com.jing.svg.dataType.SVGTransformList;

public class SVGAnimatedTransformList extends AnimatedItemList<SVGTransformList> {
    public SVGAnimatedTransformList(SVGTransformList baseVal) {
        super(baseVal);
    }

    public SVGAnimatedTransformList(SVGTransformList baseVal, SVGTransformList animVal){
        super(baseVal,animVal);
    }
}
