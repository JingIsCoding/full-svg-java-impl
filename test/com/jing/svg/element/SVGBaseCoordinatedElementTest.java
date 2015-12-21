package com.jing.svg.element;

import com.jing.svg.dataType.Constants;
import org.hamcrest.core.Is;
import org.junit.Test;

import static com.jing.svg.dataType.SVGLength.SVGLengthUnit.SVG_LENGTHTYPE_CM;
import static com.jing.svg.dataType.SVGLength.SVGLengthUnit.SVG_LENGTHTYPE_PX;
import static org.junit.Assert.assertThat;


public class SVGBaseCoordinatedElementTest {

    @Test
    public void should_x_y_width_height_in_svg_length(){

        SVGBaseCoordinatedElement svgBaseCoordinatedElement = new SVGBaseCoordinatedElement(Constants.TagName.SVG);
        svgBaseCoordinatedElement.setAttribute("x","100px");
        svgBaseCoordinatedElement.setAttribute("y","123cm");
        svgBaseCoordinatedElement.setAttribute("width","12.2px");
        svgBaseCoordinatedElement.setAttribute("height","1322.1px");

        assertThat(svgBaseCoordinatedElement.getX().getBaseVal().getValue(), Is.is(100d));
        assertThat(svgBaseCoordinatedElement.getX().getBaseVal().getUnit(), Is.is(SVG_LENGTHTYPE_PX));

        assertThat(svgBaseCoordinatedElement.getY().getBaseVal().getValue(), Is.is(123d));
        assertThat(svgBaseCoordinatedElement.getY().getBaseVal().getUnit(), Is.is(SVG_LENGTHTYPE_CM));

        assertThat(svgBaseCoordinatedElement.getWidth().getBaseVal().getValue(), Is.is(12.2d));

        assertThat(svgBaseCoordinatedElement.getHeight().getBaseVal().getUnit(), Is.is(SVG_LENGTHTYPE_PX));
    }

}