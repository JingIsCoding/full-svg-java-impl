package com.jing.svg.dataType;

import java.util.ArrayList;
import java.util.List;

public class SVGTransformList {

    List<SVGTransform> transforms = new ArrayList<>();

    public SVGTransformList(){
        this(new SVGTransform[0]);
    }

    public SVGTransformList(String transforms){
        SVGStringList svgStringList = splitTransformString(transforms);
        for(int i = 0; i <svgStringList.getSize() ; i++ ){
            this.transforms.add(new SVGTransform(svgStringList.getItem(i)));
        }
    }

    SVGTransformList(SVGTransform[] transforms){
        for(SVGTransform s : transforms){
            this.transforms.add(s);
        }
    }

    private SVGStringList splitTransformString(String transforms){
        SVGStringList svgStringList = new SVGStringList();
        int fromIndex = 0;
        int index = transforms.indexOf(')',fromIndex);
        while(index != -1){
            String transform = transforms.substring(fromIndex,index + 1);
            svgStringList.insertItem(transform);
            fromIndex = index + 1;
            index = transforms.indexOf(')',fromIndex);
        }
        return svgStringList;
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
