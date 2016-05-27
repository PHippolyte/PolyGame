package Sound;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class soundManager{

	private Clip cur, cancel, enter, att, def, move, heal, menu;
	private List<Clip> soundList;
	
	public soundManager(int choice){
		soundList = new ArrayList<Clip>();
		try{
			if (choice ==0){
				File curf = new File("ressources/sounds/sound_cursor.wav");
				cur = AudioSystem.getClip();
				AudioInputStream inputStreamCur = AudioSystem.getAudioInputStream(curf);
				cur.open(inputStreamCur);
				soundList.add(cur);
				
				File enterf = new File("ressources/sounds/sound_enter.wav");
				enter = AudioSystem.getClip();
				AudioInputStream inputStreamEnter = AudioSystem.getAudioInputStream(enterf);
				enter.open(inputStreamEnter);
				soundList.add(enter);
				
				File cancelf = new File("ressources/sounds/sound_cancel.wav");
				cancel = AudioSystem.getClip();
				AudioInputStream inputStreamCancel = AudioSystem.getAudioInputStream(cancelf);
				cancel.open(inputStreamCancel);
				soundList.add(cancel);
				
			}
			
			if (choice == 1){
				
				File attf = new File("ressources/sounds/sound_attack.wav");
				att = AudioSystem.getClip();
				AudioInputStream inputStreamAtt = AudioSystem.getAudioInputStream(attf);
				att.open(inputStreamAtt);
				soundList.add(att);
				
				File movef = new File("ressources/sounds/sound_move.wav");
				move = AudioSystem.getClip();
				AudioInputStream inputStreamMove = AudioSystem.getAudioInputStream(movef);
				move.open(inputStreamMove);
				soundList.add(move);
				
				File healf = new File("ressources/sounds/sound_heal.wav");
				heal = AudioSystem.getClip();
				AudioInputStream inputStreamHeal = AudioSystem.getAudioInputStream(healf);
				heal.open(inputStreamHeal);
				soundList.add(heal);
				
				File deff = new File("ressources/sounds/sound_defense.wav");
				def = AudioSystem.getClip();
				AudioInputStream inputStreamDef = AudioSystem.getAudioInputStream(deff);
				def.open(inputStreamDef);
				soundList.add(def);
			}
			
			if (choice==2){
				File menuf = new File("ressources/sounds/sound_menu.wav");
				menu = AudioSystem.getClip();
				AudioInputStream inputStreamMenu = AudioSystem.getAudioInputStream(menuf);
				menu.open(inputStreamMenu);
				soundList.add(menu);
			}
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void play(int index){
		Clip sound = this.soundList.get(index);
		
		if(sound.isActive()){
			sound.stop();
		}
		sound.setFramePosition(0);
		sound.start();
	}
	
}
