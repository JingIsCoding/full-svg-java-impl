package com.jing.svg.dataType;

public class SVGMatrix {
    /**
     * [a c e]
     * [b d f]
     * [0 0 1]
     * */
    private double[][] matrix = new double[3][3];

    public SVGMatrix(){
        this(new double[]{1,0,0,0,1,0});
    }


    public SVGMatrix(double[] values){
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
       this(new double[]{svgMatrix.getValues()[0],
                svgMatrix.getValues()[1],
                svgMatrix.getValues()[2],
                svgMatrix.getValues()[3],
                svgMatrix.getValues()[4],
                svgMatrix.getValues()[5]});
    }

    public SVGMatrix multiply(SVGMatrix secondMatrix){
        double[][] newMatrix = new double[3][3];
        for(int column=0;column<3;column++){
            for(int row=0;row<3;row++){
                newMatrix[row][column] = claMatrixColumnAndRow(this,secondMatrix,row,column);
            }
        }
        SVGMatrix svgMatrix = new SVGMatrix();
        svgMatrix.matrix = newMatrix;
        return svgMatrix;
    }

    private double claMatrixColumnAndRow(SVGMatrix first, SVGMatrix second,int r,int c){
        double[] column = new double[3];
        column[0] = first.matrix[0][c];
        column[1] = first.matrix[1][c];
        column[2] = first.matrix[2][c];

        double[] row = new double[3];
        row[0] = second.matrix[r][0];
        row[1] = second.matrix[r][1];
        row[2] = second.matrix[r][2];

        return column[0]*row[0] + column[1]*row[1] + column[2]*row[2];
    }

    public SVGMatrix inverse(){

        return null;
    }
    public SVGMatrix translate(double x, double y){
        return this.multiply(new SVGMatrix(new double[]{1, 0 ,x, 0 , 1, y}));
    }

    public SVGMatrix scale(double scaleFactor){
        return this.scaleNonUniform(scaleFactor,scaleFactor);
    }
    public SVGMatrix scaleNonUniform(double scaleFactorX, double scaleFactorY){
        return this.multiply(new SVGMatrix(new double[]{scaleFactorX , 0 , 0, 0 ,scaleFactorY , 0}));
    }
    public SVGMatrix rotate(SVGAngle angle){
        double svgAngle = angle.getRadius();
        return this.multiply(new SVGMatrix(new double[]{Math.cos(svgAngle) ,-Math.sin(svgAngle) , 0, Math.sin(svgAngle) ,Math.cos(svgAngle) , 0}));
    }
    public SVGMatrix rotateFromVector(SVGAngle angle,double x,double y){

        return this.translate(-x,-y).rotate(angle).translate(x, y);
    }
    public SVGMatrix flipX(){
        return this.multiply(new SVGMatrix(new double[]{-1,0,0,1,0,0}));
    }
    public SVGMatrix flipY(){
        return this.multiply(new SVGMatrix(new double[]{1,0,0,-1,0,0}));
    }
    public SVGMatrix skewX(SVGAngle angle){
        return this.multiply(new SVGMatrix(new double[]{1, Math.tan(angle.getRadius()) ,0, 0 , 1, 0}));
    }
    public SVGMatrix skewY(SVGAngle angle){
        return this.multiply(new SVGMatrix(new double[]{1, 0 ,0, Math.tan(angle.getRadius()) , 1, 0}));
    }

    public double[] getValues(){
        return new double[]{this.matrix[0][0],this.matrix[0][1],this.matrix[0][2],this.matrix[1][0],this.matrix[1][1],this.matrix[1][2]};
    }
}
