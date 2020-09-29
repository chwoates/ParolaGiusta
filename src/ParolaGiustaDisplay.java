import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ParolaGiustaDisplay {
	
	private JFrame frame;
	private MyWordsPanel drawPanel;
	private PunteggioPanel punteggioPanel;
	private JButton button1;
	private JButton button2;
	String endgame = ""; String punteggio = ""; String puntiFinale = "";
	int numcircles = 1;

	int punti = 0;
	
	public ParolaGiustaDisplay(int gameMinutes){
		
		frame = new JFrame("Use your words!");
		drawPanel = new MyWordsPanel();
		punteggioPanel = new PunteggioPanel();
		numcircles = gameMinutes;
	
		Font bigFont = new Font("serif", Font.BOLD, 64);
		button1 = new JButton("Parola Giusta");
		button1.setFont(bigFont);
		button2 = new JButton("Punto");
		button2.addActionListener(new PuntoListener());
		button2.setFont(bigFont);
		punteggioPanel.add(button2);

	

		frame.setSize(1800,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
		frame.getContentPane().add(BorderLayout.NORTH,button1);
		frame.getContentPane().add(BorderLayout.SOUTH,punteggioPanel);
		frame.setVisible(true);
	}
	
	public void endGame(){
		
		endgame = "Gioco Finito";
		punteggio = "Punteggio";
		puntiFinale = Integer.toString(punti);
		button2.setEnabled(false);
		frame.repaint();
	}
	
	class MyWordsPanel extends JPanel{
		
		private static final long serialVersionUID = 1L;
		
		int xLocation = 650;
		int yLocation = 350;
	
		public void paintComponent(Graphics g){
			
			Graphics2D g2d = (Graphics2D)g;
			g.setColor(Color.red);
			g2d.setStroke(new BasicStroke(5));
			for(int i=0; i < numcircles; ++i){
				g2d.drawOval(xLocation + i*100, 350, 50, 50);	
			}
			for(int i=0; i < punti; ++i){
				g2d.fillOval(xLocation + i*100, 350, 50, 50);	
			}
			g.setColor(Color.blue);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
			
			g.drawString(punteggio, xLocation, yLocation-100);
			g.drawString(puntiFinale, xLocation+350, yLocation-100);	
			g.drawString(endgame, xLocation, yLocation+200);
		}
	}
	
	class PunteggioPanel extends JPanel{
		
		private static final long serialVersionUID = 1L;
	
		public void paintComponent(Graphics g){			
			g.setColor(Color.blue);
		}
	}
	
	class PuntoListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			++punti;
			frame.repaint();
		}
	}
	
	class EndGameListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
		}
	}
}
