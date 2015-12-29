package com.jing.svg.dom;

import com.jing.svg.SVGSVGElement;
import com.jing.svg.dataType.Constants;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


public class MatcherTest {

    @Test
    public void should_match_id(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(Constants.ElementAttributeNames.ID.toString(),"123456");

        Matcher matcher = new Matcher("#abcdef");
        Assert.assertThat(matcher.match(svgsvgElement), Is.is(false));
    }

    @Test
    public void should_match_type(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(Constants.ElementAttributeNames.ID.toString(),"123456");

        Matcher matcher = new Matcher("svg");
        Assert.assertThat(matcher.match(svgsvgElement), Is.is(true));
    }

    @Test
    public void should_match_class_names(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(Constants.ElementAttributeNames.CLASS.toString(),"what has happened");

        Matcher matcher = new Matcher(".what.has");
        Assert.assertThat(matcher.match(svgsvgElement), Is.is(true));
    }

    @Test
    public void should_not_match_class_names_and_type(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(Constants.ElementAttributeNames.CLASS.toString(),"what has happened");

        Matcher matcher = new Matcher("rect.what.has");
        Assert.assertThat(matcher.match(svgsvgElement), Is.is(false));
    }

    @Test
    public void should_match_attribute(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(Constants.ElementAttributeNames.CLASS.toString(),"what has happened");
        svgsvgElement.setAttribute(Constants.StyleName.FILL.toString(),"#abcdef");
        Matcher matcher = new Matcher("svg[fill=#abcdef]");
        Assert.assertThat(matcher.match(svgsvgElement), Is.is(true));
    }

    @Test
    public void should_not_match_attribute(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(Constants.ElementAttributeNames.CLASS.toString(),"what has happened");
        svgsvgElement.setAttribute(Constants.StyleName.FILL.toString(),"#abcdef");
        Matcher matcher = new Matcher("svg[fill=#abcedf]");
        Assert.assertThat(matcher.match(svgsvgElement), Is.is(false));
    }
}

