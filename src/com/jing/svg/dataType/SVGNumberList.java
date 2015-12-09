package com.jing.svg.dataType;

import java.util.ArrayList;
import java.util.List;

public class SVGNumberList {

    List<SVGNumber> numbers;

    SVGNumberList(){
        this(new Double[0]);
    }

    SVGNumberList(Double[] numbers){
        this.numbers = new ArrayList<>();
        for(Double s : numbers){
            this.numbers.add(new SVGNumber(s));
        }
    }

    SVGNumberList(String value,String splitter) throws Exception {
        this(convertStringToNumber(value.split(splitter)));

    }

    SVGNumberList(List<String> numberStrings) throws Exception {
        this(convertStringToNumber(numberStrings.toArray(new String[0])));
    }

    private static Double[] convertStringToNumber(String[] numberStrings) throws Exception{
        Double[] numbers = new Double[numberStrings.length];
        for(int i = 0 ; i < numbers.length; i++){
            numbers[i] = Double.parseDouble(numberStrings[i]);
        }
        return numbers;
    }

    public void clear(){
        this.numbers.clear();
    }

    public void insertItemAt(int pos, SVGNumber value){
        this.numbers.add(pos,value);
    }

    public void insertItem(SVGNumber value){
        this.numbers.add(value);
    }

    public void removeItem(int pos){
        this.numbers.remove(pos);
    }

    public SVGNumber getItem(int pos){
        return numbers.get(pos);
    }

    public List<SVGNumber> getAll(){
        return numbers;
    }

    public int getSize(){
        return numbers.size();
    }
}
