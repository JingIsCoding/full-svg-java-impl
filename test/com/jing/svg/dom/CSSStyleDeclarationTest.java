package com.jing.svg.dom;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

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
        assertThat(cssStyleDeclaration.getPropertyCSSValue("margin-bottom").isImportant(),Is.is(true));
    }
}