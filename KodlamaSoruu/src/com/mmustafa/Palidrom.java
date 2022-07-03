package com.mmustafa;

import java.util.Scanner;

public class Palidrom {
	static int v = 0, c = 0, r = 0;
	static boolean b = false, b1 = false;
	
	public static String palindromeTamamlayiciSayi(String sayi) {
		b = false;
		b1 = false;
		c = 0;
		r = 0;
		v = 0;
		int[] list = new int[sayi.length()];
		
		try {
			for (int i = 0; i < sayi.length(); i++) {
				list[i] = Integer.parseInt(Character.toString(sayi.charAt(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "hatali giris";
		}
		int[] listClone = list.clone();
		for (;;) {
			for (int i = 0, j = list.length - 1; i < list.length; i++, j--) {
				if (list[i] != list[j]) {
					break;
				} else if (list.length - 1 == i) {
					b = true;
					break;
					
				}
			}
			if (b) {
				
				break;
			}
			
			if (c > 0) {
				if (list[v] > 9) {
					list[v] = (list[v] - 10);
					if (v > 0) {
						list[v - 1] = (list[v - 1] + 1);
					}
					
				} else {
					
					list[v] = (list[v] + 1);
					
				}
				
			}
			
			for (int i = 0, j = list.length - 1; i < list.length; i++, j--) {
				if (list[i] != list[j]) {
					v = j;
					c++;
					break;
				}
			}
			
		}
		int[] result = new int[sayi.length()];
		int[] cloneAnswer = list.clone();
		r = 0;
		for (int i = (result.length - 1); i >= 0; i--) {
			if ((list[i] - listClone[i]) < 0) {
				r = i - 1;
				result[i] += (10 - Math.abs(list[i] - listClone[i]));
				list[r] = list[r] - 1;
			} else {
				result[i] = result[i] + (list[i] - listClone[i]);
			}
			
			// System.out.print(result[i] + " res ");
		}
		StringBuilder builder = new StringBuilder();
		StringBuilder builder3 = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0 || i == result.length - 1) {
				b1 = true;
			}
			if (b1) {
				builder.append(Integer.toString(result[i]));
			}
			
			builder3.append(cloneAnswer[i]);
		}
		StringBuilder builder2 = new StringBuilder();
		builder2.append("(" + sayi).append(" + ").append(builder.toString()).append(" sonucunda olusan ")
				.append(builder3.toString()).append(" palindromdur.)");
		return builder2.toString();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			System.out.println("***********************************");
			System.out.println("Lutfen Deger Giriniz : ");
			String value = scanner.nextLine();
			if (value.equals("exit")) {
				scanner.close();
				System.exit(0);
			}
			System.out.println("**********SONUC**************");
			
			System.out.println(palindromeTamamlayiciSayi(value));
			System.gc();
			System.out.println("Cikis icin exit yaziniz: ");
			System.out.println("\n***************YENI DEGER***********************");
			
		}
		
	}
}
