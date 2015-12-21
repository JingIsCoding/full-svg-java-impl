package com.jing.svg;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSValue;
import com.jing.svg.dom.NodeList;
import com.jing.svg.element.*;

import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.TagName.SYMBOL;

public class SVGSymbolElement extends SVGBaseElement implements SVGLangSpace,SVGStylable {

    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);
    private SVGStylable svgStylable = new SVGStylableImpl(this);

    public SVGSymbolElement() {
        super(SYMBOL);
    }

    public SVGSymbolElement(SVGSVGElement ownerSVGElement) {
        super(SYMBOL, ownerSVGElement);
    }

    public SVGSymbolElement(String value, SVGSVGElement ownerSVGElement) {
        super(SYMBOL, value, ownerSVGElement);
    }

    public SVGSymbolElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(SYMBOL, value, ownerSVGElement, viewPortElement);
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
}
