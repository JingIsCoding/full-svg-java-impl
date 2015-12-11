package com.jing.svg.dataType;

import com.jing.svg.dataType.SVGElement;
import com.jing.svg.SVGSVGElement;
import com.jing.svg.dataType.dom.Attribute;
import com.jing.svg.dataType.dom.Element;
import com.jing.svg.dataType.dom.NodeList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SVGElementImpl implements SVGElement{
    //SVG Element
    private String id;
    private String xmlBase;
    private SVGSVGElement ownerSVGElement;
    private SVGElement viewPortElement;

    //Element
    private Map<String,Attribute> attributes = new HashMap<>();

    //Node
    private String tagName;
    private String value;
    private SVGElement parent;
    private NodeList<SVGElement> children;


    public SVGElementImpl(String tagName, SVGSVGElement ownerSVGElement, SVGElement parent){
        this(tagName, null, ownerSVGElement ,parent);
    }

    public SVGElementImpl(String tagName, String value, SVGSVGElement ownerSVGElement, SVGElement parent){
        this(tagName,value, ownerSVGElement, parent,null);
    }

    public SVGElementImpl(String tagName, String value, SVGSVGElement ownerSVGElement, SVGElement parent, SVGElement viewPortElement){
        this.tagName = tagName;
        this.value = value;
        this.ownerSVGElement = ownerSVGElement;
        this.viewPortElement = viewPortElement;
        this.children = new NodeList<>();
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setXmlBase(String xmlBase) {
        this.xmlBase=xmlBase;
    }

    @Override
    public String getXmlBase() {
        return xmlBase;
    }

    @Override
    public SVGSVGElement getOwnerSVGElement() {
        return this.ownerSVGElement;
    }

    @Override
    public SVGElement getViewportElement() {
        return this.viewPortElement;
    }

    @Override
    public void setAttribute(String name, String value) {
        Attribute attribute = new Attribute(this, name, value);
        attributes.put(name,attribute);
    }

    @Override
    public String getTagName() {
        return tagName;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public SVGElement getParent() {
        return parent;
    }

    @Override
    public NodeList<SVGElement> getChildrenNodes() {
        return children;
    }

    @Override
    public SVGElement getFirstChild() {
        return children.getItem(0);
    }

    @Override
    public SVGElement getLastChild() {
        return children.getItem(children.size() - 1);
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
