package com.jing.svg.element;

import com.jing.svg.dataType.SVGStringList;

public interface SVGTests {

    public SVGStringList getSystemLanguage();

    public void setSystemLanguage(SVGStringList systemLanguage);

    public SVGStringList getRequiredFeatures();

    public void setRequiredFeatures(SVGStringList requiredFeatures);

    public SVGStringList getRequiredExtensions();

    public void setRequiredExtensions(SVGStringList requiredExtensions);

    public boolean hasExtension(String extension);
}
