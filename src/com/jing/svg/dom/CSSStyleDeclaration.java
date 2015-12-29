package com.jing.svg.dom;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.jing.svg.dataType.Constants.StyleName.*;

public class CSSStyleDeclaration {
    private String cssText;
    private Map<String,Attribute<CSSValue>> attributeMap = new HashMap<>();
    private Font font = new Font(attributeMap);

    public CSSStyleDeclaration(){
        cssText = "";
    }

    public CSSStyleDeclaration(@NotNull String style){
            cssText = style;
            parseStyles(style);
    }

    private void parseStyles(String style) {
        String[] styles = style.split(";");
        for(String s : styles){
            String[] nameAndValue = s.split(":");
            if(nameAndValue.length != 2)
            {
                continue;
            }
            int importantIndex = nameAndValue[1].lastIndexOf("!important");
            String value = importantIndex == -1 ? nameAndValue[1].trim() : nameAndValue[1].substring(0, importantIndex).trim();
            CSSValue<String> cssValue = new CSSValue<>(value);
            if(importantIndex > -1){
                cssValue.setImportant(true);
            }
            attributeMap.put(nameAndValue[0].trim(),new Attribute<CSSValue>(null,nameAndValue[0].trim(),cssValue));
        }
    }

    public CSSValue<String> getDirection(){
        return getValue(DIRECTION.toString());
    }

    public CSSValue<String> getLetterSpacing(){
        return getValue(LETTER_SPACING.toString());
    }

    public CSSValue<String> getTextDecoration(){
        return getValue(TEXT_DECORATION.toString());
    }

    public CSSValue<String> getUnicodeBidi(){
        return getValue(UNICODE_BIDI.toString());
    }

    public CSSValue<String> getWordSpacing(){
        return getValue(WORD_SPACING.toString());
    }

    public CSSValue getClip(){
        return getValue(GLYPH_ORIENTATION_VERTICAL.toString());
    }

    public CSSValue<String> getColor(){
        return getValue(COLOR.toString());
    }

    public CSSValue<String> getCursor(){
        return getValue(CURSOR.toString());
    }

    public CSSValue<String> getDisplay(){
        return getValue(DISPLAY.toString());
    }

    public CSSValue<String> getOverflow(){
        return getValue(OVERFLOW.toString());
    }

    public CSSValue<String> getVisibility(){
        return getValue(VISIBILITY.toString());
    }

    public CSSValue<String> getClippath(){
        return getValue(CLIP_PATH.toString());
    }

    public CSSValue<String> getMask(){
        return getValue(MASK.toString());
    }

    public CSSValue<String> getOpacity(){
        return getValue(OPACITY.toString());
    }

    public CSSValue<String> getEnableBackground(){
        return getValue(ENABLE_BACKGROUND.toString());
    }

    public CSSValue<String> getFilter(){
        return getValue(FILTER.toString());
    }

    public CSSValue<String> getFloodColor(){
        return getValue(FLOOD_COLOR.toString());
    }

    public CSSValue<String> getFloodOpacity(){
        return getValue(FLOOD_OPACITY.toString());
    }

    public CSSValue<String> getLightingColor(){
        return getValue(LIGHTING_COLOR.toString());
    }

    public CSSValue<String> getStopColor(){
        return getValue(STOP_COLOR.toString());
    }

    public CSSValue<String> getStopOpacity(){
        return getValue(STOP_OPACITY.toString());
    }

    public CSSValue<String> getPointerEvents(){
        return getValue(POINTER_EVENTS.toString());
    }

    public CSSValue<String> getColorInterpolation(){
        return getValue(COLOR_INTERPOLATION.toString());
    }

    public CSSValue<String> getColorInterpolationFilters(){
        return getValue(COLOR_INTERPOLATION_FILTERS.toString());
    }

    public CSSValue<String> getColorProfile(){
        return getValue(COLOR_PROFILE.toString());
    }

    public CSSValue<String> getColorRendering(){
        return getValue(COLOR_RENDERING.toString());
    }

    public CSSValue<String> getFill(){
        return getValue(FILL.toString());
    }

    public CSSValue<String> getFillOpacity(){
        return getValue(FILL_OPACITY.toString());
    }

    public CSSValue<String> getImageRendering(){
        return getValue(IMAGE_RENDERING.toString());
    }

    public CSSValue<String> getMarker(){
        return getValue(MARKER.toString());
    }

    public CSSValue<String> getMarkerEnd(){
        return getValue(MARKER_END.toString());
    }

    public CSSValue<String> getMarkerStart(){
        return getValue(MARKER_START.toString());
    }

    public CSSValue<String> getMarkerMid(){
        return getValue(MARKER_MID.toString());
    }

    public CSSValue<String> getShapeRendering(){
        return getValue(SHAPE_RENDERING.toString());
    }

    public CSSValue<String> getStroke(){
        return getValue(STROKE.toString());
    }

    public CSSValue<String> getStrokeDasharray(){
        return getValue(STROKE_DASHARRAY.toString());
    }

    public CSSValue<String> getStrokeDashOffset(){
        return getValue(STROKE_DASHOFFSET.toString());
    }

    public CSSValue<String> getStrokeLinecap(){
        return getValue(STROKE_LINECAP.toString());
    }

    public CSSValue<String> getStrokeLinejoin(){
        return getValue(STROKE_LINEJOIN.toString());
    }

    public CSSValue<String> getStrokeMiterLlimit(){
        return getValue(STROKE_MITERLIMIT.toString());
    }

    public CSSValue<String> getStrokeOpacity(){
        return getValue(STROKE_OPACITY.toString());
    }

    public CSSValue<String> getStrokeWidth(){
        return getValue(STROKE_WIDTH.toString());
    }

    public CSSValue<String> getTextRendering(){
        return getValue(TEXT_RENDERING.toString());
    }

    public CSSValue<String> getAlignmentBaseline(){
        return getValue(ALIGNMENT_BASELINE.toString());
    }

    public CSSValue<String> getBaselineShift(){
        return getValue(BASELINE_SHIFT.toString());
    }

    public CSSValue<String> getDominantBaseline(){
        return getValue(DOMINANT_BASELINE.toString());
    }

    public CSSValue<String> getGlyphOrientationHorizontal(){
        return getValue(GLYPH_ORIENTATION_HORIZONTAL.toString());
    }

    public CSSValue<String> getGlyphOrientationVertical(){
        return getValue(GLYPH_ORIENTATION_VERTICAL.toString());
    }

    public CSSValue<String> getKerning(){
        return getValue(KERNING.toString());
    }

    public CSSValue<String> getWritingMode(){
        return getValue(WRITING_MODE.toString());
    }

    public CSSValue getValue(String name){
        Attribute<CSSValue> cssValueAttribute = attributeMap.get(name);
        return cssValueAttribute != null ? cssValueAttribute.getValue() : null;
    }

    public void setAttribute(String key, CSSValue cssValue){
        attributeMap.put(key,new Attribute<>(null, key,cssValue));
    }

    public String getPropertyValue(String key){
        return (String)attributeMap.get(key).getValue().getValue();
    }

    public CSSValue getPropertyCSSValue(String key){
        return attributeMap.containsKey(key) ? attributeMap.get(key).getValue() : null;
    }

    public String getCssText() {
        return cssText;
    }

    public Font getFont() {
        return font;
    }

    public static final class Font{
        private Map<String, Attribute<CSSValue>> attributeMap;

        public Font(Map<String, Attribute<CSSValue>> attributeMap) {
            this.attributeMap = attributeMap;
        }

        public CSSValue getFontFamily() {
            return getValue(FONT_FAMILY.toString());
        }

        public CSSValue getFontSize() {
            return getValue(FONT_SIZE.toString());
        }

        public CSSValue getFontSizeAdjust() {
                return getValue(FONT_SIZE.toString());
        }

        public CSSValue getFontStretch() {
            return getValue(FONT_STRETCH.toString());
        }

        public CSSValue getFontStyle() {
            return getValue(FONT_STYLE.toString());
        }

        public CSSValue getFontWeight() {
            return getValue(FONT_WEIGHT.toString());
        }

        public CSSValue getFontVariant() {
            return getValue(FONT_VARIANT.toString());
        }

        public CSSValue getValue(String name){
            Attribute<CSSValue> cssValueAttribute = attributeMap.get(name);
            return cssValueAttribute != null ? cssValueAttribute.getValue() : null;
        }
    }

    public CSSStyleDeclaration mergeStyleDeclaration(CSSStyleDeclaration cssStyleDeclaration){
        CSSStyleDeclaration mergedStyle = new CSSStyleDeclaration();
        mergedStyle.attributeMap.putAll(cssStyleDeclaration.attributeMap);
        mergedStyle.attributeMap.putAll(this.attributeMap);
        return mergedStyle;
    }

}
