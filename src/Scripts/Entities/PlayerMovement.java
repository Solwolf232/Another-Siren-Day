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

    public void update()
    {
        float newPos;

        if(m_inputHandlerScript.isUp)
        {
            newPos = m_player.getPosY() - m_player.getPlayerSpeed();
            m_player.setPosY(newPos);
        }
        if(m_inputHandlerScript.isDown)
        {
            newPos = m_player.getPosY() + m_player.getPlayerSpeed();
            m_player.setPosY(newPos);
        }
        if(m_inputHandlerScript.isRight)
        {
            newPos = m_player.getPosX() + m_player.getPlayerSpeed();
            m_player.setPosX(newPos);
        }
        if(m_inputHandlerScript.isLeft)
        {
            newPos = m_player.getPosX() - m_player.getPlayerSpeed();
            m_player.setPosX(newPos);
        }
    }


}
