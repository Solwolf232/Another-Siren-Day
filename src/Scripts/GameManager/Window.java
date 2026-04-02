package Scripts.GameManager;
import javax.swing.JFrame;

@SuppressWarnings("all")

public class Window extends JFrame
{

    GamePanel panel = new GamePanel();

    // ======================
    // Constructors
    // ======================
    public Window()
    {
        CreateWindow();

        CreatePanel();
        setVisible(true);
    }


    // ======================
    // Functions
    // ======================

    private void CreatePanel()
    {
        add(panel);
    }

    private void CreateWindow() // No Parameters
    {
        setTitle("Another Siren Day");
        setSize(panel.getScreenWidth(),panel.getScreenHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
