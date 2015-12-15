package com.jing.svg;

import com.jing.svg.animated.SVGAnimatedLength;
import com.jing.svg.dataType.*;
import com.jing.svg.element.SVGElement;

import static com.jing.svg.dataType.Constants.Location.*;
import static com.jing.svg.dataType.Constants.TagName.*;


public class SVGSVGElement {
    private SVGElement svgElement = new SVGElement(SVG, this);
    private SVGTests svgTests = new SVGTests();


    SVGSVGElement(){
    }

    public void setX(String x){
        svgElement.setAttribute(X.toString(),new SVGAnimatedLength(new SVGLength(x)));
    }

    public SVGAnimatedLength getX(){
        return (SVGAnimatedLength) svgElement.getAttribute(X.toString()).getValue();
    }

    public void setY(String y){
        svgElement.setAttribute(Y.toString(),new SVGAnimatedLength(new SVGLength(y)));
    }

    public SVGAnimatedLength getY(){
        return (SVGAnimatedLength) svgElement.getAttribute(Y.toString()).getValue();
    }

    public void setWidth(String width){
        svgElement.setAttribute(WIDTH.toString(),new SVGAnimatedLength(new SVGLength(width)));
    }

    public SVGAnimatedLength getWidth(){
        return (SVGAnimatedLength) svgElement.getAttribute(WIDTH.toString()).getValue();
    }

    public void setHeight(String height){
        svgElement.setAttribute(HEIGHT.toString(),new SVGAnimatedLength(new SVGLength(height)));
    }

    public SVGAnimatedLength getHeight(){
        return (SVGAnimatedLength) svgElement.getAttribute(HEIGHT.toString()).getValue();
    }

    public SVGNumber createSVGNumber(double number){
        return new SVGNumber(number);
    }
    public SVGLength createSVGLength(String length){
        return new SVGLength(length);
    }
    public SVGAngle createSVGAngle(String angleStr){
        return new SVGAngle(angleStr);
    }
    public SVGPoint createSVGPoint(String point){
        return new SVGPoint(point);
    }
    public SVGMatrix createSVGMatrix(){
        return new SVGMatrix();
    }
    public SVGRect createSVGRect(){
        return new SVGRect();
    }
    public SVGTransform createSVGTransform(){
        return new SVGTransform();
    }
    public SVGTransform createSVGTransformFromMatrix(SVGMatrix matrix){
        return new SVGTransform(matrix);
    }
    public SVGElement getElementById(String elementId){
        return null;
    }
}
