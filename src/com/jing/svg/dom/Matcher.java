package com.jing.svg.dom;

import com.jing.svg.dataType.SVGStringList;
import com.jing.svg.element.SVGElement;
import com.jing.svg.element.SVGStylable;

import java.util.ArrayList;
import java.util.List;

public class Matcher {
    private String matchString;
    private String id;
    private String elementName;
    private SVGStringList classNames = new SVGStringList();
    private SVGStringList attributeName = new SVGStringList();
    private SVGStringList attributeValue = new SVGStringList();

    List<AttributeOperator> attributeOperators = new ArrayList<>();
    List<StatusOperatorHolder> statusOperators = new ArrayList<>();

    public Matcher(String elementMatch){
        matchString = elementMatch == null ? "" : elementMatch;
        parseString(matchString);

    }

    private void parseString(String matchString) {
        SelectorType previousType = SelectorType.TAG_NAME;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < matchString.length() ;i++){
            char c = matchString.charAt(i);
            SelectorType selectorType = SelectorType.getSelectorType(c);
            if(selectorType != null){
                if(stringBuilder.length() > 0){
                    createSelector(previousType,stringBuilder.toString());
                }
                previousType = selectorType;
                stringBuilder = new StringBuilder();
            }else{
                stringBuilder.append(c);
                if(i == matchString.length() -1){
                    createSelector(previousType,stringBuilder.toString());
                }
            }
        }
    }

    public boolean match(SVGElement svgElement){

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
                switch (this.attributeOperators.get(i)){
                    case Equal:
                        if(!svgElement.getAttributeValue(attributeName.getItem(i)).toString().equals(attributeValue.getItem(i))){
                            return false;
                        }
                        break;
                    case StartsWith:
                        if(!svgElement.getAttributeValue(attributeName.getItem(i)).toString().startsWith(attributeValue.getItem(i))){
                            return false;
                        }
                        break;
                    case EndWith:
                        if(!svgElement.getAttributeValue(attributeName.getItem(i)).toString().endsWith(attributeValue.getItem(i))){
                            return false;
                        }
                        break;
                    case Contains:
                        if(!svgElement.getAttributeValue(attributeName.getItem(i)).toString().contains(attributeValue.getItem(i))){
                            return false;
                        }
                        break;
                    case Has:
                        if(!svgElement.hasOwnAttribute(attributeName.getItem(i))){
                            return false;
                        }
                        break;
                }
            }
        }

        if(statusOperators.size() > 0){
            for(int i = 0 ;i <statusOperators.size();i++){
                StatusOperatorHolder statusOperatorHolder = statusOperators.get(i);
                switch (statusOperatorHolder.statusOperator){
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

                        break;
                    case LAST_CHILD:
                        if(svgElement.getParent() == null || svgElement.getParent().getLastChild() != svgElement)
                        {
                            return false;
                        }
                        break;
                    case LAST_OF_TYPE:
                        break;
                    case NOT:
                        break;
                    case NTH_CHILD:
                        if(svgElement.getParent() == null || svgElement.getParent().getChildrenNodes().getItem(Integer.parseInt(statusOperatorHolder.parameter)) != svgElement)
                        {
                            return false;
                        }
                        break;
                    case NTH_LAST_CHILD:
                        if(svgElement.getParent() == null || svgElement.getParent().getChildrenNodes().getItem(Integer.parseInt(statusOperatorHolder.parameter)) != svgElement)
                        {
                            return false;
                        }
                        break;
                    case NTH_LAST_OF_TYPE:
                        break;
                    case NTH_OF_TYPE:
                        break;
                    case ONLY_TYPE:
                        break;
                    case ONLY_CHILD:
                        if(svgElement.getParent().getChildrenNodes().size() != 1)
                            return false;
                        break;
                    case LANG:
                        break;
                }

            }
        }

        return true;
    }

    private void createSelector(SelectorType selectorType,String value){
        switch (selectorType){
            case CLASS:
                addClass(value);
                break;
            case ID:
                id = value;
                break;
            case ATTRIBUTE:
                addAttribute(value);
                break;
            case STATUS:
                addStatus(value);
                break;
            case TAG_NAME:
                this.elementName = value;
                break;
        }
    }

    private void addStatus(String value) {
        StatusOperator statusOperator = StatusOperator.getOperator(value);
        if(statusOperator != null){
            int start = value.indexOf("(");
            int end = value.indexOf(")");
            if((start > -1 && end > -1)&& start < end){
                try {
                    statusOperators.add(new StatusOperatorHolder(statusOperator,value.substring(start,end -1)));
                }
                catch (Exception e){
                }
            }else{
                statusOperators.add(new StatusOperatorHolder(statusOperator));
            }
        }

    }

    private void addAttribute(String value) {
        if(value.charAt(value.length() -1) == ']'){
            value = value.substring(0,value.length() -1);
        }
        AttributeOperator operator = AttributeOperator.getOperator(value);
        if(operator != null){
            String[] split = value.split(operator.toString());
            if(split.length == 2){
                attributeName.insertItem(split[0]);
                attributeValue.insertItem(split[1]);
                attributeOperators.add(operator);
            }
        }
    }

    private void addClass(String value) {
        classNames.insertItem(value);
    }

    public enum SelectorType{
        CLASS('.'),
        ID('#'),
        ATTRIBUTE('['),
        STATUS(':'),
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

    private class StatusOperatorHolder{
        StatusOperator statusOperator;
        String parameter;

         StatusOperatorHolder(StatusOperator statusOperator) {
            this.statusOperator = statusOperator;
        }

         StatusOperatorHolder(StatusOperator statusOperator, String parameter) {
            this.statusOperator = statusOperator;
            this.parameter = parameter;
        }
    }

    public enum StatusOperator{
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
        int n;
        StatusOperator(String operator){
            this.operator = operator;
        }

        public void setN(int n){
            this.n = n;
        }

        public static StatusOperator getOperator(String query){
            for(StatusOperator statusOperator : values()){
                if(query.contains(statusOperator.toString())){
                    return statusOperator;
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