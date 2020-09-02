package main_pc;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BankAccount a = new BankAccount();

		File file = new File("accounts.in");

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		String name = "";
		double amount = 0;

		outer: while (true) {
			a.menu();
			System.out.println("Enter your choice :- ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Customer Name : ");
				name = scanner.next();
				a.setCustomerName(name);

				System.out.println("Customer Family : ");
				name = scanner.next();
				a.setCustomerFamily(name);

				a.accountNumber();

				System.out.println("Amount : ");
				amount = scanner.nextDouble();
				a.setBalance(amount);
				a.makeAccount(file);
				break;
			case 2:
				System.out.println("Deposit amount : ");
				amount = scanner.nextDouble();
				amount = a.getBalance() + amount;
				a.setBalance(amount);
				a.makeAccount(file);
				break;
			case 3:
				System.out.println("Withdrawal : ");
				amount = scanner.nextDouble();
				if (amount < a.getBalance()) {
					amount = a.getBalance() - amount;
					a.setBalance(amount);
				} else {
					System.out.println("Not sufficient balance");
				}
				a.makeAccount(file);
				break;
			case 4:
				System.out.println("Total money : " + a.getBalance());
			default:
				scanner.close();
				break outer;
			}
		}
	}
}
