package com.jing.svg.dataType;

public class Constants {

    public enum TagName{

        SVG("svg");

        private String name;
        TagName(String name){
            this.name = name;
        };

        @Override
        public String toString(){
            return this.name;
        }
    }

    public static final String SVG_TAG = "svg";

}
