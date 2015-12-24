package com.jing.svg.dataType;

import java.util.ArrayList;
import java.util.List;

public class SVGTransformList {

    List<SVGTransform> transforms;

    SVGTransformList(){
        this(new SVGTransform[0]);
    }

    SVGTransformList(SVGTransform[] transforms){
        this.transforms = new ArrayList<>();
        for(SVGTransform s : transforms){
            this.transforms.add(s);
        }
    }

    public void clear(){
        this.transforms.clear();
    }

    public void insertItemAt(int pos, SVGTransform value){
        this.transforms.add(pos,value);
    }

    public void insertItem(SVGTransform value){
        this.transforms.add(value);
    }

    public void removeItem(int pos){
        this.transforms.remove(pos);
    }

    public SVGTransform getItem(int pos){
        return transforms.get(pos);
    }

    public List<SVGTransform> getAll(){
        return transforms;
    }

    public int getSize(){
        return transforms.size();
    }

}
