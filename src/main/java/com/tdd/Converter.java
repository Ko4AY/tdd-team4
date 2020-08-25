package com.tdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {
    private static int MINIMUM_ROMAN = 1;
    private static int MAXIMUM_ROMAN = 3999;

    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10), 
        XL(40), L(50), XC(90), C(100), 
        CD(400), D(500), CM(900), M(1000);
     
        private int value;
     
        RomanNumeral(int value) {
            this.value = value;
        }
     
        public int getValue() {
            return value;
        }
        
        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
              .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
              .collect(Collectors.toList());
        }
    }

    public static String arabicToRoman(Integer arabic) { 
        if ((arabic < MINIMUM_ROMAN) || (arabic > MAXIMUM_ROMAN))  {
            throw new IllegalArgumentException(arabic + " is not in range [1,3999]");
        }
        
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
     
        int i = 0;
        StringBuilder sb = new StringBuilder();
     
        while ((arabic > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= arabic) {
                sb.append(currentSymbol.name());
                arabic -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
     
        return sb.toString();
    }
}