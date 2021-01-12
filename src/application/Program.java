package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		List<Employee> employees = new ArrayList<>();
		try {
			System.out.print("Qual a quantidade de funcionários: ");
			int n = input.nextInt();

			for (int i = 1; i <= n; i++) {
				System.out.println("\nEntre com os dados do funcionário nº" + i + ".");
				System.out.print("Funcionário terceirizado? (y/n) ");
				char ch = input.next().charAt(0);

				System.out.print("Nome: ");
				input.nextLine();
				String name = input.nextLine();
				System.out.print("Quantidade de horas: ");
				int hours = input.nextInt();
				System.out.print("Valor por hora: R$ ");
				double valuePerHour = input.nextDouble();

				if (ch == 'y' || ch == 'Y') {
					System.out.print("Taxa adicional: R$ ");
					double additionalCharge = input.nextDouble();
					employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
				} else {
					employees.add(new Employee(name, hours, valuePerHour));
				}
			}

			System.out.println("\nPAYMENT:");
			for (Employee emp : employees) {
				System.out.println(emp);
			}
		} catch (RuntimeException e) {
			System.out.println("Você inseriu um tipo de dado inadequado para a operação!");
			System.out.println("Reinicie o programa para tentar novamente.");
		} finally {
			input.close();
		}
	}
}
