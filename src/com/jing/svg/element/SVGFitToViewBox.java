package com.jing.svg.element;

import com.jing.svg.animated.SVGAnimatedPreserveAspectRatio;
import com.jing.svg.animated.SVGAnimatedRect;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGFitToViewBox {

    SVGAnimatedRect viewBox;

    public void setPreserveAspectRatio(SVGAnimatedPreserveAspectRatio preserveAspectRatio) {
        this.preserveAspectRatio = preserveAspectRatio;
    }

    public void setViewBox(SVGAnimatedRect viewBox) {
        this.viewBox = viewBox;
    }

    SVGAnimatedPreserveAspectRatio preserveAspectRatio;

    public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }

    public SVGAnimatedRect getViewBox() {
        return viewBox;
    }
}
