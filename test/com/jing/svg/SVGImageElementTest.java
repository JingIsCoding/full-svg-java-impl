package com.jing.svg;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGPreserveAspectRatio;
import org.hamcrest.core.Is;
import org.junit.Test;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.PRESERVE_ASPECT_RATIO;
import static com.jing.svg.dataType.SVGPreserveAspectRatio.AlignmentType.SVG_PRESERVEASPECTRATIO_XMINYMIN;
import static com.jing.svg.dataType.SVGPreserveAspectRatio.MeetOrSliceType.SVG_MEETORSLICE_SLICE;
import static org.junit.Assert.*;


public class SVGImageElementTest {

    @Test
    public void should_get_preserve_aspect_correctly(){
        SVGImageElement svgImageElement = new SVGImageElement();
        svgImageElement.setAttribute(PRESERVE_ASPECT_RATIO.toString(),"xMinYMin slice");

        assertThat(svgImageElement.getPreserveAspectRatio().getBaseVal().getAlignmentType(), Is.is(SVG_PRESERVEASPECTRATIO_XMINYMIN));
        assertThat(svgImageElement.getPreserveAspectRatio().getBaseVal().getMeetOrSliceType(), Is.is(SVG_MEETORSLICE_SLICE));

    }

}