package com.jing.svg.animated;

import com.jing.svg.dataType.SVGPreserveAspectRatio;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGAnimatedPreserveAspectRatio {
    private SVGPreserveAspectRatio baseVal;
    private SVGPreserveAspectRatio animVal;


    public SVGPreserveAspectRatio getAnimVal() {
        return animVal;
    }

    public SVGPreserveAspectRatio getBaseVal() {
        return baseVal;
    }
}
