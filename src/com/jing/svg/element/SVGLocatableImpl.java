package com.jing.svg.element;


import com.jing.svg.dataType.SVGLength;
import com.jing.svg.dataType.SVGMatrix;
import com.jing.svg.dataType.SVGRect;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.*;

public class SVGLocatableImpl implements SVGLocatable{
    private SVGBaseElement nearestViewportElement;
    private SVGBaseElement farthestViewportElement;
    private SVGElement svgElement;

    SVGLocatableImpl(SVGElement svgElement){
        this.svgElement = svgElement;
    }

    public SVGRect getBBox(){
        if(svgElement.hasOwnAttribute(WIDTH.toString()) && svgElement.hasOwnAttribute(HEIGHT.toString())){
            try{
                SVGLength x = new SVGLength(svgElement.hasOwnAttribute(X.toString()) ? (String)svgElement.getAttributeValue(X.toString()) : "0");
                SVGLength y = new SVGLength(svgElement.hasOwnAttribute(Y.toString()) ? (String)svgElement.getAttributeValue(Y.toString()) : "0");
                SVGLength width = new SVGLength((String)svgElement.getAttributeValue(WIDTH.toString()));
                SVGLength height = new SVGLength((String)svgElement.getAttributeValue(HEIGHT.toString()));

                int fontSize = 0;
                if(svgElement instanceof SVGStylable){
                    fontSize = ((SVGStylable)svgElement).getComputedStyleDeclarationStyle().getFont().getFontSize().getValue();
                }

            }catch (Exception e){

            }
        }
        return null;
    }
    public SVGMatrix getCTM(){
        return null;
    }
    public SVGMatrix getScreenCTM(){
        return null;
    }
    public SVGMatrix getTransformToElement(SVGBaseElement element) {
        return null;
    }
}