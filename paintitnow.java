
package paintapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Emmanuel Adigwu
 */
public class paintitnow
{
	public static void main(String[] args)
        {
            
                Icon iM = new ImageIcon("magenta");
                
		Icon iB = new ImageIcon("blue");
		
		Icon iR = new ImageIcon("red");
                
                Icon iG = new ImageIcon("green");
		
		Icon iBl = new ImageIcon("black");
                
		
		
		
		final PadDraw drawPad = new PadDraw();
	
		
		JFrame frame = new JFrame("Paint It");
		
		
		Container content = frame.getContentPane();
		
		content.setLayout(new BorderLayout());
		
		content.add(drawPad, BorderLayout.CENTER);
		
		
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(50, 70));
		panel.setMinimumSize(new Dimension(50, 70));
		panel.setMaximumSize(new Dimension(50, 70));
		
		
		JButton clearButton = new JButton("Clear");
		
		clearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.clear();
			}
		});
		
		JButton redButton = new JButton("Red");
		
		redButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.red();
			}

		});
		
		
	
		JButton magentaButton = new JButton("Magenta");
		
		magentaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.magenta();
			}
		});
                
		JButton blackButton = new JButton("Black");
		
		blackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.black();
			}
		});
		
		JButton blueButton = new JButton("Blue");
		
		blueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.blue();
			}
		});
		
		JButton greenButton = new JButton("Green");
		
		greenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.green();
			}
		});
		blackButton.setPreferredSize(new Dimension(100, 100));
		magentaButton.setPreferredSize(new Dimension(150, 150));
                blueButton.setPreferredSize(new Dimension(90, 90));
		greenButton.setPreferredSize(new Dimension(120, 120));
		redButton.setPreferredSize(new Dimension(90, 90));
		
		
		panel.add(blackButton);
		panel.add(redButton);
		panel.add(greenButton);
		panel.add(blueButton);
		panel.add(magentaButton);
                panel.add(clearButton);
		
		
		
		content.add(panel, BorderLayout.WEST);
		
		
		frame.setSize(1100, 1100);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
	}
}


class PadDraw extends JComponent
{
	Image image;
	
	Graphics2D graphics2D;
	
	int currentX, currentY, oldX, oldY;
	

	
	public PadDraw(){
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				currentX = e.getX();
				currentY = e.getY();
				if(graphics2D != null)
				graphics2D.drawLine(oldX, oldY, currentX, currentY);
				repaint();
				oldX = currentX;
				oldY = currentY;
			}

		});
		
	}

	public void paintComponent(Graphics g)
        {
		if(image == null){
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();

		}
		g.drawImage(image, 0, 0, null);
	}

	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
	}
	
	public void red(){
		graphics2D.setPaint(Color.red);
		repaint();
	}
	
	public void black(){
		graphics2D.setPaint(Color.black);
		repaint();
	}
	
	public void magenta(){
		graphics2D.setPaint(Color.magenta);
		repaint();
	}
	
	public void blue(){
		graphics2D.setPaint(Color.blue);
		repaint();
	}
	
	public void green(){
		graphics2D.setPaint(Color.green);
		repaint();
	}
	

}