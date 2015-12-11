package com.jing.svg.dataType;

public class SVGTests {

    SVGStringList requiredFeatures;
    SVGStringList requiredExtensions;
    SVGStringList systemLanguage;

    public SVGStringList getSystemLanguage() {
        return systemLanguage;
    }

    public void setSystemLanguage(SVGStringList systemLanguage) {
        this.systemLanguage = systemLanguage;
    }

    public SVGStringList getRequiredFeatures() {
        return requiredFeatures;
    }

    public void setRequiredFeatures(SVGStringList requiredFeatures) {
        this.requiredFeatures = requiredFeatures;
    }

    public SVGStringList getRequiredExtensions() {
        return requiredExtensions;
    }

    public void setRequiredExtensions(SVGStringList requiredExtensions) {
        this.requiredExtensions = requiredExtensions;
    }

    public boolean hasExtension(String extension){
        return false;
    }
}
