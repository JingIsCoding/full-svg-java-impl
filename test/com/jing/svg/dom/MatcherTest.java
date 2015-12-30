package com.jing.svg.dom;

import com.jing.svg.SVGGElement;
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
    public void should_not_match_class_names(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(Constants.ElementAttributeNames.CLASS.toString(),"what has happened");

        Matcher matcher = new Matcher(".what.the");
        Assert.assertThat(matcher.match(svgsvgElement), Is.is(false));
    }

    @Test
    public void should_not_match_class_names_and_type_when_type_doesnt_match(){
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
        Matcher matcher = new Matcher("svg[fill=\"#abcdef\"]");
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

    @Test
    public void should_match_attribute_with_start_with(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        svgsvgElement.setAttribute(Constants.ElementAttributeNames.CLASS.toString(),"what has happened");
        svgsvgElement.setAttribute(Constants.StyleName.FILL.toString(),"#abcdef");
        svgsvgElement.setAttribute(Constants.ElementAttributeNames.X.toString(),"200px");
        Matcher matcher = new Matcher("svg[x|=200]");
        Assert.assertThat(matcher.match(svgsvgElement), Is.is(false));
    }

    @Test
    public void should_match_status_with_nth_child(){
        SVGSVGElement svgsvgElement = new SVGSVGElement();
        SVGGElement svggElement1 = new SVGGElement();
        SVGGElement svggElement2 = new SVGGElement();
        svgsvgElement.appendChild(svggElement1);
        svgsvgElement.appendChild(svggElement2);

        Matcher matcher = new Matcher("g:nth-child(2)");
        Assert.assertThat(matcher.match(svggElement2), Is.is(true));
    }
}

