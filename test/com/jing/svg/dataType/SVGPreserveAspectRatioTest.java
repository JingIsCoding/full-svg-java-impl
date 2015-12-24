package com.jing.svg.dataType;

import org.hamcrest.core.Is;
import org.junit.Test;

import static com.jing.svg.dataType.SVGPreserveAspectRatio.AlignmentType.SVG_PRESERVEASPECTRATIO_NONE;
import static com.jing.svg.dataType.SVGPreserveAspectRatio.AlignmentType.SVG_PRESERVEASPECTRATIO_XMAXYMAX;
import static com.jing.svg.dataType.SVGPreserveAspectRatio.MeetOrSliceType.SVG_MEETORSLICE_MEET;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;


public class SVGPreserveAspectRatioTest {

    @Test
    public void should_create_svg_preserve_aspect_by_String_input_correctly(){

        SVGPreserveAspectRatio svgPreserveAspectRatio = new SVGPreserveAspectRatio(" xMaxYMax meet");
        assertThat(svgPreserveAspectRatio.getAlignmentType(), is(SVG_PRESERVEASPECTRATIO_XMAXYMAX));
        assertThat(svgPreserveAspectRatio.getMeetOrSliceType(), is(SVG_MEETORSLICE_MEET));
    }


    @Test
    public void should_create_svg_preserve_aspect_by_only_alignment_type_correctly(){

        SVGPreserveAspectRatio svgPreserveAspectRatio = new SVGPreserveAspectRatio(" xMaxYMax");
        assertThat(svgPreserveAspectRatio.getAlignmentType(), is(SVG_PRESERVEASPECTRATIO_XMAXYMAX));
        assertThat(svgPreserveAspectRatio.getMeetOrSliceType(), is(SVG_MEETORSLICE_MEET));
    }

    @Test
    public void should_create_svg_preserve_aspect_invalid_type_correctly(){

        SVGPreserveAspectRatio svgPreserveAspectRatio = new SVGPreserveAspectRatio(" sdfdsf fdsfsdf");
        assertThat(svgPreserveAspectRatio.getAlignmentType(), is(SVG_PRESERVEASPECTRATIO_NONE));
        assertThat(svgPreserveAspectRatio.getMeetOrSliceType(), is(SVG_MEETORSLICE_MEET));
    }

}