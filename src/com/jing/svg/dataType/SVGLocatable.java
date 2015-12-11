package com.jing.svg.dataType;


public interface SVGLocatable {
    public SVGRect getBBox();
    public SVGMatrix getCTM();
    public SVGMatrix getScreenCTM();
    public SVGMatrix getTransformToElement(SVGElement element);
}
