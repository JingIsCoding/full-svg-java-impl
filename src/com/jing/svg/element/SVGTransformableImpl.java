package com.jing.svg.element;

import com.jing.svg.animated.SVGAnimatedTransformList;
import com.jing.svg.dataType.SVGMatrix;
import com.jing.svg.dataType.SVGRect;

public class SVGTransformableImpl implements SVGTransformable {

    SVGElement svgElement = null;
    SVGAnimatedTransformList transforms;
    SVGLocatable svgLocatable;

    public SVGTransformableImpl(SVGElement svgElement){
        this.svgElement = svgElement;
        this.svgLocatable = new SVGLocatableImpl(svgElement);
    }

    public SVGAnimatedTransformList getTransforms(){
        return transforms;
    }

    @Override
    public SVGRect getBBox() {
        return svgLocatable.getBBox();
    }

    @Override
    public SVGMatrix getCTM() {
        return svgLocatable.getCTM();
    }

    @Override
    public SVGMatrix getScreenCTM() {
        return svgLocatable.getScreenCTM();
    }

    @Override
    public SVGMatrix getTransformToElement(SVGBaseElement element) {
        return svgLocatable.getTransformToElement(element);
    }
}
