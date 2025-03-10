package Threads;

import java.util.Scanner;

class Sum1 extends Thread {
	private int n;
	private int tong;
	
	public Sum1(int n) {
		this.n = n;
	}
	@Override
	public void run() {
		tong = 0;
		for(int i=1;i<=n;i++) {
			tong += i;
		}
	}
	
	public int tong() {
		return tong;
	}
}

class Giaithua extends Thread {
	private int n;
	private int tong2;
	
	public Giaithua (int n) {
		this.n = n;
	}
	@Override
	public void run() {
		tong2=1;
		for(int i=1;i<=n;i++) {
			tong2*=i;
		}
	}
	
	public int tong2() {
		return tong2;
	}
}

class Tongsochan extends Thread {
	private int n;
	private int tong3;
	
	public Tongsochan(int n) {
		this.n = n;
	}
	@Override
	public void run() {
		tong3=0;
		for(int i=2;i<=n;i+=2) {
			tong3+=i;
		}
	}
	
	public int tong3() {
		return tong3;
	}
}

public class Test2 {
	public static void main(String[] args) throws InterruptedException{		
		Scanner sc = new Scanner(System.in);
		System.out.print("Hãy nhập số tự nhiên n: ");
		int n = sc.nextInt();
		sc.close();
		
		Sum1 s1 = new Sum1(n);
		Giaithua s2 = new Giaithua(n);
		Tongsochan s3 = new Tongsochan(n);
		
		s1.start();
		s2.start();
		s3.start();
		
		s1.join();
		s2.join();
		s3.join();
		
		System.out.println("Đang xử lý!");
		Thread.sleep(3000);
		System.out.println("Đang tính tổng từ 1 đến n...");
		Thread.sleep(3000);
		System.out.println("Đang tính tổng giai thừa 1 đến n...");
		Thread.sleep(3000);
		System.out.println("Đang tính tổng các số chẵn từ 1 đến n...");
		Thread.sleep(3000);
		System.out.println("Đang tính tổng trên S = S1 + S2 + S3...");
		System.out.println("Đã xong, kết quả là: "+(s1.tong()+s2.tong2()+s3.tong3()));
	}

}
