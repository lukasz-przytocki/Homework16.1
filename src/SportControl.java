import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SportControl {

    void addPlayer(String fileName) throws IOException {
        String firstName;
        String lastName;
        int result;
        List<Player> players = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj imie zawodnika: ");
        firstName = scan.nextLine();
        while (!(firstName.contains("stop"))) {
            System.out.println("Podaj nazwisko zawodnika: ");
            lastName = scan.nextLine();
            System.out.println("Podaj wynik: ");
            result = scan.nextInt();
            scan.nextLine();
            players.add(new Player(firstName, lastName, result));
            System.out.println("Podaj imie zawodnika: ");
            firstName = scan.nextLine();
        }
        saveToFile(fileName,players);
    }

    private void saveToFile(String fileName, List<Player> players) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bfw = new BufferedWriter(fileWriter);
        Collections.sort(players);
        for (int i = 0; i < players.size(); i++) {
            bfw.write(players.get(i).getPlayerData());
            bfw.newLine();

        }
        bfw.close();
    }


    void addPlayerString(String fileName) throws IOException { //drugi sposób
        String userData;
        String[] userDataTable;
        List<Player> players = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wynik kolejnego gracza Imie Nazwisko wynik (lub stop): ");
        userData = scan.nextLine();
        while (!(userData.contains("stop"))) {
            userDataTable= userData.split(" ");
            players.add(new Player(userDataTable[0], userDataTable[1], Integer.valueOf(userDataTable[2])));
            System.out.println("Podaj wynik kolejnego gracza Imie Nazwisko wynik (lub stop): ");
            userData = scan.nextLine();
        }
        saveToFile(fileName,players);
    }

}
