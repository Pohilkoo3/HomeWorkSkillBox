import figures.Rectangle;
import figures.Square;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(20,30);
        rectangle.setHeight(50);
        System.out.println(rectangle.getSquare());


    }
}

