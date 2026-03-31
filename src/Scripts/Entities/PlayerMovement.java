package Scripts.Entities;

import Scripts.GameManager.InputHandler;


public class PlayerMovement
{
    // ======================
    // Variables / Objects
    // ======================
    Player m_player; // Player Object
    InputHandler m_inputHandlerScript;


    // ======================
    // Constructors
    // ======================

    public PlayerMovement(Player player , InputHandler inputHandlerScript)
    {
         this.m_player = player;
         this.m_inputHandlerScript = inputHandlerScript;
    }

    // ======================
    // update , Start Methods
    // ======================
    public void update()
    {
        float newPosY;
        float newPosX;

        m_player.isMoving = false;

        if(m_inputHandlerScript.isUp && m_inputHandlerScript.isLeft)
        {
          newPosY =  m_player.getPosY();
          newPosX = m_player.getPosX();

          movePlayer(true,newPosX,newPosY,DirectionState.none);
        }
        else if(m_inputHandlerScript.isUp && m_inputHandlerScript.isRight)
        {
            newPosY =  m_player.getPosY();
            newPosX = m_player.getPosX();

            movePlayer(true,newPosX,newPosY,DirectionState.none);
        }

        else if(m_inputHandlerScript.isDown && m_inputHandlerScript.isLeft)
        {
            newPosY =  m_player.getPosY();
            newPosX = m_player.getPosX();

            movePlayer(true,newPosX,newPosY,DirectionState.none);
        }

        else if(m_inputHandlerScript.isDown && m_inputHandlerScript.isRight)
        {
            newPosY =  m_player.getPosY();
            newPosX = m_player.getPosX();

            movePlayer(true,newPosX,newPosY,DirectionState.none);
        }



        else if(m_inputHandlerScript.isUp)
        {
            newPosY = m_player.getPosY() - m_player.getSpeed();
            movePlayer(true,m_player.getPosX(),newPosY,DirectionState.up);
        }

        else if(m_inputHandlerScript.isDown)
        {
            newPosY = m_player.getPosY() + m_player.getSpeed();
            movePlayer(true, m_player.getPosX(),newPosY,DirectionState.down);
        }
        else if(m_inputHandlerScript.isRight)
        {
            newPosX = m_player.getPosX() + m_player.getSpeed();
            movePlayer(true,newPosX, m_player.getPosY(),DirectionState.right);
        }
        else if(m_inputHandlerScript.isLeft)
        {
            newPosX = m_player.getPosX() - m_player.getSpeed();
            movePlayer(true,newPosX, m_player.getPosY(), DirectionState.left);
        }

        if(m_player.isMoving)
           m_player.current_animationState = AnimationState.walking;
        else
           m_player.current_animationState = AnimationState.idle;

    }

    // ======================
    // Helper Methods
    // ======================

    private void movePlayer(boolean isMoving,float newPosX,float newPosY,DirectionState playerDirection)
    {
        m_player.isMoving = isMoving;

        m_player.setPosX(newPosX); // Sets new Position in X

        m_player.setPosY(newPosY); // Sets new Position in Y

        m_player.current_directionState = playerDirection;


    }



}
