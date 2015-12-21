package com.jing.svg.element;
import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.Constants.ElementAttributeNames;
import com.jing.svg.dataType.Constants.StyleName;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSValue;
import com.jing.svg.util.StringUtil;

import static com.jing.svg.dataType.Constants.BY_SPACE;
import static com.jing.svg.dataType.Constants.ElementAttributeNames.*;

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
        return StringUtil.getSVGStringListValue(svgElement,"class", BY_SPACE);
    }

    @Override
    public CSSValue getPresentationAttribute(String name) {
        return getStyle() != null ? getStyle().getPropertyCSSValue(name) : null;
    }

    @Override
    public CSSStyleDeclaration getStyle() {
          if(svgElement.hasOwnAttribute(STYLE.toString())){
            if(svgElement.getAttribute(STYLE.toString()).getValue() instanceof CSSStyleDeclaration){
                return (CSSStyleDeclaration) svgElement.getAttribute(STYLE.toString()).getValue();
            }
           else{
                CSSStyleDeclaration styleDeclaration = new CSSStyleDeclaration(svgElement.getAttribute(STYLE.toString()).getValue().toString());

                //merge style attribute from svg element
                for(StyleName styleName : StyleName.values()){
                    if(svgElement.hasOwnAttribute(styleName.toString()) && styleDeclaration.getPropertyCSSValue(styleName.toString()) == null){
                        styleDeclaration.setAttribute(styleName.toString(),new CSSValue(svgElement.getAttribute(styleName.toString()).getValue()));
                    }
                }

                svgElement.setAttribute(STYLE.toString(),styleDeclaration);
                return styleDeclaration;
            }
        }
        return null;
    }

    @Override
    public CSSStyleDeclaration getComputedStyleDeclarationStyle() {
        return computedStyleDeclaration;
    }
}
