import java.util.ArrayList;
import java.util.List;


public class Fir extends Thread implements Observable {
    int id;
    int processorLoad;
    List<Observer> observers = new ArrayList<>();
    // List to hold observer instances
    Fir(int id,int priority, int procLoad){
        this.id=id;
        this.processorLoad=procLoad;
        this.setPriority(priority);
    }
    public void run(){
        int c=0;
        while(c<1000){
            // Nested loop to simulate processor load
            for(int j=0;j<this.processorLoad;j++){
                j++;j--;
            }
            c++;
            // Notifying observers about the current state
            notifyObservers(id,c);
            try{
                Thread.sleep(10); // Putting the thread to sleep for a short duration
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int id, int value) {
        for (Observer observer: observers)
        {
           observer.update(id,value);
        }
    }
}
