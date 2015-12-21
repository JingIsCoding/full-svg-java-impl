package com.jing.svg.element;

import com.jing.svg.SVGSVGElement;
import com.jing.svg.dataType.Constants;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.TagName;

public class SVGBaseElement implements SVGElement{
    //SVG Element
    private SVGSVGElement ownerSVGElement;
    private SVGElement viewPortElement;

    //Element
    private Map<String,Attribute> attributes = new HashMap<>();

    //Node
    private TagName tagName;

    private String content;
    private SVGElement parent;
    private NodeList<SVGElement> children;

    protected SVGBaseElement(TagName tagName){
        this(tagName, null, null ,null);
    }

    protected SVGBaseElement(TagName tagName, SVGSVGElement ownerSVGElement){
        this(tagName, null, ownerSVGElement ,null);
    }


    protected SVGBaseElement(TagName tagName, String content, SVGSVGElement ownerSVGElement){
        this(tagName, content, ownerSVGElement,null);
    }

    protected SVGBaseElement(TagName tagName, String content, SVGSVGElement ownerSVGElement, SVGElement viewPortElement){
        this.tagName = tagName;
        this.content = content;
        this.ownerSVGElement = ownerSVGElement;
        this.viewPortElement = viewPortElement;
        this.children = new NodeList<>();
    }


    public void setId(String id) {
        this.setAttribute("id",id);
    }

    public String getId() {
        return (String) this.getAttribute("id").getValue();
    }

    public void setXmlBase(String xmlBase) {
        this.setAttribute("xml:base",xmlBase);
    }

    public String getXmlBase() {
        return (String) this.getAttribute("xml:base").getValue();
    }

    @Override
    public void setOwnerSVGElement(SVGSVGElement ownerSVGElement) {
        this.ownerSVGElement = ownerSVGElement;
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
    public Attribute getAttribute(Constants.ElementAttributeNames name) {
        return name!= null ? getAttribute(name.toString()) : null;
    }

    @Override
    public TagName getTagName() {
        return tagName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setParent(SVGElement parent){
        this.parent = parent;
        if(!parent.getChildrenNodes().hasChild(this)){
            parent.appendChild(this);
        }

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
    public boolean hasChild() {
        return this.children!=null && !this.children.isEmpty() ;
    }

    @Override
    public void appendChild(SVGElement element){
        children.appendChild(element);
        element.setParent(this);
        element.setOwnerSVGElement(this.ownerSVGElement);
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
        return this.attributes.get(name) == null ? new Attribute(this,null,null) : this.attributes.get(name);
    }

    @Override
    public Object getAttributeValue(Constants.ElementAttributeNames name) {
        return this.getAttribute(name.toString()) != null ? this.getAttribute(name.toString()).getValue() : null;
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
        SVGBaseElement svgElement = new SVGBaseElement(this.tagName, this.content, this.ownerSVGElement, this.viewPortElement);
        svgElement.attributes.putAll(this.attributes);
        svgElement.setContent(this.content);

        if(deep) {
            recCloneNode(svgElement, this.children);
        }

        return svgElement;
    }

    private void recCloneNode(SVGElement root, NodeList<SVGElement> children){
        for(SVGElement child : children.getList()){
            SVGElement newChild = child.cloneNode(false);
            root.appendChild(newChild);

            if(!child.getChildrenNodes().isEmpty()){
                recCloneNode(newChild,child.getChildrenNodes());
            }
        }
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
            if(element.hasChild())
            {
                result.addAll(recFindElementByName(name,element.getChildrenNodes()));
            }
        }
        return result;
    }

    @Override
    public SVGElement getElementById(String id){
        return recGetElementById(this, id);
    }

    private SVGElement recGetElementById(SVGElement root, String id){
        if(root != null)
        {
            if(root.getId()!=null && root.getId().equals(id)){
                return root;
            }else{
                if(!root.getChildrenNodes().isEmpty()){
                    for(SVGElement element : root.getChildrenNodes().getList()){
                        SVGElement elementWithId = recGetElementById(element,id);
                        if(elementWithId !=null){
                            return elementWithId;
                        }
                    }
                }
            }
        }
        return null;
    }
}
