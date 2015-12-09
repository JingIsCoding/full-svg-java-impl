package com.jing.svg.dataType;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

/**
 * Created by jing on 12/9/2015.
 */
public class RGBColorTest {

    @Test
    public void constructor_should_handle_hex_color_with_RGB(){
        RGBColor rgbColor = new RGBColor("#AABBCC");
        assertThat(rgbColor.getRed(), is(170));
        assertThat(rgbColor.getGreen(), is(187));
        assertThat(rgbColor.getBlue(), is(204));
        assertThat(rgbColor.getAlpha(), is(255));
        assertThat(rgbColor.getRgbColor(), is("rgb(170,187,204)"));
        assertThat(rgbColor.getRgbaColor(), is("rgba(170,187,204,255)"));
        assertThat(rgbColor.getHexColor(), is("#AABBCC"));
    }

    @Test
    public void constructor_should_handle_hex_color_with_RGBA(){
        RGBColor rgbColor = new RGBColor("#AABBCCDD");
        assertThat(rgbColor.getRed(), is(170));
        assertThat(rgbColor.getGreen(), is(187));
        assertThat(rgbColor.getBlue(), is(204));
        assertThat(rgbColor.getAlpha(), is(221));
        assertThat(rgbColor.getRgbColor(), is("rgb(170,187,204)"));
        assertThat(rgbColor.getRgbaColor(), is("rgba(170,187,204,221)"));
        assertThat(rgbColor.getHexColor(), is("#AABBCCDD"));
    }

    @Test
    public void constructor_should_handle_rgb_string_color(){
        RGBColor rgbColor = new RGBColor("rgb(132,56,67)");
        assertThat(rgbColor.getRed(), is(132));
        assertThat(rgbColor.getGreen(), is(56));
        assertThat(rgbColor.getBlue(), is(67));
        assertThat(rgbColor.getAlpha(), is(255));
        assertThat(rgbColor.getRgbColor(), is("rgb(132,56,67)"));
        assertThat(rgbColor.getRgbaColor(), is("rgba(132,56,67,255)"));
        assertThat(rgbColor.getHexColor(), is("#843843"));
    }

    @Test
    public void constructor_should_handle_rgba_string_color(){
        RGBColor rgbColor = new RGBColor("rgba(132,56,67,41)");
        assertThat(rgbColor.getRed(), is(132));
        assertThat(rgbColor.getGreen(), is(56));
        assertThat(rgbColor.getBlue(), is(67));
        assertThat(rgbColor.getAlpha(), is(41));
        assertThat(rgbColor.getRgbColor(), is("rgb(132,56,67)"));
        assertThat(rgbColor.getRgbaColor(), is("rgba(132,56,67,41)"));
        assertThat(rgbColor.getHexColor(), is("#84384329"));
    }

    @Test
    public void constructor_should_handle_rgba_string_color_with_space(){
        RGBColor rgbColor = new RGBColor("rgba(132, 56, 67,  41 )");
        assertThat(rgbColor.getRed(), is(132));
        assertThat(rgbColor.getGreen(), is(56));
        assertThat(rgbColor.getBlue(), is(67));
        assertThat(rgbColor.getAlpha(), is(41));
        assertThat(rgbColor.getRgbColor(), is("rgb(132,56,67)"));
        assertThat(rgbColor.getRgbaColor(), is("rgba(132,56,67,41)"));
        assertThat(rgbColor.getHexColor(), is("#84384329"));
    }

    @Test
    public void constructor_should_handle_rgba_string_color_with_zero(){
        RGBColor rgbColor = new RGBColor("rgba(132, 056, 067,  041 )");
        assertThat(rgbColor.getRed(), is(132));
        assertThat(rgbColor.getGreen(), is(56));
        assertThat(rgbColor.getBlue(), is(67));
        assertThat(rgbColor.getAlpha(), is(41));
        assertThat(rgbColor.getRgbColor(), is("rgb(132,56,67)"));
        assertThat(rgbColor.getRgbaColor(), is("rgba(132,56,67,41)"));
        assertThat(rgbColor.getHexColor(), is("#84384329"));
    }
}