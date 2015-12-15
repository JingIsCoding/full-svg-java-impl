package com.jing.svg.util;

/**
 * Created by jing on 12/15/2015.
 */
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
}
