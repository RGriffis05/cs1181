public class Counter {
    private int value = 0;

    public synchronized void increment(){
        this.value++;
    }

    public synchronized int readValue(){
        return this.value;
    }

}
