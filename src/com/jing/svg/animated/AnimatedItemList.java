package com.jing.svg.animated;

public abstract class AnimatedItemList<T> {

    private T baseVal;
    private T animVal;

    protected AnimatedItemList(T baseVal){
        this(baseVal,baseVal);
    }

    protected AnimatedItemList(T baseVal, T animVal){
        this.baseVal = baseVal;
        this.animVal = animVal;
    }

    public T getBaseVal(){
        return baseVal;
    }

    public T getAnimVal(){
        return animVal;
    }
}
