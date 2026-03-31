package Scripts.Entities;
import Scripts.Graphics.Animation;
import java.util.Map;
import java.util.HashMap;
import java.awt.image.BufferedImage;

enum AnimationState
{
    idle,
    walking,
    running,
}

enum DirectionState
{
  down,
  left,
  up,
  right,
  none
}

public abstract class Humanoid
{
    // ======================
    // Variables
    // ======================

    //Stats
    protected String m_name;
    protected int m_health;
    protected float m_speed;

    //Position
    protected float posX;
    protected float posY;

    //State
    AnimationState current_animationState;
    DirectionState current_directionState;

    //Animations
    protected Animation[][] animations;



    //Booleans
    protected boolean isMoving;

    // ======================
    // Constructors
    // ======================

    protected Humanoid(String name , int health , float speed , float posX, float posY)
    {
      this.m_name = name;
      this.m_health = health;
      this.m_speed = speed;
      this.posX = posX;
      this.posY = posY;
      this.current_directionState = DirectionState.down;
      this.current_animationState = AnimationState.idle;

    }
    protected Humanoid()
    {
        this.m_name = "Default";
        this.m_health = 100;
        this.m_speed = 4.5f;
        this.posX = 0f;
        this.posY = 0f;
        this.current_directionState = DirectionState.down;
        this.current_animationState = AnimationState.idle;

    }

    // ======================
    // Animation Handler
    // ======================



    // ======================
    // Getters & Setters
    // ======================

    public String getName()
    {
        return m_name;
    }

    public void setName(String m_name)
    {
        this.m_name = m_name;
    }

    public int getHealth()
    {
        return m_health;
    }

    public void setHealth(int m_health)
    {
        this.m_health = m_health;
    }

    public float getSpeed()
    {
        return m_speed;
    }

    public void setSpeed(float m_speed)
    {
        this.m_speed = m_speed;
    }

    public float getPosX()
    {
        return posX;
    }

    public void setPosX(float posX)
    {
        this.posX = posX;
    }

    public float getPosY()
    {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

}
