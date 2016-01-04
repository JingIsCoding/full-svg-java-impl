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

    public static String cleanQuotes(String input){
        if(input == null || input.isEmpty())
            return input;
        char firstChar = input.charAt(0);
        char lastChat = input.charAt(input.length() -1);
        if(firstChar =='"' && lastChat =='"'){
            return input.substring(1,input.length() -1);
        }
        else if(firstChar =='\'' && lastChat =='\''){
            return input.substring(1,input.length() -1);
        }
        return input;
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

    public static class LogicSkipper {
        private String[] openers;
        private String[] closers;
        private int openerIndex = -1;
        private boolean shouldSkip = false;
        public LogicSkipper(String...symbols)
        {
            if(symbols.length % 2 != 0){
                throw new IllegalArgumentException("Symbols have to be in pairs");
            }
            openers = new String[symbols.length /2];
            closers = new String[symbols.length /2];

            for(int i = 0 ; i < symbols.length ;i+=2){
                openers[i/2] = symbols[i];
                closers[i/2] = symbols[i+1];
            }
        }

        public boolean shouldSkip(String word){
            if(openerIndex == -1){
                for(int i = 0 ; i < openers.length ;i++){
                    if(openers[i].equals(word)){
                        openerIndex = i;
                        this.shouldSkip = true;
                        return false;
                    }
                }
            }
            else{
                for(int i = 0 ; i < closers.length ;i++){
                    if(closers[i].equals(word) && i == openerIndex){
                        openerIndex = -1;
                        this.shouldSkip = false;
                    }
                }
            }
            return shouldSkip;
        }
    }
}
