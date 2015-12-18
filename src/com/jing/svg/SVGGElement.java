package com.jing.svg;


import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.element.*;
import com.jing.svg.element.SVGBaseElement;

import static com.jing.svg.dataType.Constants.TagName.G;

public class SVGGElement extends SVGBaseElement implements SVGTests, SVGLangSpace {
    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);

    public SVGGElement() {
        super(G);
    }

    public SVGGElement(SVGSVGElement ownerSVGElement){
        super(G, null, ownerSVGElement ,null);
    }


    public SVGGElement(String value, SVGSVGElement ownerSVGElement){
        super(G,value, ownerSVGElement,null);
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
