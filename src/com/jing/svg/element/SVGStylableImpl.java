package com.jing.svg.element;

import com.jing.svg.dataType.Constants.StyleName;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.*;
import com.jing.svg.dom.Matcher.SelectorType;
import com.jing.svg.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }

    private void setupInlineStyle() {
        if(svgElement.hasOwnAttribute(STYLE.toString())){
            CSSStyleRule inlineStyle = new CSSStyleRule(SelectorType.STYLE,(String)svgElement.getAttributeValue(STYLE.toString()),null);
            this.addStyleRule(inlineStyle);
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
        if(cssStyleDeclaration == null){
            setupInlineStyle();
            Map<String,Attribute<CSSValue>> attributeMap = new HashMap<>();
            for(StyleName styleName : StyleName.values()){
                CSSValue valueFromRules = getValueFromRules(styleName);
                if(valueFromRules != null)
                {
                    attributeMap.put(styleName.toString(),new Attribute<>(svgElement,styleName.toString(),valueFromRules));
                }else if(svgElement.hasOwnAttribute(styleName.toString())){
                    CSSValue cssValue = new CSSValue(svgElement.getAttributeValue(styleName.toString()));
                    attributeMap.put(styleName.toString(),new Attribute<>(svgElement,styleName.toString(),cssValue));
                }
            }
            cssStyleDeclaration = new CSSStyleDeclaration(attributeMap);
        }
        return cssStyleDeclaration;
    }

    private CSSValue getValueFromRules(StyleName styleName) {
        CSSValue result = null;
        for(int i = cssRules.size() - 1 ; i >=0; i--){
            CSSStyleRule cssStyleRule = cssRules.get(i);
            CSSValue value = cssStyleRule.getStyle().getValue(styleName.toString());
            if(value != null){
                if(value.isImportant()){
                    return value;
                }
                if(result == null){
                    result = value;
                }
            }
        }
        return result;
    }

    @Override
    public CSSStyleDeclaration getComputedStyleDeclarationStyle() {
        SVGElement styleElement = this.svgElement.getParent();
        while(styleElement != null && !(styleElement instanceof SVGStylable)){
            styleElement = styleElement.getParent();
        }
        CSSStyleDeclaration mergedStyle =  styleElement != null ? this.getStyle().overRideStyle(((SVGStylable)styleElement).getComputedStyleDeclarationStyle()) : this.getStyle();
        return mergedStyle;
    }

    public List<CSSStyleRule> getCssRules() {
        return cssRules;
    }


    @Override
    public void addStyleRule(CSSStyleRule cssStyleRule) {
        if(cssRules.isEmpty()){
            cssRules.add(cssStyleRule);
            return;
        }
        for(int i = cssRules.size() - 1 ; i >=0; i--){
            if(cssStyleRule.getSpecificity() >= cssRules.get(i).getSpecificity()){
                cssRules.add(i+1,cssStyleRule);
                return;
            }
        }
        cssRules.add(0,cssStyleRule);
    }
}
