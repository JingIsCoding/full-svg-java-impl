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

        @Override
        public String toString(){
            return this.name;
        }
    }

    public enum Location{
        X("x"),
        Y("y"),
        WIDTH("width"),
        HEIGHT("height");

        private String name;
        Location(String name){
            this.name = name;
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
    public static final String SVG_TAG = "svg";

}
