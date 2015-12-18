package com.jing.svg.dom;

import java.util.HashMap;
import java.util.Map;

public class CSSStyleDeclaration {
    private String cssText;
    private Map<String,Attribute<CSSValue>> attributeMap = new HashMap<>();

    public CSSStyleDeclaration(String style){
        cssText = style;
        parseStyles(style);
    }

    private void parseStyles(String style) {
        String[] styles = style.split(";");
        for(String s : styles){
            String[] nameAndValue = s.split(":");

            int importantIndex = nameAndValue[1].lastIndexOf("!important");
            String value = importantIndex == -1 ? nameAndValue[1].trim() : nameAndValue[1].substring(0, importantIndex).trim();

            CSSValue<String> cssValue = new CSSValue<>(value);
            if(importantIndex > -1){
                cssValue.setImportant(true);
            }

            attributeMap.put(nameAndValue[0].trim(),new Attribute<CSSValue>(null,nameAndValue[0].trim(),cssValue));
        }
    }

    public void setAttribute(String key, CSSValue cssValue){
        attributeMap.put(key,new Attribute<>(null, key,cssValue));
    }

    public String getPropertyValue(String key){
        return (String)attributeMap.get(key).getValue().getValue();
    }

    public CSSValue getPropertyCSSValue(String key){
        return attributeMap.get(key).getValue();
    }

    public String getCssText() {
        return cssText;
    }

}
