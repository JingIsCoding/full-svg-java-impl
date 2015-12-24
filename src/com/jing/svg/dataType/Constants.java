package com.jing.svg.dataType;

public class Constants {

    public enum TagName{
        SVG("svg"),
        RECT("rect"),
        G("g"),
        DEFS("defs"),
        USE("use"),
        DESC("desc"),
        SYMBOL("symbol"),
        STYLE("style"),
        IMAGE("image"),
        SWITCH("switch"),
        TITLE("title");

        private String name;
        TagName(String name){
            this.name = name;
        }

        public static String[] getNames(){
            String[] names = new String[values().length];
            for(int i = 0 ; i < values().length ; i++){
                names[i] = values()[i].name;
            }
            return names;
        }

        @Override
        public String toString(){
            return this.name;
        }
    }

    public enum Tests{
        REQUIRED_FEATURES("requiredFeatures"),
        REQUIRED_EXTENSIONS("requiredExtensions"),
        SYSTEM_LANGUAGE("systemLanguage");

        private String name;
        Tests(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return this.name;
        }
    }

    public enum ElementAttributeNames{
        X("x"),
        Y("y"),
        WIDTH("width"),
        HEIGHT("height"),
        STYLE("style"),
        TITLE("title"),
        TYPE("type"),
        MEDIA("media"),
        XLINK_HREF("xlink:href"),
        PRESERVE_ASPECT_RATIO("preserveAspectRatio");
        private String name;
        ElementAttributeNames(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return this.name;
        }
    }

    public enum StyleName{
        FONT("font"),
        FONT_FAMILY("font-family"),
        FONT_SIZE("font-size"),
        FONT_SIZE_ADJUST("font-size-adjust"),
        FONT_STRETCH("font-stretch"),
        FONT_STYLE("font-style"),
        FONT_VARIANT("font-variant"),
        FONT_WEIGHT("font-weight"),
        DIRECTION("direction"),
        LETTER_SPACING("letter-spacing"),
        TEXT_DECORATION("test-decoration"),
        UNICODE_BIDI("unicode-bidi"),
        WORD_SPACING("word-spacing"),
        CLIP("clip"),
        COLOR("color"),
        CURSOR("cursor"),
        DISPLAY("display"),
        OVERFLOW("overflow"),
        VISIBILITY("visibility"),
        CLIP_PATH("clip-path"),
        CLIP_RULE("clip_rule"),
        MASK("mast"),
        OPACITY("opacity"),
        ENABLE_BACKGROUND("enable-background"),
        FILTER("filter"),
        FLOOD_COLOR("flood-color"),
        FLOOD_OPACITY("flood-opacity"),
        LIGHTING_COLOR("lighting-color"),
        STOP_COLOR("stop-color"),
        STOP_OPACITY("stop-opacity"),
        POINTER_EVENTS("pointer-events"),
        COLOR_INTERPOLATION("color-interpolation"),
        COLOR_INTERPOLATION_FILTERS("color-interpolation-filters"),
        COLOR_PROFILE("color-profile"),
        COLOR_RENDERING("color-rendering"),
        FILL("fill"),
        FILL_OPACITY("fill-opacity"),
        FILL_RULE("fill-rule"),
        IMAGE_RENDERING("image-rendering"),
        MARKER("marker"),
        MARKER_END("marker-end"),
        MARKER_MID("marker-mid"),
        MARKER_START("marker-start"),
        SHAPE_RENDERING("shape-rendering"),
        STROKE("stroke"),
        STROKE_DASHARRAY("stroke-dasharray"),
        STROKE_DASHOFFSET("stroke-dashoffset"),
        STROKE_LINECAP("stroke-linecap"),
        STROKE_LINEJOIN("stroke-linejoin"),
        STROKE_MITERLIMIT("stroke-miterlimit"),
        STROKE_OPACITY("stroke-opacity"),
        STROKE_WIDTH("stroke-width"),
        TEXT_RENDERING("text-rendering"),
        ALIGNMENT_BASELINE("alignment-baseline"),
        BASELINE_SHIFT("baseline-shift"),
        DOMINANT_BASELINE("dominant-baseline"),
        GLYPH_ORIENTATION_HORIZONTAL("glyph-orientation-horizontal"),
        GLYPH_ORIENTATION_VERTICAL("glyph-orientation-vertical"),
        KERNING("kerning"),
        TEXT_ANCHOR("text-anchor"),
        WRITING_MODE("writing-mode");

        private String name;
        StyleName(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return this.name;
        }
    }

    public static final String BY_SPACE = "\\s+";

}
