package Threads;

import java.util.Scanner;

class s1 extends Thread {
	 private int n;
	 private double sum1;
	 
	 public s1(int n) {
		 this.n = n;
	 }
	 public void run() {
		 sum1 = 1;
		 for(int i=1; i<=n; i++) {
			 sum1 *=i;
		 }
	 }
	 public double getSum1() {
		 return sum1;
	 }
}

class s2 extends Thread {
	private int n;
	private double sum2;
	
	public s2(int n) {
		this.n = n;
	}
	
	public void run() {
		sum2=0;
		for(int i=1; i<=n; i++) {
			sum2 += i;
		}
	}
	public double getSum2() {
		return sum2;
	}
}

class s3 extends Thread {
	int n;
	double sum3;
	
	public s3 (int n) {
		this.n = n;
	}
	
	public void run() {
		sum3=0;
		for(int i=2; i<=n; i+=2) {
			sum3+=i;
		}
	}
	
	public double getSum3() {
		return sum3;
	}
}

public class test {
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập 1 số tự nhiên n ");
	    int n = scanner.nextInt();
		scanner.close();
		
		s1 gt = new s1(n);
		s2 tong = new s2(n);
		s3 tongeven = new s3(n);
		
		gt.start();
		tong.start();
		tongeven.start();
		
		gt.join();
		tong.join();
		tongeven.join();
		
		System.out.println("tổng giai thừa: "+gt.getSum1());
		Thread.sleep(2000);
		System.out.println("tổng 1 - n: "+tong.getSum2());
		Thread.sleep(2000);
		System.out.println("tổng số chẵn 1 - n: "+tongeven.getSum3());
		Thread.sleep(2000);
		System.out.println("Tổng S = s1 + s2 + s3 là: "+(gt.getSum1()+tong.getSum2()+tongeven.getSum3()));
	}

}
