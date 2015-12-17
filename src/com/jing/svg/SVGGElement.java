package com.jing.svg;


import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.element.*;
import com.jing.svg.element.SVGBaseElement;

import static com.jing.svg.dataType.Constants.TagName.G;

public class SVGGElement implements SVGElement, SVGTests, SVGLangSpace {
    private SVGElement svgElement = new SVGBaseElement(G);
    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);




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
}
