public class Fliniowa extends Function implements Printable{
    
    private double a,b;

    public Fliniowa(double a, double b){
        
        if(a==0){
            throw new IllegalArgumentException("wspolczynnik a nie moze byc rowny 0");
        }
        this.a = a;
        this.b = b;

    }


    @Override 
    public double calculateValue(double x){
        return a*x+b;
    }

    @Override 
    public double[] calculateZeros(){
        double x0 = -b/a;
        return new double[]{x0};
    }

    @Override

    public void print(){
        System.out.println("--- FUNKCJA LINIOWA ---");
        System.out.println("Wzór: f(x) = " + a + "x + " + b);
        System.out.println("Współczynniki: a = " + a + ", b = " + b);
        
        double[] zeros = calculateZeros();
        System.out.println("Miejsce zerowe: x0 = " + zeros[0]);
    }



}
