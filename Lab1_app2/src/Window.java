import java.util.ArrayList;
import javax.swing.*;

public class Window extends JFrame implements Observer {
    // List to hold JProgressBar instances
    ArrayList<JProgressBar> bars=new ArrayList<JProgressBar>();
    public Window(int nrThreads) {
        setLayout(null);
        setSize(450,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(nrThreads);
        this.setVisible(true);
    }
    private void init(int n){
        for(int i=0 ;i<n; i++){
            JProgressBar pb=new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(50,(i+1)*30,350,20);
            this.add(pb);
            this.bars.add(pb);
        }
    }
    public void setProgressValue(int id,int val){
        bars.get(id).setValue(val);
    }
    // Method to set progress value of a specific progress bar
    public void update(int id, int value)
    {
        SwingUtilities.invokeLater(() -> {
            setProgressValue(id, value);
        });
    }
}
