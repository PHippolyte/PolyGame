package view.teamMenu;

import java.awt.Color;
import java.awt.Graphics;

import view.GamePanel;

@SuppressWarnings("serial")
public class TeamMenuPanel extends GamePanel{
	private TeamMenuSoldierPanel teamSelect;//320*420 (0,60)
	private CurrentTeamPanel currentTeam; //320*210 (320,60)
	private InfoSoldierPanel infoSoldier; //320*210 (320,270)
	
	private boolean init;
	private boolean paintCurrentTeam;
	private boolean paintTeamSelect;
	private boolean paintinfoSoldier;
	
	public TeamMenuPanel(int size){
		this.init = true;
		
		this.setBackground(Color.MAGENTA);
		this.setLayout(null);
		this.loadBackground("ressources/menu/teamMenu/Background.png");
		
		//création panels
		this.teamSelect = new TeamMenuSoldierPanel();
		this.currentTeam = new CurrentTeamPanel();
		this.infoSoldier = new InfoSoldierPanel();
		
		//dimensionnement panel
		this.teamSelect.setBounds(0, 60, 320, 420);
		this.currentTeam.setBounds(320,60,320,210);
		this.infoSoldier.setBounds(320, 270, 320, 210);
		
		//INITIALISATION
		this.teamSelect.init(size);
		
		this.repaint();
	}
	
	public void init(){
		this.init = true;
		this.repaint();
	}
	
	public void resetPanel(){
		
	}
	
	public void paint(Graphics g){
		if (this.init){
			g.drawImage(this.bg, 0, 0, this);
			this.init = false;
		}
		//this.currentTeam.repaint();
		this.teamSelect.paint(g);
		this.infoSoldier.paint(g);
	}
	
	public TeamMenuSoldierPanel getSelectSoldierPanel(){
		return this.teamSelect;
	}
}
