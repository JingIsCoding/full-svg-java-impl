package com.jing.svg.element;

import com.jing.svg.SVGSVGElement;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.Element;
import com.jing.svg.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.TagName;

public class SVGElement implements Element<SVGElement>{
    //SVG Element
    private String id;
    private String xmlBase;
    private SVGSVGElement ownerSVGElement;
    private SVGElement viewPortElement;

    //Element
    private Map<String,Attribute> attributes = new HashMap<>();

    //Node
    private TagName tagName;
    private String value;
    private SVGElement parent;
    private NodeList<SVGElement> children;

    public SVGElement(TagName tagName, SVGSVGElement ownerSVGElement){
        this(tagName, null, ownerSVGElement ,null);
    }

    public SVGElement(TagName tagName, SVGSVGElement ownerSVGElement, SVGElement parent){
        this(tagName, null, ownerSVGElement ,parent);
    }

    public SVGElement(TagName tagName, String value, SVGSVGElement ownerSVGElement, SVGElement parent){
        this(tagName,value, ownerSVGElement, parent,null);
    }

    public SVGElement(TagName tagName, String value, SVGSVGElement ownerSVGElement, SVGElement parent, SVGElement viewPortElement){
        this.tagName = tagName;
        this.value = value;
        this.parent = parent;
        this.ownerSVGElement = ownerSVGElement;
        this.viewPortElement = viewPortElement;
        this.children = new NodeList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setXmlBase(String xmlBase) {
        this.xmlBase=xmlBase;
    }

    public String getXmlBase() {
        return xmlBase;
    }

    public SVGSVGElement getOwnerSVGElement() {
        return this.ownerSVGElement;
    }

    public SVGElement getViewportElement() {
        return this.viewPortElement;
    }

    @Override
    public void setAttribute(String name, Object value) {
        Attribute attribute = new Attribute(this, name, value);
        attributes.put(name,attribute);
    }

    @Override
    public TagName getTagName() {
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

    public void appendChild(SVGElement element){
        element.parent = this;
        children.appendChild(element);
    }

    @Override
    public SVGElement getFirstChild() {
        return !children.isEmpty() ? children.getItem(0) : null;
    }

    @Override
    public SVGElement getLastChild() {
        return !children.isEmpty()?children.getItem(children.size() - 1) :null;
    }

    @Override
    public SVGElement getPreviousSibling() {
        return parent != null ? parent.getChildrenNodes().getPreviousSiblingOf(this) : null;
    }

    @Override
    public SVGElement getNextSibling() {
        return parent != null ? parent.getChildrenNodes().getNextSiblingOf(this) : null;
    }

    @Override
    public Map<String, Attribute> getAttributes() {
        return this.attributes;
    }

    @Override
    public Attribute getAttribute(String name) {
        return this.attributes.get(name);
    }

    @Override
    public boolean hasAttributes() {
        return !this.attributes.isEmpty();
    }

    @Override
    public boolean hasOwnAttribute(String name) {
        return this.attributes.containsKey(name);
    }

    @Override
    public SVGElement cloneNode(boolean deep) {
        return null;
    }

    @Override
    public void removeAttribute(String name) {
        this.attributes.remove(name);
    }

    @Override
    public List<SVGElement> getElementByTagName(TagName name) {
        return  recFindElementByName(name,children);
    }

    private List<SVGElement> recFindElementByName(TagName name, NodeList<SVGElement> children){
        List<SVGElement> result = new ArrayList<>();
        for(SVGElement element : children.getList()){
            if(element.getTagName() == name){
                result.add(element);
            }
            if(element.children != null && !element.children.isEmpty())
            {
                result.addAll(recFindElementByName(name,element.children));
            }
        }
        return result;
    }
}
