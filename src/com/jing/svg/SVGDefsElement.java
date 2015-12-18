package com.jing.svg;


import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.NodeList;
import com.jing.svg.element.*;
import com.jing.svg.element.SVGBaseElement;

import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.TagName.DEFS;

public class SVGDefsElement extends SVGBaseElement implements SVGTests, SVGLangSpace {
    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);

    public SVGDefsElement() {
        super(DEFS);
    }

    public SVGDefsElement(SVGSVGElement ownerSVGElement) {
        super(DEFS, ownerSVGElement);
    }

    public SVGDefsElement(String value, SVGSVGElement ownerSVGElement) {
        super(DEFS, value, ownerSVGElement);
    }

    public SVGDefsElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(DEFS, value, ownerSVGElement, viewPortElement);
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
}
