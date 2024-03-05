import java.util.Scanner;
import java.rmi.Naming;
public class Client {
public static void main (String[] args) {
	
	try {
        Calculette calc = (Calculette) Naming.lookup("rmi://localhost/Calculatrice");
        Scanner scanner = new Scanner(System.in);
        String choix = "oui";
        
        while (choix.equalsIgnoreCase("oui")) {
            System.out.println("Choisissez une opération: ");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            int operation = scanner.nextInt();
            
            System.out.print("Entrez le premier nombre: ");
            double a = scanner.nextDouble();
            System.out.print("Entrez le deuxième nombre: ");
            double b = scanner.nextDouble();
            
            double resultat = 0;
            switch (operation) {
                case 1:
                    resultat = calc.addition(a, b);
                    break;
                case 2:
                    resultat = calc.soustraction(a, b);
                    break;
                case 3:
                    resultat = calc.multiplication(a, b);
                    break;
                case 4:
                    resultat = calc.division(a, b);
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
            
            System.out.println("Résultat: " + resultat);
            
            System.out.print("Voulez-vous continuer ? (oui/non) ");
            choix = scanner.next();
        }
        scanner.close();
    } catch (Exception e) {
        System.err.println("Erreur survenue: " + e);
    }
}
}
