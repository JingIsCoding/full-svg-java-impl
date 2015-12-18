package com.jing.svg;

import com.jing.svg.animated.SVGAnimatedString;
import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.NodeList;
import com.jing.svg.element.*;
import com.jing.svg.element.SVGBaseElement;

import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.TagName.IMAGE;

public class SVGImageElement extends SVGBaseElement implements SVGTests, SVGLangSpace,SVGURIReference {

    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);
    private SVGURIReference svguriReference = new SVGURIReferenceImpl();

    public SVGImageElement() {
        super(IMAGE);
    }

    public SVGImageElement(SVGSVGElement ownerSVGElement) {
        super(IMAGE, ownerSVGElement);
    }

    public SVGImageElement(String value, SVGSVGElement ownerSVGElement) {
        super(IMAGE, value, ownerSVGElement);
    }

    public SVGImageElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(IMAGE, value, ownerSVGElement, viewPortElement);
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
}
