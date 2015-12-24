package com.jing.svg.dataType;

public class SVGPreserveAspectRatio {

    private AlignmentType alignmentType;
    private MeetOrSliceType meetOrSliceType;

    public SVGPreserveAspectRatio(String preserveAspectRatio){
        String[] aspectRatioConfigs = preserveAspectRatio.split(Constants.BY_SPACE);
        for(String config : aspectRatioConfigs){
            AlignmentType alignmentType = AlignmentType.findByValue(config);
            MeetOrSliceType meetOrSliceType = MeetOrSliceType.findByValue(config);

            this.alignmentType = alignmentType != null ? alignmentType : this.alignmentType;
            this.meetOrSliceType = meetOrSliceType != null ? meetOrSliceType : this.meetOrSliceType;
        }
        if( this.alignmentType == null){this.alignmentType = AlignmentType.SVG_PRESERVEASPECTRATIO_NONE;}
        if( this.meetOrSliceType == null){this.meetOrSliceType = MeetOrSliceType.SVG_MEETORSLICE_MEET;}
    }

    public MeetOrSliceType getMeetOrSliceType() {
        return meetOrSliceType;
    }

    public AlignmentType getAlignmentType() {
        return alignmentType;
    }

    public enum AlignmentType{
        SVG_PRESERVEASPECTRATIO_UNKNOWN("unkown"),
        SVG_PRESERVEASPECTRATIO_NONE("none"),
        SVG_PRESERVEASPECTRATIO_XMINYMIN("xMinYMin"),
        SVG_PRESERVEASPECTRATIO_XMIDYMIN("xMidYMin"),
        SVG_PRESERVEASPECTRATIO_XMAXYMIN("xMaxYMin"),
        SVG_PRESERVEASPECTRATIO_XMINYMID("xMinYMid"),
        SVG_PRESERVEASPECTRATIO_XMIDYMID("xMidYMid"),
        SVG_PRESERVEASPECTRATIO_XMAXYMID("xMaxYMid"),
        SVG_PRESERVEASPECTRATIO_XMINYMAX("xMinYMax"),
        SVG_PRESERVEASPECTRATIO_XMIDYMAX("xMidYMax"),
        SVG_PRESERVEASPECTRATIO_XMAXYMAX("xMaxYMax");

        private String value;
        AlignmentType(String value){
            this.value = value;
        }
        @Override
        public String toString(){
            return value;
        }

        public static AlignmentType findByValue(String value){
            if(value== null){
                return null;
            }
            for(AlignmentType type : values()){
                if(type.value.toLowerCase().equals(value.toLowerCase())){
                    return type;
                }
            }
            return null;
        }
    }

    public enum MeetOrSliceType{
        SVG_MEETORSLICE_UNKNOWN("unknown"),
        SVG_MEETORSLICE_MEET("meet"),
        SVG_MEETORSLICE_SLICE("slice");

        private String value;
        MeetOrSliceType(String value){
            this.value = value;
        }
        @Override
        public String toString(){
            return value;
        }

        public static MeetOrSliceType findByValue(String value){
            if(value== null){
                return null;
            }
            for(MeetOrSliceType type : values()){
                if(type.value.toLowerCase().equals(value.toLowerCase())){
                    return type;
                }
            }
            return null;
        }
    }

}
