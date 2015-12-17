package com.jing.svg.dataType;

public class SVGTransform {

    private SVGTransformType transformType;
    private SVGMatrix matrix;
    private float angle;

    public SVGTransform(){
        matrix = new SVGMatrix();
    }

    public SVGTransform(SVGMatrix matrix) {
        this.matrix = matrix;
    }

    public float getAngle() {
        return angle;
    }

    public SVGMatrix getMatrix() {
        return matrix;
    }

    public SVGTransformType getTransformType() {
        return transformType;
    }

    public void setMatrix(SVGMatrix matrix){
        this.matrix = matrix;
    }

    public void setTranslate(float tx, float ty){
        setMatrix(matrix.translate(tx,ty));
    }
    public void setScale(float sx, float sy){
        setMatrix(matrix.scaleNonUniform(sx,sy));
    }
    public void setRotate(float angle, float cx, float cy){
        setMatrix(matrix.translate(-cx, -cy).rotate(new SVGAngle(SVGAngle.SVGAngelType.SVG_ANGLETYPE_RAD, angle)).translate(cx, cy));
    }
    public void setSkewX(float angle){
        setMatrix(matrix.skewX(angle));
    }
    public void setSkewY(float angle){
        setMatrix(matrix.skewY(angle));
    }

    public enum SVGTransformType{
        SVG_TRANSFORM_UNKNOWN,
        SVG_TRANSFORM_MATRIX,
        SVG_TRANSFORM_TRANSLATE,
        SVG_TRANSFORM_SCALE,
        SVG_TRANSFORM_ROTATE,
        SVG_TRANSFORM_SKEWX,
        SVG_TRANSFORM_SKEWY
    }

}
