package com.jing.svg.element;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.Constants.StyleName;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSValue;
import com.jing.svg.util.StringUtil;

import static com.jing.svg.dataType.Constants.BY_SPACE;
import static com.jing.svg.dataType.Constants.ElementAttributeNames.CLASS;
import static com.jing.svg.dataType.Constants.ElementAttributeNames.STYLE;

public class SVGStylableImpl implements SVGStylable{
    private CSSStyleDeclaration styleDeclaration;
    private CSSStyleDeclaration computedStyleDeclaration;
    private SVGElement svgElement;

    public SVGStylableImpl(SVGElement svgElement){
        this.svgElement = svgElement;
        if(svgElement.hasOwnAttribute(STYLE.toString())){
            styleDeclaration = new CSSStyleDeclaration(svgElement.getAttribute(STYLE.toString()).getValue().toString());
        }
    }

    @Override
    public SVGStringList getClassNames() {
        return StringUtil.getSVGStringListValue(svgElement, CLASS.toString(), BY_SPACE);
    }

    @Override
    public CSSValue getPresentationAttribute(String name) {
        return getStyle() != null ? getStyle().getPropertyCSSValue(name) : null;
    }

    @Override
    public CSSStyleDeclaration getStyle() {
        if(styleDeclaration == null){
            styleDeclaration  = !svgElement.hasOwnAttribute(STYLE.toString()) ?  new CSSStyleDeclaration() :  new CSSStyleDeclaration((String) svgElement.getAttributeValue(STYLE.toString()));
            for(StyleName styleName : StyleName.values()){
                if(svgElement.hasOwnAttribute(styleName.toString())){
                    if(styleDeclaration.getPropertyCSSValue(styleName.toString()) == null){
                        styleDeclaration.setAttribute(styleName.toString(),new CSSValue(svgElement.getAttribute(styleName.toString()).getValue()));
                    }
                }
            }
        }
        return styleDeclaration;
    }

    @Override
    public CSSStyleDeclaration getComputedStyleDeclarationStyle() {
        SVGElement styleElement = this.svgElement.getParent();
        while(styleElement != null && !(styleElement instanceof SVGStylable)){
            styleElement = styleElement.getParent();
        }
        return styleElement != null ? this.getStyle().mergetStyleDeclaration(((SVGStylable)styleElement).getComputedStyleDeclarationStyle()) : this.getStyle();
    }
}
