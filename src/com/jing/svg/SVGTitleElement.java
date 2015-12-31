package com.jing.svg;


import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSStyleRule;
import com.jing.svg.dom.CSSValue;
import com.jing.svg.element.*;

import static com.jing.svg.dataType.Constants.TagName.TITLE;

public class SVGTitleElement extends SVGBaseElement implements SVGLangSpace,SVGStylable {

    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);
    private SVGStylable svgStylable = new SVGStylableImpl(this);

    public SVGTitleElement() {
        super(TITLE);
    }

    public SVGTitleElement(SVGSVGElement ownerSVGElement) {
        super(TITLE, ownerSVGElement);
    }

    public SVGTitleElement(String value, SVGSVGElement ownerSVGElement) {
        super(TITLE, value, ownerSVGElement);
    }

    public SVGTitleElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(TITLE, value, ownerSVGElement, viewPortElement);
    }

    @Override
    public String getXmlspace() {
        return svgLangSpace.getXmlspace();
    }

    @Override
    public String getXmllang() {
        return svgLangSpace.getXmllang();
    }

    @Override
    public SVGStringList getClassNames() {
        return svgStylable.getClassNames();
    }

    @Override
    public CSSValue getPresentationAttribute(String name) {
        return svgStylable.getPresentationAttribute(name);
    }

    @Override
    public CSSStyleDeclaration getStyle() {
        return svgStylable.getStyle();
    }

    @Override
    public CSSStyleDeclaration getComputedStyleDeclarationStyle() {
        return svgStylable.getComputedStyleDeclarationStyle();
    }

    @Override
    public void addStyleRule(CSSStyleRule cssStyleRule) {
        this.svgStylable.addStyleRule(cssStyleRule);
    }
}
