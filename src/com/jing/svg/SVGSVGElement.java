package com.jing.svg;

import com.jing.svg.animated.SVGAnimatedLength;
import com.jing.svg.dataType.*;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.NodeList;
import com.jing.svg.element.*;
import com.jing.svg.element.SVGBaseElement;

import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.*;
import static com.jing.svg.dataType.Constants.Location.*;
import static com.jing.svg.dataType.Constants.TagName.*;


public class SVGSVGElement extends SVGBaseElement implements SVGTests, SVGLangSpace{

    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);

    public SVGSVGElement() {
        super(SVG);
    }

    public SVGSVGElement(SVGSVGElement ownerSVGElement) {
        super(SVG, ownerSVGElement);
    }

    public SVGSVGElement(String value, SVGSVGElement ownerSVGElement) {
        super(SVG, value, ownerSVGElement);
    }

    public SVGSVGElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(SVG, value, ownerSVGElement, viewPortElement);
    }


    public void setX(String x){
        setAttribute(X.toString(),new SVGAnimatedLength(new SVGLength(x)));
    }

    public SVGAnimatedLength getX(){
        return (SVGAnimatedLength) getAttribute(X.toString()).getValue();
    }

    public void setY(String y){
        setAttribute(Y.toString(),new SVGAnimatedLength(new SVGLength(y)));
    }

    public SVGAnimatedLength getY(){
        return (SVGAnimatedLength) getAttribute(Y.toString()).getValue();
    }

    public void setWidth(String width){
        setAttribute(WIDTH.toString(),new SVGAnimatedLength(new SVGLength(width)));
    }

    public SVGAnimatedLength getWidth(){
        return (SVGAnimatedLength) getAttribute(WIDTH.toString()).getValue();
    }

    public void setHeight(String height){
        setAttribute(HEIGHT.toString(),new SVGAnimatedLength(new SVGLength(height)));
    }

    public SVGAnimatedLength getHeight(){
        return (SVGAnimatedLength) getAttribute(HEIGHT.toString()).getValue();
    }

    public SVGNumber createSVGNumber(double number){
        return new SVGNumber(number);
    }
    public SVGLength createSVGLength(String length){
        return new SVGLength(length);
    }
    public SVGAngle createSVGAngle(String angleStr){
        return new SVGAngle(angleStr);
    }
    public SVGPoint createSVGPoint(String point){
        return new SVGPoint(point);
    }
    public SVGMatrix createSVGMatrix(){
        return new SVGMatrix();
    }
    public SVGRect createSVGRect(){
        return new SVGRect();
    }
    public SVGTransform createSVGTransform(){
        return new SVGTransform();
    }
    public SVGTransform createSVGTransformFromMatrix(SVGMatrix matrix){
        return new SVGTransform(matrix);
    }

    @Override
    public SVGStringList getSystemLanguage() {
        return svgTests.getSystemLanguage();
    }

    @Override
    public SVGStringList getRequiredFeatures() {
        return svgTests.getRequiredFeatures();
    }

    @Override
    public SVGStringList getRequiredExtensions() {
        return svgTests.getRequiredExtensions();
    }


    @Override
    public boolean hasExtension(String extension) {
        return svgTests.hasExtension(extension);
    }

    @Override
    public String getXmlspace() {
        return svgLangSpace.getXmlspace();
    }

    @Override
    public String getXmllang() {
        return svgLangSpace.getXmllang();
    }
}
