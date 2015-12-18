package com.jing.svg.element;


import com.jing.svg.animated.SVGAnimatedString;
import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSValue;
import com.jing.svg.util.StringUtil;

import static com.jing.svg.dataType.Constants.*;
import static com.jing.svg.dataType.Constants.BY_SPACE;


public class SVGStylableImpl implements SVGStylable{
    private CSSStyleDeclaration styleDeclaration;
    private CSSStyleDeclaration computedStyleDeclaration;
    private SVGElement svgElement;

    public SVGStylableImpl(SVGElement svgElement){
        this.svgElement = svgElement;

    }

    @Override
    public SVGStringList getClassNames() {
        return StringUtil.getSVGStringListValue(svgElement,"class", BY_SPACE);
    }

    @Override
    public CSSValue getPresentationAttribute(String name) {
        return styleDeclaration.getPropertyCSSValue(name);
    }


}
