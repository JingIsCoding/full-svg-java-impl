package com.jing.svg.element;

import com.jing.svg.SVGGElement;
import com.jing.svg.dataType.SVGStringList;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;


public class SVGStylableImplTest {
    @Test
    public void should_get_class_names_correctly(){
        SVGGElement svggElement = new SVGGElement();
        svggElement.setAttribute("class","what has    happened  ");

        SVGStylable svgStylable = new SVGStylableImpl(svggElement);
        assertThat(svgStylable.getClassNames().getSize(), is(3));
        assertThat(svgStylable.getClassNames().getItem(0), is("what"));
        assertThat(svgStylable.getClassNames().getItem(1), is("has"));
        assertThat(svgStylable.getClassNames().getItem(2), is("happened"));

        assertThat(svggElement.getAttribute("class").getValue().getClass() == SVGStringList.class,is(true));
    }
}