package com.jing.svg;

import com.jing.svg.dataType.*;
import com.jing.svg.element.SVGElement;

import static com.jing.svg.dataType.Constants.TagName.*;


public class SVGSVGElement {
    private SVGElement svgElement = new SVGElement(SVG, this, null);

    SVGSVGElement(){
    }

    void deselectAll(){}

    SVGNumber createSVGNumber(double number){
        return new SVGNumber(number);
    }
    SVGLength createSVGLength(String length){
        return new SVGLength(length);
    }
    SVGAngle createSVGAngle(String angleStr){
        return new SVGAngle(angleStr);
    }
    SVGPoint createSVGPoint(String point){
        return new SVGPoint(point);
    }
    SVGMatrix createSVGMatrix(){
        return new SVGMatrix();
    }
    SVGRect createSVGRect(){
        return new SVGRect();
    }
    SVGTransform createSVGTransform(){
        return new SVGTransform();
    }
    SVGTransform createSVGTransformFromMatrix(SVGMatrix matrix){
        return new SVGTransform(matrix);
    }
    SVGElement getElementById(String elementId){
        return null;
    }
}
