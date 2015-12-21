package com.jing.svg.element;

import com.jing.svg.SVGUseElement;
import com.jing.svg.animated.SVGAnimatedString;
import com.jing.svg.dataType.Constants;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGURIReferenceImpl implements SVGURIReference{

    private SVGElement svgElement;

    public SVGURIReferenceImpl(SVGElement svgUseElement) {
        this.svgElement = svgUseElement;
    }

    public SVGAnimatedString getHref() {
        return new SVGAnimatedString((String)svgElement.getAttributeValue(Constants.ElementAttributeNames.XLINK_HREF));
    }
}
