// Author Name: Andy Falkowski
// Date: 5/28/2021
// Program Name: Falkowski_SpellChecker
// Purpose: Perform spell checking by comparing words in a document file to a dictionary file

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Falkowski_SpellChecker {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String docFile;   // name of file to be spell checked
		ArrayList<String> words = new ArrayList<>();  // ArrayList to hold words to check

		String dictionary;   // name of dictionary file
		ArrayList<String> definitions = new ArrayList<>();  // ArrayList to hold words from dictionary
		
		do {
			System.out.println("Please enter name of file to be checked: ");
			docFile = input.nextLine();

			docFile = addToList(words,docFile);
		} while (docFile == null);  // continue to prompt until valid file name is entered

		System.out.println();
		
		do {
			System.out.println("Please enter name of the dictionary file: ");
			dictionary = input.nextLine();

			dictionary = addToList(definitions,dictionary);
		} while (dictionary == null);  // continue to prompt until valid file name is entered

		System.out.println();

		boolean match;

		for (String word: words) {
			match = false;
			for (String definition: definitions) {
				if (word.equals(definition)) {
					match = true;
				}

			}
			if (match == false)
				System.out.println(word + " is an unknown word.");
		}
		input.close();
	}
	
	// method for making sure file name is valid and then adding words to array list
	public static String addToList(ArrayList<String> list, String fileName) {
		try(Scanner fileInput = new Scanner(new File(fileName))) {
			while (fileInput.hasNext()) {	// if file name is valid, read each word and then add to ArrayList
				list.add(fileInput.nextLine());
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not found. Please re-enter.");
			fileName = null;   // set docFile variable to null so user will be prompted to enter file name again
		}
		return fileName;
	}
}