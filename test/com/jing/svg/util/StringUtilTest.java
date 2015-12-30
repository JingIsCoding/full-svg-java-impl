package com.jing.svg.util;

import org.hamcrest.core.IsEqual;
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

    @Test
    public void should_crop_string(){
        String origin = "what has happened";
        String s = StringUtil.cropString(origin, 3, 5);
        assertThat(s, IsEqual.equalTo("whaas happened"));
    }

    @Test
    public void should_clean_up_double_quote(){
        String origin = "\"what\"";
        assertThat(StringUtil.cleanQuotes(origin), is("what"));
    }

    @Test
    public void should_clean_up_single_quote(){
        String origin = "''";
        assertThat(StringUtil.cleanQuotes(origin), is(""));
    }

    @Test
    public void should_not_clean_up_quote_when_quote_doesnt_match(){
        String origin = "'what\"";
        assertThat(StringUtil.cleanQuotes(origin), is("'what\""));
    }

    @Test
    public void should_crop_string_when_end_larger_than_length(){
        String origin = "what?";
        String s = StringUtil.cropString(origin, -1, 100);
        assertThat(s, IsEqual.equalTo(""));
    }
}