package com.jing.svg.element;

import com.jing.svg.dataType.SVGStringList;

public interface SVGTests {

    SVGStringList getSystemLanguage();


    SVGStringList getRequiredFeatures();


    SVGStringList getRequiredExtensions();

    boolean hasExtension(String extension);
}
