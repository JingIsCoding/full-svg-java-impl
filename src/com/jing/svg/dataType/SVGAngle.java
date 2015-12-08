package com.jing.svg.dataType;

import com.sun.istack.internal.NotNull;

public class SVGAngle {
    private SVGAngelType unit;
    private double value;
    private String valueAsString;

    public SVGAngle(){}

    public SVGAngle(@NotNull String angle){
        char[] chars = angle.toCharArray();
        //TODO
        float value;
        String unitName;

    }

    public void setValueWithSpecifiedUnits(@NotNull String unit,@NotNull float value){
        setValueWithSpecifiedUnits(SVGAngelType.findByName(unit),value);
    }

    public void setValueWithSpecifiedUnits(SVGAngelType unit,float value){
        this.unit = unit;
        this.value = value;
        this.valueAsString = value + unit.toString();
    }

    public void convertToSpecifiedUnits(SVGAngelType unit){
        //TODO
    }

    public enum SVGAngelType {
        SVG_ANGLETYPE_UNKNOWN("unknown"),
        SVG_ANGLETYPE_UNSPECIFIED("unspecified"),
        SVG_ANGLETYPE_DEG("deg"),
        SVG_ANGLETYPE_RAD("rad"),
        SVG_ANGLETYPE_GRAD("grad");

        String unitName;
        SVGAngelType(String unitName){
            this.unitName = unitName;
        }

        private String getUnitName(){
            return unitName;
        }

        private static SVGAngelType findByName(String name){
            for(SVGAngelType unit : values()){
                if(unit.toString().equals(name.trim().toLowerCase())){
                    return unit;
                }
            }
            return null;
        }
    }
}
