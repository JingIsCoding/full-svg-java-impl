package com.jing.svg.dom;

import com.jing.svg.dom.Matcher.SelectorType;
import com.jing.svg.element.SVGElement;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.jing.svg.dom.Selector.RelationType.getRelationType;

public class Selector {
    /**
     * The matching approach is to split svg>.class1+#id into three matches [svg,.class1 #id] and connected by relations [SPACE , >, +, ~]
     * */
    private List<MatcherRelation> matcherRelations = new ArrayList<>();
    Selector(SelectorType selectorType){
        Matcher matcher = new Matcher(selectorType);
    }

    Selector(@NotNull String selector){
        String removeUselessSpaceSelector = removeUselessSpace(new StringBuilder(selector));
        createMatchRelations(removeUselessSpaceSelector);
    }

    public int getSpecificity(){
        int specificity = 0;
        for(MatcherRelation matcherRelation : this.matcherRelations){
            specificity += matcherRelation.getSpecificity();
        }
        return specificity;
    }

    public boolean match(SVGElement svgElement){
        SVGElement matchOnElement = svgElement;
        for(int i = matcherRelations.size() -1 ; i >= 0 ; i--){
            matchOnElement = this.matcherRelations.get(i).matchElement(matchOnElement);

            if(matchOnElement == null){
                return false;
            }
        }
        return matchOnElement != null;
    }

    private void createMatchRelations(String selector) {
        String cleanSelector = removeUselessSpace(new StringBuilder(selector));
        List<String> selectorStrings = new ArrayList<>();
        Stack<String> symbol = new Stack<>();
        int start = 0;
        for(int i = 0 ; i  < cleanSelector.length() ; i++){
            char c = selector.charAt(i);
            if(inBracketOrQuote(symbol, c)){
                continue;
            }
            RelationType relationType = RelationType.getRelationType(c);
            if(relationType != null){
                selectorStrings.add(cleanSelector.substring(start,i));
                if(relationType == RelationType.OR){

                }else{
                    if(selectorStrings.size() > 1){
                        matcherRelations.add(new MatcherRelation(selectorStrings,relationType));
                        selectorStrings.clear();
                    }else{
                        matcherRelations.add(new MatcherRelation(cleanSelector.substring(start,i),relationType));
                    }
                }
                start = i + 1;
            }
            if(i == cleanSelector.length() -1){
                    matcherRelations.add(new MatcherRelation(cleanSelector.substring(start,cleanSelector.length()),null));
            }
        }
    }

    private String removeUselessSpace(StringBuilder selector){
        Stack<String> symbol = new Stack<>();
        for(int i = 0 ; i  < selector.length() ; i++){
            char c = selector.charAt(i);
            if(inBracketOrQuote(symbol, c)){
                continue;
            }
            if(RelationType.getRelationType(c) != null){
                while(selector.charAt(i -1) ==' '){
                    selector.deleteCharAt(i -1);
                    i--;
                }
                while(selector.charAt(i+1) ==' '){
                    selector.deleteCharAt(i + 1);
                }
            }
        }
        return selector.toString();
    }

    private boolean inBracketOrQuote(Stack<String> symbol, char c) {
        if(c == '[' || c=='(')
        {
            symbol.push(""+c);
        }
        else if(c==']' || c == ')'){
            if((c==']' && symbol.peek().equals("[")) || (c==')' && symbol.peek().equals("("))){
                symbol.pop();
            }
        }
        if(c == '"'){
            if(symbol.peek().equals("\"")){
                symbol.pop();
            }else{
                symbol.push(""+c);
            }
        }else if(c == '\''){
            if(symbol.peek().equals("'")){
                symbol.pop();
            }else{
                symbol.push(""+c);
            }
        }
        return symbol.size() > 0;
    }

    public enum RelationType{
        INSIDE(' '),
        OR(','),
        PARENT_IS('>'),
        IMMEDIATELY_AFTER('+'),
        PRECEDED_BY('~');

        char symbol;
        RelationType(char symbol){
            this.symbol = symbol;
        }

        protected static RelationType getRelationType(char symbol){
           for(RelationType relationType : values()){
               if(relationType.symbol == symbol){
                   return relationType;
               }
           }
            return null;
        }

        @Override
        public String toString(){
            return ""+symbol;
        }
    }

    private class MatcherRelation {
        RelationType relationType;
        List<Matcher> matchers = new ArrayList<>();

        MatcherRelation(String selector, RelationType relationType) {
            matchers.add(new Matcher(selector));
            this.relationType = relationType;
        }

        MatcherRelation(List<String> selectors, RelationType relationType) {
            for(String part : selectors){
                matchers.add(new Matcher(part));
            }
            this.relationType = relationType;
        }

        SVGElement matchElement(SVGElement svgElement){
            if(relationType == null){
                   if(matchOr(svgElement)){
                       return svgElement;
                   }
            }
            switch (relationType){
                case INSIDE:
                    return matchInside(svgElement);
                case PARENT_IS:
                    return matchParent(svgElement);
                case IMMEDIATELY_AFTER:
                    return matchAfter(svgElement);
                case PRECEDED_BY:
                    return matchPreceded(svgElement);
            }
            return null;
        }

        private SVGElement matchPreceded(SVGElement svgElement) {
            return matchOr(svgElement.getNextSibling()) ? svgElement.getNextSibling() : null;
        }

        private SVGElement matchAfter(SVGElement svgElement) {
            return matchOr(svgElement.getPreviousSibling()) ? svgElement.getPreviousSibling() : null;
        }

        private SVGElement matchParent(SVGElement svgElement) {
            return matchOr(svgElement.getParent()) ? svgElement.getParent() : null;
        }

        private SVGElement matchInside(SVGElement svgElement) {
            SVGElement parent = svgElement.getParent();
            while(parent != null){
                if(matchOr(parent)){
                    return parent;
                }
                parent = parent.getParent();
            }
            return null;
        }

        private int getSpecificity(){
            int specificity = 0;
            for(Matcher matcher : matchers){
                if(matcher.getSpecificity() > specificity){
                    specificity = matcher.getSpecificity();
                }
            }
            return specificity;
        }

        private boolean matchOr(SVGElement svgElement) {
            for(Matcher matcher : matchers){
                if(matcher.match(svgElement))
                {
                    return true;
                }
            }
            return false;
        }
    }
}
