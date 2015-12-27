package com.jing.svg.element;

import com.jing.svg.animated.SVGAnimatedPreserveAspectRatio;
import com.jing.svg.animated.SVGAnimatedRect;
import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGPreserveAspectRatio;
import com.jing.svg.dataType.SVGRect;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.PRESERVE_ASPECT_RATIO;
import static com.jing.svg.dataType.Constants.ElementAttributeNames.VIEW_BOX;

public class SVGFitToViewBoxImpl implements SVGFitToViewBox{
    SVGElement svgElement;

    public SVGFitToViewBoxImpl(SVGElement svgElement){
        this.svgElement = svgElement;
    }

    public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        if(!svgElement.hasOwnAttribute(PRESERVE_ASPECT_RATIO.toString())){
            return null;
        }
        Object attributeValue = svgElement.getAttributeValue(PRESERVE_ASPECT_RATIO.toString());
        if(attributeValue instanceof SVGAnimatedPreserveAspectRatio)
            return (SVGAnimatedPreserveAspectRatio) attributeValue;
        else if(attributeValue instanceof String){
            SVGAnimatedPreserveAspectRatio svgAnimatedPreserveAspectRatio = new SVGAnimatedPreserveAspectRatio(new SVGPreserveAspectRatio((String) attributeValue));
            svgElement.setAttribute(PRESERVE_ASPECT_RATIO.toString(),svgAnimatedPreserveAspectRatio);
            return svgAnimatedPreserveAspectRatio;
        }
        return null;
    }

    public SVGAnimatedRect getViewBox() {
        if(!svgElement.hasOwnAttribute(VIEW_BOX.toString())){
            return null;
        }
        Object attributeValue = svgElement.getAttributeValue(VIEW_BOX.toString());
        if(attributeValue instanceof SVGAnimatedRect)
            return (SVGAnimatedRect) attributeValue;
        else if(attributeValue instanceof String){
            SVGAnimatedRect svgAnimatedRect = new SVGAnimatedRect(new SVGRect((String)attributeValue));
            svgElement.setAttribute(VIEW_BOX.toString(),svgAnimatedRect);
            return svgAnimatedRect;
        }
        return null;
    }
}
