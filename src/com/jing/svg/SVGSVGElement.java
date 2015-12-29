package com.jing.svg;

import com.jing.svg.animated.SVGAnimatedPreserveAspectRatio;
import com.jing.svg.animated.SVGAnimatedRect;
import com.jing.svg.dataType.*;
import com.jing.svg.dom.CSSStyleDeclaration;
import com.jing.svg.dom.CSSValue;
import com.jing.svg.element.*;

import java.util.List;

import static com.jing.svg.dataType.Constants.TagName.SVG;

public class SVGSVGElement extends SVGBaseCoordinatedElement implements SVGTests, SVGLangSpace, SVGStylable,SVGFitToViewBox{
    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);
    private SVGStylable svgStylable = new SVGStylableImpl(this);
    private SVGFitToViewBox svgFitToViewBox = new SVGFitToViewBoxImpl(this);

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

    @Override
    public SVGStringList getClassNames() {
        return this.svgStylable.getClassNames();
    }

    @Override
    public CSSValue getPresentationAttribute(String name) {
        return this.svgStylable.getPresentationAttribute(name);
    }

    @Override
    public CSSStyleDeclaration getStyle() {
        return this.svgStylable.getStyle();
    }

    @Override
    public CSSStyleDeclaration getComputedStyleDeclarationStyle() {
        return this.svgStylable.getComputedStyleDeclarationStyle();
    }

    @Override
    public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return svgFitToViewBox.getPreserveAspectRatio();
    }

    @Override
    public SVGAnimatedRect getViewBox() {
        return svgFitToViewBox.getViewBox();
    }

    protected void consolidateStyle(){
        List<SVGElement> svgStyleElement = this.getElementByTagName(Constants.TagName.STYLE);
        ((SVGStyleElement)svgStyleElement).consolidateStyle();
    }
}
