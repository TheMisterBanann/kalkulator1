import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
    Scanner cin = new Scanner(System.in);
    boolean running = true;

    while(running){
        System.out.println("\n=== KALKULATOR FUNKCJI ===");
        System.out.println("3. Testuj funkcję wykladnicza");
        System.out.println("2. Testuj funkcję liniowa");
        System.out.println("1. Testuj funkcję kwadratową");
        System.out.println("0. Wyjdź z programu");
        System.out.print("Wybierz opcję: ");

        int choice = cin.nextInt();

        switch(choice){
            case 3:
                testFwykladnicza(cin);
                break;
            case 2:
                testFlinowa(cin);
                break;
            case 1:
                testFkwadrat(cin);
                break;
            case 0:
                running = false;
                System.out.println("Koniec Programu.");
                break;
            default:
                System.out.println("Niepoprawna opcja, Sprobuj ponownie.");
        }
    }

        cin.close();
    }

    private static void testFkwadrat(Scanner cin){
        System.out.println("\n--- Tworzenie funkcji kwadratowej f(x) = ax^2 + bx + c ---");
        System.out.println("Podaj a: ");
        double a = cin.nextDouble();

        System.out.println("podaj b:  ");
        double b = cin.nextDouble();

        System.out.print("Podaj c: ");
        double c = cin.nextDouble();

        try {
            Fkwadrat FK = new Fkwadrat(a, b, c);

            System.out.println("\n Udalo sie");
            FK.print();

            System.out.println("Podaj x dla ktorego chcesz obliczyc f(x): ");
            double x = cin.nextDouble();
            System.out.println("Wartosc f(" + x +" ) = " + FK.calculateValue(x));

            analize(FK, cin);
        } catch (IllegalArgumentException e){
            System.out.println("\n Blad" + e.getMessage());
        }

    }

    private static void testFlinowa(Scanner cin) {
        System.out.println("\n--- Tworzenie funkcji liniowej f(x) = ax + b ---");
        System.out.print("Podaj a: ");
        double a = cin.nextDouble();

        System.out.print("Podaj b: ");
        double b = cin.nextDouble();

    try {
        Fliniowa FL = new Fliniowa(a, b);
        System.out.println("\n[Sukces] Utworzono obiekt!");
        FL.print();

        System.out.println("dla jakiego x obliczyc wartosc funkcji liniowej? ");
        double x = cin.nextDouble();
        System.out.println("Wartosc f(" + x +" ) = " + FL.calculateValue(x));
        
        analize(FL, cin);
    } catch (IllegalArgumentException e) {
        System.out.println("\n[BŁĄD]: " + e.getMessage());
    }
}

    private static void testFwykladnicza(Scanner cin){
        System.out.println("\n--- Tworzenie funkcji wykladniczej f(x) = a^x + b ---");
        System.out.print("Podaj a: ");
        double a = cin.nextDouble();
        System.out.print("Podaj b: ");
        double b = cin.nextDouble();
        
        
        try {
            Fwykladnicza FW = new Fwykladnicza(a,b);
            System.out.println("\n[Sukces] Utworzono obiekt!");
            FW.print();

            System.out.println("dla jakiego x obliczyc wartosc funkcji wykladniczej? ");
            double x = cin.nextDouble();
            System.out.println("Wartosc f(" + x +" ) = " + FW.calculateValue(x));

            analize(FW, cin);
        } catch (IllegalArgumentException e) {
            System.out.println("\n[BLAD]: " + e.getMessage());
        }
    }


    private static void analize(Function f, Scanner cin) {
    try {
        System.out.println("\n--- Analiza funkcji na przedziale ---");
        System.out.print("Podaj początek przedziału (xMin): ");
        double xMin = cin.nextDouble();

        System.out.print("Podaj koniec przedziału (xMax): ");
        double xMax = cin.nextDouble();

        System.out.print("Podaj krok (h): ");
        double h = cin.nextDouble();

        FunctionOnInterval interval = new FunctionOnInterval(f, xMin, xMax, h);
        interval.print();

    } catch (IllegalArgumentException e) {
        System.out.println("[BŁĄD PRZEDZIAŁU]: " + e.getMessage());
    }
}


}