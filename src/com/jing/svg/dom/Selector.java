package com.jing.svg.dom;

import com.jing.svg.dataType.Constants;
import com.jing.svg.element.SVGElement;
import com.sun.istack.internal.NotNull;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.jing.svg.dom.Selector.RelationType.getRelationType;

public class Selector {

    private HashSet<SVGElement> selecterElement = new HashSet<>();
    private List<Pair<Matcher,RelationType>> parentElement = new ArrayList<>();
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

    private void parseSelector(String selector) {
        String symbolWithSpace = addSpaceToSelector(selector);
        String[] parts = symbolWithSpace.split(Constants.BY_SPACE);
        for(int i = 0 ; i< parts.length; i++){
            if(i == parts.length - 1)
            {
                currentMatcher = new Matcher(parts[i]);
            }
            else{
                RelationType relationType = getRelationType(parts[i + 1]);
                if(relationType != null){
                    parentElement.add(new Pair<>(new Matcher(parts[i]),relationType));
                    i++;
                }
                else{
                    parentElement.add(new Pair<>(new Matcher(parts[i]),RelationType.INSIDE));
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
        return this.selecterElement.contains(svgElement);
    }

    public enum RelationType{
        INSIDE(Constants.BY_SPACE),
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
}
