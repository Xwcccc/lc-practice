package Array;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size="+size);
        System.out.println("ab="+size.getab());
        if(size == Size.EXTRA_LARGE){
            System.out.println("Good job--you paid attention to the _.");
        }
    }

    enum Size{
        SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
        private Size(String ab){this.ab = ab;}
        public String getab(){
            return ab;
        }
        private String ab;
    }
}
