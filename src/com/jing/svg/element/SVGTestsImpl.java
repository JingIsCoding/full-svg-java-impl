package com.jing.svg.element;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.util.StringUtil;

import static com.jing.svg.dataType.Constants.*;
import static com.jing.svg.dataType.Constants.Tests.REQUIRED_EXTENSIONS;
import static com.jing.svg.dataType.Constants.Tests.SYSTEM_LANGUAGE;
import static com.jing.svg.util.StringUtil.*;

public class SVGTestsImpl implements SVGTests {

    SVGElement svgElement;

    public SVGTestsImpl(SVGElement svgElement) {
        this.svgElement = svgElement;
    }

    public SVGStringList getSystemLanguage() {
        return getSVGStringListValue(svgElement, SYSTEM_LANGUAGE.toString(),BY_SPACE);
    }

    public SVGStringList getRequiredFeatures() {
        return getSVGStringListValue(svgElement, Tests.REQUIRED_FEATURES.toString(),BY_SPACE);
    }

    public SVGStringList getRequiredExtensions() {
        return getSVGStringListValue(svgElement, Tests.REQUIRED_EXTENSIONS.toString(),BY_SPACE);
    }

    public boolean hasExtension(String extension){
        return getRequiredExtensions() == null ? false : getRequiredExtensions().contains(extension);
    }

}
