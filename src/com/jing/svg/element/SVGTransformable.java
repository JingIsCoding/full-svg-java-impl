package com.jing.svg.element;

import com.jing.svg.animated.SVGAnimatedTransformList;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGTransformable extends SVGLocatable {

    SVGAnimatedTransformList transforms;

    public SVGAnimatedTransformList getTransforms(){
        return transforms;
    }

}
