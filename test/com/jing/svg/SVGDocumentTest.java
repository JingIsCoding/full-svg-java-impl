package com.jing.svg;

import com.jing.svg.dataType.Constants;
import com.jing.svg.element.SVGElement;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;


public class SVGDocumentTest {

    @Test
    public void should_create_svg_element_and_becomes_root_svg(){
        SVGDocument svgDocument = new SVGDocument();
        try {
            SVGElement svg = svgDocument.createElement("svg");
            assertThat(svg.getTagName(), Is.is(Constants.TagName.SVG));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_create_svg_and_throw(){
        SVGDocument svgDocument = new SVGDocument();
        try {
            SVGElement svg = svgDocument.createElement("asdsad");
            assertThat(svg.getTagName(), Is.is(Constants.TagName.SVG));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}