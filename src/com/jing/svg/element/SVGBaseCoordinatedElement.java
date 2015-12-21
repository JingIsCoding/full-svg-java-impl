package com.jing.svg.element;


import com.jing.svg.SVGSVGElement;
import com.jing.svg.animated.SVGAnimatedLength;
import com.jing.svg.dataType.Constants.ElementAttributeNames;
import com.jing.svg.dataType.Constants.TagName;
import com.jing.svg.dataType.SVGLength;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.*;

public class SVGBaseCoordinatedElement extends SVGBaseElement{
    protected SVGBaseCoordinatedElement(TagName tagName) {
        super(tagName);
    }

    protected SVGBaseCoordinatedElement(TagName tagName, SVGSVGElement ownerSVGElement) {
        super(tagName, ownerSVGElement);
    }

    protected SVGBaseCoordinatedElement(TagName tagName, String content, SVGSVGElement ownerSVGElement) {
        super(tagName, content, ownerSVGElement);
    }

    protected SVGBaseCoordinatedElement(TagName tagName, String content, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(tagName, content, ownerSVGElement, viewPortElement);
    }

    protected SVGAnimatedLength getX(){
       return convertAnimatedLength(X);
    }

    public SVGAnimatedLength getY(){
        return convertAnimatedLength(Y);
    }

    public SVGAnimatedLength getWidth(){
        return convertAnimatedLength(WIDTH);
    }

    public SVGAnimatedLength getHeight(){
        return  convertAnimatedLength(HEIGHT);
    }

    private SVGAnimatedLength convertAnimatedLength(ElementAttributeNames name){
        if(hasOwnAttribute(name.toString())){
            if(getAttributeValue(name.toString()) instanceof SVGAnimatedLength)
            {
                return (SVGAnimatedLength) getAttributeValue(name.toString());
            }else{
                SVGLength svgLength = new SVGLength(getAttributeValue(name.toString()).toString());
                SVGAnimatedLength svgAnimatedLength = new SVGAnimatedLength(svgLength);
                setAttribute(name.toString(),svgAnimatedLength);
                return svgAnimatedLength;

            }
        }
        return null;
    }

}
