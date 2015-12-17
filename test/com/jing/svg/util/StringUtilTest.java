package com.jing.svg.util;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

/**
 * Created by jing on 12/15/2015.
 */
public class StringUtilTest {

    @Test
    public void should_parse_string_into_num_and_unit(){
        String length = "133 px";
        String[] strings = StringUtil.splitIntoNumberAndUnit(length);
        assertThat(strings[0], is("133"));
        assertThat(strings[1], is("px"));
    }

    @Test
    public void should_parse_string_into_double_and_unit(){
        String length = "133.31 px";
        String[] strings = StringUtil.splitIntoNumberAndUnit(length);
        assertThat(strings[0], is("133.31"));
        assertThat(strings[1], is("px"));
    }

    @Test
    public void should_parse_string_into_negative_num_and_unit(){
        String length = "-133.31 cm";
        String[] strings = StringUtil.splitIntoNumberAndUnit(length);
        assertThat(strings[0], is("-133.31"));
        assertThat(strings[1], is("cm"));
    }
}