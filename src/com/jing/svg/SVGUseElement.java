package com.jing.svg;

import com.jing.svg.animated.SVGAnimatedString;
import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSValue;
import com.jing.svg.dom.NodeList;
import com.jing.svg.element.*;
import com.jing.svg.element.SVGBaseElement;

import java.util.List;
import java.util.Map;
import static com.jing.svg.dataType.Constants.TagName.USE;

public class SVGUseElement extends SVGBaseCoordinatedElement implements SVGTests, SVGLangSpace,SVGURIReference,SVGStylable{

    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);
    private SVGURIReference svguriReference = new SVGURIReferenceImpl(this);
    private SVGStylable svgStylable = new SVGStylableImpl(this);

    public SVGUseElement() {
        super(USE);
    }

    public SVGUseElement(SVGSVGElement ownerSVGElement) {
        super(USE, ownerSVGElement);
    }

    public SVGUseElement(String value, SVGSVGElement ownerSVGElement) {
        super(USE, value, ownerSVGElement);
    }

    public SVGUseElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(USE, value, ownerSVGElement, viewPortElement);
    }

    @Override
    public SVGStringList getSystemLanguage() {
        return svgTests.getSystemLanguage();
    }

    @Override
    public SVGStringList getRequiredFeatures() {
        return svgTests.getRequiredFeatures();
    }


    @Override
    public SVGStringList getRequiredExtensions() {
        return svgTests.getRequiredExtensions();
    }

    @Override
    public boolean hasExtension(String extension) {
        return svgTests.hasExtension(extension);
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
    public SVGAnimatedString getHref() {
        return svguriReference.getHref();
    }

    @Override
    public SVGStringList getClassNames() {
        return null;
    }

    @Override
    public CSSValue getPresentationAttribute(String name) {
        return null;
    }

    @Override
    public CSSStyleDeclaration getStyle() {
        return null;
    }

    @Override
    public CSSStyleDeclaration getComputedStyleDeclarationStyle() {
        return null;
    }
}
