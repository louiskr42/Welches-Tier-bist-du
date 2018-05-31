package com.coreelements.de.whichanimalareyou;

public class Quiz {

    int[] values = new int[8];

    public void setValue(int statement, int value) {
        values[statement] = value;
    }

    public int getStatement(int statement) {
        if (statement == 1) {
            return R.string.statement1;
        } else if (statement == 2) {
            return R.string.statement2;
        } else if (statement == 3) {
            return R.string.statement3;
        } else if (statement == 4) {
            return R.string.statement4;
        } else if (statement == 5) {
            return R.string.statement5;
        } else if (statement == 6) {
            return R.string.statement6;
        } else if (statement == 7) {
            return R.string.statement7;
        } else if (statement == 8) {
            return R.string.statement8;
        } else {
            return R.string.statement1;
        }
    }

    public int[] getValues() {
        return values;
    }
}