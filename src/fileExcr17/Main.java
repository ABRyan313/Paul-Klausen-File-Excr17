package fileExcr17;

import java.io.*;

public class Main {

	public static void main(String[] args) {

		test1();
		try {

			test2();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	private static int[] createNumber() {

		int[] numbers = new int[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		return numbers;
	}

	private static void test1() {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("Numbers.txt"));
			stream.writeObject(createNumber());
			stream.close();

		} catch (IOException e) {
			System.out.println("Whatever");
		}
	}

	private static void printSum(int[] numbers) {

		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {

			sum += numbers[i];
		}

		System.out.println(sum);

	}

	private static void test2() throws ClassNotFoundException {
		try {

			ObjectInputStream stream = new ObjectInputStream(new FileInputStream("Numbers.txt"));
			printSum((int[]) stream.readObject());
			stream.close();

		} catch (IOException E) {
			System.out.println(E.getMessage());
		}
	}

}
