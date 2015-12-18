package com.jing.svg.element;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;

import static com.jing.svg.dataType.Constants.Tests.REQUIRED_EXTENSIONS;

public class SVGTestsImpl implements SVGTests {

    SVGElement svgElement;

    public SVGTestsImpl(SVGElement svgElement) {
        this.svgElement = svgElement;
    }

    public SVGStringList getSystemLanguage() {
        return getSVGStringListValue(Constants.Tests.SYSTEM_LANGUAGE.toString());
    }

    public SVGStringList getRequiredFeatures() {
        return getSVGStringListValue(Constants.Tests.REQUIRED_FEATURES.toString());
    }

    public SVGStringList getRequiredExtensions() {
        return getSVGStringListValue(Constants.Tests.REQUIRED_EXTENSIONS.toString());
    }

    public boolean hasExtension(String extension){
        return getRequiredExtensions() == null ? false : getRequiredExtensions().contains(extension);
    }

    private SVGStringList getSVGStringListValue(String key){
        Object value = svgElement.getAttribute(key).getValue();
        if(value == null)
            return null;
        if(value instanceof String){
            SVGStringList svgStringList = new SVGStringList((String) value, "\\s+");
            svgElement.setAttribute(key,svgStringList);
            return svgStringList;
        }
        else{
            return (SVGStringList) value;
        }
    }
}
