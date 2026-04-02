package Scripts.GameManager;
import Scripts.Entities.Player;
import Scripts.Entities.PlayerMovement;
import Scripts.Tiles.TileManager;

import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel
{
    // ======================
    // Objects
    // ======================
    Player player;
    InputHandler inputHandlerScript;
    PlayerMovement playerMovementScript;



    // ======================
    // Tiles (Map)
    // ======================
    public int tileSize = 32;

    private int screenWidth = 800;
    private int screenHeight = 600;

    public int maxScreenCol = screenWidth / tileSize;
    public int maxScreenRow = screenHeight / tileSize;

    TileManager tileManager = new TileManager(this);

    // ======================
    // Constructors
    // ======================
    public GamePanel()
    {
        init(); // Initializes Objects

        GameLoop();
    }

    // ======================
    // Update / Start Methods
    // ======================
    private void update()
    {
        playerMovementScript.update();
        player.update();
    }

    private void GameLoop()
    {
        new javax.swing.Timer(16, e -> // Functions to repeat
        {
            update();
            repaint();
        }).start();
    }



    // ======================
    // Paint Methods
    // ======================

    @Override
    protected void paintComponent(Graphics g) // Paints The Game
    {
      super.paintComponent(g);

      tileManager.draw(g);
      player.paintPlayer(g);
    }


    // ======================
    // Initialize Methods
    // ======================

    private void init()
    {
        player = new Player();

        inputHandlerScript = new InputHandler();

        playerMovementScript = new PlayerMovement(player,inputHandlerScript);


        addKeyListener(inputHandlerScript); //Tracks the Key Inputs

        setFocusable(true); // Don't Ignore the key Inputs
    }

    // ======================
    // Getters & Setters
    // ======================

    public int getScreenHeight()
    {
      return this.screenHeight;
    }

    public void setScreenHeight(int newScreenHeight)
    {
        this.screenHeight = newScreenHeight;
    }

    public int getScreenWidth()
    {
        return this.screenWidth;
    }


    public void setScreenWidth(int newScreenWidth)
    {
        this.screenWidth = newScreenWidth;
    }
}
