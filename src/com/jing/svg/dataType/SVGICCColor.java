package com.jing.svg.dataType;


public class SVGICCColor {
    private String colorProfile;
    private SVGNumberList colors;

    public SVGICCColor(){}

    public SVGICCColor(String colorProfile, SVGNumberList colors) {
        this.colorProfile = colorProfile;
        this.colors = colors;
    }

    public String getColorProfile() {
        return colorProfile;
    }

    public void setColorProfile(String colorProfile) {
        this.colorProfile = colorProfile;
    }

    public SVGNumberList getColors() {
        return colors;
    }

    public void setColors(SVGNumberList colors) {
        this.colors = colors;
    }
}
