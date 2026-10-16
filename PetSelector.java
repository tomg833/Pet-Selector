/*
 * Pet Selector
 * Name: Tom Glick
 * Period: 3
 * Date: 10/15/26
 *
 * What the program does: gives you an animal based on your chosen color, season, and name
 */

import java.util.Scanner;

public class PetSelector {

    // Returns true if the color is red, blue, or green
    public static boolean isValidColor(String color) {
        return color.equals("red") || color.equals("blue") || color.equals("green");
    }

    // Returns true if the season is winter, spring, summer, or fall
    public static boolean isValidSeason(String season) {
        return season.equals("winter") || season.equals("spring")
                || season.equals("summer") || season.equals("fall");
    }

    // Returns true if the name starts with a letter
    public static boolean isValidName(String name) {
        return name.length() > 0
                && "abcdefghijklmnopqrstuvwxyz".indexOf(name.substring(0, 1).toLowerCase()) >= 0;
    }

    // Returns true if the name starts with a vowel
    public static boolean startsWithVowel(String name) {
        return "aeiou".indexOf(name.substring(0, 1).toLowerCase()) >= 0;
    }

    // Asks the user to enter a valid color, then returns it
    public static String getColor(Scanner input) {
        String color = "";
        while (!isValidColor(color)) {
            System.out.println("Enter your favorite color (red, blue, or green):");
            color = input.nextLine().trim().toLowerCase();
            if (!isValidColor(color)) {
                System.out.println("Invalid color. Please enter red, blue, or green.");
            }
        }
        return color;
    }

    // Asks the user to enter a valid season, then returns it
    public static String getSeason(Scanner input) {
        String season = "";
        while (!isValidSeason(season)) {
            System.out.println("Enter your favorite season (winter, spring, summer, or fall):");
            season = input.nextLine().trim().toLowerCase();
            if (!isValidSeason(season)) {
                System.out.println("Invalid season. Please enter winter, spring, summer, or fall.");
            }
        }
        return season;
    }

    // Asks the user to enter a valid name, then returns it
    public static String getName(Scanner input) {
        String name = "";
        while (!isValidName(name)) {
            System.out.println("Enter your name:");
            name = input.nextLine().trim();
            if (!isValidName(name)) {
                System.out.println("Invalid name. Your name must start with a letter.");
            }
        }
        return name;
    }

    //  Returns the pet
    public static String choosePet(String color, String season, String name) {
        boolean vowel = startsWithVowel(name);
        boolean consonant = !vowel;
        String pet = "";

        // Rule 1
        if (color.equals("blue") && season.equals("fall")) {
            pet = "Alligator";
        }

        // Rule 2
        if (color.equals("blue") && season.equals("spring")) {
            pet = "Ostrich";
        }

        // Rule 3
        if (color.equals("green") && consonant && season.equals("winter")) {
            pet = "Giraffe";
        }

        // Rule 4
        if (color.equals("green") && !season.equals("fall") && !pet.equals("Giraffe")) {
            pet = "Dog";
        }

        // Rule 5
        if (color.equals("red")) {
            if (vowel) {
                pet = "Porcupine";
            } else {
                pet = "Panda";
            }
        }

        // Rule 6
        if (season.equals("summer")
                && !(pet.equals("Dog") || pet.equals("Panda") || pet.equals("Porcupine"))) {
            pet = "Pony";
        }

        // Rule 7
        if (consonant && color.equals("blue")
                && !(season.equals("summer") || season.equals("fall"))
                && !pet.equals("Ostrich")) {
            pet = "Axolotl";
        }

        // Rule 8
        if (pet.equals("")) {
            pet = "Pet Rock";
        }

        return pet;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String color = getColor(input);
        String season = getSeason(input);
        String name = getName(input);

        String pet = choosePet(color, season, name);

        System.out.println();
        System.out.println("Your perfect pet is: " + pet);

        input.close();
    }
}