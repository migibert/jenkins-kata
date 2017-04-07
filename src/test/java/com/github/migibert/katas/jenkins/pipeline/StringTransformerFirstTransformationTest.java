package com.github.migibert.katas.jenkins.pipeline;

import com.gihub.migibert.katas.jenkins.pipeline.StringTransformer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringTransformerFirstTransformationTest {

    private StringTransformer transformer = new StringTransformer();

    @Test
    public void firstTransformationLowercase() {
        String result = transformer.firstTransformation("abc");
        assertEquals("ABbCcc", result);
    }

    @Test
    public void firstTransformationUppercase() {
        String result = transformer.firstTransformation("ABC");
        assertEquals("ABbCcc", result);
    }

    @Test
    public void firstTransformationMixedcase() {
        String result = transformer.firstTransformation("aBc");
        assertEquals("ABbCcc", result);
    }

    @Test
    public void firstTransformationManyCharactersMixedCases() {
        String result = transformer.firstTransformation("aBcdEfGh");
        assertEquals("ABbCccDdddEeeeeFfffffGggggggHhhhhhhh", result);
    }

    @Test
    public void firstTransformationRandomCharactersMixedCases() {
        String result = transformer.firstTransformation("aAaAbBAcc");
        assertEquals("AAaAaaAaaaBbbbbBbbbbbAaaaaaaCcccccccCcccccccc", result);
    }
}
