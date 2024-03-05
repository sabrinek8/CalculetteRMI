import java.rmi.registry.*;
import java.rmi.Naming;
public class Serveur {
	 public static void main(String[] args) {
	        try {
	            LocateRegistry.createRegistry(1099); 
	            Calculette calc = new CalculetteImpl();
	            Naming.rebind("rmi://localhost/Calculatrice", calc);
	            System.out.println("Serveur prêt.");
	        } catch (Exception e) {
	            System.err.println("Erreur survenue: " + e);
	        }
	    }
}
