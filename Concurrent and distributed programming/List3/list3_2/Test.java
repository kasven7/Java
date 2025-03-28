package list3_2;


public class Test {
    public static void main(String[] args){
        int sleepValue = (int) (Math.random() % 100) + 1;
        Watek[] watek = new Watek[5];



        for(int i = 4; i >= 0; i--){
            watek[i] = new Watek();
            watek[i].setName("W" + (i + 1));

            try {
                Thread.sleep(sleepValue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            watek[i].start();

            try {
                watek[i].join(); // ensures that the current thread finishes its tasks before starting the next
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }}
