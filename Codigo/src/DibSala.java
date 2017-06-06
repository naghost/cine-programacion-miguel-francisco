import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DibSala extends JPanel {
					
	//0 ocupado, 1 disponible, 2 seleccionado
	ArrayList<Butaca> butacas = new ArrayList<Butaca>();

	public DibSala( ArrayList<Butaca> butacas) {
		
		this.butacas=butacas;
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
				
			g2d.setColor(Color.RED);
			
			
			
			for(int i=0; i<butacas.size(); i++){
				
				if(butacas.get(i).getEstado()==0){
								
					ImageIcon img =new ImageIcon(getClass().getResource("sillonRojo.png"));
					g2d.drawImage(img.getImage(), butacas.get(i).getX(), butacas.get(i).getY(), 40, 40, null);
				}
				
				if(butacas.get(i).getEstado()==1){
					
					ImageIcon img =new ImageIcon(getClass().getResource("sillonVerde.png"));
					g2d.drawImage(img.getImage(), butacas.get(i).getX(), butacas.get(i).getY(), 40, 40, null);
					
				}
				
				if(butacas.get(i).getEstado()==2){
					
					ImageIcon img =new ImageIcon(getClass().getResource("sillonAmarillo.png"));
					g2d.drawImage(img.getImage(), butacas.get(i).getX(), butacas.get(i).getY(), 40, 40, null);
					
					//g2d.setColor(Color.ORANGE);
					//g2d.fillRect(butacas.get(i).getX(), butacas.get(i).getY(), 40, 40);
				}
				
				
								
			}
			
			g2d.setColor(Color.BLACK);
			g2d.fillRect(5, 305, 640, 5);
			
		
		
		
		
	}

	
	
	

}
