package com.jing.svg.element;

import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSStyleRule;
import com.jing.svg.dom.CSSValue;
import com.jing.svg.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import static com.jing.svg.dataType.Constants.BY_SPACE;
import static com.jing.svg.dataType.Constants.ElementAttributeNames.CLASS;
import static com.jing.svg.dataType.Constants.ElementAttributeNames.STYLE;

public class SVGStylableImpl implements SVGStylable{
    private List<CSSStyleRule> cssRules;
    private SVGElement svgElement;
    private CSSStyleDeclaration cssStyleDeclaration;

    public SVGStylableImpl(SVGElement svgElement){
        this.svgElement = svgElement;
        cssRules = new ArrayList<>();
        if(svgElement.hasOwnAttribute(STYLE.toString())){
            cssRules = new ArrayList<>();
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
        return null;
    }

    @Override
    public CSSStyleDeclaration getComputedStyleDeclarationStyle() {
        SVGElement styleElement = this.svgElement.getParent();
        while(styleElement != null && !(styleElement instanceof SVGStylable)){
            styleElement = styleElement.getParent();
        }
        CSSStyleDeclaration mergedStyle =  styleElement != null ? this.getStyle().mergeStyleDeclaration(((SVGStylable)styleElement).getComputedStyleDeclarationStyle()) : this.getStyle();
        return mergedStyle;
    }

    @Override
    public void addStyleRule(CSSStyleRule cssStyleRule) {
        cssRules.add(cssStyleRule);
    }
}
