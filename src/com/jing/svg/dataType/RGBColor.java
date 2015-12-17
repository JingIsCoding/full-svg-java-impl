package com.jing.svg.dataType;

public class RGBColor {
    private int color;

    // rgb(123,23,43)
    // rgba(123,23,43,99)
    // #ABABAB
    public RGBColor(String colorString){
        String colorStr = colorString.trim().toLowerCase();
        if (colorStr.startsWith("rgb")) {
            parseRGBColor(colorStr);
        }else if(colorStr.startsWith("#")){
            parseHexColor(colorStr);
        }
    }

    private void parseHexColor(String colorStr) {
        String colorSection = colorStr.substring(colorStr.lastIndexOf("#") + 1).trim();
        int r,g,b,a = 255;
        if(colorSection.length() == 6){
            r = Integer.parseInt(colorSection.substring(0,2),16);
            g = Integer.parseInt(colorSection.substring(2,4),16);
            b = Integer.parseInt(colorSection.substring(4,6),16);
        }else if(colorSection.length() == 8){
            r = Integer.parseInt(colorSection.substring(0,2),16);
            g = Integer.parseInt(colorSection.substring(2,4),16);
            b = Integer.parseInt(colorSection.substring(4,6),16);
            a = Integer.parseInt(colorSection.substring(6,8),16);
        }else{
            throw new IllegalArgumentException();
        }
        this.setColor(r,g,b,a);
    }

    private void parseRGBColor(String colorStr) {
        int r = 255,g = 255,b = 255,a = 255;
        colorStr = colorStr.lastIndexOf("(") > -1 ? colorStr.substring(colorStr.lastIndexOf("(") + 1,colorStr.indexOf(")")) : null;
        String[] colors = colorStr != null ? colorStr.split(",") : new String[0];
        if(colors.length == 3){
            try{
                r = Integer.parseInt(colors[0].trim());
                g = Integer.parseInt(colors[1].trim());
                b = Integer.parseInt(colors[2].trim());
            }
            catch (NumberFormatException e){

            }
        }
        else if(colors.length == 4){
            try{
                r = Integer.parseInt(colors[0].trim());
                g = Integer.parseInt(colors[1].trim());
                b = Integer.parseInt(colors[2].trim());
                a = Integer.parseInt(colors[3].trim());
            }catch (NumberFormatException e){

            }
        }else{
            throw new IllegalArgumentException();
        }
        this.setColor(r,g,b,a);
    }

    public RGBColor(int r, int g, int b) {
        this(r, g, b, 255);
    }

    /**
     * Creates an sRGB color with the specified red, green, blue, and alpha
     * values in the range (0 - 255).
     *
     * @throws IllegalArgumentException if <code>r</code>, <code>g</code>,
     *        <code>b</code> or <code>a</code> are outside of the range
     *        0 to 255, inclusive
     * @param r the red component
     * @param g the green component
     * @param b the blue component
     * @param a the alpha component
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     * @see #getAlpha
     * @see #getRGB
     */

    public RGBColor(int r, int g, int b, int a) {
        this.setColor(r,g,b,a);
    }

    private void setColor(int r, int g, int b, int a){
        this.color = ((a & 0xFF) << 24) |
                ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8)  |
                ((b & 0xFF) << 0);
        testColorValueRange(r,g,b,a);
    }

    public void setRed(int red){
        this.setColor(red,this.getGreen(),this.getBlue(),this.getAlpha());
    }

    public void setGreen(int green){
        this.setColor(this.getRed(),green,this.getBlue(),this.getAlpha());
    }

    public void setBlue(int blue){
        this.setColor(this.getRed(),this.getGreen(),blue,this.getAlpha());
    }

    public void setAlpha(int alpha){
        this.setColor(this.getRed(),this.getGreen(),this.getBlue(),alpha);
    }

    /**
     * Returns the red component in the range 0-255 in the default sRGB
     * space.
     * @return the red component.
     * @see #getRGB
     */
    public int getRed() {
        return (getRGB() >> 16) & 0xFF;
    }

    private int getRGB() {
        return this.color;
    }

    /**
     * Returns the green component in the range 0-255 in the default sRGB
     * space.
     * @return the green component.
     * @see #getRGB
     */
    public int getGreen() {
        return (getRGB() >> 8) & 0xFF;
    }

    /**
     * Returns the blue component in the range 0-255 in the default sRGB
     * space.
     * @return the blue component.
     * @see #getRGB
     */
    public int getBlue() {
        return (getRGB() >> 0) & 0xFF;
    }

    /**
     * Returns the alpha component in the range 0-255.
     * @return the alpha component.
     * @see #getRGB
     */
    public int getAlpha() {
        return (getRGB() >> 24) & 0xff;
    }


    private static void testColorValueRange(int r, int g, int b, int a) {
        boolean rangeError = false;
        String badComponentString = "";

        if ( a < 0 || a > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Alpha";
        }
        if ( r < 0 || r > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Red";
        }
        if ( g < 0 || g > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Green";
        }
        if ( b < 0 || b > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Blue";
        }
        if ( rangeError ) {
            throw new IllegalArgumentException("Color parameter outside of expected range:"
                    + badComponentString);
        }
    }

    public String getHexColor() {
        return "#"+Integer.toHexString(this.getRed()).toUpperCase() + Integer.toHexString(this.getGreen()).toUpperCase()  + Integer.toHexString(this.getBlue()).toUpperCase() + (this.getAlpha() != 255 ? Integer.toHexString(this.getAlpha()).toUpperCase() : "");
    }

    public String getRgbColor() {
        return "rgb("+this.getRed()+","+this.getGreen()+","+this.getBlue()+")";
    }

    public String getRgbaColor() {
        return "rgba("+this.getRed()+","+this.getGreen()+","+this.getBlue()+","+this.getAlpha()+")";
    }
}
