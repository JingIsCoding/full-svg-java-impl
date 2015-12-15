package com.jing.svg.dom;

import org.hamcrest.core.IsNull;
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

    @Test
    public void should_return_null_when_it_is_the_first_node() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);
        list.appendChild(16d);

        assertThat(list.getPreviousSiblingOf(12d), IsNull.nullValue());
    }

    @Test
    public void should_return_null_when_try_get_previous_node_and_node_is_not_in_list() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);
        list.appendChild(16d);

        assertThat(list.getPreviousSiblingOf(17d), IsNull.nullValue());
    }

    @Test
    public void should_find_the_previous_node() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);
        list.appendChild(16d);

        assertThat(list.getPreviousSiblingOf(15d),is(5d));
    }

    @Test
    public void should_return_null_when_get_next_sibling_when_it_is_the_last_node() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);
        list.appendChild(16d);

        assertThat(list.getNextSiblingOf(16d), IsNull.nullValue());
    }

    @Test
    public void should_return_null_when_try_get_next_sibling_node_and_node_is_not_in_list() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);
        list.appendChild(16d);

        assertThat(list.getNextSiblingOf(17d), IsNull.nullValue());
    }

    @Test
    public void should_find_the_next_sibling_node() throws Exception {
        NodeList<Double> list = new NodeList<>();
        list.appendChild(12d);
        list.appendChild(5d);
        list.appendChild(15d);
        list.appendChild(16d);

        assertThat(list.getNextSiblingOf(15d),is(16d));
    }
}