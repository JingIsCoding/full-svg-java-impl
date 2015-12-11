package com.jing.svg.dataType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGPointList {

    List<SVGPoint> points;

    SVGPointList(){
        this(new SVGPoint[0]);
    }

    SVGPointList(SVGPoint[] points){
        this.points = new ArrayList<>();
        for(SVGPoint s : points){
            this.points.add(s);
        }
    }

    public void clear(){
        this.points.clear();
    }

    public void insertItemAt(int pos, SVGPoint value){
        this.points.add(pos,value);
    }

    public void insertItem(SVGPoint value){
        this.points.add(value);
    }

    public void removeItem(int pos){
        this.points.remove(pos);
    }

    public SVGPoint getItem(int pos){
        return points.get(pos);
    }

    public List<SVGPoint> getAll(){
        return points;
    }

    public int getSize(){
        return points.size();
    }
}
