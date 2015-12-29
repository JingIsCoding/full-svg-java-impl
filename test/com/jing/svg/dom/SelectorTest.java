package com.jing.svg.dom;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectorTest {

    @Test
    public void should_add_space_before_and_after_css_relation_symbol(){
        Selector selector = new Selector("rect+.class>#abc~.class[attr=yes] div");

    }

}