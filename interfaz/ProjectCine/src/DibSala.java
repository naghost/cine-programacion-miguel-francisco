import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

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
				
				System.out.println(butacas.get(i).getX());
				
				if(butacas.get(i).getEstado()==0){
					
					
					g2d.setColor(Color.RED);
					
				}
				
				if(butacas.get(i).getEstado()==1){
					
					g2d.setColor(Color.GREEN);
					
				}
				
				if(butacas.get(i).getEstado()==2){
					
					g2d.setColor(Color.ORANGE);
					
				}
				
				g2d.fillRect(butacas.get(i).getX(), butacas.get(i).getY(), 40, 40);
				
				
			}
			
			g2d.setColor(Color.ORANGE);
			g2d.fillRect(5, 305, 640, 25);
			
		
		
		
		
	}

	
	
	

}
