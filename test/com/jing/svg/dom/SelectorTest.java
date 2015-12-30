package com.jing.svg.dom;

import com.jing.svg.SVGSVGElement;
import com.jing.svg.dataType.Constants;
import org.hamcrest.core.Is;
import org.junit.Test;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.CLASS;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class SelectorTest {

    @Test
    public void should_select_svg_element(){
        Selector selector = new Selector("svg");
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        assertThat(selector.match(svgsvgElement), is(true));
    }

    @Test
    public void should_select_svg_element_with_class(){
        Selector selector = new Selector("svg.class");
        SVGSVGElement svgsvgElement = new SVGSVGElement();

        svgsvgElement.setAttribute(CLASS.toString(),"class");
        assertThat(selector.match(svgsvgElement), is(true));
    }
}