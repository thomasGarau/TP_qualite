
import java.util.ArrayList;
import java.util.Arrays;

public class Plateau {
    private final int NB_CASES = 40;
    private final ArrayList<Case> plateau = new ArrayList<Case>(Arrays.asList(
    new Depart(),
    new Terrain("Belleville", 60, 2),
    new CaisseDeCom("Caisse communauté"),
    new Terrain("Rue Lecourbe", 60, 4),
    new caseTaxe("Impot sur le revenu", 200),
    new Gare("Gare Montparnasse", 200, 25),
    new Terrain("Rue de Vaugirard", 100, 6),
    new Chance("chance"),
    new Terrain("Rue de Courcelles", 100, 6),
    new Terrain("Avenue de la république", 120, 8),
    new Prison(),
    new Terrain("Boulevard de La Vilette", 140, 10),
    new CaseSociete("Compagnie Electricité"),
    new Terrain("Avenue de Neuilly", 140, 10),
    new Terrain("Rue de Paradis", 160, 12),
    new Gare("Gare de Lyon", 200, 25),
    new Terrain("Avenue Mozart", 180, 14),
    new CaisseDeCom("Caisse communauté"),
    new Terrain("Boulevard Saint-Michel Rue Saint-Honoré", 180, 14),
    new Terrain("Place Pigalle", 200, 16),
    new ParcGratuit("Parc gratuit"),
    new Terrain("Avenue Matignon", 220, 18),
    new Chance("chance"),
    new Terrain("Boulevard Malesherbes", 220, 18),
    new Terrain("Avenue Henri-Martin", 220, 20),
    new Gare("Gare du Nord", 200, 25),
    new Terrain("Faubourg Saint Honoré", 240, 22),
    new Terrain("Place de la Bourse", 260, 22),
    new CaseSociete("Compagnie des eaux"),
    new Terrain("Rue la Fayette", 260, 22),
    new AllerPrison(),
    new Terrain("Avenue de Breteuil", 280, 24),
    new Terrain("Avenue Foch", 300, 24),
    new CaisseDeCom("Caisse communauté"),
    new Terrain("Boulevard des capucines", 300, 26),
    new Gare("Gare Saint Lazare", 200, 25),
    new Chance("chance"),
    new Terrain("Avenue des Champs-Élysées", 320, 28),
    new caseTaxe("Taxe de luxe", 100),
    new Terrain("Rue de la paix", 400, 50)
));

public int getNB_CASES() {
    return NB_CASES;
}

public ArrayList<Case> getPlateau() {
    return plateau;
}

public Case getCase(int index){
    return plateau.get(index);
}
	
}
