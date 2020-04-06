import old.CalcObject;

public class MyClient {
    public static void main(String[] args){
        double wynik;
        CalcObject zObject;

        if (args.length == 0) {
            System.out.println("You have to enter RMI object address in the form: // host_address/service_name ");
            return;
        }

        String adres = args[0];

//use this if needed
//        if (System.getSecurityManager() == null)
//            System.setSecurityManager(new SecurityManager());

        try {
            zObject = (CalcObject) java.rmi.Naming.lookup(adres);
        } catch (Exception e) {
            System.out.println("Nie mozna pobrac referencji do "+adres);
            e.printStackTrace();
            return;
        }
        System.out.println("Referencja do "+adres+" jest pobrana.");
        try {
            wynik = zObject.calculate(1.1, 2.2);
        } catch (Exception e) {
            System.out.println("Blad zdalnego wywolania.");
            e.printStackTrace();
            return;
        }
        System.out.println("Wynik = "+wynik);

    }
}
