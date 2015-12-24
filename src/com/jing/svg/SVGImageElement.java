package com.jing.svg;

import com.jing.svg.animated.SVGAnimatedPreserveAspectRatio;
import com.jing.svg.animated.SVGAnimatedString;
import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGPreserveAspectRatio;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.NodeList;
import com.jing.svg.element.*;
import com.jing.svg.element.SVGBaseElement;

import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.PRESERVE_ASPECT_RATIO;
import static com.jing.svg.dataType.Constants.TagName.IMAGE;

public class SVGImageElement extends SVGBaseElement implements SVGTests, SVGLangSpace,SVGURIReference {

    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);
    private SVGURIReference svguriReference = new SVGURIReferenceImpl(this);

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

    public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio(){
        if(this.hasOwnAttribute(PRESERVE_ASPECT_RATIO.toString())){
            if(this.getAttributeValue(PRESERVE_ASPECT_RATIO.toString()) instanceof String){
                SVGAnimatedPreserveAspectRatio svgAnimatedPreserveAspectRatio = new SVGAnimatedPreserveAspectRatio(new SVGPreserveAspectRatio((String) this.getAttributeValue(PRESERVE_ASPECT_RATIO.toString())));
                this.setAttribute(PRESERVE_ASPECT_RATIO.toString(),svgAnimatedPreserveAspectRatio);
                return svgAnimatedPreserveAspectRatio;
            }
            else if(this.getAttributeValue(PRESERVE_ASPECT_RATIO.toString()) instanceof SVGAnimatedPreserveAspectRatio){
                return (SVGAnimatedPreserveAspectRatio) this.getAttributeValue(PRESERVE_ASPECT_RATIO.toString());
            }
        }
        return null;
    }
}
