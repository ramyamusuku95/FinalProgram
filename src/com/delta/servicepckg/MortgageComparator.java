package com.delta.servicepckg;

import java.util.Comparator;

public class MortgageComparator {

	private String name;
	double balance;
	double interest_rate;
	double current_monthly_payment;
	double extra_monthly_payment;
	double new_payment;
	double current_duration_inmonths;
	double current_duration_inyears;
	double current_interest;
	double new_duration_inmonths;
	double new_duration_inyears;
	double new_interest;
	double savings;
	String fees;

	public MortgageComparator() {

	}

	public MortgageComparator(String a, double balance, double interest_rate, double current_monthly_payment,
			double extra_monthly_payment, double current_duration_inmonths, double current_duration_inyears,
			double new_duration_inmonths, double new_duration_inyears, double current_interest, double new_interest,
			double savings, String fees, double new_payment) {
		this.name = a;
		this.balance = balance;
		this.interest_rate = interest_rate;
		this.current_monthly_payment = current_monthly_payment;
		this.extra_monthly_payment = extra_monthly_payment;
		this.current_duration_inmonths = current_duration_inmonths;
		this.current_duration_inyears = current_duration_inyears;
		this.new_duration_inmonths = new_duration_inmonths;
		this.new_duration_inyears = new_duration_inyears;
		this.current_interest = current_interest;
		this.new_interest = new_interest;
		this.savings = savings;
		this.fees = fees;
		this.new_payment = new_payment;
	}

	/* Comparator for sorting the list by roll no */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}

	public double getCurrent_monthly_payment() {
		return current_monthly_payment;
	}

	public void setCurrent_monthly_payment(double current_monthly_payment) {
		this.current_monthly_payment = current_monthly_payment;
	}

	public double getExtra_monthly_payment() {
		return extra_monthly_payment;
	}

	public void setExtra_monthly_payment(double extra_monthly_payment) {
		this.extra_monthly_payment = extra_monthly_payment;
	}

	public double getNew_payment() {
		return new_payment;
	}

	public void setNew_payment(double new_payment) {
		this.new_payment = new_payment;
	}

	public double getCurrent_duration_inmonths() {
		return current_duration_inmonths;
	}

	public void setCurrent_duration_inmonths(double current_duration_inmonths) {
		this.current_duration_inmonths = current_duration_inmonths;
	}

	public double getCurrent_duration_inyears() {
		return current_duration_inyears;
	}

	public void setCurrent_duration_inyears(double current_duration_inyears) {
		this.current_duration_inyears = current_duration_inyears;
	}

	public double getCurrent_interest() {
		return current_interest;
	}

	public void setCurrent_interest(double current_interest) {
		this.current_interest = current_interest;
	}

	public double getNew_duration_inmonths() {
		return new_duration_inmonths;
	}

	public void setNew_duration_inmonths(double new_duration_inmonths) {
		this.new_duration_inmonths = new_duration_inmonths;
	}

	public double getNew_duration_inyears() {
		return new_duration_inyears;
	}

	public void setNew_duration_inyears(double new_duration_inyears) {
		this.new_duration_inyears = new_duration_inyears;
	}

	public double getNew_interest() {
		return new_interest;
	}

	public void setNew_interest(double new_interest) {
		this.new_interest = new_interest;
	}

	public double getSavings() {
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public static Comparator<MortgageComparator> getStuRollno() {
		return StuRollno;
	}

	public static void setStuRollno(Comparator<MortgageComparator> stuRollno) {
		StuRollno = stuRollno;
	}

	public static Comparator<MortgageComparator> StuRollno = new Comparator<MortgageComparator>() {

		public int compare(MortgageComparator s1, MortgageComparator s2) {

			double rollno1 = s1.getSavings();
			double rollno2 = s2.getSavings();

			/* For descending order */
			return (int) ((int) rollno2 - rollno1);
		}
	};
}
