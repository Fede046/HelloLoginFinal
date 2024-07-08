import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account= new Account();
        try{
            int val=0;
            while(val!=3){
                System.out.println();
                System.out.println("1.login");
                System.out.println("2.crea Account");
                System.out.println("3.exit");
                val=scanner.nextInt();
                
            switch (val) {
                case 1: 
                //login    
                    System.out.println("Username");
                    String user = scanner.next();
                    System.out.println("password");
                    String password = scanner.next();
                    if(account.LeggiAccount(user, password)){
                        System.out.println("Esiste");
                        for(String a: account.salvaStringa){
                            System.out.println(a+" ");
                        }
                    }else{
                        System.out.println("Non esiste");
                    }

                    break;
                case 2: 
                //nuovo accesso
                    System.out.println("Username");
                    String user1 = scanner.next();
                    System.out.println("password");
                    String password1 = scanner.next();
                   if(account.CreaAccount(user1, password1)){
                    System.out.println("Account creato");
                   }else{
                    System.out.println("Account non creato");
                   }
                

                break;
            
                default:
                    break;
            }
            }
            System.out.print("Finito!!");
            scanner.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        

    }
}
