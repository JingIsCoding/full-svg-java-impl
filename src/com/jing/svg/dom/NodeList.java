package com.jing.svg.dom;

import java.util.ArrayList;
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

    public boolean isEmpty(){
        return nodes.isEmpty();
    }

    public int size(){
        return nodes.size();
    }

    public boolean hasChild(T child){
        return nodes.contains(child);
    }

    public T getPreviousSiblingOf(T element) {
        return hasChild(element) && nodes.indexOf(element) > 0 ? nodes.get(nodes.indexOf(element) - 1) : null;
    }

    public T getNextSiblingOf(T element) {
        return hasChild(element) && nodes.indexOf(element) < nodes.size() - 1 ? nodes.get(nodes.indexOf(element) + 1) : null;
    }
}
