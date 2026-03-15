package Scripts.GameManager;
import javax.swing.JFrame;

@SuppressWarnings("all")

public class Window extends JFrame
{
    // ======================
    // Constructors
    // ======================
    public Window()
    {
        CreateWindow();

        CreatePanel();
        setVisible(true);
    }

    public Window(int widthSize,int heightSize)
    {
        CreateWindow(widthSize,heightSize);

        CreatePanel();

        setVisible(true);
    }

    // ======================
    // Functions
    // ======================

    private void CreatePanel()
    {
        GamePanel panel = new GamePanel();
        add(panel);
    }

    private void CreateWindow() // No Parameters
    {
        setTitle("Another Siren Day");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void CreateWindow(int width,int height) // With Width/Height
    {
        setTitle("Another Siren Day");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
