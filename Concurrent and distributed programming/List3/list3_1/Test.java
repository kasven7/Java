package list3_1;

public class Test {
    public static void main(String[] args){
        Watek watek1 = new Watek();
        Watek watek2 = new Watek();
        Watek watek3 = new Watek();

        watek1.setName("Watek1");
        watek2.setName("Watek2");
        watek3.setName("Watek3");

        watek1.start();
        try{
            Thread.sleep(200);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        watek2.start();
        watek3.start();

        // the results differ from one another with each execution of the program, it is totally random when these threads will work
        // if we add Thread.sleep then the two threads will end their run before the second one will start
    }
}
