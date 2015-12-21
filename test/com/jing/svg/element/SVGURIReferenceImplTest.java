package com.jing.svg.element;

import com.jing.svg.SVGUseElement;
import com.jing.svg.dataType.Constants;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;


public class SVGURIReferenceImplTest {

    @Test
    public void should_get_uri_link(){
        SVGUseElement svgUseElement = new SVGUseElement();
        svgUseElement.setAttribute(Constants.ElementAttributeNames.XLINK_HREF.toString(),"#123");

        assertThat(svgUseElement.getHref().getBaseVal(), Is.is("#123"));
    }

}