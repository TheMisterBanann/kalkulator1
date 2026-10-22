public class Fwykladnicza extends Function implements Printable {
    
    private double a,b;

    public Fwykladnicza(double a, double b){
        
        if(a<=0 || a==1){
            throw new IllegalArgumentException("wspolczynnik a nie moze byc rowny 1 anmie mniejszy badz rowny 0");
        }
        this.a = a;
        this.b = b;

    }


    @Override 
    public double calculateValue(double x){
        double value = a;
        for(int i=1;i<x;i++){
            value = value * a; 
        }
        value+=b;
        return value;
    }


    @Override 
    public double[] calculateZeros(){

        if (b >= 0) {
            return new double[]{};
        }

        double x0 = Math.log(-b)/Math.log(a);
        return new double[]{x0};
    }

    @Override

    public void print(){
        System.out.println("--- FUNKCJA Wykladnicza ---");
        System.out.println("Wzór: f(x) = " + a + "^x + " + b);
        System.out.println("Współczynniki: a = " + a + ", b = " + b);
        
        double[] zeros = calculateZeros();
        if (zeros.length == 0) {
            System.out.println("Miejsce zerowe: brak (a^x + b nie przecina osi X dla b >= 0)");
        } else {
            System.out.println("Miejsce zerowe: x0 = " + zeros[0]);
        }
    }

}
