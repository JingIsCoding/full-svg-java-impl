package com.jing.svg.element;

import org.hamcrest.core.IsNull;
import org.junit.Test;

import static com.jing.svg.dataType.Constants.TagName.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SVGBaseElementTest {

    @Test
    public void should_set_attribute_correctly(){
        SVGBaseElement svgElement= new SVGBaseElement(SVG, null ,null);
        svgElement.setAttribute("class","what");
        svgElement.setAttribute("width","123px");

        assertThat(svgElement.getAttribute("width").getValue().toString(), is("123px"));
        assertThat(svgElement.getAttribute("class").getValue().toString(), is("what"));
    }

    @Test
    public void should_set_parent_correctly(){
        SVGElement svgElement= new SVGBaseElement(SVG, null ,null);
        SVGElement rectElement= new SVGBaseElement(RECT, null ,null);
        svgElement.appendChild(rectElement);

        assertThat(rectElement.getParent(), is(svgElement));
    }

    @Test
    public void should_set_children_correctly(){
        SVGElement svgElement= new SVGBaseElement(SVG, null ,null);
        SVGElement rectElement1= new SVGBaseElement(RECT, null ,null);
        SVGElement rectElement2= new SVGBaseElement(RECT, null ,null);
        SVGElement rectElement3= new SVGBaseElement(RECT, null ,null);

        svgElement.appendChild(rectElement1);
        svgElement.appendChild(rectElement2);
        svgElement.appendChild(rectElement3);

        assertThat(svgElement.getChildrenNodes().size(), is(3));
        assertThat(svgElement.getFirstChild(), is(rectElement1));
        assertThat(svgElement.getLastChild(), is(rectElement3));
    }

    @Test
    public void should_get_siblings_correctly(){
        SVGElement svgElement= new SVGBaseElement(SVG, null ,null);
        SVGElement rectElement1= new SVGBaseElement(RECT, null ,null);
        SVGElement rectElement2= new SVGBaseElement(RECT, null ,null);
        SVGElement rectElement3= new SVGBaseElement(RECT, null ,null);

        svgElement.appendChild(rectElement1);
        svgElement.appendChild(rectElement2);
        svgElement.appendChild(rectElement3);

        assertThat(rectElement2.getPreviousSibling(), is(rectElement1));
        assertThat(rectElement2.getNextSibling(), is(rectElement3));
        assertThat(rectElement3.getNextSibling(), IsNull.nullValue());
    }

    @Test
    public void should_get_element_by_tag_name_correctly(){
        SVGBaseElement svgElement= new SVGBaseElement(SVG, null ,null);
        SVGBaseElement rect= new SVGBaseElement(RECT, null ,null);
        SVGBaseElement gElement= new SVGBaseElement(G, null ,null);
        SVGBaseElement defsElement= new SVGBaseElement(DEFS, null ,null);
        SVGBaseElement descElement = new SVGBaseElement(DESC, null ,null);

        svgElement.appendChild(rect);
        svgElement.appendChild(gElement);
        svgElement.appendChild(defsElement);
        svgElement.appendChild(descElement);

        SVGBaseElement rect1= new SVGBaseElement(RECT, null ,null);
        SVGBaseElement rect2= new SVGBaseElement(RECT, null ,null);
        SVGBaseElement rect3= new SVGBaseElement(RECT, null ,null);
        gElement.appendChild(rect1);
        gElement.appendChild(rect2);
        gElement.appendChild(rect3);

        assertThat(svgElement.getElementByTagName(RECT).size() ,is(4));
        assertThat(svgElement.getElementByTagName(G).size() ,is(1));
    }

    @Test
    public void should_clone_node_not_deep_with_correctly_properties(){
        SVGBaseElement svgElement= new SVGBaseElement(SVG, null ,null);
        svgElement.setId("abc");
        svgElement.setXmlBase("base");
        svgElement.setAttribute("key1",new Integer(123));
        svgElement.setAttribute("key2",new Integer(321));
        svgElement.setContent("Just some thing in the content");
        SVGElement svgElement1 = svgElement.cloneNode(false);


        assertThat(svgElement1.getId(),is("abc"));
        assertThat(svgElement1.getXmlBase(),is("base"));
        assertThat(svgElement1.getContent(),is("Just some thing in the content"));
        assertThat((Integer)svgElement1.getAttribute("key1").getValue(),is(new Integer(123)));
        assertThat((Integer)svgElement1.getAttribute("key2").getValue(),is(new Integer(321)));

        svgElement1.setAttribute("key1",new Double(123.123d));
        svgElement.setContent("changed the content");

        assertThat((Double)svgElement1.getAttribute("key1").getValue(),is(new Double(123.123d)));
        assertThat((Integer)svgElement.getAttribute("key1").getValue(),is(new Integer(123)));
        assertThat(svgElement1.getContent(),is("Just some thing in the content"));
    }

    @Test
    public void should_clone_node_deep_with_correctly_properties(){
        SVGBaseElement svgElement= new SVGBaseElement(SVG, null ,null);
        SVGBaseElement gElement= new SVGBaseElement(G, null ,null);
        SVGBaseElement rect= new SVGBaseElement(RECT, null ,null);

        svgElement.appendChild(gElement);
        gElement.appendChild(rect);

        SVGElement svgElement1 = svgElement.cloneNode(true);
        assertThat(svgElement1.getChildrenNodes().size(),is(1));
        assertThat(svgElement1.getFirstChild().getTagName(),is(G));
        assertThat(svgElement1.getFirstChild().getChildrenNodes().size(),is(1));
        assertThat(svgElement1.getFirstChild().getFirstChild().getTagName(),is(RECT));
    }

    @Test
    public void should_find_element_by_Id(){
        SVGElement svgElement= new SVGBaseElement(SVG);

        SVGElement gElement= new SVGBaseElement(G, null);
        SVGElement rect= new SVGBaseElement(RECT, null);
        SVGElement rect1= new SVGBaseElement(RECT, null);
        gElement.appendChild(rect);
        gElement.appendChild(rect1);

        SVGElement gElement1= new SVGBaseElement(G, null);
        SVGElement rect2= new SVGBaseElement(RECT, null);
        rect2.setId("rect2");

        SVGElement rect3= new SVGBaseElement(RECT, null);
        gElement1.appendChild(rect2);
        gElement1.appendChild(rect3);

        gElement.appendChild(gElement1);

        svgElement.appendChild(gElement);

        assertThat(svgElement.getElementById("rect2"),is(rect2));
    }
}