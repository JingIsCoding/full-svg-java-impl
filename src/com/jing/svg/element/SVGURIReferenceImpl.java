package com.jing.svg.element;

import com.jing.svg.animated.SVGAnimatedString;

/**
 * Created by jguo on 12/11/2015.
 */
public class SVGURIReferenceImpl implements SVGURIReference{

    private SVGAnimatedString href;

    public void setHref(String href){
        if(href == null){
            this.href = new SVGAnimatedString(href);
        }
    }

    public void setHref(String href,String aniHref){
        if(href == null){
            this.href = new SVGAnimatedString(href,aniHref);
        }
    }

    public SVGAnimatedString getHref() {
        return href;
    }
}
