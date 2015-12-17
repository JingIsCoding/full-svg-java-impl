package com.jing.svg.dom;

import java.util.HashMap;
import java.util.Map;

public class CSSStyleDeclaration {
    private String cssText;
    private Map<String,Attribute<CSSValue>> attributeMap = new HashMap<>();

    public CSSStyleDeclaration(String data){

    }

    public void setAttribute(String key, CSSValue cssValue){
        attributeMap.put(key,new Attribute<>(null, key,cssValue));
    }

    public String getPropertyValue(String key){
        return attributeMap.get(key).getValue().toString();
    }

    public CSSValue getPropertyCSSValue(String key){
        return attributeMap.get(key).getValue();
    }

}
