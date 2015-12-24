package com.jing.svg.element;

import com.jing.svg.SVGGElement;
import com.jing.svg.animated.SVGAnimatedTransformList;
import com.jing.svg.dataType.Constants;
import org.hamcrest.core.Is;
import org.junit.Test;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.TRANSFORM;
import static org.junit.Assert.*;


public class SVGTransformableImplTest {

    @Test
    public void should_get_transforms_from_svg_element(){
        SVGGElement svggElement = new SVGGElement();
        svggElement.setAttribute(TRANSFORM.toString(),"rotate(20) translate( 100,20)");

        SVGTransformable transformable = new SVGTransformableImpl(svggElement);
        SVGAnimatedTransformList transforms = transformable.getTransforms();

        assertThat(transforms.getBaseVal().getSize(), Is.is(2));
    }

}