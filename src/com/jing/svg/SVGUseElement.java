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
import static com.jing.svg.dataType.Constants.TagName.USE;

public class SVGUseElement extends SVGBaseElement implements SVGTests, SVGLangSpace,SVGURIReference{

    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);
    private SVGURIReference svguriReference = new SVGURIReferenceImpl();

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
    public void setSystemLanguage(SVGStringList systemLanguage) {
        svgTests.setSystemLanguage(systemLanguage);
    }

    @Override
    public SVGStringList getRequiredFeatures() {
        return svgTests.getRequiredFeatures();
    }

    @Override
    public void setRequiredFeatures(SVGStringList requiredFeatures) {
        svgTests.setRequiredFeatures(requiredFeatures);
    }

    @Override
    public SVGStringList getRequiredExtensions() {
        return svgTests.getRequiredExtensions();
    }

    @Override
    public void setRequiredExtensions(SVGStringList requiredExtensions) {
        svgTests.setRequiredFeatures(requiredExtensions);
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
    public void setXmlspace(String xmlspace) {
        svgLangSpace.setXmlspace(xmlspace);
    }

    @Override
    public String getXmllang() {
        return svgLangSpace.getXmllang();
    }

    @Override
    public void setXmllang(String xmllang) {
        svgLangSpace.setXmlspace(xmllang);
    }

    @Override
    public SVGAnimatedString getHref() {
        return svguriReference.getHref();
    }
}
