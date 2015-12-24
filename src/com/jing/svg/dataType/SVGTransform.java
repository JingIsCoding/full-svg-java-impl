package com.jing.svg.dataType;

import static com.jing.svg.dataType.Constants.BY_SPACE;
import static com.jing.svg.dataType.SVGTransform.SVGTransformType.findByValue;

public class SVGTransform {

    private SVGTransformType transformType;
    private SVGMatrix matrix;
    private SVGAngle angle;

    public SVGTransform(){
        this("");
    }

    public SVGTransform(String value){
        this.matrix = new SVGMatrix();
        String transform = value.indexOf("(") != -1 ? value.substring(0,value.indexOf("(")).trim() : null;
        this.transformType = findByValue(transform);

        try{
        switch (transformType){
            case SVG_TRANSFORM_MATRIX:
                setMatrix(extractData(value));
                break;
            case SVG_TRANSFORM_TRANSLATE:
                setTranslate(extractData(value));
                break;
            case SVG_TRANSFORM_SCALE:
                setScale(extractData(value));
                break;
            case SVG_TRANSFORM_ROTATE:
                setRotate(extractData(value));
                break;
            case SVG_TRANSFORM_SKEWX:
                setSkewX(extractData(value));
                break;
            case SVG_TRANSFORM_SKEWY:
                setSkewY(extractData(value));
                break;
            default:
                break;
        }}catch (Exception e){

        }
    }

    private void setSkewY(String skewY) {
        this.matrix = this.matrix.skewY(new SVGAngle(skewY));
    }

    private void setSkewX(String skewX) {
        this.matrix = this.matrix.skewX(new SVGAngle(skewX));
    }

    private void setScale(String scale) {
        String[] xy = scale.split(",");
        if(xy.length == 1){
            this.matrix = this.matrix.scaleNonUniform(Double.parseDouble(xy[0]),Double.parseDouble(xy[0]));
        }else if(xy.length == 2){
            this.matrix = this.matrix.scaleNonUniform(Double.parseDouble(xy[0]) ,Double.parseDouble(xy[1]));
        }
    }

    private void setTranslate(String translate) {
        String[] xy = translate.split(",");
        if(xy.length == 1){
            this.matrix = this.matrix.translate(Double.parseDouble(xy[0]) ,0d);
        }else if(xy.length == 2){
            this.matrix = this.matrix.translate(Double.parseDouble(xy[0]) ,Double.parseDouble(xy[1]));
        }
    }

    private void setRotate(String rotate) {
        String[] values = rotate.split(BY_SPACE);
        if(values.length == 1){
            SVGAngle svgAngle = new SVGAngle(values[0]);
            this.matrix = this.matrix.rotate(svgAngle);
        }
        else if(values.length == 3){
            SVGAngle svgAngle = new SVGAngle(values[0]);
                this.matrix = this.matrix.rotateFromVector(svgAngle,Double.parseDouble(values[1]),Double.parseDouble(values[2]));

        }
    }

    private void setMatrix(String matrixString) {
        String[] valueString = matrixString.split(",");
        if(valueString.length < 6)
        {
            this.matrix = new SVGMatrix();}
        else {
            this.matrix = new SVGMatrix(new double[]{Double.parseDouble(valueString[0].trim()), Double.parseDouble(valueString[1].trim()), Double.parseDouble(valueString[2].trim()), Double.parseDouble(valueString[3].trim()), Double.parseDouble(valueString[4].trim()), Double.parseDouble(valueString[5].trim())});
        }
    }

    public SVGTransform(SVGMatrix matrix) {
        this.matrix = matrix;
    }

    public SVGAngle getAngle() {
        return angle;
    }

    public SVGMatrix getMatrix() {
        return matrix;
    }

    public SVGTransformType getTransformType() {
        return transformType;
    }


    public enum SVGTransformType{
        SVG_TRANSFORM_UNKNOWN("unknown"),
        SVG_TRANSFORM_MATRIX("matrix"),
        SVG_TRANSFORM_TRANSLATE("translate"),
        SVG_TRANSFORM_SCALE("scale"),
        SVG_TRANSFORM_ROTATE("rotate"),
        SVG_TRANSFORM_SKEWX("skewX"),
        SVG_TRANSFORM_SKEWY("skewY");

        String value;
        SVGTransformType(String value){
            this.value = value;
        }

        public static SVGTransformType findByValue(String value){
            if(value == null){
                return SVG_TRANSFORM_UNKNOWN;
            }
            for(SVGTransformType transformType : values()){
                if(transformType.value.equalsIgnoreCase(value)){
                    return transformType;
                }
            }
            return SVG_TRANSFORM_UNKNOWN;
        }
    }

    private String extractData(String value){
        return value.substring(value.indexOf("(") + 1,value.indexOf(")"));
    }
}
