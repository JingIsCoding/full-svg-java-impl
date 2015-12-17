package com.jing.svg.element;

import com.jing.svg.dataType.SVGStringList;

public interface SVGTests {

    SVGStringList getSystemLanguage();

    void setSystemLanguage(SVGStringList systemLanguage);

    SVGStringList getRequiredFeatures();

    void setRequiredFeatures(SVGStringList requiredFeatures);

    SVGStringList getRequiredExtensions();

    void setRequiredExtensions(SVGStringList requiredExtensions);

    boolean hasExtension(String extension);
}
