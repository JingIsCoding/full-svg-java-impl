package com.jing.svg.element;


import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStyle;

import java.util.HashMap;
import java.util.Map;


public class SVGStyleElement {
    private SVGElement element = new SVGElementImpl(Constants.TagName.STYLE, null);

    private String type;
    private String media;
    private String title;
    private String value;

    public void setId(String id){
        element.setId(id);
    }

    public void getId(String id){
        element.getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SVGStyle toSVGStyle(){
        Map<String,String> styles = new HashMap<>();
        String[] pairs = value.split(";");
        for(String p : pairs){
            String[] keyValue = p.split(":");
            if(keyValue.length == 2){
                styles.put(keyValue[0].trim(),keyValue[1].trim());
            }
        }
        SVGStyle svgStyle = new SVGStyle();
        return svgStyle;
    }
}
