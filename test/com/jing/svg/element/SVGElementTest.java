package com.jing.svg.element;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.Constants.TagName;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.omg.CORBA.DoubleHolder;

import static com.jing.svg.dataType.Constants.TagName.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SVGElementTest {

    @Test
    public void should_set_attribute_correctly(){
        SVGElement svgElement= new SVGElement(SVG, null ,null);
        svgElement.setAttribute("class","what");
        svgElement.setAttribute("width","123px");

        assertThat(svgElement.getAttribute("width").getValue().toString(), is("123px"));
        assertThat(svgElement.getAttribute("class").getValue().toString(), is("what"));
    }

    @Test
    public void should_set_parent_correctly(){
        SVGElement svgElement= new SVGElement(SVG, null ,null);
        SVGElement rectElement= new SVGElement(RECT, null ,null);
        svgElement.appendChild(rectElement);

        assertThat(rectElement.getParent(), is(svgElement));
    }

    @Test
    public void should_set_children_correctly(){
        SVGElement svgElement= new SVGElement(SVG, null ,null);
        SVGElement rectElement1= new SVGElement(RECT, null ,null);
        SVGElement rectElement2= new SVGElement(RECT, null ,null);
        SVGElement rectElement3= new SVGElement(RECT, null ,null);

        svgElement.appendChild(rectElement1);
        svgElement.appendChild(rectElement2);
        svgElement.appendChild(rectElement3);

        assertThat(svgElement.getChildrenNodes().size(), is(3));
        assertThat(svgElement.getFirstChild(), is(rectElement1));
        assertThat(svgElement.getLastChild(), is(rectElement3));
    }

    @Test
    public void should_get_siblings_correctly(){
        SVGElement svgElement= new SVGElement(SVG, null ,null);
        SVGElement rectElement1= new SVGElement(RECT, null ,null);
        SVGElement rectElement2= new SVGElement(RECT, null ,null);
        SVGElement rectElement3= new SVGElement(RECT, null ,null);

        svgElement.appendChild(rectElement1);
        svgElement.appendChild(rectElement2);
        svgElement.appendChild(rectElement3);

        assertThat(rectElement2.getPreviousSibling(), is(rectElement1));
        assertThat(rectElement2.getNextSibling(), is(rectElement3));
        assertThat(rectElement3.getNextSibling(), IsNull.nullValue());
    }

    @Test
    public void should_get_element_by_tag_name_correctly(){
        SVGElement svgElement= new SVGElement(SVG, null ,null);
        SVGElement rect= new SVGElement(RECT, null ,null);
        SVGElement gElement= new SVGElement(G, null ,null);
        SVGElement defsElement= new SVGElement(DEFS, null ,null);
        SVGElement descElement = new SVGElement(DESC, null ,null);

        svgElement.appendChild(rect);
        svgElement.appendChild(gElement);
        svgElement.appendChild(defsElement);
        svgElement.appendChild(descElement);

        SVGElement rect1= new SVGElement(RECT, null ,null);
        SVGElement rect2= new SVGElement(RECT, null ,null);
        SVGElement rect3= new SVGElement(RECT, null ,null);
        gElement.appendChild(rect1);
        gElement.appendChild(rect2);
        gElement.appendChild(rect3);

        assertThat(svgElement.getElementByTagName(RECT).size() ,is(4));
        assertThat(svgElement.getElementByTagName(G).size() ,is(1));
    }

    @Test
    public void should_clone_node_not_deep_with_correctly_properties(){
        SVGElement svgElement= new SVGElement(SVG, null ,null);
        svgElement.setId("abc");
        svgElement.setXmlBase("base");
        svgElement.setAttribute("key1",new Integer(123));
        svgElement.setAttribute("key2",new Integer(321));

        SVGElement svgElement1 = svgElement.cloneNode(false);
        assertThat(svgElement1.getId(),is("abc"));
        assertThat(svgElement1.getXmlBase(),is("base"));
        assertThat((Integer)svgElement1.getAttribute("key1").getValue(),is(new Integer(123)));
        assertThat((Integer)svgElement1.getAttribute("key2").getValue(),is(new Integer(321)));

        svgElement1.setAttribute("key1",new Double(123.123d));

        assertThat((Double)svgElement1.getAttribute("key1").getValue(),is(new Double(123.123d)));
        assertThat((Integer)svgElement.getAttribute("key1").getValue(),is(new Integer(123)));
    }

    @Test
    public void should_clone_node_deep_with_correctly_properties(){
        SVGElement svgElement= new SVGElement(SVG, null ,null);
        SVGElement gElement= new SVGElement(G, null ,null);
        SVGElement rect= new SVGElement(RECT, null ,null);

        svgElement.appendChild(gElement);
        gElement.appendChild(rect);

        SVGElement svgElement1 = svgElement.cloneNode(true);
        assertThat(svgElement1.getChildrenNodes().size(),is(1));
        assertThat(svgElement1.getFirstChild().getTagName(),is(G));
        assertThat(svgElement1.getFirstChild().getChildrenNodes().size(),is(1));
        assertThat(svgElement1.getFirstChild().getFirstChild().getTagName(),is(RECT));
    }
}