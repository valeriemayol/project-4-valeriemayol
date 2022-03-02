import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.FileInputStream;



    public class Lab4 {

        public static int CompareMovies(ArrayList<DisneyMovie> disneyMovies, Comparator<DisneyMovie> c, int first, int second){
            return c.compare(disneyMovies.get((first)), disneyMovies.get(second));

        }

        public static void Swap(ArrayList<DisneyMovie> disneyMovies, int first, int second){
           DisneyMovie tempTT = new DisneyMovie(disneyMovies.get((first)));
           disneyMovies.set(first, disneyMovies.get(second));
           disneyMovies.set(second, tempTT);


        }

        public static void Sort(ArrayList<DisneyMovie> disneyMovies, int N){
            boolean notSorted = true;

            while (notSorted){
                notSorted = false;

                for (int i = 0; i< N - 1; i++){
                    if (CompareMovies(disneyMovies, new CompareTotalGross(), i, i + 1) > 0){ //Might need to change compareTotalGross
                        Swap(disneyMovies, i, i +1);
                        notSorted = true;


                    }
                }
            }
        }

        public static void main(String[] args) throws FileNotFoundException {

            Scanner scnr = new Scanner(System.in);
            System.out.println("Enter file name");
            String inputFileName = scnr.nextLine();

            String base =  "C:\\Users\\valer\\IdeaProjects\\project-4-valeriemayol\\src\\";
            String fileName = base + inputFileName;
            FileInputStream inputFileNameStream = null;
            Scanner inputFileNameScanner = null;

            inputFileNameStream = new FileInputStream(inputFileName);
            inputFileNameScanner = new Scanner(inputFileNameStream);


            if (args.length == 1){
                fileName = args[0];

                try{
                    inputFileNameStream = new FileInputStream(fileName);
                } catch (FileNotFoundException e){
                    System.out.println("Could not open");
                }
            }
            ArrayList<DisneyMovie> disneyMovies = new ArrayList<DisneyMovie>();

            //skip first line
            inputFileNameScanner.nextLine();

            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(",");
            disneyMovies.add(new DisneyMovie(parts[0],parts[1], parts[2], parts[3],Integer.parseInt(parts[4]),Integer.parseInt(parts[5])));




            while (inputFileNameScanner.hasNextLine()) {
                line = inputFileNameScanner.nextLine();
                parts = line.split(",");
                disneyMovies.add(new DisneyMovie(parts[0],parts[1], parts[2], parts[3],Integer.parseInt(parts[4]),Integer.parseInt(parts[5])));

            }

            long start = System.currentTimeMillis();

            Sort(disneyMovies, disneyMovies.size());

            long finish = System.currentTimeMillis();

            long totalTime = finish - start;
            System.out.println(totalTime);

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("sortedDataSet.txt"));
                for (int i = 0; i < disneyMovies.size(); i++) {
                    String temp = disneyMovies.toString();
                    writer.write(temp + "/n");
                }
                writer.close();
            } catch (Exception e) {
                System.out.println("Error: No File Found");
            }
        }
    }
