package edu.gatech.cs2340.game.entity;

import java.util.HashSet;
import java.util.Random;

public enum PlanetNames {

    ACAMAR("Acamar"),
    ADAHN("Adahn"),		// The alternate personality for The Nameless One in "Planescape: Torment"
    ALDEA("Aldea"),
    ANDEVIAN("Andevian"),
    ANTEDI("Antedi"),
    BALOSNEE("Balosnee"),
    BARATAS("Baratas"),
    BRAX("Brax"),			// One of the heroes in Master of Magic
    BRETEL("Bretel"),		// This is a Dutch device for keeping your pants up.
    CALONDIA("Calondia"),
    CAMPOR("Campor"),
    CAPELLE("Capelle"),		// The city I lived in while programming this game
    CARZON("Carzon"),
    CASTOR("Castor"),		// A Greek demi-god
    CESTUS("Cestus"),
    CHERON("Cheron"),
    COURTENEY("Courteney"),	// After Courteney Cox…
    DALED("Daled"),
    DAMAST("Damast"),
    DAVLOS("Davlos"),
    DENEB("Deneb"),
    DENEVA("Deneva"),
    DEVIDIA("Devidia"),
    DRAYLON("Draylon"),
    DREMA("Drema"),
    ENDOR("Endor"),
    ESMEE("Esmee"),		// One of the witches in Pratchett's Discworld
    EXO("Exo"),
    FERRIS("Ferris"),		// Iron
    FESTEN("Festen"),		// A great Scandinavian movie
    FOURMI("Fourmi"),		// An ant, in French
    FROLIX("Frolix"),		// A solar system in one of Philip K. Dick's novels
    GEMULON("Gemulon"),
    GUINIFER("Guinifer"),		// One way of writing the name of king Arthur's wife
    HADES("Hades"),		// The underworld
    HAMLET("Hamlet"),		// From Shakespeare
    HELENA("Helena"),		// Of Troy
    HULST("Hulst"),		// A Dutch plant
    IODINE("Iodine"),		// An element
    IRALIUS("Iralius"),
    JANUS("Janus"),		// A seldom encountered Dutch boy's name
    JAPORI("Japori"),
    JARADA("Jarada"),
    JASON("Jason"),		// A Greek hero
    KAYLON("Kaylon"),
    KHEFKA("Khefka"),
    KIRA("Kira"),			// My dog's name
    KLAATU("Klaatu"),		// From a classic SF movie
    KLAESTRON("Klaestron"),
    KORMA("Korma"),		// An Indian sauce
    KRAVAT("Kravat"),		// Interesting spelling of the French word for "tie"
    KRIOS("Krios"),
    LAERTES("Laertes"),		// A king in a Greek tragedy
    LARGO("Largo"),
    LAVE("Lave"),			// The starting system in Elite
    LIGON("Ligon"),
    LOWRY("Lowry"),		// The name of the "hero" in Terry Gilliam's "Brazil"
    MAGRAT("Magrat"),		// The second of the witches in Pratchett's Discworld
    MALCORIA("Malcoria"),
    MELINA("Melina"),
    MENTAR("Mentar"),		// The Psilon home system in Master of Orion
    MERIK("Merik"),
    MINTAKA("Mintaka"),
    MONTOR("Montor"),		// A city in Ultima III and Ultima VII part 2
    MORDAN("Mordan"),
    MYRTHE("Myrthe"),		// The name of my daughter
    NELVANA("Nelvana"),
    NIX("Nix"),			// An interesting spelling of a word meaning "nothing" in Dutch
    NYLE("Nyle"),			// An interesting spelling of the great river
    ODET("Odet"),
    OG("Og"),			// The last of the witches in Pratchett's Discworld
    OMEGA("Omega"),		// The end of it all
    OMPHALOS("Omphalos"),		// Greek for navel
    ORIAS("Orias"),
    OTHELLO("Othello"),		// From Shakespeare
    PARADE("Parade"),		// This word means the same in Dutch and in English
    PENTHARA("Penthara"),
    PICARD("Picard"),		// The enigmatic captain from ST:TNG
    POLLUX("Pollux"),		// Brother of Castor
    QUATOR("Quator"),
    RAKHAR("Rakhar"),
    RAN("Ran"),			// A film by Akira Kurosawa
    REGULAS("Regulas"),
    RELVA("Relva"),
    RHYMUS("Rhymus"),
    ROCHANI("Rochani"),
    RUBICUM("Rubicum"),		// The river Ceasar crossed to get into Rome
    RUTIA("Rutia"),
    SARPEIDON("Sarpeidon"),
    SEFALLA("Sefalla"),
    SELTRICE("Seltrice"),
    SIGMA("Sigma"),
    SOL("Sol"),			// That's our own solar system
    SOMARI("Somari"),
    STAKORON("Stakoron"),
    STYRIS("Styris"),
    TALANI("Talani"),
    TAMUS("Tamus"),
    TANTALOS("Tantalos"),		// A king from a Greek tragedy
    TANUGA("Tanuga"),
    TARCHANNEN("Tarchannen"),
    TEROSA("Terosa"),
    THERA("Thera"),		// A seldom encountered Dutch girl's name
    TITAN("Titan"),		// The largest moon of Jupiter
    TORIN("Torin"),		// A hero from Master of Magic
    TRIACUS("Triacus"),
    TURKANA("Turkana"),
    TYRUS("Tyrus"),
    UMBERLEE("Umberlee"),		// A god from AD&D, which has a prominent role in Baldur's Gate
    UTOPIA("Utopia"),		// The ultimate goal
    VADERA("Vadera"),
    VAGRA("Vagra"),
    VANDOR("Vandor"),
    VENTAX("Ventax"),
    XENON("Xenon"),
    XERXES("Xerxes"),		// A Greek hero
    YEW("Yew"),			// A city which is in almost all of the Ultima games
    YOJIMBO("Yojimbo"),		// A film by Akira Kurosawa
    ZALKON("Zalkon"),
    ZUUL("Zuul");			// From the first Ghostbusters movie

    private String name;
    private static PlanetNames[] allNames = PlanetNames.values();
    private static Random rand = new Random();
    private static HashSet<PlanetNames> used = new HashSet<>();

    private PlanetNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static final String randomPlanetName(){
        PlanetNames tmp = allNames[rand.nextInt(allNames.length)];
        while(used.contains(tmp)) {
            tmp = allNames[rand.nextInt(allNames.length)];
        }
        return tmp.getName();
    }

    public void refreshUsed(){
        used = new HashSet<>();
        System.out.printf("WARNING: RESETTING USED NAMES!");
    }
}
