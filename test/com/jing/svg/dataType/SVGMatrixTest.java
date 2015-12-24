package com.jing.svg.dataType;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;


public class SVGMatrixTest {

    @Test
    public void should_create_new_matrix_with_default_values(){
        SVGMatrix svgMatrix = new SVGMatrix();
        assertThat(svgMatrix.getValues().length, is(6));
        assertThat(svgMatrix.getValues()[0], is(1d));
        assertThat(svgMatrix.getValues()[1], is(0d));
        assertThat(svgMatrix.getValues()[2], is(0d));
        assertThat(svgMatrix.getValues()[3], is(0d));
        assertThat(svgMatrix.getValues()[4], is(1d));
        assertThat(svgMatrix.getValues()[5], is(0d));
    }

    @Test
    public void should_create_matrix_with_input_values_correctly(){
        SVGMatrix svgMatrix = new SVGMatrix(new double[]{1d,2d,3d,4d,5d,6d});
        assertThat(svgMatrix.getValues().length, is(6));
        assertThat(svgMatrix.getValues()[0], is(1d));
        assertThat(svgMatrix.getValues()[1], is(2d));
        assertThat(svgMatrix.getValues()[2], is(3d));
        assertThat(svgMatrix.getValues()[3], is(4d));
        assertThat(svgMatrix.getValues()[4], is(5d));
        assertThat(svgMatrix.getValues()[5], is(6d));
    }

    @Test
    public void should_create_matrix_with_input_maxtrix_correctly(){
        SVGMatrix svgMatrix1 = new SVGMatrix(new double[]{1d,0,0,0,1,0});
        SVGMatrix svgMatrix2 = new SVGMatrix(svgMatrix1);

        SVGMatrix translate = svgMatrix1.translate(3d, 4d);

        assertThat(translate.getValues()[2],is(3d));
        assertThat(translate.getValues()[5],is(4d));
        assertThat(svgMatrix2.getValues()[2],is(0d));
        assertThat(svgMatrix2.getValues()[5],is(0d));
    }

    @Test
    public void should_multiply_matrix_correctly(){
        SVGMatrix svgMatrix = new SVGMatrix(new double[]{1d,0d,0d,0d,1d,0d});
        SVGMatrix translate = new SVGMatrix(new double[]{1d,0d,5d,0d,1d,5d});
        SVGMatrix multiply = svgMatrix.multiply(translate);
        assertThat(multiply.getValues().length, is(6));
        assertThat(multiply.getValues()[0], is(1d));
        assertThat(multiply.getValues()[1], is(0d));
        assertThat(multiply.getValues()[2], is(5d));
        assertThat(multiply.getValues()[3], is(0d));
        assertThat(multiply.getValues()[4], is(1d));
        assertThat(multiply.getValues()[5], is(5d));
    }

    @Test
    public void should_translate_matrix_correctly(){
        SVGMatrix svgMatrix = new SVGMatrix(new double[]{1d,0d,0d,0d,1d,0d});
        SVGMatrix multiply = svgMatrix.translate(3d,4d);
        assertThat(multiply.getValues().length, is(6));
        assertThat(multiply.getValues()[0], is(1d));
        assertThat(multiply.getValues()[1], is(0d));
        assertThat(multiply.getValues()[2], is(3d));
        assertThat(multiply.getValues()[3], is(0d));
        assertThat(multiply.getValues()[4], is(1d));
        assertThat(multiply.getValues()[5], is(4d));
    }

    @Test
    public void should_scale_matrix_correctly(){
        SVGMatrix svgMatrix = new SVGMatrix(new double[]{1d,0d,0d,0d,1d,0d});
        SVGMatrix multiply = svgMatrix.scaleNonUniform(2d,1d);
        assertThat(multiply.getValues().length, is(6));
        assertThat(multiply.getValues()[0], is(2d));
        assertThat(multiply.getValues()[1], is(0d));
        assertThat(multiply.getValues()[2], is(0d));
        assertThat(multiply.getValues()[3], is(0d));
        assertThat(multiply.getValues()[4], is(1d));
        assertThat(multiply.getValues()[5], is(0d));
    }
}