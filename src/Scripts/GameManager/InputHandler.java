package Scripts.GameManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter
{
    // ======================
    // Boolean Keys
    // ======================
    public boolean isUp;
    public boolean isDown;
    public boolean isLeft;
    public boolean isRight;


    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) isUp = true;
        if (key == KeyEvent.VK_S) isDown = true;
        if(key == KeyEvent.VK_D) isRight = true;
        if(key == KeyEvent.VK_A) isLeft = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) isUp = false;
        if (key == KeyEvent.VK_S) isDown = false;
        if(key == KeyEvent.VK_D) isRight = false;
        if(key == KeyEvent.VK_A) isLeft = false;
    }




}
