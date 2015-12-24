package com.jing.svg.dataType;

import com.jing.svg.util.StringUtil;
import com.sun.istack.internal.NotNull;

public class SVGAngle {


    private SVGAngelType unit;
    private double value;
    private String valueAsString;

    public SVGAngle(@NotNull String angle){
        String[] strings = StringUtil.splitIntoNumberAndUnit(angle);
        try{
            value = Double.parseDouble(strings[0]);
            unit = SVGAngelType.findByName(strings[1].toLowerCase().trim());
            if(unit == null){
                unit = SVGAngelType.SVG_ANGLETYPE_DEG;
            }
        }catch (Exception e){
            value = 0;
            unit = SVGAngelType.SVG_ANGLETYPE_RAD;
        }
    }

    public SVGAngelType getUnit() {
        return unit;
    }

    public String getValueAsString() {
        return valueAsString;
    }

    public SVGAngle(@NotNull SVGAngelType unit,@NotNull float value){
        setValueWithSpecifiedUnits(unit,value);
    }

    public void setValueWithSpecifiedUnits(@NotNull String unit,@NotNull float value){
        setValueWithSpecifiedUnits(SVGAngelType.findByName(unit),value);
    }

    public void setValueWithSpecifiedUnits(SVGAngelType unit,float value){
        this.unit = unit;
        this.value = value;
        this.valueAsString = value + unit.toString();
    }

    public double getRadius(){
        if(unit == SVGAngelType.SVG_ANGLETYPE_DEG){
            return Math.toRadians(value);
        }
        return this.getValue();
    }

    public double getValue() {
        return value;
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
