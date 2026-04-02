package Scripts.Entities;

import Scripts.Graphics.Animation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("all")
public class Player extends Humanoid
{
    // ======================
    // Variables
    // ======================

    private BufferedImage playerImage;
    final private int imageWidth = 64;
    final private int imageHeight = 64;

    // Animation system

    //Idle
    private Animation idleUp;
    private Animation idleDown;
    private Animation idleLeft;
    private Animation idleRight;

    //Walking
    private Animation walkUp;
    private Animation walkDown;
    private Animation walkLeft;
    private Animation walkRight;

    private Animation currentAnimation;

    private BufferedImage playerSheet;

    // ======================
    // Constructors
    // ======================

    public Player(BufferedImage playerImage,String name , int health , float speed , float posX, float posY)
    {
        super(name,health,speed,posX,posY);
        init();
    }

    public Player()
    {
        super();
        init();
    }

    // ======================
    // Init
    // ======================

    private void init()
    {
       initAnimations();
    }


    private void initAnimations()
    {
        try
        {
            //Idle
            playerSheet = ImageIO.read(new File("src/Assets/Player/IdlePlayer.png"));

            idleDown  = createAnimation(playerSheet, 2, 2, 22, 2, 4);
            idleLeft  = createAnimation(playerSheet, 1, 2, 22, 2, 4);
            idleRight = createAnimation(playerSheet, 3, 2, 22, 2, 4);
            idleUp    = createAnimation(playerSheet, 0, 2, 22, 2, 4);

            currentAnimation = idleDown; // default

            //Walk Animation
            playerSheet = ImageIO.read(new File("src/Assets/Player/walkPlayer.png"));
            walkDown  = createAnimation(playerSheet, 2, 9, 10, 9, 4);
            walkLeft  = createAnimation(playerSheet, 1, 9, 10, 9, 4);
            walkRight = createAnimation(playerSheet, 3, 9, 10, 9, 4);
            walkUp    = createAnimation(playerSheet, 0, 9, 10, 9, 4);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // ======================
    // Update
    // ======================

    public void update()
    {
        switch(current_animationState)
        {
            case idle:
                switch (current_directionState)
                {
                    case up:
                        currentAnimation = idleUp;
                        break;

                    case left:
                        currentAnimation = idleLeft;
                        break;

                    case down:
                        currentAnimation = idleDown;
                        break;

                    case right:
                        currentAnimation = idleRight;
                        break;
                }
            break;

            case walking:
                switch (current_directionState)
                {
                    case up:
                        currentAnimation = walkUp;
                        break;

                    case left:
                        currentAnimation = walkLeft;
                        break;

                    case down:
                        currentAnimation = walkDown;
                        break;

                    case right:
                        currentAnimation = walkRight;
                        break;
                }
            break;
        }

        currentAnimation.update();
    }

    // ======================
    // Paint
    // ======================

    public void paintPlayer(Graphics g)
    {
        playerImage = currentAnimation.getFrame();

        g.drawImage(
                playerImage,
                (int)posX,
                (int)posY,
                imageWidth,
                imageHeight,
                null
        );
    }

    // ======================
    // Animations
    // ======================

    private Animation createAnimation(BufferedImage sheet, int row, int frameCount, int delay , int widthSlice , int heightSlice)
    {
        int frameWidth = sheet.getWidth() / widthSlice;
        int frameHeight = sheet.getHeight() / heightSlice;

        BufferedImage[] frames = new BufferedImage[frameCount];

        for (int i = 0; i < frameCount; i++)
        {
            frames[i] = sheet.getSubimage(i * frameWidth, row * frameHeight + 3, frameWidth, frameHeight);
        }

        return new Animation(frames, delay);
    }



}