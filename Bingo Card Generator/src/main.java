import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        //Wieviele spalten soll der ArrayList haben
        int column = 5;
        //Wieviele Reihen soll die ArrayList in der ArrayList haben?
        int row = 5;

        //Erstellt eine ArrayList des Types String welche in einer ArrayList enthalten ist
        ArrayList<ArrayList> bingo = new ArrayList<>(column);
        for (int i = 0; i < column; i++) {
            bingo.add(new ArrayList<>());
        }

        //i dient zum erkennen, in welcher Spalte man sich befindet!
        for (int i = 0; i < column; i++) {

            // initialisieren und Deklarieren der rndNmb
            int rndNmb = 0;

            // Errechnen des Zusätzlichen Zählers, anhand der Frage:"In welcher reihe befindet sich der Wertebereich"
            int nmbCol = i * 15;

            //J dient zum erkennen, in welcher Reihe man sich befindet!
            int j = 0;

            while (j < row) {
                //Erster Schritt zum erstellen einer zufälligen Zahl: deklariere eine zahl mit Math.random()-16 -1 zwischen 0> und <16
                rndNmb = (int) (Math.floor((Math.random() * 16 - 1)));

                //Falls rndNmb weniger als 1 ist, soll wiederholt eine Schleife ausgeführt werden, bis 1 oder mehr erreicht ist
                while (rndNmb < 1) {
                    rndNmb = (int) (Math.floor((Math.random() * 16 - 1)));
                }

                //Zweiter Schritt zum erstellen einer zufälligen ZahlFüge zu rndNmb den wert aus nmbCol hinzu
                rndNmb += nmbCol;

                //Wenn NICHT in der multiListe bingo[column] enthalten, dann füge hinzu und erhöhe den wert j um 1
                if (!bingo.get(i).contains(rndNmb)) {
                    bingo.get(i).add(j, rndNmb);
                    j++;
                }
            }
        }

        //Ersetzt den entsprechenden Eintrag mit "Bingo"
        bingo.get(2).set(2, "BINGO");

            //Zählt für bingo.size den zähler i nach oben
            for (int i = 0; i < bingo.size(); i++) {

                //Zählt für bingo.get(i).size() den zähler j nach oben. j
                for (int j = 0; j < bingo.get(i).size(); j++) {
                    System.out.printf("%1s %5s %1s", "", bingo.get(j).get(i), "");
                }
                System.out.println();
            }
            
    }
}
