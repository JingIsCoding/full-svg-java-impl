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
        ID("id"),
        X("x"),
        Y("y"),
        WIDTH("width"),
        HEIGHT("height"),
        CLASS("class"),
        STYLE("style"),
        TITLE("title"),
        TYPE("type"),
        MEDIA("media"),
        XLINK_HREF("xlink:href"),
        TRANSFORM("transform"),
        VIEW_BOX("viewBox"),
        PRESERVE_ASPECT_RATIO("preserveAspectRatio"),
        XML_LANG("xml:lang"),
        XML_SPACE("xml:space");
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

    public static final String DEFAULT_STYLE =
            "align-content: stretch;\n" +
                    "align-items: stretch;\n" +
                    "align-self: stretch;\n" +
                    "alignment-baseline: auto;\n" +
                    "background-attachment: scroll;\n" +
                    "background-clip: border-box;\n" +
                    "background-color: rgba(0, 0, 0, 0);\n" +
                    "background-image: none;\n" +
                    "background-origin: padding-box;\n" +
                    "background-position: 0% 0%;\n" +
                    "background-repeat: repeat;\n" +
                    "background-size: auto;\n" +
                    "baseline-shift: baseline;\n" +
                    "border-bottom-color: rgb(0, 0, 0);\n" +
                    "border-bottom-left-radius: 0px;\n" +
                    "border-bottom-right-radius: 0px;\n" +
                    "border-bottom-style: none;\n" +
                    "border-bottom-width: 0px;\n" +
                    "border-collapse: separate;\n" +
                    "border-image-outset: 0px;\n" +
                    "border-image-repeat: stretch;\n" +
                    "border-image-slice: 100%;\n" +
                    "border-image-source: none;\n" +
                    "border-image-width: 1;\n" +
                    "border-left-color: rgb(0, 0, 0);\n" +
                    "border-left-style: none;\n" +
                    "border-left-width: 0px;\n" +
                    "border-right-color: rgb(0, 0, 0);\n" +
                    "border-right-style: none;\n" +
                    "border-right-width: 0px;\n" +
                    "border-top-color: rgb(0, 0, 0);\n" +
                    "border-top-left-radius: 0px;\n" +
                    "border-top-right-radius: 0px;\n" +
                    "border-top-style: none;\n" +
                    "border-top-width: 0px;\n" +
                    "bottom: auto;\n" +
                    "box-shadow: none;\n" +
                    "box-sizing: content-box;\n" +
                    "buffered-rendering: auto;\n" +
                    "caption-side: top;\n" +
                    "clear: none;\n" +
                    "clip: auto;\n" +
                    "clip-path: none;\n" +
                    "clip-rule: nonzero;\n" +
                    "color: rgb(0, 0, 0);\n" +
                    "color-interpolation: srgb;\n" +
                    "color-interpolation-filters: linearrgb;\n" +
                    "color-rendering: auto;\n" +
                    "cursor: auto;\n" +
                    "direction: ltr;\n" +
                    "display: inline;\n" +
                    "dominant-baseline: auto;\n" +
                    "empty-cells: show;\n" +
                    "fill: #000000;\n" +
                    "fill-opacity: 1;\n" +
                    "fill-rule: nonzero;\n" +
                    "filter: none;\n" +
                    "flex-basis: auto;\n" +
                    "flex-direction: row;\n" +
                    "flex-grow: 0;\n" +
                    "flex-shrink: 1;\n" +
                    "flex-wrap: nowrap;\n" +
                    "float: none;\n" +
                    "flood-color: rgb(0, 0, 0);\n" +
                    "flood-opacity: 1;\n" +
                    "font-family: 'Times New Roman';\n" +
                    "font-size: 16px;\n" +
                    "font-style: normal;\n" +
                    "font-variant: normal;\n" +
                    "font-weight: normal;\n" +
                    "glyph-orientation-horizontal: 0deg;\n" +
                    "glyph-orientation-vertical: auto;\n" +
                    "height: 0px;\n" +
                    "image-rendering: auto;\n" +
                    "justify-content: flex-start;\n" +
                    "kerning: 0;\n" +
                    "left: auto;\n" +
                    "letter-spacing: normal;\n" +
                    "lighting-color: rgb(255, 255, 255);\n" +
                    "line-height: normal;\n" +
                    "list-style-image: none;\n" +
                    "list-style-position: outside;\n" +
                    "list-style-type: disc;\n" +
                    "margin-bottom: 0px;\n" +
                    "margin-left: 0px;\n" +
                    "margin-right: 0px;\n" +
                    "margin-top: 0px;\n" +
                    "marker-end: none;\n" +
                    "marker-mid: none;\n" +
                    "marker-start: none;\n" +
                    "mask: none;\n" +
                    "mask-type: luminance;\n" +
                    "max-height: none;\n" +
                    "max-width: none;\n" +
                    "min-height: 0px;\n" +
                    "min-width: 0px;\n" +
                    "opacity: 1;\n" +
                    "order: 0;\n" +
                    "orphans: auto;\n" +
                    "outline-color: rgb(0, 0, 0);\n" +
                    "outline-offset: 0px;\n" +
                    "outline-style: none;\n" +
                    "outline-width: 0px;\n" +
                    "overflow-wrap: normal;\n" +
                    "overflow-x: hidden;\n" +
                    "overflow-y: hidden;\n" +
                    "padding-bottom: 0px;\n" +
                    "padding-left: 0px;\n" +
                    "padding-right: 0px;\n" +
                    "padding-top: 0px;\n" +
                    "page-break-after: auto;\n" +
                    "page-break-before: auto;\n" +
                    "page-break-inside: auto;\n" +
                    "pointer-events: auto;\n" +
                    "position: static;\n" +
                    "resize: none;\n" +
                    "right: auto;\n" +
                    "shape-rendering: auto;\n" +
                    "speak: normal;\n" +
                    "stop-color: rgb(0, 0, 0);\n" +
                    "stop-opacity: 1;\n" +
                    "stroke: none;\n" +
                    "stroke-dasharray: none;\n" +
                    "stroke-dashoffset: 0;\n" +
                    "stroke-linecap: butt;\n" +
                    "stroke-linejoin: miter;\n" +
                    "stroke-miterlimit: 4;\n" +
                    "stroke-opacity: 1;\n" +
                    "stroke-width: 1;\n" +
                    "tab-size: 8;\n" +
                    "table-layout: auto;\n" +
                    "text-align: start;\n" +
                    "text-anchor: start;\n" +
                    "text-decoration: none solid rgb(0, 0, 0);\n" +
                    "text-indent: 0px;\n" +
                    "text-overflow: clip;\n" +
                    "text-rendering: auto;\n" +
                    "text-shadow: none;\n" +
                    "text-transform: none;\n" +
                    "top: auto;\n" +
                    "transition-delay: 0s;\n" +
                    "transition-duration: 0s;\n" +
                    "transition-property: all;\n" +
                    "transition-timing-function: ease;\n" +
                    "unicode-bidi: normal;\n" +
                    "vector-effect: none;\n" +
                    "vertical-align: baseline;\n" +
                    "visibility: visible;\n" +
                    "white-space: normal;\n" +
                    "widows: auto;\n" +
                    "width: 0px;\n" +
                    "word-break: normal;\n" +
                    "word-spacing: 0px;\n" +
                    "word-wrap: normal;\n" +
                    "writing-mode: lr-tb;\n" +
                    "z-index: auto;\n" +
                    "zoom: 1;";
}
