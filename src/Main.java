import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

public class Main {

    private static final double EPSILON = 0.01;

    private static final double A = 1;
    private static final double B = -5;
    private static final double C = 1;

    public static void main(String[] args) {
        bisection(-1, 1);
    }

    static void bisection(double a, double b)
    {
        Function<Double,Double> func = new Function<Double, Double>() {
            @Override
            public Double apply(Double v) {
                return A*Math.pow(v,2) + B*v + C;
            }
        };

        if (func.apply(a) * func.apply(b) >= 0)
        {
            System.out.println("Funkcja powinna zaczynac na przedziale gdzie poczadkowe " +
                    "wartosci sa przeciwne");
            return;
        }

        double c = a;
        while ((b-a) >= EPSILON)
        {
            c = (a+b)/2;
            if (func.apply(c) == 0.0)
                break;
            else if (func.apply(c)*func.apply(a) < 0)
                b = c;
            else
                a = c;
        }
        System.out.println(func.apply(c));
    }
}
