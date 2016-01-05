package com.jing.svg.dataType;

import static com.jing.svg.dataType.Constants.BY_SPACE;

public class SVGRect {
    private float x;
    private float y;
    private float width;
    private float height;

    public SVGRect(String coordination){
        String[] coordinations = coordination.split(",");
        try{
        if(coordinations.length == 4){
            this.x = Float.parseFloat(coordinations[0].trim());
            this.y = Float.parseFloat(coordinations[1].trim());
            this.width = Float.parseFloat(coordinations[2].trim());
            this.height = Float.parseFloat(coordinations[3].trim());
        }else{
            throw new IllegalArgumentException();
        }
        }catch (Exception e){
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
        }
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public SVGRect(){
    }

    public SVGRect(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
