package com.jing.svg.element;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;

import static com.jing.svg.dataType.Constants.Tests.REQUIRED_EXTENSIONS;

/**
 * Created by jguo on 12/16/2015.
 */
public class SVGTestsImpl implements SVGTests {

    SVGElement svgElement;

    public SVGTestsImpl(SVGElement svgElement) {
        this.svgElement = svgElement;
    }

    public SVGStringList getSystemLanguage() {
        return (SVGStringList)svgElement.getAttribute(Constants.Tests.SYSTEM_LANGUAGE.toString()).getValue();
    }

    public void setSystemLanguage(SVGStringList systemLanguage) {
        svgElement.setAttribute(Constants.Tests.SYSTEM_LANGUAGE.toString(),systemLanguage);
    }

    public SVGStringList getRequiredFeatures() {
        return (SVGStringList)svgElement.getAttribute(Constants.Tests.REQUIRED_FEATURES.toString()).getValue();
    }

    public void setRequiredFeatures(SVGStringList requiredFeatures) {
        this.svgElement.setAttribute(Constants.Tests.REQUIRED_FEATURES.toString(),requiredFeatures);
    }

    public SVGStringList getRequiredExtensions() {
        return (SVGStringList)svgElement.getAttribute(REQUIRED_EXTENSIONS.toString()).getValue();
    }

    public void setRequiredExtensions(SVGStringList requiredExtensions) {
        this.svgElement.setAttribute(REQUIRED_EXTENSIONS.toString(),requiredExtensions);
    }

    public boolean hasExtension(String extension){
        return ((SVGStringList)svgElement.getAttribute(REQUIRED_EXTENSIONS.toString()).getValue()).contains(extension);
    }
}
