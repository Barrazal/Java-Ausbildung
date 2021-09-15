import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Schreibe ein kleines Programm, welches einen String über die Konsole einliest. Übersetzte den Text dann in Leetspeak - Du darfst dir hier eine beliebige Konfiguration verwenden, falls dir keine einfällt hier ein Vorschlag:
        //Wenn du eine andere verwendest bitte in einer Markdown Datei deine Wahl angeben ;)

        //Nutze StringBuilder!





        //Uebung buch seite 142:
        String linuxPfad = "/media/usbstick/daten/unfug";
        String windowsPfad ="";
        System.out.println("vorher : " + linuxPfad);
        System.out.println("vorher : " + windowsPfad);


        int pos = 0;        //Aktuelle Position im String
        int oldpos = 0;     //wo wir zueltz waren
        //wiederholen, wenn es noch weitere Schrägstriche gibt

        while(pos>=0){
            pos = linuxPfad.indexOf('/',oldpos);
            if(pos>=0){
                //Der Windows-Pfad ist der alte
                //plus dem Backslash
                //und dem Pfad zwischen den Schrägstrichen.
                if (pos>oldpos){
                    windowsPfad = windowsPfad + '\\' + linuxPfad.substring(oldpos,pos);
                }
                oldpos = pos+1;
            }
        }
        //Sollte nach dem letzten Schrägstrich noch ein Pfad
        //kommen, muss der natürlich auch übernommen werden.
        if (oldpos<linuxPfad.length()){
            windowsPfad = windowsPfad + '\\' + linuxPfad.substring(oldpos,linuxPfad.length());
        }
        System.out.println("nachher : " + linuxPfad);
        System.out.println("nachher : " + windowsPfad);

    }
}

