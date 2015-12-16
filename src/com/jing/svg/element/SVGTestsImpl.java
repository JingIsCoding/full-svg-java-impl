package com.jing.svg.element;

import com.jing.svg.SVGSVGElement;
import com.jing.svg.dataType.SVGStringList;

/**
 * Created by jguo on 12/16/2015.
 */
public class SVGTestsImpl implements SVGTests {

    SVGElement svgElement;

    public static final String REQUIRED_FEATURES = "requiredFeatures";
    public static final String REQUIRED_EXTENSIONS = "requiredExtensions";
    public static final String SYSTEM_LANGUAGE = "systemLanguage";

    public SVGTestsImpl(SVGElement svgElement) {
        this.svgElement = svgElement;
    }

    public SVGStringList getSystemLanguage() {
        return (SVGStringList)svgElement.getAttribute(SYSTEM_LANGUAGE).getValue();
    }

    public void setSystemLanguage(SVGStringList systemLanguage) {
        svgElement.setAttribute(SYSTEM_LANGUAGE,systemLanguage);
    }

    public SVGStringList getRequiredFeatures() {
        return (SVGStringList)svgElement.getAttribute(REQUIRED_FEATURES).getValue();
    }

    public void setRequiredFeatures(SVGStringList requiredFeatures) {
        this.svgElement.setAttribute(REQUIRED_FEATURES,requiredFeatures);
    }

    public SVGStringList getRequiredExtensions() {
        return (SVGStringList)svgElement.getAttribute(REQUIRED_EXTENSIONS).getValue();
    }

    public void setRequiredExtensions(SVGStringList requiredExtensions) {
        this.svgElement.setAttribute(REQUIRED_EXTENSIONS,requiredExtensions);
    }

    public boolean hasExtension(String extension){
        return ((SVGStringList)svgElement.getAttribute(REQUIRED_EXTENSIONS).getValue()).contains(extension);
    }
}
