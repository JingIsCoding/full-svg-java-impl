package com.jing.svg.dom;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;


public class CSSStyleDeclarationTest {

    @Test
    public void should_parse_style_correctly(){
        CSSStyleDeclaration cssStyleDeclaration = new CSSStyleDeclaration("margin-top: 0;\n" +
                "margin-bottom: 12px;");

        assertThat(cssStyleDeclaration.getPropertyCSSValue("margin-top").getValue().toString(), IsEqual.equalTo("0"));
        assertThat(cssStyleDeclaration.getPropertyCSSValue("margin-bottom").getValue().toString(), IsEqual.equalTo("12px"));
    }

    @Test
    public void should_parse_style_with_priority_correctly(){
        CSSStyleDeclaration cssStyleDeclaration = new CSSStyleDeclaration("margin-top: 0;\n" +
                "margin-bottom: 12px !important;");

        assertThat(cssStyleDeclaration.getPropertyCSSValue("margin-top").getValue().toString(), IsEqual.equalTo("0"));
        assertThat(cssStyleDeclaration.getPropertyCSSValue("margin-bottom").getValue().toString(), IsEqual.equalTo("12px"));
        assertThat(cssStyleDeclaration.getPropertyCSSValue("margin-bottom").isImportant(), is(true));
    }

    @Test
    public void should_get_properties_with_functions_correctly(){
        CSSStyleDeclaration cssStyleDeclaration = new CSSStyleDeclaration("font-family: asad; font-size:12px");
        assertThat(cssStyleDeclaration.getFont().getFontFamily().getValue().toString(), IsEqual.equalTo("asad"));
        assertThat(cssStyleDeclaration.getFont().getFontSize().getValue().toString(), IsEqual.equalTo("12px"));
    }
}