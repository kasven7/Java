package List4.list4_4;


public class MinMaxThreadInt extends Thread{
    private int[] tab;
    private int minValue = Integer.MAX_VALUE;
    private int maxValue = Integer.MIN_VALUE;
    private int startPos;   // starting position of the thread in the table
    private int endPos; // end position of the thread in the table


    public MinMaxThreadInt(int[] tab, int startPos, int endPos){
        this.tab = tab;
        this.startPos = startPos;
        this.endPos = endPos;
    }

    @Override
    public void run(){
        // The thread parses from the start position to the end position
        for(int i = startPos; i < endPos; i++){
            if(minValue > tab[i]) minValue = tab[i];
            if(maxValue < tab[i]) maxValue = tab[i];
        }
    }

    public int getMinValue() { return minValue; }
    public int getMaxValue(){ return maxValue; }
}
