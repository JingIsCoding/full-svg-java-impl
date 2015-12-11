package com.jing.svg.dataType.dom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NodeList<T> {
    List<T> nodes = new ArrayList<>();

    public T getItem(int index){
        return index < nodes.size() ? nodes.get(index) : null;
    }

    public List<T> getList(){
        return this.nodes;
    }

    public void removeChild(T t){
        nodes.remove(t);
    }

    public void removeChild(int index){
        nodes.remove(index);
    }

    public void appendChild(T newChild){
        nodes.add(newChild);
    }

    public void insertBefore(T newChild, T refChild){
        nodes.add(nodes.indexOf(refChild),newChild);
    }

    public void replaceChild(T newChild, T oldChild){
        nodes.add(nodes.indexOf(oldChild),newChild);
        nodes.remove(oldChild);
    }

    public int size(){
        return nodes.size();
    }
}
