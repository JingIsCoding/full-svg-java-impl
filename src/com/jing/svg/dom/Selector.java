package com.jing.svg.dom;

import com.jing.svg.element.SVGElement;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.jing.svg.dataType.Constants.*;
import static com.jing.svg.dom.Selector.RelationType.getRelationType;

public class Selector {

    private HashSet<SVGElement> selectedElement = new HashSet<>();
    private List<MatcherRelation> matcherRelations = new ArrayList<>();
    private int specificity = 0;
    private Matcher currentMatcher;

    public Selector(){
    }

    public int getSpecificity(){
        return specificity;
    }

    public Selector(@NotNull String selector){
        parseSelector(selector);
    }

    public boolean match(SVGElement svgElement){
        boolean match;
        match = currentMatcher.match(svgElement);
        for(int i = matcherRelations.size() -1 ; i >= 0 ; i--){
            MatcherRelation matcherRelation = this.matcherRelations.get(i);
            switch (matcherRelation.relationType){
                case INSIDE:
                    match = matchInside(matcherRelation.matcher, svgElement);
                    break;
                case OR:
                    match = matchOr(matcherRelation.matcher, svgElement);
                    break;
                case PARENT_IS:
                    match = matchParent(matcherRelation.matcher, svgElement);
                    break;
                case IMMEDIATELY_AFTER:
                    match = matchAfter(matcherRelation.matcher, svgElement);
                    break;
                case PRECEDED_BY:
                    match = matchPreceded(matcherRelation.matcher, svgElement);
            }
        }

        return match;
    }

    private boolean matchPreceded(Matcher matcher, SVGElement svgElement) {
        return matcher.match(svgElement.getNextSibling());
    }

    private boolean matchAfter(Matcher matcher, SVGElement svgElement) {
        return matcher.match(svgElement.getPreviousSibling());
    }

    private boolean matchParent(Matcher matcher, SVGElement svgElement) {
        if(svgElement.getParent() == null)
            return false;
        return matcher.match(svgElement.getParent());
    }

    private boolean matchInside(Matcher matcher, SVGElement svgElement) {
        SVGElement parent = svgElement.getParent();
        while(parent != null){
            if(matcher.match(parent)){
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    private boolean matchOr(Matcher matcher, SVGElement svgElement) {
        return matcher.match(svgElement);
    }

    private void parseSelector(String selector) {
        String symbolWithSpace = addSpaceToSelector(selector);
        String[] parts = symbolWithSpace.split(BY_SPACE);

        for(int i = 0 ; i< parts.length; i++){
            if(i == parts.length - 1)
            {
                currentMatcher = new Matcher(parts[i]);
            }
            else{
                RelationType relationType = getRelationType(parts[i + 1]);
                if(relationType != null){
                    matcherRelations.add(new MatcherRelation(new Matcher(parts[i]),relationType));
                    i++;
                }
                else{
                    matcherRelations.add(new MatcherRelation(new Matcher(parts[i]),RelationType.INSIDE));
                }
            }
        }

    }

    private String addSpaceToSelector(String selector) {
        StringBuilder stringBuilder = new StringBuilder(selector);
        boolean shouldAddSpace = true;
        for (int i = 0 ; i < stringBuilder.length() ; i++){
            char c = stringBuilder.charAt(i);
            if(c == '['){
                shouldAddSpace = false;
            }
            else if(c == ']'){
                shouldAddSpace = true;
            }
            if(RelationType.getRelationType(""+c) != null && shouldAddSpace){
                stringBuilder.insert(i,' ');
                stringBuilder.insert(i+=2,' ');
            }
        }
        return stringBuilder.toString();
    }

    public boolean hasSelectedElement(SVGElement svgElement){
        return this.selectedElement.contains(svgElement);
    }

    public enum RelationType{
        INSIDE(BY_SPACE),
        OR(","),
        PARENT_IS(">"),
        IMMEDIATELY_AFTER("+"),
        PRECEDED_BY("~");

        String symbol;
        RelationType(String symbol){
            this.symbol = symbol;
        }

        protected static RelationType getRelationType(String symbol){
           for(RelationType relationType : values()){
               if(relationType.toString().equals(symbol)){
                   return relationType;
               }
           }
            return null;
        }

        @Override
        public String toString(){
            return symbol;
        }
    }

    private class MatcherRelation {
        Matcher matcher;
        RelationType relationType;

        MatcherRelation(Matcher matcher, RelationType relationType) {
            this.matcher = matcher;
            this.relationType = relationType;
        }

    }
}
