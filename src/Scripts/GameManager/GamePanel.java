package Scripts.GameManager;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel
{
    BufferedImage playerSheet;

    public GamePanel()
    {
        try
        {
            playerSheet = ImageIO.read(new File("src/Assets/PlayerSheet.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
      super.paintComponent(g);

      g.drawImage(playerSheet, 200, 200, null);

    }
}
