package List4.list4_2;


public class Potato implements Runnable {
        public void run(){
            for(int i = 0; i < 100000; i++){
                i += i;
            }
        }
}

