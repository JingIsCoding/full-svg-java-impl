package com.jing.svg.dataType;

public class SVGMatrix {
    /**
     * [a c e]
     * [b d f]
     * [0 0 1]
     * */
    private float[][] matrix = new float[3][3];

    public SVGMatrix(){
        this(new float[]{1,0,0,0,1,0});
    }

    public SVGMatrix(float[] values){
        if(values.length < 6){
            throw new IllegalArgumentException();
        }
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0; j <3;j++){
                this.matrix[i][j] = values[i * 3 + j];
            }
        }
        this.matrix[2][0] = 0;
        this.matrix[2][1] = 0;
        this.matrix[2][2] = 1;
    }

    public SVGMatrix(SVGMatrix svgMatrix){
        this.matrix = svgMatrix.matrix;
    }

    public SVGMatrix multiply(SVGMatrix secondMatrix){
        float[][] newMatrix = new float[3][3];
        for(int column=0;column<3;column++){
            for(int row=0;row<3;row++){
                newMatrix[row][column] = claMatrixColumnAndRow(this,secondMatrix,row,column);
            }
        }
        SVGMatrix svgMatrix = new SVGMatrix();
        svgMatrix.matrix = newMatrix;
        return svgMatrix;
    }

    private float claMatrixColumnAndRow(SVGMatrix first, SVGMatrix second,int r,int c){
        float[] column = new float[3];
        column[0] = first.matrix[0][c];
        column[1] = first.matrix[1][c];
        column[2] = first.matrix[2][c];

        float[] row = new float[3];
        column[0] = second.matrix[r][0];
        column[1] = second.matrix[r][1];
        column[2] = second.matrix[r][2];

        return column[0]*row[0] + column[1]*row[1] + column[2]*row[2];
    }

    public SVGMatrix inverse(){

        return null;
    }
    public SVGMatrix translate(float x, float y){
        return this.multiply(new SVGMatrix(new float[]{1, 0 ,x, 0 , 1, y}));
    }

    public SVGMatrix scale(float scaleFactor){
        return this.scaleNonUniform(scaleFactor,scaleFactor);
    }
    public SVGMatrix scaleNonUniform(float scaleFactorX, float scaleFactorY){
        return this.multiply(new SVGMatrix(new float[]{scaleFactorX , 0 , 0, 0 ,scaleFactorX , 0}));
    }
    public SVGMatrix rotate(SVGAngle angle){
        return null;
    }
    public SVGMatrix rotateFromVector(float x,float y){
        return null;
    }
    public SVGMatrix flipX(){
        return null;
    }
    public SVGMatrix flipY(){
        return null;
    }
    public SVGMatrix skewX(float angle){
        return null;
    }
    public SVGMatrix skewY(float angle){
        return null;
    }

    public float[] getValues(){
        return new float[]{this.matrix[0][0],this.matrix[0][1],this.matrix[0][2],this.matrix[1][0],this.matrix[1][1],this.matrix[1][2]};
    }
}
