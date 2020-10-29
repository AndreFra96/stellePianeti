package stellePianeti;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args){
        ArrayList<Pianeta> pianeti = new ArrayList<>();
        try(Scanner s = new Scanner(new FileInputStream(new File("stellePianeti/pianeti.txt")))){
            while(s.hasNextLine()){
                String[] line = s.nextLine().split(" ");
                Punto posizione = new Punto(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
                Punto speed = new Punto(Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]));
                pianeti.add(new Pianeta(line[0],posizione,speed));
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }

        for(Pianeta actual : pianeti){
            System.out.println(actual);
        }

    }
}