package com.jing.svg;

import com.jing.svg.dataType.SVGElement;
import com.jing.svg.dataType.SVGElementImpl;
import com.jing.svg.dataType.dom.Attribute;
import com.jing.svg.dataType.dom.Element;
import com.jing.svg.dataType.dom.NodeList;

import java.util.List;
import java.util.Map;

/**
 * Created by jguo on 12/8/2015.
 */
public class SVGSVGElement implements SVGElement {
    private SVGElement svgElement;

    public SVGSVGElement(){
        svgElement = new SVGElementImpl();
    }
    @Override
    public void setId(String id) {
        svgElement.setId(id);
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setXmlBase(String xmlBase) {

    }

    @Override
    public String getXmlBase() {
        return null;
    }

    @Override
    public SVGSVGElement getOwnerSVGElement() {
        return null;
    }

    @Override
    public SVGElement getViewportElement() {
        return null;
    }

    @Override
    public void setAttribute(String name, String value) {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public SVGElement getParent() {
        return null;
    }

    @Override
    public NodeList<SVGElement> getChildrenNodes() {
        return null;
    }

    @Override
    public SVGElement getFirstChild() {
        return null;
    }

    @Override
    public SVGElement getLastChild() {
        return null;
    }

    @Override
    public SVGElement getPreviousSibling() {
        return null;
    }

    @Override
    public SVGElement getNextSibling() {
        return null;
    }

    @Override
    public Map<String, Attribute> getAttributes() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean hasAttributes() {
        return false;
    }

    @Override
    public boolean hasOwnAttribute(String name) {
        return false;
    }

    @Override
    public SVGElement cloneNode(boolean deep) {
        return null;
    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public List<Element> getElementByTagName(String name) {
        return null;
    }
}
