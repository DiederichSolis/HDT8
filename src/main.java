import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
public class main {
    private static int id;
    public static void main(String[] args)  {
        System.out.println("PROCESOS:" + " \nSin procesos actuales...");
       
        PriorityQue<operaciones> pq = new vHeap<>();
         // leer archivo de procesos
         InputStream inputStream = null;
         BufferedReader reader = null;
        try {
            ClassLoader classLoader = main.class.getClassLoader();
            
            // Usa la ruta de la clase para obtener la ruta del archivo que deseas leer
            inputStream = classLoader.getResourceAsStream("archivo.txt");
            
            // Crea un objeto BufferedReader para leer el archivo de forma eficiente
            reader = new BufferedReader(new InputStreamReader(inputStream));
            
            // Lee el archivo línea por línea e imprime cada línea en la consola
           
            String line;
            
            Scanner input = new Scanner(System.in);
           
            while ((line = reader.readLine()) != null) {
                Scanner scanner;
              
                String[] fields = line.split(",");
                String nombre = fields[0];
                String usuario = fields[1];
                int nice = Integer.parseInt(fields[2]);
                operaciones proceso = new operaciones(nombre, usuario, nice);
                pq.agregar(proceso);
                
                System.out.print("Ingrese 'y' para avanzar con el siguiente proceso o 'q'  para salir... \n> ");
                String userInput = input.nextLine();
                if (userInput.equals("q")) {
                    break;
                }else {
                    // procesar procesos
                    while (!pq.isEmpty()) {                     
                        System.out.println("");   
                        if (id != 0){
                            System.out.println("Proceso anterior finalizado. Iniciando con el siguiente proceso...");
                            id = 0;
                        } if (id == 0){
                            id = 1;
                        }
                        System.out.println("Proceso actual...");
                        proceso = pq.remove();
                        System.out.println( "Nombre: " +  proceso.getname() +"\nUsuario: " +  proceso.getuser() +  "\nNice: " +  proceso.getn() + "\n");  
                    }
                }
            }
            System.out.println("Lo lamentamos, ya no hay más procesos por realizar.\nGracias por utilizar nuestro programa :D \nSaliendo del sistema..." );
         
            input.close(); 
        } catch (IOException e) {
            e.printStackTrace();}
    }
    }

