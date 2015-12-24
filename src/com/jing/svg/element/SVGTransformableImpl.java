package com.jing.svg.element;

import com.jing.svg.animated.SVGAnimatedTransformList;
import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGMatrix;
import com.jing.svg.dataType.SVGRect;
import com.jing.svg.dataType.SVGTransformList;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.TRANSFORM;

public class SVGTransformableImpl implements SVGTransformable {

    SVGElement svgElement = null;
    SVGLocatable svgLocatable;

    public SVGTransformableImpl(SVGElement svgElement){
        this.svgElement = svgElement;
        this.svgLocatable = new SVGLocatableImpl(svgElement);
    }

    public SVGAnimatedTransformList getTransforms(){
         if(!svgElement.hasOwnAttribute(TRANSFORM.toString())){
             return null;
         }
        if(svgElement.getAttributeValue(TRANSFORM.toString()) instanceof String){
            SVGAnimatedTransformList svgAnimatedTransformList = new SVGAnimatedTransformList(new SVGTransformList((String) svgElement.getAttributeValue(TRANSFORM.toString())));
            svgElement.setAttribute(TRANSFORM.toString(),svgAnimatedTransformList);
            return svgAnimatedTransformList;
        }
        else if(svgElement.getAttributeValue(TRANSFORM.toString()) instanceof SVGAnimatedTransformList){
            return (SVGAnimatedTransformList) svgElement.getAttributeValue(TRANSFORM.toString());
        }
        return null;
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
