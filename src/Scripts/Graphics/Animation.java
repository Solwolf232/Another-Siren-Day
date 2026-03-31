package Scripts.Graphics;

import java.awt.image.BufferedImage;

public class Animation
{
    // ======================
    // Variables
    // ======================
    private BufferedImage[] m_frames;
    private int m_currentFrame;
    private int m_tick;
    private int m_speed;

    // ======================
    // Constructors
    // ======================
    public Animation(BufferedImage[] frames,int speed)
    {
     this.m_frames = frames;
     this.m_speed = speed;
    }
    // ======================
    // Update / Start methods
    // ======================

    public void update()
    {
        m_tick++;

        if(m_tick >= m_speed)
        {
            m_tick = 0;
            m_currentFrame++;

            if(m_currentFrame >= m_frames.length)
            {
                m_currentFrame = 0;
            }
        }
    }

    // ======================
    // Methods
    // ======================

    public BufferedImage getFrame()
    {
        return m_frames[m_currentFrame];
    }
}
