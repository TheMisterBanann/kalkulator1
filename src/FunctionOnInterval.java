public class FunctionOnInterval implements Printable {
    private Function f;
    private double xMin;
    private double xMax;
    private double h;


    public FunctionOnInterval(Function f, double xMin, double xMax, double h) {
        if (f == null) {
            throw new IllegalArgumentException("Funkcja nie może być nullem!");
        }
        if (xMin >= xMax) {
            throw new IllegalArgumentException("Początek przedziału (xMin) musi być mniejszy od końca (xMax)!");
        }
        if (h <= 0) {
            throw new IllegalArgumentException("Krok (h) musi być większy od 0!");
        }

        this.f = f;
        this.xMin = xMin;
        this.xMax = xMax;
        this.h = h;
    }

    public double calcMin() {
        double min = f.calculateValue(xMin);
        for (double x = xMin + h; x <= xMax + 0.00001; x += h) {
            double y = f.calculateValue(x);
            if (y < min) {
                min = y;
            }
        }
        return min;
    }

    public double calcMax() {
        double max = f.calculateValue(xMin);
        for (double x = xMin + h; x <= xMax + 0.00001; x += h) {
            double y = f.calculateValue(x);
            if (y > max) {
                max = y;
            }
        }
        return max;
    }


    public double calculateIntegral() {
        double sum = 0.0;
        for (double x = xMin; x < xMax - 0.00001; x += h) {
            double currentH = Math.min(h, xMax - x);
            
            double y1 = f.calculateValue(x);
            double y2 = f.calculateValue(x + currentH);
            
            sum += ((y1 + y2) / 2.0) * currentH;
        }
        return sum;
    }

    @Override
    public void print() {
        System.out.println("\n==========================================");
        System.out.println("ANALIZA FUNKCJI NA PRZEDZIALE [" + xMin + ", " + xMax + "] z krokiem h = " + h);
        System.out.println("==========================================");

        if (f instanceof Printable) {
            ((Printable) f).print();
        }

        System.out.println("\n--- TABELA WARTOŚCI ---");
        System.out.printf("%-12s | %-12s%n", "x", "f(x)");
        System.out.println("-----------------------------");

        for (double x = xMin; x <= xMax + 0.00001; x += h) {
            System.out.printf("%-12.4f | %-12.4f%n", x, f.calculateValue(x));
        }

        System.out.println("\n--- WYNIKI ANALIZY ---");
        System.out.printf("Wartość minimalna: %.4f%n", calcMin());
        System.out.printf("Wartość maksymalna: %.4f%n", calcMax());
        System.out.printf("Całka (pole pod wykresem): %.4f%n", calculateIntegral());
        System.out.println("==========================================\n");
    }

}