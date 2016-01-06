package com.jing.svg.dataType;

import org.hamcrest.core.Is;
import org.junit.Test;

import static com.jing.svg.dataType.SVGTransform.SVGTransformType.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;


public class SVGTransformTest {

    @Test
    public void should_get_transform_from_invalid_string(){
        SVGTransform svgTransform = new SVGTransform("  some random stuffs");
        assertThat(svgTransform.getTransformType(), Is.is(SVG_TRANSFORM_UNKNOWN));
        assertThat(svgTransform.getMatrix().getValues()[0], Is.is(1d));
        assertThat(svgTransform.getMatrix().getValues()[1], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[2], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[3], Is.is(1d));
        assertThat(svgTransform.getMatrix().getValues()[4], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[5], Is.is(0d));
    }

    @Test
    public void should_get_transform_from_input_string_rotate_correctly(){
        SVGTransform svgTransform = new SVGTransform("  rotate(30)");
        assertThat(svgTransform.getTransformType(), Is.is(SVG_TRANSFORM_ROTATE));
        assertThat(svgTransform.getMatrix().getValues()[0], Is.is(0.8660254037844387d));
        assertThat(svgTransform.getMatrix().getValues()[1], Is.is(0.49999999999999994));
        assertThat(svgTransform.getMatrix().getValues()[2], Is.is(-0.49999999999999994));
        assertThat(svgTransform.getMatrix().getValues()[3], Is.is(0.8660254037844387));
        assertThat(svgTransform.getMatrix().getValues()[4], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[5], Is.is(0d));
    }

    @Test
    public void should_get_transform_from_input_invalid_rotate(){
        SVGTransform svgTransform = new SVGTransform("  rotate( what is this)");
        assertThat(svgTransform.getTransformType(), Is.is(SVG_TRANSFORM_ROTATE));
        assertThat(svgTransform.getMatrix().getValues()[0], Is.is(1d));
        assertThat(svgTransform.getMatrix().getValues()[1], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[2], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[3], Is.is(1d));
        assertThat(svgTransform.getMatrix().getValues()[4], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[5], Is.is(0d));
    }

    @Test
    public void should_get_transform_from_input_string_rotate_on_point_correctly(){
        SVGTransform svgTransform = new SVGTransform("  rotate(30 100 100)");
        assertThat(svgTransform.getTransformType(), Is.is(SVG_TRANSFORM_ROTATE));
        assertThat(svgTransform.getMatrix().getValues()[0], Is.is(0.8660254037844387d));
        assertThat(svgTransform.getMatrix().getValues()[1], Is.is(0.49999999999999994));
        assertThat(svgTransform.getMatrix().getValues()[2], Is.is(-0.49999999999999994));
        assertThat(svgTransform.getMatrix().getValues()[3], Is.is(0.8660254037844387));
        assertThat(svgTransform.getMatrix().getValues()[4], Is.is(63.397459621556116));
        assertThat(svgTransform.getMatrix().getValues()[5], Is.is(-36.60254037844388d));
    }

    @Test
    public void should_get_transform_from_input_string_for_matrix_correctly(){
        SVGTransform svgTransform = new SVGTransform("  matrix(1,2,3,4,5,6)");
        assertThat(svgTransform.getTransformType(), Is.is(SVG_TRANSFORM_MATRIX));
        assertThat(svgTransform.getMatrix().getValues()[0], Is.is(1d));
        assertThat(svgTransform.getMatrix().getValues()[1], Is.is(2d));
        assertThat(svgTransform.getMatrix().getValues()[2], Is.is(3d));
        assertThat(svgTransform.getMatrix().getValues()[3], Is.is(4d));
        assertThat(svgTransform.getMatrix().getValues()[4], Is.is(5d));
        assertThat(svgTransform.getMatrix().getValues()[5], Is.is(6d));
    }

    @Test
    public void should_get_transform_from_input_string_for_translate_x(){
        SVGTransform svgTransform = new SVGTransform("translate( 100 )");
        assertThat(svgTransform.getTransformType(), Is.is(SVG_TRANSFORM_TRANSLATE));
        assertThat(svgTransform.getMatrix().getValues()[0], Is.is(1d));
        assertThat(svgTransform.getMatrix().getValues()[1], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[2], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[3], Is.is(1d));
        assertThat(svgTransform.getMatrix().getValues()[4], Is.is(100d));
        assertThat(svgTransform.getMatrix().getValues()[5], Is.is(0d));
    }

    @Test
    public void should_get_transform_from_input_string_for_translate_xy(){
        SVGTransform svgTransform = new SVGTransform("  translate( 100,200 )");
        assertThat(svgTransform.getTransformType(), Is.is(SVG_TRANSFORM_TRANSLATE));
        assertThat(svgTransform.getMatrix().getValues()[0], Is.is(1d));
        assertThat(svgTransform.getMatrix().getValues()[1], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[2], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[3], Is.is(1d));
        assertThat(svgTransform.getMatrix().getValues()[4], Is.is(100d));
        assertThat(svgTransform.getMatrix().getValues()[5], Is.is(200d));
    }

    @Test
    public void should_get_transform_from_input_string_for_scale_x_correctly(){
        SVGTransform svgTransform = new SVGTransform("  scale( 12 )");
        assertThat(svgTransform.getTransformType(), Is.is(SVG_TRANSFORM_SCALE));
        assertThat(svgTransform.getMatrix().getValues()[0], Is.is(12d));
        assertThat(svgTransform.getMatrix().getValues()[1], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[2], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[3], Is.is(12d));
        assertThat(svgTransform.getMatrix().getValues()[4], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[5], Is.is(0d));
    }


    @Test
    public void should_get_transform_from_input_string_for_scale_xy_correctly(){
        SVGTransform svgTransform = new SVGTransform("  scale( 12,5)");
        assertThat(svgTransform.getTransformType(), Is.is(SVG_TRANSFORM_SCALE));
        assertThat(svgTransform.getMatrix().getValues()[0], Is.is(12d));
        assertThat(svgTransform.getMatrix().getValues()[1], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[2], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[3], Is.is(5d));
        assertThat(svgTransform.getMatrix().getValues()[4], Is.is(0d));
        assertThat(svgTransform.getMatrix().getValues()[5], Is.is(0d));
    }
}