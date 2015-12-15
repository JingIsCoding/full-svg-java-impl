package com.jing.svg.dataType;

public class SVGStyle {

    private Font font = new Font();

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public String getFontFamily() {
        return font.getFontFamily();
    }

    public void setFontFamily(String fontFamily) {
        font.setFontFamily(fontFamily);
    }

    public int getFontSize() {
        return font.getFontSize();
    }

    public void setFontSize(int fontSize) {
        this.font.setFontSize(fontSize);
    }

    public String getFontSizeAdjust() {
        return font.getFontSizeAdjust();
    }

    public void setFontSizeAdjust(String fontSizeAdjust) {
        this.font.setFontSizeAdjust(fontSizeAdjust);
    }

    public String getFontStretch() {
        return this.font.getFontStretch();
    }

    public void setFontStretch(String fontStretch) {
        this.font.setFontStretch(fontStretch);
    }

    public String getFontStyle() {
        return this.font.getFontStyle();
    }

    public void setFontStyle(String fontStyle) {
        this.font.setFontStyle(fontStyle);
    }

    public String getFontWeight() {
        return this.font.getFontWeight();
    }

    public void setFontWeight(String fontWeight) {
        this.font.setFontWeight(fontWeight);
    }

    public String getFontVariant() {
        return this.font.getFontVariant();
    }

    public void setFontVariant(String fontVariant) {
        this.font.setFontVariant(fontVariant);
    }



    public static final class Font{
        private String fontFamily;
        private int fontSize;
        private String fontSizeAdjust;
        private String fontStretch;
        private String fontStyle;
        private String fontWeight;
        private String fontVariant;

        public String getFontFamily() {
            return fontFamily;
        }

        public void setFontFamily(String fontFamily) {
            this.fontFamily = fontFamily;
        }

        public int getFontSize() {
            return fontSize;
        }

        public void setFontSize(int fontSize) {
            this.fontSize = fontSize;
        }

        public String getFontSizeAdjust() {
            return fontSizeAdjust;
        }

        public void setFontSizeAdjust(String fontSizeAdjust) {
            this.fontSizeAdjust = fontSizeAdjust;
        }

        public String getFontStretch() {
            return fontStretch;
        }

        public void setFontStretch(String fontStretch) {
            this.fontStretch = fontStretch;
        }

        public String getFontStyle() {
            return fontStyle;
        }

        public void setFontStyle(String fontStyle) {
            this.fontStyle = fontStyle;
        }

        public String getFontWeight() {
            return fontWeight;
        }

        public void setFontWeight(String fontWeight) {
            this.fontWeight = fontWeight;
        }

        public String getFontVariant() {
            return fontVariant;
        }

        public void setFontVariant(String fontVariant) {
            this.fontVariant = fontVariant;
        }

    }
}
