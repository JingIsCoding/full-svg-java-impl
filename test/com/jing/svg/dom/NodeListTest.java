package com.jing.svg.dom;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNull.*;
import static org.junit.Assert.*;

/**
 * Created by jguo on 12/10/2015.
 */
public class NodeListTest {

    @Test
    public void testGetItem() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);

        assertThat(list.getItem(2), is(15d));
        assertThat(list.getItem(5), nullValue());
    }


    @Test
    public void testRemoveChild() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);

        list.removeChild(12d);

        assertThat(list.size(),is(2));

    }

    @Test
    public void testRemoveChild1() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);

        list.removeChild(0);

        assertThat(list.getItem(0),is(5d));
        assertThat(list.getItem(1),is(15d));
    }

    @Test
    public void testInsertBefore() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);

        list.insertBefore(17d ,5d);

        assertThat(list.getItem(0),is(12d));
        assertThat(list.getItem(1),is(17d));
        assertThat(list.getItem(2),is(5d));
        assertThat(list.getItem(3),is(15d));
    }

    @Test
    public void testReplaceChild() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);
        list.replaceChild(13d,12d);

        assertThat(list.getItem(0),is(13d));
        assertThat(list.getItem(1),is(5d));
        assertThat(list.getItem(2),is(15d));
    }
}