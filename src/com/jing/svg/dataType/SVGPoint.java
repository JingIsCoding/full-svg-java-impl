package com.jing.svg.dataType;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGPoint {
    private float x;
    private float y;

    public SVGPoint(String point){

    }

    public SVGPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    SVGPoint matrixTransform(SVGMatrix matrix){
        return new SVGPoint(x,y);
    }
}
