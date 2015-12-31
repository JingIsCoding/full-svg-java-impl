package com.jing.svg.dom;

import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;


public class CSSStyleSheetTest {

    @Test
    public void should_parse_css_text_corretly(){
        CSSStyleSheet cssStyleSheet = new CSSStyleSheet("H4 {\n" +
                "  text-align: left;\n" +
                "  font-family: sans-serif;\n" +
                "  font-weight: normal;\n" +
                "  color: black;\n" +
                "}\n" +
                ".idl-code { \n" +
                "  font-family: monospace;\n" +
                "  border: 1px solid black;\n" +
                "  white-space: pre; \n" +
                "  color: black;\n" +
                "  background-color: #dfdfdf; \n" +
                "}");
        assertThat(cssStyleSheet.getCssStyleRules().size(), is(2));
        assertThat(cssStyleSheet.getCssStyleRules().get(0).getSelector(),is("H4"));
        assertThat((String)cssStyleSheet.getCssStyleRules().get(0).getStyle().getFont().getFontFamily().getValue(),is("sans-serif"));
        assertThat(cssStyleSheet.getCssStyleRules().get(0).getStyle().getColor().getValue(),is("black"));
        assertThat(cssStyleSheet.getCssStyleRules().get(1).getSelector(),is(".idl-code"));
    }


}