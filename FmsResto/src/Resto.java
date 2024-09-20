
import java.util.Scanner;

public class Resto {
	
			
		// Road Map
		
		//1. Enregistrer les menus
			
		//2. Demander "Bonjour, combien de menus souhaitez-vous ?"
			
		//3. Faire des méthodes pour les différents choix

		//4. Générer le résumé de la commande
			 
			//5. Lire la réponse de l'Utilisateur
			
				//5.1 Gérer le cas où l'utilisateur rentre une donnée innatendue
				//5.2 Gérer le cas où il y a une entrée invalide dans les différents choix
			//6. Fermer le programme
				
			
		
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Demande combien de menus l'utilisateur souhaite commander
	        System.out.println("Bonjour, combien de menus souhaitez-vous ?");
	       
	        // On lit l'entrée utilisateur attendue, un Int
			int nbMenus = scanner.nextInt();  
			
	        // Options pour chaque catégorie du menu
	        String[][] menuOptions = {
	            {"[Votre entree]", "[1 - Salade]", "[2 - Soupe]", "[3 - Quiche]", "[4 - Aucune]"},
	            {"[Votre plat]", "[1 - Poulet]", "[2 - Boeuf]", "[3 - Poisson]", "[4 - Végétarien]", "[5 - Vegan]", "[6 - AUCUN]"},
	            {"[Votre accompagnement]", "[1 - Riz]", "[2 - Pates]", "[3 - Frites]", "[4 - Légumes]", "[5 - Aucun]"},
	            {"[Votre boisson]", "[1 - Eau]", "[2 - Eau gazeuse]", "[3 - Soda]", "[4 - Vin]", "[5 - Aucun]"},
	            {"[Votre dessert]", "[1 - Tarte Maison]", "[2 - Mousse au chocolat]", "[3 - TIRAMISU]", "[4 - Aucune]"}
	        };

	        // Boucle pour chaque menu, on répète le processus de commande autant de fois que l'Utilisateur souhaite de menus
	        for (int i = 0; i < nbMenus; i++) {
	        	
	        	//On créé l'objet qui permet de construire une chaîne de caractères
	            StringBuilder order = new StringBuilder();

	            // Boucle à l'intérieur des catégories de choix
	            for (String[] options : menuOptions) {
	            	
	            	//Le résultat de chaque choix est "append" à order pour faire la commande complète,
	            	//À chaque itération de la boucle (chaque option à l'intérieur), on veut ajouter le choix fait par l'Utilisateur
	                order.append(faireChoix(options, scanner)).append(" ");
	            }

	            // Affichage du résumé de la commande pour chaque menu
	            System.out.println("Résumé de la commande " + (i + 1) + " : " + order);
	        }
	    }

	    
	    // Méthode pour afficher les options et lire le choix utilisateur
	    //Cette méthode prends en paramètre les options d'une catégorie 
	    //et l'objet Scanner pour lire les choix de l'utilisateur 
	    //Elle retourne le choix de l'utilisateur en String
	    
	    public static String faireChoix(String[] options, Scanner scanner) {
	    	
	        // Affichage des options
	        for (int i = 0; i < options.length; i++) {
	            System.out.println(options[i]);
	        }
	        
			// Initialisation du choix
	        int choix = -1;  

	        // Lecture du choix de l'utilisateur avec validation
	        while (true) {
	        	
	            // Si l'utilisateur entre autre chose qu'un entier, on affiche un message d'erreur
	            if (!scanner.hasNextInt()) {
	                scanner.next(); 
	                
	                System.out.println("Veuillez entrer un nombre valide.");
	            } 
	            
	            else {
	                // Lecture
	                choix = scanner.nextInt();

	                // Validation que le choix est dans les limites attendues
	                if (choix >= 1 && choix < options.length) {
	                	// On évite la boucle infinie si le choix est valide
	                    break; 
	                    
	                //Si la valeur est innattendue, le programme redemande une saisie correcte
	                } else {
	                    System.out.println("Veuillez choisir un nombre entre 1 et " + (options.length - 1));
	                }
	            }
	        }

	        // Retour du choix de l'utilisateur
	        return options[choix];
	    }
	}

