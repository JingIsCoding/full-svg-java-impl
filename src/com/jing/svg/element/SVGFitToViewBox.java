package com.jing.svg.element;

import com.jing.svg.animated.SVGAnimatedPreserveAspectRatio;
import com.jing.svg.animated.SVGAnimatedRect;

public interface SVGFitToViewBox {

    SVGAnimatedPreserveAspectRatio getPreserveAspectRatio();

    SVGAnimatedRect getViewBox();
}
