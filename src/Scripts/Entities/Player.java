package Scripts.Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("all")
public class Player
{
    // ======================
    // Variables
    // ======================

    //Image Related
    private BufferedImage playerImage; // Single Player Image (Sub Image)
    final private int imageWidth = 64;
    final private int imageHeight = 64;

    //Movement Related
    private float posX; // Player X pos At world
    private float posY; // Player Y pos at World
    final private float playerSpeed = 4.5f;

    // ======================
    // Paint Methods
    // ======================

    public void paintPlayer(Graphics g)
    {
        try
        {
            // Player Full Sprite Sheet
            BufferedImage playerSheet = ImageIO.read(new File("src/Assets/PlayerSheet.png"));

            playerImage = playerSheet.getSubimage(0,0,20,20);

            g.drawImage(playerImage,(int)posX,(int)posY,imageWidth,imageHeight,null);
        }
        catch (IOException exception)
        {
            exception.printStackTrace(); // Print the Error
        }
    }

    // ======================
    // Getters & Setters
    // ======================

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getPlayerSpeed() {
        return playerSpeed;
    }
}
