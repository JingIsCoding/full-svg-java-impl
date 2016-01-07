package com.jing.svg;

import com.jing.svg.dataType.Constants;
import com.jing.svg.element.SVGElement;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class SVGSVGElementTest {

    @Test
    public void should_get_all_style_element() {
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        SVGStyleElement svgStyleElement = new SVGStyleElement();

        SVGGElement svggElement = new SVGGElement();
        SVGStyleElement svgStyleElement1 = new SVGStyleElement();
        svggElement.appendChild(svgStyleElement1);

        svgsvgElement.appendChild(svgStyleElement);
        svgsvgElement.appendChild(svggElement);

        List<SVGElement> elementByTagName = svgsvgElement.getElementByTagName(Constants.TagName.STYLE);

        assertThat(elementByTagName.size(), Is.is(2));
    }

    @Test
    public void should_has_default_style(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        assertThat(svgsvgElement.getComputedStyleDeclarationStyle().getFill().getValue(),Is.is("#000000"));
        assertThat(svgsvgElement.getComputedStyleDeclarationStyle().getFont().getFontFamily().getValue(),Is.is("'Times New Roman'"));
        assertThat(svgsvgElement.getComputedStyleDeclarationStyle().getFont().getFontSize().getValue(),Is.is("16px"));
    }
}