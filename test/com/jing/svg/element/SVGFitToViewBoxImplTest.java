package com.jing.svg.element;

import com.jing.svg.SVGSVGElement;
import org.hamcrest.core.Is;
import org.junit.Test;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.VIEW_BOX;
import static org.junit.Assert.assertThat;


public class SVGFitToViewBoxImplTest {

    @Test
    public void should_get_view_box(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(VIEW_BOX.toString(),"50,51,100,200");

        SVGFitToViewBox svgFitToViewBox = new SVGFitToViewBoxImpl(svgsvgElement);
        assertThat(svgFitToViewBox.getViewBox().getBaseVal().getX(),Is.is(50f));
        assertThat(svgFitToViewBox.getViewBox().getBaseVal().getY(),Is.is(51f));
        assertThat(svgFitToViewBox.getViewBox().getBaseVal().getWidth(),Is.is(100f));
        assertThat(svgFitToViewBox.getViewBox().getBaseVal().getHeight(),Is.is(200f));
    }

}