package project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener 
{
    private int playerX = 50; // Initial player X position
    private int playerY = 50; // Initial player Y position

    public GamePanel() 
    {
        setFocusable(true);
        addKeyListener(this);

        // Start a game timer to handle animation and updates
        javax.swing.Timer timer = new javax.swing.Timer(0, this); // 100ms interval
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // Implement game logic and updates here
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        // Clear the panel
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the player
        g.setColor(Color.WHITE);
        g.fillOval(playerX, playerY, 50, 50); // Example: Player is represented as a white circle
        
        // Draw the enemy
        g.setColor(Color.GREEN);
        g.fillRect(250, 250, 50, 50);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Implement keyTyped if needed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Implement player movement based on key presses
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_S) {
            playerX -= 10;
        } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            playerX += 10;
        } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            playerY -= 10;
        } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            playerY += 10;
        }
    }

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

    



