package com.austin.challenge.i256;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args){
//        if(args.length > 0 && args[0].matches("(1\\d+|[2-9]\\d*)")){ 
//            HatGame cHat  = HatGame.of(Integer.parseInt(args[0]));
//            String result = cHat.play();
//
//            System.out.println(result);
//        }
//        else{
//            System.out.println("Invalid input, cond: n >= 2 ");
//        }
    	
		HatGame cHat  = HatGame.of(10);
		String result = cHat.play();

		System.out.println(result);
    }
}

final class HatGame{    
    private final List<? extends Player> players; 
    private final int[] visBlHats;

    private HatGame(List<Player> pl, int[] vBH){
        this.players     = pl;
        this.visBlHats   = vBH;
        
    }

    public static HatGame of(int numPlayers){
        if(numPlayers < 2) throw new IllegalArgumentException();

        List<Player> pl = generatePlayerList(numPlayers);
        int[] vBH  = new int[pl.size()];
        int nBlack = getNumBlack(pl);

        for(int i = 0 , n = pl.size(); i < n; i++){
            if(pl.get(i) == Player.BLACK){
                nBlack--;
            }
            vBH[i] = nBlack;
        }
        return new HatGame(pl, vBH);
    }

    public String play(){
        StringBuilder result = new StringBuilder();
        boolean[] guesses    = new boolean[players.size()];

        guesses[0] = visBlHats[0] % 2 != 0;
        int currBlack = (guesses[0])? 1 : 0; 

        for(int i = 1, n = players.size(); i < n ; i++){
            guesses[i] = (currBlack & 1) != (visBlHats[i] & 1);

            if(guesses[i]){
                result.append("g:Black ");
                currBlack++;
            }
            else
                result.append("g:White ");

            result.append(String.format("%s %d%n", players.get(i), i + 1));         
        }
        if(validate(guesses))
            result.append("players won");
        else
            result.append("gameMaster Won");

        return result.toString();
    }
    private static List<Player> generatePlayerList(int numPlayers){
        return new Random().doubles(numPlayers)
                           .mapToObj(dNum-> Player.get(dNum >= 0.5))
                           .collect(Collectors.toList());
    }
    private static int getNumBlack(List<Player> pl){
        return (int)pl.stream().filter(p -> p == Player.BLACK).count();
    }
    private boolean validate(boolean[] guesses ){
        for(int i = 0, count = 0; i < players.size(); i++){
            if(guesses[i] != (players.get(i) == Player.BLACK)){
                count++;
            }       
            if(count > 1){
                return false;
            }
        }
        return true;
    }
}

enum Player{
    BLACK, WHITE;

    public static Player get(boolean col){
        return (col) ? BLACK : WHITE;
    }
    @Override
    public String toString(){
        return (this ==BLACK) ? "p:Black" : "p:White";  
    }
}
