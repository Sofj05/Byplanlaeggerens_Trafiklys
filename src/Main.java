import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Hvad tid på døgnet er det? (Dag, Aften, Nat)");
        String time = input.nextLine();

        System.out.println("Er trafikmængden høj eller lav?");
        String trafficMass = input.nextLine();

        System.out.println("I hvilket område kører du? (Bolig, Erhverv, Blandet)");
        String area = input.nextLine();

        System.out.println("Er der en nødsituation? (True/False)");
        boolean emergency = input.nextBoolean();

        String light = "";
        String access = "";

// Første: bestemme lysfarve
        if (emergency) {
            light = "Grønt lys (Nødsituation)";
        } else {
            switch (time) {
                case "Dag":
                    if (trafficMass.equals("Lav")) {
                        light = "Grønt Lys";
                    } else {
                        light = "Rødt lys"; // Høj trafik om dagen
                    }
                    break;

                case "Aften":
                    light = "Gult lys";
                    break;

                case "Nat":
                    if (trafficMass.equals("Høj")) {
                        light = "Rødt lys";
                    } else {
                        light = "Gult lys"; //nat med lav trafik
                    }
                    break;
                default:
                    light = "Ugyldigt tidspunkt";
            }
        }

        // Dernæst: bestemme adgang
        if (area.equals("Erhverv") || (area.equals("Blandet") && trafficMass.equals("Lav"))) {
            access = "Adgang tilladt";
        } else if (area.equals("Bolig") && time.equals("Nat")) {
                access = "Adgang forbudt (Boligområde om natten)";
            } else {
                access = "Adgang begrænset til beboere og gæster i dagstimerne";
        }

            System.out.println("Trafiklys status: " + light);
            System.out.println("Adgangs status: " + access);


        }
    }
