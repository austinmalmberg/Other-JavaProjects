package com.austin.challenge._mini;

import java.math.BigInteger;
import java.util.TreeSet;

public class HammingNumbers {
	public static void main(String[] args) {
	    TreeSet<BigInteger> pq = new TreeSet<>();
	    BigInteger cur = BigInteger.ONE;
	    for(int count = 1; count < 1000000; count++, cur = pq.pollFirst()){
	    	if(count < 10) System.out.println(cur);
	    	
	        pq.add(cur.multiply(BigInteger.valueOf(2l)));
	        pq.add(cur.multiply(BigInteger.valueOf(3l)));
	        pq.add(cur.multiply(BigInteger.valueOf(5l)));
	    }
	    
	    System.out.println(pq.size() + " " + cur);
	}
}
