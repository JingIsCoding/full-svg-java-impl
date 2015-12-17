package com.jing.svg;


import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.NodeList;
import com.jing.svg.element.*;
import com.jing.svg.element.SVGBaseElement;

import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.TagName.DEFS;

public class SVGDefsElement implements SVGElement, SVGTests, SVGLangSpace {
    private SVGElement svgElement = new SVGBaseElement(DEFS);
    private SVGTests svgTests = new SVGTestsImpl(this);
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);



    @Override
    public void setAttribute(String name, Object value) {
        svgElement.setAttribute(name,value);
    }

    @Override
    public Constants.TagName getTagName() {
        return svgElement.getTagName();
    }

    @Override
    public String getValue() {
        return svgElement.getValue();
    }

    @Override
    public void setParent(SVGElement element) {
        svgElement.setParent(element);
    }

    @Override
    public SVGElement getParent() {
        return svgElement.getParent();
    }

    @Override
    public NodeList<SVGElement> getChildrenNodes() {
        return svgElement.getChildrenNodes();
    }

    @Override
    public boolean hasChild() {
        return svgElement.hasChild();
    }

    @Override
    public SVGElement getFirstChild() {
        return svgElement.getFirstChild();
    }

    @Override
    public SVGElement getLastChild() {
        return svgElement.getLastChild();
    }

    @Override
    public SVGElement getPreviousSibling() {
        return svgElement.getPreviousSibling();
    }

    @Override
    public SVGElement getNextSibling() {
        return svgElement.getNextSibling();
    }

    @Override
    public Map<String, Attribute> getAttributes() {
        return svgElement.getAttributes();
    }

    @Override
    public Attribute getAttribute(String name) {
        return svgElement.getAttribute(name);
    }

    @Override
    public boolean hasAttributes() {
        return svgElement.hasAttributes();
    }

    @Override
    public boolean hasOwnAttribute(String name) {
        return svgElement.hasOwnAttribute(name);
    }

    @Override
    public SVGElement cloneNode(boolean deep) {
        return svgElement.cloneNode(deep);
    }

    @Override
    public void removeAttribute(String name) {
        svgElement.removeAttribute(name);
    }

    @Override
    public List<SVGElement> getElementByTagName(Constants.TagName name) {
        return svgElement.getElementByTagName(name);
    }

    public SVGElement getElementById(String elementId){
        return svgElement.getElementById(elementId);
    }

    @Override
    public void setId(String id) {
        svgElement.setId(id);
    }

    @Override
    public String getId() {
        return svgElement.getId();
    }

    @Override
    public void setXmlBase(String xmlBase) {
        svgElement.setXmlBase(xmlBase);
    }

    @Override
    public String getXmlBase() {
        return svgElement.getXmlBase();
    }

    @Override
    public void setOwnerSVGElement(SVGSVGElement element) {
        svgElement.setOwnerSVGElement(element);
    }

    @Override
    public SVGSVGElement getOwnerSVGElement() {
        return svgElement.getOwnerSVGElement();
    }

    @Override
    public SVGElement getViewportElement() {
        return svgElement.getViewportElement();
    }

    @Override
    public void appendChild(SVGElement element) {
        svgElement.appendChild(element);
    }

    @Override
    public SVGStringList getSystemLanguage() {
        return svgTests.getSystemLanguage();
    }

    @Override
    public void setSystemLanguage(SVGStringList systemLanguage) {
        svgTests.setSystemLanguage(systemLanguage);
    }

    @Override
    public SVGStringList getRequiredFeatures() {
        return svgTests.getRequiredFeatures();
    }

    @Override
    public void setRequiredFeatures(SVGStringList requiredFeatures) {
        svgTests.setRequiredFeatures(requiredFeatures);
    }

    @Override
    public SVGStringList getRequiredExtensions() {
        return svgTests.getRequiredExtensions();
    }

    @Override
    public void setRequiredExtensions(SVGStringList requiredExtensions) {
        svgTests.setRequiredFeatures(requiredExtensions);
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
    public void setXmlspace(String xmlspace) {
        svgLangSpace.setXmlspace(xmlspace);
    }

    @Override
    public String getXmllang() {
        return svgLangSpace.getXmllang();
    }

    @Override
    public void setXmllang(String xmllang) {
        svgLangSpace.setXmlspace(xmllang);
    }
}
