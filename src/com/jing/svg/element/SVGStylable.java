package com.jing.svg.element;

import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSValue;

public interface SVGStylable  {

    SVGStringList getClassNames();

    CSSValue getPresentationAttribute(String name);

    CSSStyleDeclaration getStyle();

    CSSStyleDeclaration getComputedStyleDeclarationStyle();
}
