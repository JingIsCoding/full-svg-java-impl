package com.jing.svg.dataType;


public class SVGColor {

    private SVGColorType svgColorType;
    private RGBColor rgbColor;


    public enum SVGColorType{
        SVG_COLORTYPE_UNKNOWN,
        SVG_COLORTYPE_RGBCOLOR,
        SVG_COLORTYPE_RGBCOLOR_ICCCOLOR,
        SVG_COLORTYPE_CURRENTCOLOR,
    }
}
