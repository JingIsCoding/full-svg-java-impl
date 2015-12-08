package com.jing.svg.dataType;
import com.sun.istack.internal.NotNull;

public class SVGLength {
    private SVGLengthUnit unit;
    private double value;
    private String valueAsString;

    public SVGLength(){}

    public SVGLength(@NotNull String lengthString){
        //TODO
        char[] chars = lengthString.toCharArray();
        float value;
        String unitName;

    }

    public void setValueWithSpecifiedUnits(@NotNull String unit,@NotNull float value){
        setValueWithSpecifiedUnits(SVGLengthUnit.findByName(unit),value);
    }

    public void setValueWithSpecifiedUnits(SVGLengthUnit unit,float value){
        this.unit = unit;
        this.value = value;
        this.valueAsString = value + unit.toString();
    }

    public void convertToSpecifiedUnits(SVGLengthUnit unit){
        //TODO
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
                if(unit.toString().equals(name.trim().toLowerCase())){
                    return unit;
                }
            }
            return null;
        }
    }

}
