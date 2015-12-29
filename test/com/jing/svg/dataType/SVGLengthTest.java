package com.jing.svg.dataType;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;


public class SVGLengthTest {

    @Test
    public void should_set_the_length_with_unit_px_correctly(){

        SVGLength svgLength = new SVGLength("123.32px");

        assertThat(svgLength.getValue(), Is.is(123.32));
        assertThat(svgLength.getUnit(), Is.is(SVGLength.SVGLengthUnit.SVG_LENGTH_TYPE_PX));
    }

    @Test
    public void should_set_the_length_with_unit_cm_correctly(){

        SVGLength svgLength = new SVGLength("123.32 cm");

        assertThat(svgLength.getValue(), Is.is(123.32));
        assertThat(svgLength.getUnit(), Is.is(SVGLength.SVGLengthUnit.SVG_LENGTH_TYPE_CM));
    }

    @Test
    public void should_set_the_length_unit_default_to_px_if_not_provided(){

        SVGLength svgLength = new SVGLength("123");

        assertThat(svgLength.getValue(), Is.is(123d));
        assertThat(svgLength.getUnit(), Is.is(SVGLength.SVGLengthUnit.SVG_LENGTH_TYPE_PX));
    }

    @Test
    public void should_set_the_length_unit_to_0_px_if_the_input_is_incorrectly(){
        SVGLength svgLength = new SVGLength("gsgdfsg");
        assertThat(svgLength.getValue(), Is.is(0d));
        assertThat(svgLength.getUnit(), Is.is(SVGLength.SVGLengthUnit.SVG_LENGTH_TYPE_PX));
    }
}