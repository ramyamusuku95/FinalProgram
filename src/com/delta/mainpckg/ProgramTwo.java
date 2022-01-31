package com.delta.mainpckg;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.delta.servicepckg.MortgageComparator;

public class ProgramTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<MortgageComparator> list = new ArrayList<>();

		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		System.out.print("Enter the number of entries to calculate mortgage- ");
		int n = sc.nextInt();
		final DecimalFormat dfZero = new DecimalFormat("#");

		String names[] = new String[n];
		double balances[] = new double[n];
		double interest[] = new double[n];
		double monthly_payments[] = new double[n];
		double extra_payments[] = new double[n];
		double new_payment[] = new double[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter the name of borrower: ");
			names[i] = sc.next();
			System.out.print("Enter the mortgage balance: ");
			String balance = sc.next();
			if(balance.startsWith("$")){
	   		       String[] splitString = balance.split(Pattern.quote("$"));
	   		       balances[i]=Double.parseDouble(splitString[1]);
	   		} else {
	   		    	balances[i]=Double.parseDouble(balance);
	   		}
			System.out.print("Enter the annual interest rate: ");
			interest[i] = sc.nextDouble();
			System.out.print("Enter the current monthly payment: ");
			String monthly_payment = sc.next();
			 if(monthly_payment.startsWith("$")){
	            	String[] splitMonthlyPayment = monthly_payment.split(Pattern.quote("$"));
	            	monthly_payments[i]=Double.parseDouble(splitMonthlyPayment[1]);
	        } else {
	        		monthly_payments[i]=Double.parseDouble(monthly_payment);
	        }
			System.out.print("Enter the extra monthly payment: ");
			String extra_payment = sc.next();
			if(extra_payment.startsWith("$")){
            	String[] splitExtraPayment = extra_payment.split(Pattern.quote("$"));
            	extra_payments[i]=Double.parseDouble(splitExtraPayment[1]);
        	} else {
        		extra_payments[i]=Double.parseDouble(extra_payment);
        	}
			System.out.println();
		}
		for (int i = 0; i < n; i++) {
			double new_payment1 = monthly_payments[i] + extra_payments[i];
			new_payment[i] = new_payment1;

			double interest_rate = (interest[i] / 100) / 12;
			double current_duration_var = (monthly_payments[i] / interest_rate);
			double current_duration_var_formula = current_duration_var / (current_duration_var - balances[i]);
			double currentDuration = (Math.log(current_duration_var_formula) / Math.log(1 + interest_rate));
			double newDuration_var = new_payment1 / interest_rate;
			double newDuration_var_formula = newDuration_var / (newDuration_var - balances[i]);
			double new_Duration = (Math.log(newDuration_var_formula) / Math.log(1 + interest_rate));
			double current_duration_in_months = Math.round(currentDuration % 12);
			double current_duration_in_years = Math.floor(currentDuration / 12);
			double new_duration_in_months = Math.round(new_Duration % 12);
			double new_duration_in_years = Math.floor(new_Duration / 12);
			double current_interest = (monthly_payments[i] * Math.round(currentDuration)) - balances[i];
			double new_interest = (new_payment1 * Math.round(new_Duration)) - balances[i];
			double savings = current_interest - new_interest;
			String fee1 = null;
			if (new_Duration <= (currentDuration / 2)) {
				fee1 = "Extra Fees";

			} else {
				fee1 = "No Fees";
			}
			System.out.println();

			MortgageComparator mortgageW = new MortgageComparator(names[i], balances[i], interest[i],
					monthly_payments[i], extra_payments[i], current_duration_in_months, current_duration_in_years,
					new_duration_in_months, new_duration_in_years, current_interest, new_interest, savings, fee1,
					new_payment1);
			list.add(mortgageW);
		}

		Collections.sort(list, MortgageComparator.StuRollno);
		System.out.println("Name" + "     " + "|Mortgage Balance|" + "  " + "Interest Rate|" + "   " + "Payment" + "  "
				+ "   " + "Current Duration" + "  " + "Interest|" + "    " + "Payment" + "  " + "New Duration" + "   "
				+ "Interest" + "  " + "|Savings" + "   " + "|Fees");

		System.out.println(
				"_ _ _ _ _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ _ _ _ __  _ _ _ _ _ _ _ _ _ _ _ _ _ _ __  _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ _ _ __ _ _ _ _ _ _ _ _ _ ");

		for (MortgageComparator mortgageNew : list) {
			System.out.print(mortgageNew.getName() + "    ");
			System.out.print("$" + String.format("%.2f", mortgageNew.getBalance()) + "            ");
			System.out.print(String.format("%.3f", mortgageNew.getInterest_rate()) + "%" + "            ");
			System.out.print("$" + String.format("%.2f", mortgageNew.getCurrent_monthly_payment()) + "         ");
			System.out.print(dfZero.format(mortgageNew.getCurrent_duration_inyears()) + "yrs" + " "
					+ dfZero.format(mortgageNew.getCurrent_duration_inmonths()) + "mo" + "    ");
			System.out.print("$" + String.format("%.2f", mortgageNew.getCurrent_interest()) + "   ");
			System.out.print("$"+String.format("%.2f", mortgageNew.getNew_payment()) + "    ");
			System.out.print(dfZero.format(mortgageNew.getNew_duration_inyears()) + "yrs" + " "
					+ dfZero.format(mortgageNew.getNew_duration_inmonths()) + "mo" + "    ");
			System.out.print("$" + String.format("%.2f", mortgageNew.getNew_interest()) + "   ");
			System.out.print("$" + String.format("%.2f", mortgageNew.getSavings()) + "   ");
			// System.out.print(mortgageNew.getSavings()+" ");
			System.out.print(mortgageNew.getFees());

			System.out.println();

		}
	}

}
