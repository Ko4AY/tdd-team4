package com.tdd;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestConverter {

    @Test
    public void arabicToRoman_whenArabicOneIsI_thenOk() {
        Integer arabic = 1;

        String roman = Converter.arabicToRoman(arabic);

        assertEquals(roman, "I");
    }

    @Test
    public void arabicToRoman_whenArabicNineIsIX_thenOk() {
        Integer arabic = 9;

        String roman = Converter.arabicToRoman(arabic);

        assertEquals(roman, "IX");
    }

}