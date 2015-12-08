package com.jing.svg.dataType;

import java.util.ArrayList;
import java.util.List;

public class SVGStringList {

    List<String> strings;

    SVGStringList(){
        this(new String[0]);
    }

    SVGStringList(String value,String splitter){
        this(value.split(splitter));
    }

    SVGStringList(String[] initStrings){
        this.strings = new ArrayList<>();
        for(String s : initStrings){
            strings.add(s);
        }
    }

    SVGStringList(List<String> initStrings){
        this(initStrings.toArray(new String[0]));
    }

    public void clear(){
        this.strings.clear();
    }

    public void insertItemAt(int pos, String value){
        this.strings.add(pos,value);
    }

    public void insertItem(String value){
        this.strings.add(value);
    }

    public void removeItem(int pos){
        this.strings.remove(pos);
    }

    public String getItem(int pos){
        return strings.get(pos);
    }

    public List<String> getAll(){
        return strings;
    }

    public int getSize(){
        return strings.size();
    }
}
