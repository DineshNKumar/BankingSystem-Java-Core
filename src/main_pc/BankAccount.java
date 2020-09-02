package main_pc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BankAccount {
	String customerFamily;
	String customerName;
	int randomNumber;
	double balance;

	Random random = new Random();

	enum Status {
		ACTIVE, INACTIVE
	}

	public String getCustomerFamily() {
		return customerFamily;
	}

	public void setCustomerFamily(String customerFamily) {
		this.customerFamily = removeEsticks(customerFamily);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = removeEsticks(customerName);
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String accountNumber() {
		String account = "";

		String astrick = "***";

		if (customerFamily.length() < 3 || customerName.length() < 3) {
			customerFamily += astrick;
			customerName += astrick;
		}

		int[] arr = random.ints(1, 10).limit(5).toArray();
		for (int i : arr) {
			account += String.valueOf(i);
		}
		account = customerFamily.substring(0, 3).toUpperCase() + "-" + account + "-"
				+ customerName.substring(0, 3).toUpperCase();

		setCustomerName(removeEsticks(customerName));
		setCustomerFamily(removeEsticks(customerFamily));

		return account;
	}

	public String removeEsticks(String str) {
		int index = 0;
		if (str.contains("*")) {
			index = str.indexOf("*");
			return str.substring(0, index);
		}
		return str;
	}

	public void makeAccount(File file) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(
					getCustomerName() + "," + getCustomerFamily() + "," + accountNumber() + "," + getBalance() + "\n");
			writer.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void menu() {
		System.out.println("1. Create");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Total");
		System.out.println("5. Exit");
	}
}
