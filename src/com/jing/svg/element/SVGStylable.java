package com.jing.svg.element;

import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.CSSValue;

public interface SVGStylable  {

    public String getClassName();

    public SVGStringList getClassNames();

    public CSSValue getPresentationAttribute(String name);

}
