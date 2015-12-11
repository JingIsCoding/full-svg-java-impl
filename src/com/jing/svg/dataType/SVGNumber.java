package com.jing.svg.dataType;

public class SVGNumber {

    private double value;

    public SVGNumber(double value){
        this.value = value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }
}
