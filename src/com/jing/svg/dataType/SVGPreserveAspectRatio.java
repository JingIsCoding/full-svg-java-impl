package com.jing.svg.dataType;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGPreserveAspectRatio {

    private AlignmentType alignmentType;
    private MeetOrSliceType meetOrSliceType;

    public SVGPreserveAspectRatio(){

    }

    public MeetOrSliceType getMeetOrSliceType() {
        return meetOrSliceType;
    }

    public AlignmentType getAlignmentType() {
        return alignmentType;
    }

    public enum AlignmentType{
        SVG_PRESERVEASPECTRATIO_UNKNOWN,
        SVG_PRESERVEASPECTRATIO_NONE,
        SVG_PRESERVEASPECTRATIO_XMINYMIN,
        SVG_PRESERVEASPECTRATIO_XMIDYMIN,
        SVG_PRESERVEASPECTRATIO_XMAXYMIN,
        SVG_PRESERVEASPECTRATIO_XMINYMID,
        SVG_PRESERVEASPECTRATIO_XMIDYMID,
        SVG_PRESERVEASPECTRATIO_XMAXYMID,
        SVG_PRESERVEASPECTRATIO_XMINYMAX,
        SVG_PRESERVEASPECTRATIO_XMIDYMAX,
        SVG_PRESERVEASPECTRATIO_XMAXYMAX
    }

    public enum MeetOrSliceType{
        SVG_MEETORSLICE_UNKNOWN,
        SVG_MEETORSLICE_MEET,
       SVG_MEETORSLICE_SLICE
    }

}
