package com.jing.svg.element;

import com.jing.svg.SVGGElement;
import com.jing.svg.SVGSVGElement;
import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.Constants.ElementAttributeNames;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.CSSStyleDeclaration;
import org.hamcrest.core.Is;
import org.junit.Test;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.*;
import static com.jing.svg.dataType.Constants.StyleName.FILL;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;


public class SVGStylableImplTest {
    @Test
    public void should_get_class_names_correctly(){
        SVGGElement svggElement = new SVGGElement();
        svggElement.setAttribute(CLASS.toString(),"what has    happened  ");

        SVGStylable svgStylable = new SVGStylableImpl(svggElement);
        assertThat(svgStylable.getClassNames().getSize(), is(3));
        assertThat(svgStylable.getClassNames().getItem(0), is("what"));
        assertThat(svgStylable.getClassNames().getItem(1), is("has"));
        assertThat(svgStylable.getClassNames().getItem(2), is("happened"));

        assertThat(svggElement.getAttribute("class").getValue().getClass() == SVGStringList.class,is(true));
    }

    @Test
    public void should_get_style_when_style_specified(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(STYLE.toString(),"font-family: abc; stroke: #122312; stoke-width: 13px");
        svgsvgElement.setAttribute(FILL.toString(),"#ababab");
        assertThat(svgsvgElement.getStyle().getFont().getFontFamily().getValue().toString(), Is.is("abc"));
        assertThat(svgsvgElement.getStyle().getFill().getValue().toString(), Is.is("#ababab"));

    }

    @Test
    public void should_get_style_when_style_not_specified(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(FILL.toString(),"#ababab");
        assertThat(svgsvgElement.getStyle().getFill().getValue().toString(), Is.is("#ababab"));
    }

    @Test
    public void should_get_style_when_style_is_not_valid(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(STYLE.toString(),"there is some strange things; that");
        svgsvgElement.setAttribute(FILL.toString(),"#ababab");
        assertThat(svgsvgElement.getStyle().getFill().getValue().toString(), Is.is("#ababab"));
    }

    @Test
    public void should_get_style_correctly_when_element_has_style_attribute(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(STYLE.toString(),"font-family: abc; stroke: #122312; stoke-width: 13px");
        svgsvgElement.setAttribute(FILL.toString(),"#ababab");
        assertThat(svgsvgElement.getStyle().getFont().getFontFamily().getValue().toString(), Is.is("abc"));
        assertThat(svgsvgElement.getStyle().getFill().getValue(), Is.is("#ababab"));
    }

    @Test
    public void should_get_style_correctly_when_element_has_style_attribute_but_override_by_style(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(STYLE.toString(),"font-family: abc; stroke: #122312; stoke-width: 13px; fill:#123132");
        svgsvgElement.setAttribute(FILL.toString(),"#ababab");
        assertThat(svgsvgElement.getStyle().getFont().getFontFamily().getValue().toString(), Is.is("abc"));
        assertThat(svgsvgElement.getStyle().getFill().getValue(), Is.is("#123132"));
    }

    @Test
    public void should_get_computed_style_from_parent(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(STYLE.toString(),"font-family: abc; stroke: #122312; stoke-width: 13px; fill:#123132");

        SVGGElement svggElement = new SVGGElement();
        svgsvgElement.setAttribute(STYLE.toString(),"font-family: def; stroke: #122312; stoke-width: 13px;");
        svgsvgElement.setAttribute(FILL.toString(),"#aabbcc");

        SVGGElement childGElment = new SVGGElement();
        childGElment.setAttribute(STYLE.toString(),"font-family: gij; stroke: #321312;");

        svggElement.appendChild(childGElment);
        svgsvgElement.appendChild(svggElement);

        CSSStyleDeclaration computedStyleDeclarationStyle = childGElment.getComputedStyleDeclarationStyle();

        assertThat(computedStyleDeclarationStyle.getFill().getValue(),is("#aabbcc"));
//        assertThat(computedStyleDeclarationStyle.getFont().getFontFamily().getValue().toString(),is("gij"));
        assertThat(computedStyleDeclarationStyle.getStroke().getValue().toString(),is("#321312"));
    }

}