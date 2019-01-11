package Ex1;

public class Exponentiation {

    public double exponentiation(double x, int n){
        if (n > 1)
            return x * exponentiation(x, n - 1);
        else if (n < 0)
            return 1 / (x * exponentiation(x, -n - 1));
        else if (n == 1)
            return x;
        else if (n == 0)
            return 1;
        else
            return 0;
    }
}
