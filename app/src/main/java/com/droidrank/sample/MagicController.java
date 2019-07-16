package com.droidrank.sample;

import android.util.Log;

public class MagicController {

    // Note:
    // to be honest i searched stackoverflow for solution as i can't understand it at first :) ,
    // thanks for making me check this algorithm :) .

    magicView view;
    public MagicController(magicView view) {
        this.view=view;
    }

    void performMagic(int odd_number){
        int [][] magicArray = new int[odd_number][odd_number];
        int number = 1;
        int row=0;
        int column=odd_number/2;
        int current_row;
        int current_column;
        while (number <= odd_number * odd_number){
            magicArray[row][column] = number;
            number ++;
            current_row = row;
            current_column = column;
            row -=1;
            column +=1;
            if (row == -1){
                row = odd_number-1;
            }
            if (column == odd_number){
                column = 0;
            }
            if (magicArray[row][column] != 0){
                row = current_row +1;
                column = current_column;
                if (row == -1){
                    row = odd_number-1;
                }
            }
        }
        printMagic(magicArray);

    }

    void printMagic(int [][] magicArray){
        StringBuilder output=new StringBuilder();
        for (int i=magicArray.length-1;i>=0;i--){
            for (int j =0 ; j<magicArray.length;j++){
                output.append(""+magicArray[i][j]+" ");
            }
            output.append("\n");
        }
        view.updateUI(output.toString());
    }

}
