package com.capgemini.bank;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		System.out.println("welcome to CapG atm ");
		System.out.println("1.Deposit");
		System.out.println("2.Withdraw");
		System.out.println("3.Exit");
		int choice;
		
		IBank b=Util.getObject();
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			b.deposit();
			System.out.println("sda");
			break;
		case 2:
			b.withdraw();
			
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("D");
		}
	}

}
