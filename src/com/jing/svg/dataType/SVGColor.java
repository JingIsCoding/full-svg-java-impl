package com.jing.svg.dataType;


public class SVGColor {

    private SVGColorType svgColorType;
    private RGBColor rgbColor;
    private SVGICCColor svgiccColor;

    public SVGColor(SVGColorType svgColorType, RGBColor rgbColor, SVGICCColor svgiccColor) {
        this.svgColorType = svgColorType;
        this.rgbColor = rgbColor;
        this.svgiccColor = svgiccColor;
    }

    public SVGColor(SVGColorType svgColorType, String rgbColor) {
        this.svgColorType = svgColorType;
        this.setRGBColor(rgbColor);
    }

    public void setRGBColor(String rgbColor){
        this.rgbColor = new RGBColor(rgbColor);
    }

    public void setRGBColorICCColor(String rbgColor,String iccColor){
        //TODO
    }

    public void setColor(SVGColorType svgColorType, String rbgColor, String iccColor){
        //TODO
    }

    public RGBColor getRgbColor() {
        return rgbColor;
    }

    public SVGICCColor getSvgiccColor() {
        return svgiccColor;
    }

    public SVGColorType getSvgColorType() {
        return svgColorType;
    }

    public enum SVGColorType{
        SVG_COLORTYPE_UNKNOWN,
        SVG_COLORTYPE_RGBCOLOR,
        SVG_COLORTYPE_RGBCOLOR_ICCCOLOR,
        SVG_COLORTYPE_CURRENTCOLOR,
    }
}
