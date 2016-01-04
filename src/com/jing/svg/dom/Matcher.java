package com.jing.svg.dom;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.element.SVGElement;
import com.jing.svg.element.SVGStylable;
import com.jing.svg.util.StringUtil;
import com.jing.svg.util.StringUtil.LogicSkipper;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Matcher {
    private String matchString;
    private String id;
    private String elementName;
    private SVGStringList classNames = new SVGStringList();
    private SVGStringList attributeName = new SVGStringList();
    private SVGStringList attributeValue = new SVGStringList();

    private int specificity;

    List<AttributeOperator> attributeOperators = new ArrayList<>();
    List<PseudoClassHolder> pseudoClassHolders = new ArrayList<>();

    Matcher(){
        //inline style;
        specificity = 1 << 24;
    }

    Matcher(String elementMatch){
        matchString = elementMatch == null ? "" : elementMatch;
        parseMatcher(matchString);
    }

    private void parseMatcher(String matchString) {
        SelectorType type = SelectorType.TAG_NAME;
        StringBuilder stringBuilder = new StringBuilder();
        LogicSkipper logicSkipper = new LogicSkipper("[","]","\"","\"","'","'","(",")");
        for(int i = 0 ; i < matchString.length() ;i++){
            char c = matchString.charAt(i);
            if(logicSkipper.shouldSkip(""+c)){
                stringBuilder.append(c);
                continue;
            }
            SelectorType selectorType = SelectorType.getSelectorType(c);
            if(selectorType != null){
                if(stringBuilder.length() > 0){
                    createSelector(type,stringBuilder.toString());
                }
                type = selectorType;
                stringBuilder = new StringBuilder();
            }else{
                if(c==']'){
                    createSelector(type,stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }else{
                    stringBuilder.append(c);
                }
                if(i == matchString.length() -1 && c!=']'){
                    createSelector(type,stringBuilder.toString());
                }
            }
        }
        calSpecificity();
    }


    private void calSpecificity() {

    }

    public boolean match(SVGElement svgElement){
        if(svgElement == null)
        {
            return false;
        }

        if(elementName != null && !svgElement.getTagName().toString().equalsIgnoreCase(elementName))
        {
            return false;
        }

        if (id != null && (svgElement.getId() == null || !svgElement.getId().equals(id))){
            return false;
        }

        if(classNames.getSize() > 0){
            if(svgElement instanceof SVGStylable){
                for(int i = 0 ; i < classNames.getSize() ;i++){
                    if(!((SVGStylable)svgElement).getClassNames().contains(classNames.getItem(i))){
                        return false;
                    }
                }
            }
        }

        if(this.attributeOperators.size() > 0){
            for(int i = 0 ; i < this.attributeOperators.size(); i++){
                String name = attributeName.getItem(i);
                String value = attributeValue.getItem(i);

                if(!svgElement.hasOwnAttribute(name))
                {
                    return false;
                }
                switch (this.attributeOperators.get(i)){
                    case Equal:
                        if(!svgElement.getAttributeValue(name).toString().equals(value)){
                            return false;
                        }
                        break;
                    case StartsWith:
                        if(!svgElement.getAttributeValue(name).toString().startsWith(value)){
                            return false;
                        }
                        break;
                    case EndWith:
                        if(!svgElement.getAttributeValue(name).toString().endsWith(value)){
                            return false;
                        }
                        break;
                    case Contains:
                        if(!svgElement.getAttributeValue(name).toString().contains(value)){
                            return false;
                        }
                        break;
                    case Has:
                        if(!svgElement.hasOwnAttribute(name)){
                            return false;
                        }
                        break;
                }
            }
        }

        if(pseudoClassHolders.size() > 0 && !matchPseudoClass(svgElement)){
                return false;
        }

        return true;
    }

    private boolean matchPseudoClass(SVGElement svgElement){
        NodeList<SVGElement> typeChildren;
        for(int i = 0; i < pseudoClassHolders.size(); i++){
            PseudoClassHolder pseudoClassHolder = pseudoClassHolders.get(i);
            switch (pseudoClassHolder.pseudoClass){
                case EMPTY:
                    if(svgElement.hasChild() || svgElement.getContent() != null)
                        return false;
                    break;
                case FIRST_CHILD:
                    if(svgElement.getParent() == null || svgElement.getParent().getFirstChild() != svgElement)
                    {
                        return false;
                    }
                    break;
                case FIRST_OF_TYPE:
                    if(svgElement.getParent() == null){
                        return false;
                    }
                    if(getTypeChildren(svgElement.getParent().getChildrenNodes(),svgElement.getTagName().toString()).getItem(0) != svgElement)
                        return false;
                    break;
                case LAST_CHILD:
                    if(svgElement.getParent() == null || svgElement.getParent().getLastChild() != svgElement)
                    {
                        return false;
                    }
                    break;
                case LAST_OF_TYPE:
                    if(svgElement.getParent() == null)
                    {
                        return false;
                    }
                    typeChildren = getTypeChildren(svgElement.getParent().getChildrenNodes(), svgElement.getTagName().toString());
                    if(typeChildren.getItem(typeChildren.size() - 1) != svgElement)
                    {
                        return false;
                    }
                    break;
                case NOT:
                    Matcher matcher = new Matcher(pseudoClassHolder.parameter);
                    if(matcher.match(svgElement))
                    {
                        return false;
                    }
                    break;
                case NTH_CHILD:
                    if(svgElement.getParent() == null || svgElement.getParent().getChildrenNodes().getItem(getIndexNumber(pseudoClassHolder.parameter)) != svgElement)
                    {
                        return false;
                    }
                    break;
                case NTH_LAST_CHILD:
                    if(svgElement.getParent() == null)
                    {
                        return false;
                    }
                    NodeList<SVGElement> childrenNodes = svgElement.getParent().getChildrenNodes();
                    if(childrenNodes.getItem(childrenNodes.size() - 1 - getIndexNumber(pseudoClassHolder.parameter)) != svgElement)
                    break;
                case NTH_LAST_OF_TYPE:
                    if(svgElement.getParent() == null)
                    {
                        return false;
                    }
                    typeChildren = getTypeChildren(svgElement.getParent().getChildrenNodes(), svgElement.getTagName().toString());
                    if(typeChildren.getItem(typeChildren.size() - 1 - getIndexNumber(pseudoClassHolder.parameter)) != svgElement)
                    {
                        return false;
                    }
                    break;
                case NTH_OF_TYPE:
                    if(svgElement.getParent() == null)
                    {
                        return false;
                    }
                    typeChildren = getTypeChildren(svgElement.getParent().getChildrenNodes(), svgElement.getTagName().toString());
                    if(typeChildren.getItem(getIndexNumber(pseudoClassHolder.parameter)) != svgElement)
                    {
                        return false;
                    }
                    break;
                case ONLY_TYPE:
                    if(svgElement.getParent() == null)
                    {
                        return false;
                    }
                    if(getTypeChildren(svgElement.getParent().getChildrenNodes(), svgElement.getTagName().toString()).size() != 1)
                    {
                        return false;
                    }
                    break;
                case ONLY_CHILD:
                    if(svgElement.getParent() == null)
                    {
                        return false;
                    }
                    if(svgElement.getParent().getChildrenNodes().size() != 1)
                        return false;
                    break;
                case LANG:
                    if(!svgElement.hasOwnAttribute(Constants.ElementAttributeNames.XML_LANG.toString())){
                        return false;
                    }
                    if(!svgElement.getAttributeValue(Constants.ElementAttributeNames.XML_LANG.toString()).toString().equals(pseudoClassHolder.parameter)){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    private NodeList<SVGElement> getTypeChildren(NodeList<SVGElement> childrenNodes,String tagName){
        NodeList<SVGElement> result = new NodeList<>();
        for(SVGElement element : childrenNodes){
            if(element.getTagName().toString().equals(tagName)){
                result.appendChild(element);
            }
        }
        return result;
    }

    private int getIndexNumber(String number){
        try{
            int n =  Integer.parseInt(number);
            return n - 1;
        }catch (Exception e){
            return Integer.MIN_VALUE;
        }
    }

    private void createSelector(SelectorType selectorType,String value){
        switch (selectorType){
            case CLASS:
                addClass(value);
                specificity += (1 << 8);
                break;
            case ID:
                id = value;
                specificity += (1 << 16);
                break;
            case ATTRIBUTE:
                addAttribute(value);
                specificity += (1 << 8);
                break;
            case PSEUDO_CLASS:
                addStatus(value);
                specificity += (1 << 8);
                break;
            case TAG_NAME:
                this.elementName = value;
                specificity += 1;
                break;
        }
    }

    private void addStatus(String value) {
        PseudoClass pseudoClass = PseudoClass.getOperator(value);
        if(pseudoClass != null){
            int start = value.indexOf("(");
            int end = value.indexOf(")");
            if((start > -1 && end > -1)&& start < end){
                try {
                    pseudoClassHolders.add(new PseudoClassHolder(pseudoClass,value.substring(start+1,end).trim()));
                }
                catch (Exception e){
                }
            }else{
                pseudoClassHolders.add(new PseudoClassHolder(pseudoClass));
            }
        }

    }

    private void addAttribute(String attribute) {
        AttributeOperator operator = AttributeOperator.getOperator(attribute);
        if(operator != null){
            String[] split = attribute.split(operator.toString());
            if(split.length == 2){
                String name = split[0];
                String value = split[1];
                value = StringUtil.cleanQuotes(value);
                attributeName.insertItem(name);
                attributeValue.insertItem(value);
                attributeOperators.add(operator);
            }
        }
    }

    private void addClass(String value) {
        classNames.insertItem(value);
    }

    public int getSpecificity() {
        return specificity;
    }

    public enum SelectorType{
        ALL('*'),
        CLASS('.'),
        ID('#'),
        ATTRIBUTE('['),
        PSEUDO_CLASS(':'),
        TAG_NAME('\0');
        char startCharacter;

        static SelectorType getSelectorType(char c){
            for(SelectorType type : values()){
                if(type.startCharacter == c)
                    return type;
            }
            return null;
        }

        SelectorType(char startCharacter){
            this.startCharacter = startCharacter;
        }
    }

    public enum AttributeOperator{
        Equal("="),
        StartsWith("|="),
        EndWith("$="),
        Contains("~="),
        Has("");
        String operator;

        AttributeOperator(String operator){
            this.operator = operator;
        }

        public static AttributeOperator getOperator(String query){
            for(AttributeOperator attributeOperator : values()){
                if(query.contains(attributeOperator.toString())){
                    return attributeOperator;
                }
            }
           return null;
        }

        @Override
        public String toString(){
            return operator;
        }
    }

    private class PseudoClassHolder {
        PseudoClass pseudoClass;
        String parameter;

         PseudoClassHolder(PseudoClass pseudoClass) {
            this.pseudoClass = pseudoClass;
        }

         PseudoClassHolder(PseudoClass pseudoClass, String parameter) {
            this.pseudoClass = pseudoClass;
            this.parameter = parameter;
        }
    }

    public enum PseudoClass {
        EMPTY("empty"),
        FIRST_CHILD("first-child"),
        FIRST_OF_TYPE("first-of-type"),
        LAST_CHILD("last-child"),
        LAST_OF_TYPE("last-of-type"),
        NOT("not"),
        NTH_CHILD("nth-child"),
        NTH_LAST_CHILD("nth-last-child"),
        NTH_LAST_OF_TYPE("nth-last-of-type"),
        NTH_OF_TYPE("nth-of-type"),
        ONLY_TYPE("only-of-type"),
        ONLY_CHILD("only-child"),
        LANG("lang");

        String operator;
        PseudoClass(String operator){
            this.operator = operator;
        }

        public static PseudoClass getOperator(String query){
            for(PseudoClass pseudoClass : values()){
                if(query.startsWith(pseudoClass.toString())){
                    return pseudoClass;
                }
            }
            return null;
        }
        @Override
        public String toString(){
            return operator;
        }
    }
}