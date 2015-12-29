package com.jing.svg.util;

import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.element.SVGElement;
import org.w3c.dom.css.CSSStyleSheet;

public class StringUtil {
    CSSStyleSheet a;
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

    public static String cropString(String origin, int start, int end){
        if(start > end){
            return "";
        }
        if(start < 0){
            start = 0;
        }else if(start > origin.length() -1){
            start = origin.length() -1;
        }
        if(end < 0){
            end = 0;
        }else if(end > origin.length() -1){
            end = origin.length() -1;
        }

        String startString = origin.substring(0,start);
        String endString = origin.substring(end + 1, origin.length());
        return startString + endString;
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
