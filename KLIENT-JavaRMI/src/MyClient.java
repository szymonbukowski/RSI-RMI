import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyClient {

    public static void clientTextInterface(Worker w1, Worker w2){

        int tasksNumb = readTaskNumbers(4);
        ArrayList<Task> tasks = new ArrayList<>();
        for(int i=0; i<tasksNumb; i++){
            tasks.add(readTask(i));
        }

        for(int i=1; i<=tasks.size();i++){
            if(i%2==0){
                w1.work(tasks.get(i-1));
            }
        }

    }

    private static int readTaskNumbers(int min){
        int res =0;
        boolean incorrect = true;
        while(incorrect){
            System.out.println("podaj liczbe zadan do wykonania (conajmniej " + min+ "):");
            Scanner sc = new Scanner(System.in);
            try{
                res = sc.nextInt();
            }catch(InputMismatchException e){
                sc.close();
                System.out.println("Wpisz liczbe calkowitą dodatnia");
            }
            if(res<min || res<0){
                System.out.println("liczba nie spelnia wymogow");
            }else {
                incorrect = false;
            }
        }

        return res;
    }
    private static TaskImplementation readTask(int index){
        long x=0, y=0;
        boolean incorrect = true;
        Scanner sc = new Scanner(System.in);
        while(incorrect){
            boolean local_incorrect = true;
            while(local_incorrect){
                System.out.println("podaj X"+index+":");

                try{
                    x = sc.nextLong();
                }catch(InputMismatchException e){

                    System.out.println("Wpisz liczbe calkowitą dodatnia");
                }
                if(x<0){
                    System.out.println("liczba nie spelnia wymogow");
                }else {
                    local_incorrect = false;
                }
            }
            local_incorrect = true;
            while(local_incorrect){
                System.out.println("podaj Y"+index+":");
                try{
                    y = sc.nextLong();
                }catch(InputMismatchException e){
                    System.out.println("Wpisz liczbe calkowitą dodatnia");
                }
                if(y<0){
                    System.out.println("liczba nie spelnia wymogow");
                }else {
                    local_incorrect = false;
                }
            }
            if(y-x>100){
                incorrect = false;
            }else{
                System.out.println("podano liczby niespelniajace warunków zadania wprowadz poprawne");
            }
        }
        return new TaskImplementation(x,y);
    }

    public static void main(String[] args){
        Worker worker1, worker2;

        if (args.length == 0) {
            System.out.println("You have to enter RMI object address in the form: // host_address/service_name ");
            return;
        }

        String adres1 = args[0];
        String adres2 = args[1];



        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());

        try {
            worker1 = (Worker) java.rmi.Naming.lookup(adres1);
            worker2 = (Worker) java.rmi.Naming.lookup(adres2);
        } catch (Exception e) {
            System.out.println("błąd pobierania referencji");
            e.printStackTrace();
            return;
        }
        clientTextInterface(worker1, worker2);

//        try {
//
//        } catch (Exception e) {
//            System.out.println("Blad zdalnego wywolania.");
//            e.printStackTrace();
//            return;
//        }


    }
}
