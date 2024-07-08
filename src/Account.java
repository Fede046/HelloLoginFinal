
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    

    public Account(){}

    public boolean CreaAccount(String username,String password){
            boolean creato=false;
        try{
            if(listaUtenti().contains(username)){
                System.out.println("Account già esistenete");
            }

            if(!LeggiAccount(username, password)&&!listaUtenti().contains(username)){

                

            FileWriter fileWriter = new FileWriter("src/dati.txt",true);
    
            fileWriter.write("\n");
            fileWriter.write(username+"!");
            fileWriter.write(password+"!");
            fileWriter.write("0fase0"+"!");
            fileWriter.write("1fase0"+"!");
            fileWriter.close();

            creato=true;
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return creato;
    }

    public String[] salvaStringa = new String[4];

   
    public ArrayList<String> listaUtenti(){
        ArrayList<String> listaU = new ArrayList<>();
       
        try{
            Scanner scanner = new Scanner(new File("src/dati.txt"));
            while(scanner.hasNextLine()){
                String[] parti = scanner.nextLine().split("!");
                listaU.add(parti[0]);

            }
            scanner.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        
        return listaU;
    }
    
    

    public boolean LeggiAccount(String username,String password){
        boolean esiste=false;
        try{
           
            Scanner scanner = new Scanner(new File("src/dati.txt"));
           
            while(scanner.hasNextLine()){
                
                String[] parti = scanner.nextLine().split("!");
                
            
                boolean pEx=false;
                boolean uEx=false;
                
                if(parti[0].equals(username)){
                    uEx=true;
                }
                if(parti[1].equals(password)){
                    pEx=true;
                }

                
                if(pEx&&uEx){
                    for(int i=0;i<salvaStringa.length;i++){
                        salvaStringa[i]=parti[i];
                    }
                    esiste=true;
                }
                    
                uEx=false;
                pEx=false;


            }

        
            scanner.close();
            

        }catch(Exception e){
            e.printStackTrace();
        }
        return esiste;
    }


    
}
