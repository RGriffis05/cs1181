import javax.swing.*;

public class CustomFrame extends JFrame{

    private JPanel root = new JPanel();

        Ball b = new Ball();
        

    public CustomFrame(){

        this.root.setLayout(new BoxLayout(this.root, BoxLayout.Y_AXIS));
        root.add(b);

        this.add(root);
        this.setContentPane(root);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Custom graphics");
        this.setResizable(true);

        animate();

    }
    
    private int deltaX = 5;
    private int deltaY = 5;

    private void animate(){

        int xMin = 0;
        int yMin = 0;
        int xMax = this.getWidth();
        int yMax = this.getHeight();

        Timer t = new Timer(500, (e)->{
            b.x += deltaX;
            b.y += deltaY;
            b.repaint();
            //logic

            //handle X

            if(b.x < xMin || b.x + b.diameter > xMax){
                deltaX *= -1;
            }

            //handle Y

            if(b.y < yMin || b.y + b.diameter > yMax){
                deltaY *= -1;
            }
        });

        t.start();
        t.setRepeats(true);
    }


}
