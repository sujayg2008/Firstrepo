package assignment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class blackjack {

	

	public static void main(String[] args) {
	int n;
	int Dealertotal;
	int Playertotal = 0;
	int player;
	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	
	 
	
	Random rand = new Random(); 
	Scanner input = new Scanner(System.in);
	
	
	System.out.println("Enter the number of users");
	n= input.nextInt();
	
	int Dc1 = rand.nextInt(10) +1; 
	int Dc2 = rand.nextInt(10) +1;
	Dealertotal = Dc1 +Dc2;
	hm.put(Dealertotal, "Dealer");
	
	
	System.out.println("Dealer draws card 1: " +Dc1);
	System.out.println("Dealer draws card 2: " +Dc2);
	System.out.println("Dealer total is: " +Dealertotal);
	System.out.println("\n");
	
	for(player = 1;player<=n;player++)
	{
		
		
		int Pc1 = rand.nextInt(10) +1; 
		int Pc2 = rand.nextInt(10) +1;
		Playertotal = Pc1 +Pc2;

		System.out.println("Player " +player +" draws card 1: " +Pc1 );
		System.out.println("Player " +player +" draws card 2: " +Pc2);
		System.out.println("Player " +player +" total is: " +Playertotal);
		System.out.println("\n");
		hm.put(Playertotal, "player"+player);
		System.out.println(hm);
	}
	
	}
	
/*
		if(Playertotal>Dealertotal)
		{
			
			System.out.println("Player " +player  +" wins");
		}
		else
		{
			System.out.println("Dealer wins");
		}
		*/
	
	}
	
	
