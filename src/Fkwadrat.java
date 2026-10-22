public class Fkwadrat extends Function implements Printable {
    
    private double a, b, c;


    public Fkwadrat(double a, double b, double c){
        
        if(a==0){
            throw new IllegalArgumentException("wspolczynnik a nie moze byc rowny 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double Delta(){
        return b*b-4*a*c;
    }

    public double[] vertex(){
        double p = -b/(2*a);
        double q = -Delta()/(4*a);

        return new double[]{p,q};
    }


    @Override 
    public double calculateValue(double x){
        return a*x*x+b*x+c;
    }

    @Override
    public double[] calculateZeros() {
        double delta = Delta();

        if(delta<0){
            return  new double[]{};
        }else if(delta==0){
            double x0 =-b/(2*a);
            return new double[]{x0};
        }else {
            double sqrtDelta = Math.sqrt(delta);
            double x1 = (-b+sqrtDelta)/(2*a);
            double x2 = (-b-sqrtDelta)/(2*a);
            return new double[]{x1,x2};
        }
    }

    @Override 
    public void print(){

        System.out.println("--- FUNKCJA KWADRATOWA ---");
        System.out.println("Wzór: f(x) = " + a + "x^2 + " + b + "x + " + c);
        System.out.println("Współczynniki: a = " + a + ", b = " + b + ", c = " + c);
        
        double delta = Delta();
        System.out.println("Delta: " + delta);

        double[] vertex = vertex();
        System.out.println("Wierzchołek (p, q): (" + vertex[0] + ", " + vertex[1] + ")");

        double[] zeros = calculateZeros();
        if (zeros.length == 0) {
            System.out.println("Miejsca zerowe: brak (delta < 0)");
        } else if (zeros.length == 1) {
            System.out.println("Miejsce zerowe: x0 = " + zeros[0]);
        } else {
            System.out.println("Miejsca zerowe: x1 = " + zeros[0] + ", x2 = " + zeros[1]);
        }

    }


}
