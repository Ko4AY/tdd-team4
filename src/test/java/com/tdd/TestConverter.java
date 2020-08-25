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

    @Test(expected = IllegalArgumentException.class)
    public void arabicToRoman_whenArabicZero_thenException() {
        Integer arabic = 0;

        String roman = Converter.arabicToRoman(arabic);
    }

    @Test(expected = IllegalArgumentException.class)
    public void arabicToRoman_whenArabicIsNegative_thenException() {
        Integer arabic = -1;

        String roman = Converter.arabicToRoman(arabic);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void arabicToRoman_whenArabicIsMoreThan3999_thenException() {
        Integer arabic = 4000;

        String roman = Converter.arabicToRoman(arabic);
    }
}
