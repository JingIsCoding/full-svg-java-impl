package com.jing.svg.element;


import com.jing.svg.animated.SVGAnimatedString;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSValue;


public class SVGStylableImpl implements SVGStylable{

    private SVGAnimatedString className;
    private CSSStyleDeclaration styleDeclaration;


    @Override
    public String getClassName() {
        return className.getBaseVal();
    }

    @Override
    public SVGStringList getClassNames() {
        return new SVGStringList(className.getBaseVal()," ");
    }

    @Override
    public CSSValue getPresentationAttribute(String name) {
        return styleDeclaration.getPropertyCSSValue(name);
    }
}
