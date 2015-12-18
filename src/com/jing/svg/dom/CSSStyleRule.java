package com.jing.svg.dom;


import java.util.List;

public class CSSStyleRule {
    private String selector;
    private CSSStyleRule parentRule;
    private CSSStyleSheet parentStyleSheet;
    private CSSStyleDeclaration style;

    public CSSStyleDeclaration getStyle() {
        return style;
    }

    public String getSelector() {
        return selector;
    }

    public CSSStyleRule getParentRule() {
        return parentRule;
    }

    public CSSStyleSheet getParentStyleSheet() {
        return parentStyleSheet;
    }

    public CSSStyleRule(String selector, String styles, CSSStyleRule parentRule, CSSStyleSheet parentStyleSheet) {
        this.selector = selector;
        this.parentRule = parentRule;
        this.parentStyleSheet = parentStyleSheet;
        this.style = new CSSStyleDeclaration(styles);
    }

    public CSSStyleRule(String selector, CSSStyleRule parentRule, CSSStyleSheet parentStyleSheet, CSSStyleDeclaration style) {
        this.selector = selector;
        this.parentRule = parentRule;
        this.parentStyleSheet = parentStyleSheet;
        this.style = style;
    }

}
