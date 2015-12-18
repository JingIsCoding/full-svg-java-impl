package com.jing.svg;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SVGStyleElementTest {

    @Test
    public void should_set_value_correctly(){
        SVGStyleElement svgStyleElement = new SVGStyleElement();
        svgStyleElement.setContent(".abc{ fill:rbg(123,123,11) }");
        assertThat(svgStyleElement.getContent(),is(".abc{ fill:rbg(123,123,11) }"));
    }

}