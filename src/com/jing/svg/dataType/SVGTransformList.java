package com.jing.svg.dataType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGTransformList {

    List<SVGTransform> numbers;

    SVGTransformList(){
        this(new SVGTransform[0]);
    }

    SVGTransformList(SVGTransform[] numbers){
        this.numbers = new ArrayList<>();
        for(SVGTransform s : numbers){
            this.numbers.add(s);
        }
    }

    public void clear(){
        this.numbers.clear();
    }

    public void insertItemAt(int pos, SVGTransform value){
        this.numbers.add(pos,value);
    }

    public void insertItem(SVGTransform value){
        this.numbers.add(value);
    }

    public void removeItem(int pos){
        this.numbers.remove(pos);
    }

    public SVGTransform getItem(int pos){
        return numbers.get(pos);
    }

    public List<SVGTransform> getAll(){
        return numbers;
    }

    public int getSize(){
        return numbers.size();
    }
}
