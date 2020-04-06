import old.CalcObjectImplementation;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer {

    public static void main(String[] args)
    {
        if (args.length == 0) {
            System.out.println("You have to enter RMI object address in the form: //host_address/service_name");
            return;
        }

        String adres1 = args[0];
        String adres2 = args[1];
        int port = 1099;

        try {
            Registry reg = LocateRegistry.createRegistry((port));
        }catch(Exception e){

        }
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            Worker worker = new WorkerImplementation();
            java.rmi.Naming.rebind(adres1, worker );
            Worker worker2 = new WorkerImplementation();
            java.rmi.Naming.rebind(adres2, worker2 );
            System.out.println("Server is registered now :-)");
            System.out.println("Press Crl+C to stop...");
        } catch (Exception e) {
            System.out.println("SERVER CAN'T BE REGISTERED!");
            e.printStackTrace();
            return;
        }
    }
}
