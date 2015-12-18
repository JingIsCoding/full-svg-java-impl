package com.jing.svg.util;

import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.element.SVGElement;

public class StringUtil {

    public static String[] splitIntoNumberAndUnit(String input){
        StringBuilder num = new StringBuilder();
        StringBuilder unit = new StringBuilder();
        for(char c : input.trim().toLowerCase().toCharArray()){
            if(c == '-' || c == '+' || (c>= '0' && c<='9') || c=='.'){
                num.append(c);
            }
            else if(c>='a' && c<='z'){
                unit.append(c);
            }
        }
        return new String[]{num.toString(),unit.toString()};
    }

    public static SVGStringList getSVGStringListValue(SVGElement svgElement, String key, String siplliter){
        Object value = svgElement.getAttribute(key).getValue();
        if(value == null)
            return null;
        if(value instanceof String){
            SVGStringList svgStringList = new SVGStringList((String) value, siplliter);
            svgElement.setAttribute(key,svgStringList);
            return svgStringList;
        }
        else{
            return (SVGStringList) value;
        }
    }
}
