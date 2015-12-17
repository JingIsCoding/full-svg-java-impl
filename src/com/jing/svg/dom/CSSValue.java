package com.jing.svg.dom;

/**
 * Created by jguo on 12/9/2015.
 */
public class CSSValue<T> {

    private boolean important =false;
    private T value;

    public CSSValue(T value){
        this(value,false);
    }

    public CSSValue(T value, boolean important){
        this.value = value;
        this.important = important;
    }

    public T getValue(){
        return value;
    }

    private void setImportant(boolean important){
        this.important = important;
    }

    private boolean isImportant(){
        return important;
    }



}
