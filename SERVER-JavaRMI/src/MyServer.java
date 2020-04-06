import old.CalcObjectImplementation;

public class MyServer {

    public static void main(String[] args)
    {
        if (args.length == 0) {
            System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
            return;
        }

        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        try {
            CalcObjectImplementation implObiektu = new CalcObjectImplementation();
            java.rmi.Naming.rebind(args[0], implObiektu);
            System.out.println("Server is registered now :-)");
            System.out.println("Press Crl+C to stop...");
        } catch (Exception e) {
            System.out.println("SERVER CAN'T BE REGISTERED!");
            e.printStackTrace();
            return;
        }
    }
}
