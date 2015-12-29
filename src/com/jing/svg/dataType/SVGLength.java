package com.jing.svg.dataType;

import com.jing.svg.util.StringUtil;
import com.sun.istack.internal.NotNull;

public class SVGLength {
    private SVGLengthUnit unit;
    private double value;
    private String valueAsString;

    public SVGLength(@NotNull String lengthString){
        try{
            this.valueAsString = lengthString;
            String[] numberAndUnit = StringUtil.splitIntoNumberAndUnit(lengthString);
            setValueWithSpecifiedUnits(SVGLengthUnit.findByName(numberAndUnit[1]),Double.parseDouble(numberAndUnit[0]));
        }catch (Exception e)
        {
            value = 0;
            unit = SVGLengthUnit.SVG_LENGTH_TYPE_PX;
        }
    }

    private void setValueWithSpecifiedUnits(SVGLengthUnit unit,double value){
        this.unit = unit == null ? SVGLengthUnit.SVG_LENGTH_TYPE_PX : unit;
        this.value = value;
        this.valueAsString = value + this.unit.toString();
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
        SVG_LENGTH_TYPE_UNKNOWN("unknown"),
        SVG_LENGTH_TYPE_NUMBER("num"),
        SVG_LENGTH_TYPE_PERCENTAGE("percentage"),
        SVG_LENGTH_TYPE_EMS("ems"),
        SVG_LENGTH_TYPE_EXS("exs"),
        SVG_LENGTH_TYPE_PX("px"),
        SVG_LENGTH_TYPE_CM("cm"),
        SVG_LENGTH_TYPE_MM("mm"),
        SVG_LENGTH_TYPE_IN("in"),
        SVG_LENGTH_TYPE_PT("pt"),
        SVG_LENGTH_TYPE_PC("pc");

        String unitName;
        SVGLengthUnit(String unitName){
            this.unitName = unitName;
        }
        private static SVGLengthUnit findByName(String name){
            for(SVGLengthUnit unit : values()){
                if(unit.unitName.equals(name.trim().toLowerCase())){
                    return unit;
                }
            }
            return null;
        }

        @Override
        public String toString(){
            return unitName;
        }
    }

}
