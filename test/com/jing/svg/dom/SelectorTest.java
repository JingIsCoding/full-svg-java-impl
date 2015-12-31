package com.jing.svg.dom;

import com.jing.svg.SVGGElement;
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

    @Test
    public void should_match_g_element_inside_of_svg(){
        Selector selector = new Selector("svg g");

        SVGSVGElement svgsvgElement = new SVGSVGElement();
        SVGGElement svggElement = new SVGGElement();
        svgsvgElement.appendChild(svggElement);

        assertThat(selector.match(svggElement), is(true));
    }

    @Test
    public void should_match_g_element_parent_is_svg(){
        Selector selector = new Selector("svg.svg-root.svg-root1>g");

        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(CLASS.toString(),"svg-root svg-root1");

        SVGGElement svggElement = new SVGGElement();
        SVGGElement svggElement1 = new SVGGElement();
        svgsvgElement.appendChild(svggElement);

        svggElement.appendChild(svggElement1);

        assertThat(selector.match(svggElement), is(true));
        assertThat(selector.match(svggElement1), is(false));
    }

    @Test
    public void should_match_g_element_parent_is_either_svg_g(){
        Selector selector = new Selector("svg,g>g");

        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(CLASS.toString(),"svg-root svg-root1");

        SVGGElement svggElement = new SVGGElement();
        SVGGElement svggElement1 = new SVGGElement();
        svgsvgElement.appendChild(svggElement);

        svggElement.appendChild(svggElement1);

        assertThat(selector.match(svggElement), is(true));
        assertThat(selector.match(svggElement1), is(true));
    }
}