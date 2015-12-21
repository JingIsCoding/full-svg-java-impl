package com.jing.svg.element;

import com.jing.svg.animated.SVGAnimatedString;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.XLINK_HREF;

public class SVGURIReferenceImpl implements SVGURIReference{

    private SVGElement svgElement;

    public SVGURIReferenceImpl(SVGElement svgUseElement) {
        this.svgElement = svgUseElement;
    }

    public SVGAnimatedString getHref() {
        return new SVGAnimatedString((String)svgElement.getAttributeValue(XLINK_HREF.toString()));
    }
}
