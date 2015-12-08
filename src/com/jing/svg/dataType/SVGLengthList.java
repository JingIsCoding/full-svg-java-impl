package com.jing.svg.dataType;

import java.util.ArrayList;
import java.util.List;

public class SVGLengthList {

    List<SVGLength> svgLengths;

    SVGLengthList(){
        this(new SVGLength[0]);
    }

    SVGLengthList(SVGLength[] svgLengths){
        this.svgLengths = new ArrayList<>();
        for(SVGLength s : svgLengths){
            this.svgLengths.add(s);
        }
    }


    public void clear(){
        this.svgLengths.clear();
    }

    public void insertItemAt(int pos, SVGLength value){
        this.svgLengths.add(pos,value);
    }

    public void insertItem(SVGLength value){
        this.svgLengths.add(value);
    }

    public void removeItem(int pos){
        this.svgLengths.remove(pos);
    }

    public SVGLength getItem(int pos){
        return svgLengths.get(pos);
    }

    public List<SVGLength> getAll(){
        return svgLengths;
    }

    public int getSize(){
        return svgLengths.size();
    }

}
