package com.jing.svg.dom;


import com.jing.svg.element.SVGElement;
import com.jing.svg.element.SVGStylable;
import com.sun.istack.internal.NotNull;

public class CSSStyleRule {
    private String selector;
    private Selector selectorInstance;
    private CSSStyleRule parentRule;
    private CSSStyleSheet parentStyleSheet;
    private CSSStyleDeclaration style;

    public CSSStyleRule getParentRule() {
        return parentRule;
    }

    public CSSStyleSheet getParentStyleSheet() {
        return parentStyleSheet;
    }

    public CSSStyleRule(Matcher.SelectorType selectorType, String styles, CSSStyleRule parentRule) {
        this.selector = "";
        this.parentRule = parentRule;

        this.selectorInstance = new Selector(selector);
        this.style = new CSSStyleDeclaration(styles);
    }

    public CSSStyleRule(String selector, String styles, CSSStyleRule parentRule, CSSStyleSheet parentStyleSheet) {
        this.selector = selector == null ? "" : selector;
        this.parentRule = parentRule;
        this.parentStyleSheet = parentStyleSheet;

        this.selectorInstance = new Selector(selector);
        this.style = new CSSStyleDeclaration(styles);
    }

    CSSStyleRule(String selector, CSSStyleRule parentRule, CSSStyleSheet parentStyleSheet, CSSStyleDeclaration style) {
        this.selector = selector;
        this.parentRule = parentRule;
        this.parentStyleSheet = parentStyleSheet;
        this.style = style;
    }



    public CSSStyleDeclaration getStyle() {
        return style;
    }

    public String getSelector() {
        return selector;
    }

    protected void applyToElement(@NotNull SVGElement svgElement){
        if(this.selectorInstance.match(svgElement) && svgElement instanceof SVGStylable){
            SVGStylable svgStylable = (SVGStylable)svgElement;
            svgStylable.addStyleRule(this);
        }
    }

    public int getSpecificity(){
        return this.selectorInstance.getSpecificity();
    }
}
