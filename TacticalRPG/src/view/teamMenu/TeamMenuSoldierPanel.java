package view.teamMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

import gameObject.Soldier;
import view.GameComponent;

/*Panel affichant la liste des soldats selectionnables
 * Dimension : 320*420
 * */


@SuppressWarnings("serial")
public class TeamMenuSoldierPanel extends GameComponent{
	private ArrayList<SoldierPanel> soldierPanel;
	
	public TeamMenuSoldierPanel(){
		this.soldierPanel = new ArrayList<SoldierPanel>();
	}
	
	private void initPanels(){
		int n = this.soldierPanel.size();
		int x = this.getX();
		int y = this.getY();
		int height = this.getHeight()/this.soldierPanel.size();
		
		int res = this.getHeight()%this.soldierPanel.size();
		int dy = 0;
		
		BufferedImage img = this.load("ressources/menu/teamMenu/soldierBackground.png");
		BufferedImage img2 = this.load("ressources/menu/teamMenu/soldierSelected.png");

		
		for (int i=0; i<n; i++){
			SoldierPanel p = this.soldierPanel.get(i);
			p.setBackgroundImage(img);
			p.setBgSelected(img2);
			if (res > 0) {
				dy = 1;
				res--;
			}
			else dy = 0;
			p.setBounds(x, y, this.getWidth(), height+dy);
			y += height+dy;
		}
	}
	
	public void init(int size){
		//CREATION DES PANEL
		for (int i=0; i<size; i++){
			this.soldierPanel.add(new SoldierPanel(i));
		}
		//DIMENSION DES PANELS
		this.initPanels();
		
		//AJOUTS DES PANELS
		this.addSoldierPanels();
	}
	
	private void addSoldierPanels(){
		for (SoldierPanel p : this.soldierPanel){
			this.add(p);
		}
	}
	
	public void paint(Graphics g){
		for (SoldierPanel p : this.soldierPanel){
			p.paint(g);
		}
	}
	
	public void resetPanel(){
		for (SoldierPanel p : this.soldierPanel){
			p.setSelected(false);
		}
	}
	
	public void selectSoldierPanel(int i){
		this.soldierPanel.get(i).setSelected(true);
	}
	
	public void addIcone(BufferedImage[] imgs){
		for (int i=0; i<imgs.length ; i++){
			this.soldierPanel.get(i).setIcone(imgs[i]);
		}
	}
	
	public void addNameImage(BufferedImage[] imgs){
		int err = 0;
		for (int i=0; i<imgs.length ; i++){
			if (imgs[i] == null) err++;
			this.soldierPanel.get(i).setNameImage(imgs[i]);
		}
		System.out.println("FCT [addNameImage] ERREURS : "+err);
	}
	
	public SoldierPanel getSoldierPanel(int i){
		return this.soldierPanel.get(i);
	}
}
