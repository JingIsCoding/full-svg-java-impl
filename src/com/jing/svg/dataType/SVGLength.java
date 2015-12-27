package com.jing.svg.dataType;

import com.jing.svg.util.StringUtil;
import com.sun.istack.internal.NotNull;

public class SVGLength {
    private SVGLengthUnit unit;
    private double value;
    private String valueAsString;

    public SVGLength(){}

    public SVGLength(@NotNull String lengthString){
        try{
            this.valueAsString = lengthString;
            String[] numberAndUnit = StringUtil.splitIntoNumberAndUnit(lengthString);
            setValueWithSpecifiedUnits(SVGLengthUnit.findByName(numberAndUnit[1]),Double.parseDouble(numberAndUnit[0]));
        }catch (Exception e)
        {
            value = 0;
            unit = SVGLengthUnit.SVG_LENGTHTYPE_PX;
        }
    }

    private void setValueWithSpecifiedUnits(@NotNull String unit,@NotNull double value){
        setValueWithSpecifiedUnits(SVGLengthUnit.findByName(unit),value);
    }

    private void setValueWithSpecifiedUnits(SVGLengthUnit unit,double value){
        this.unit = unit == null ? SVGLengthUnit.SVG_LENGTHTYPE_PX : unit;
        this.value = value;
        this.valueAsString = value + this.unit.toString();
    }

    public void convertToSpecifiedUnits(SVGLengthUnit unit,float dpi){


    }

    public double getValue() {
        return value;
    }

    public SVGLengthUnit getUnit() {
        return unit;
    }

    public String getValueAsString() {
        return valueAsString;
    }


    // Length Unit Types
    public enum SVGLengthUnit{
        SVG_LENGTHTYPE_UNKNOWN("unknown"),
        SVG_LENGTHTYPE_NUMBER("num"),
        SVG_LENGTHTYPE_PERCENTAGE("percentage"),
        SVG_LENGTHTYPE_EMS("ems"),
        SVG_LENGTHTYPE_EXS("exs"),
        SVG_LENGTHTYPE_PX("px"),
        SVG_LENGTHTYPE_CM("cm"),
        SVG_LENGTHTYPE_MM("mm"),
        SVG_LENGTHTYPE_IN("in"),
        SVG_LENGTHTYPE_PT("pt"),
        SVG_LENGTHTYPE_PC("pc");

        String unitName;
        SVGLengthUnit(String unitName){
            this.unitName = unitName;
        }

        private String getUnitName(){
            return unitName;
        }

        private static SVGLengthUnit findByName(String name){
            for(SVGLengthUnit unit : values()){
                if(unit.unitName.equals(name.trim().toLowerCase())){
                    return unit;
                }
            }
            return null;
        }
    }

}
