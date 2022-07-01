package com.mmustafa;

import java.util.Scanner;

public class Palidrom {
	static int a = 0, result = 0;
	
	public static String palindromeTamamlayiciSayi(String sayi) {
		
		try {
			a = Integer.parseInt(sayi);
		} catch (Exception e) {
			e.printStackTrace();
			return "Bu Format Desteklenmemektedir :/ ";
		}
		for (int i = 0;; i++) {
			
			int r, sum = 0, temp;
			int n = a + i;
			
			temp = n;
			while (n > 0) {
				r = n % 10;
				sum = (sum * 10) + r;
				n = n / 10;
			}
			if (temp == sum) {
				result = i;
				break;
			}
			
		}
		StringBuilder builder = new StringBuilder();
		builder.append("(" + Integer.toString(a)).append(" + ").append(Integer.toString(result))
				.append(" sonucunda olusan ").append(Integer.toString(a + result)).append(" palindromdur.)");
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			System.out.println("***********************************");
			System.out.println("Lutfen Deger Giriniz : ");
			String value = scanner.nextLine();
			if (value.equals("exit")) {
				break;
			}
			System.out.println("**********SONUC**************");
			System.out.println(palindromeTamamlayiciSayi(value));
			System.out.println("\n***************YENI DEGER***********************");
			System.out.println("Cikis icin exit yaziniz: ");
			
		}
		
	}
}
