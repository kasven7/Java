package List4.list4_2;


public class TestOfPriorities {
    public static void main(String[] args){
        Potato potato = new Potato();

        Thread thread1 = new Thread(potato, "Potato1");
        Thread thread2 = new Thread(potato, "Potato2");
        Thread thread3 = new Thread(potato, "Potato3");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/* W praktyce, wątek z najwyższym priorytetem (10) ma większą szansę na wcześniejsze wykonanie niż wątki z niższymi
 priorytetami. Jednak w większości nowoczesnych systemów operacyjnych priorytety są tylko „sugestią” dla planisty i nie gwarantują kolejności wykonania.
 Podczas testów można zaobserwować, że wątek z wysokim priorytetem częściej kończy się szybciej niż pozostałe, ale
 nie zawsze – zależne jest to również od obciążenia CPU i systemu operacyjnego.
 */
