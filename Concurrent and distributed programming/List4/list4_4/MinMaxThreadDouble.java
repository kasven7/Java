package List4.list4_4;


public class MinMaxThreadDouble extends Thread{
    private double[] tab;
    private double minValue = Double.MAX_VALUE;
    private double maxValue = Double.MIN_VALUE;
    private int startPos;   // starting position of the thread in the table
    private int endPos; // end position of the thread in the table


    public MinMaxThreadDouble(double[] tab, int startPos, int endPos){
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

    public double getMinValue() { return minValue; }
    public double getMaxValue(){ return maxValue; }
}
