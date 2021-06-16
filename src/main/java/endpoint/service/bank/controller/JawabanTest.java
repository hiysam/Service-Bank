package endpoint.service.bank.controller;

import java.util.Scanner;

public class JawabanTest {
	
	public static void main(String[] args) {
		JawabanTest app = new JawabanTest();
		//app.soalSatu();
		app.soalDua();
	}

	private void soalDua() {
		// TODO Auto-generated method stub
		 /*String[][]angka = {
		            {"7","3","9"},
		            {"8","6","9"},
		            {"1","2","5"},        
		        };*/
		 String[][]angka = {
		            {"9","3","5","4","8"},
		            {"5","1","4","2","7"},
		            {"6","5","7","9","1"},        
		        };
		 
		 int angkaKecil = 0;
		 int angkaJumlah = 0;
		 for(int i = 0; i < angka.length; i++) {
			 for(int j = 0; j < 5; j++) {
				 System.out.print(angka[i][j]+" ");
				 if(j != 0 && j != angka.length - 1) {
					 if(angkaKecil == 0 || Integer.valueOf(angka[i][j]) < angkaKecil) {
						 angkaKecil = Integer.valueOf(angka[i][j]);
						 
						 if(i == 0 && (j != 0 || j != angka.length-1)) {
							 angkaJumlah = Integer.valueOf(angka[i+1][j]);
						 } else if (i == angka.length-1 && (j != 0 || j != angka.length-1)) {
							 angkaJumlah = Integer.valueOf(angka[i-1][j]);
						 } else {
							 angkaJumlah = Integer.valueOf(angka[i-1][j]);
						 }
					 }
				 }
			 }
			 System.out.println();
		 }
		 int total = angkaKecil + angkaJumlah;
		 System.out.println("Answer "+angkaKecil+" + "+angkaJumlah+" = "+ total);
	}

	private void soalSatu() {
		// TODO Auto-generated method stub
		Scanner show = new Scanner(System.in);
        System.out.print("Masukan Angka Awal : ");
		int angkaMulai = show.nextInt();
		int manipulasi = 0;
	    int tinggi = 9;
	    for(int i = 1; i <= tinggi; i++){
	        for(int j = 1; j <= i; j++){
	            if(j+i <= tinggi+1) {
	                System.out.print(angkaMulai+" ");
	                angkaMulai +=1;
	                if(j == 2 && i >= 2) {
	                	manipulasi = angkaMulai-1; 
	                }
	            }else {
	                System.out.print(" ");
	                }
	        }
	        if(i >= 2) {
	        	angkaMulai = manipulasi;
	        }
	        
	        System.out.print("\n");
	    }
	}
}
