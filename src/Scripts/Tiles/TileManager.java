package Scripts.Tiles;

import Scripts.GameManager.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
   GamePanel gamePanelScript;
   Tile[] tiles;
   int mapTileNum[][];


   public TileManager(GamePanel gamePanelScript)
   {
       this.gamePanelScript = gamePanelScript;
       this.tiles = new Tile[10]; // can Change Later for More Tiles
       mapTileNum = new int[gamePanelScript.maxScreenCol][gamePanelScript.maxScreenRow];

       getTileImage();
       loadMap();
   }


   public void loadMap()
   {
       try
       {
           InputStream is = getClass().getResourceAsStream("/Map/gameMap.txt");
           BufferedReader br = new BufferedReader(new InputStreamReader(is));

           int row = 0;

           String line;
           while ((line = br.readLine()) != null && row < gamePanelScript.maxScreenRow)
           {
               String numbers[] = line.trim().split("\\s+"); // handles multiple spaces

               for (int col = 0; col < numbers.length && col < gamePanelScript.maxScreenCol; col++)
               {
                   mapTileNum[col][row] = Integer.parseInt(numbers[col]);
               }

               row++;
           }
           br.close();

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

   }

   public void getTileImage()
   {
        try
        {
          tiles[0] = new Tile(); // instantiates New Tile (Road Tile 1)
          tiles[0].tileImage = ImageIO.read(new File("src/Assets/Tiles/RoadTile1.png"));

          tiles[1] = new Tile(); // instantiates New Tile (Road Tile 2)
          tiles[1].tileImage = ImageIO.read(new File("src/Assets/Tiles/RoadTile2.png"));

          tiles[2] = new Tile(); // instantiates New Tile (Floor Tile)
          tiles[2].tileImage = ImageIO.read(new File("src/Assets/Tiles/FloorTile1.png"));
        }

        catch (Exception e)
        {
          e.printStackTrace();
        }
   }

   public void draw(Graphics g)
   {
       int col = 0;
       int row = 0;
       int posX = 0;
       int posY = 0;

       while(col < gamePanelScript.maxScreenCol && row < gamePanelScript.maxScreenRow)
       {
         int tileNum = mapTileNum[col][row];

         g.drawImage(tiles[tileNum].tileImage,posX,posY,gamePanelScript.tileSize, gamePanelScript.tileSize,null);
         col++;
         posX += gamePanelScript.tileSize;


         if(col == gamePanelScript.maxScreenCol)
         {
           col = 0;
           posX = 0;
           row++;
           posY += gamePanelScript.tileSize;
         }


       }

   }

}
