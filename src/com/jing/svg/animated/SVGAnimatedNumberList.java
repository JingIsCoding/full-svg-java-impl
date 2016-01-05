package com.jing.svg.animated;


import com.jing.svg.dataType.SVGNumberList;

public class SVGAnimatedNumberList extends AnimatedItemList<SVGNumberList>{

    public SVGAnimatedNumberList(SVGNumberList baseVal) {
        super(baseVal);
    }

    public SVGAnimatedNumberList(SVGNumberList baseVal, SVGNumberList animVal){
        super(baseVal,animVal);
    }
}
