package Sound;

import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class soundManager{

	private Clip cur, cancel, enter, att, def, move, heal, menu, matt, error, turn;
	private Clip spellArrow, spellBoost, spellFireball, spellHeal, spellMeteore,
		spellResurect, spellRoot, spellShield, spellSprint, spellIceField, spellLessAction;
	private HashMap<String, Clip> soundList;

	
	public soundManager(){
		soundList = new HashMap<String, Clip>();

		try{
			
/*----------------------------------------------------------------------------------------------------------------------
			
												SONS DE BASE

-----------------------------------------------------------------------------------------------------------------------*/
			
			File curf = new File("ressources/sounds/sound_cursor.wav");
			cur = AudioSystem.getClip();
			AudioInputStream inputStreamCur = AudioSystem.getAudioInputStream(curf);
			cur.open(inputStreamCur);
			soundList.put("cursor",cur);
			
			File enterf = new File("ressources/sounds/sound_enter.wav");
			enter = AudioSystem.getClip();
			AudioInputStream inputStreamEnter = AudioSystem.getAudioInputStream(enterf);
			enter.open(inputStreamEnter);
			soundList.put("enter",enter);
			
			File cancelf = new File("ressources/sounds/sound_cancel.wav");
			cancel = AudioSystem.getClip();
			AudioInputStream inputStreamCancel = AudioSystem.getAudioInputStream(cancelf);
			cancel.open(inputStreamCancel);
			soundList.put("cancel",cancel);
			
			File menuf = new File("ressources/sounds/sound_menu.wav");
			menu = AudioSystem.getClip();
			AudioInputStream inputStreamMenu = AudioSystem.getAudioInputStream(menuf);
			menu.open(inputStreamMenu);
			soundList.put("menu",menu);
			
			File errorf = new File("ressources/sounds/sound_erreur.wav");
			error = AudioSystem.getClip();
			AudioInputStream inputStreamError = AudioSystem.getAudioInputStream(errorf);
			error.open(inputStreamError);
			soundList.put("error",error);
			
			File turnf = new File("ressources/sounds/sound_endturn.wav");
			turn = AudioSystem.getClip();
			AudioInputStream inputStreamTurn = AudioSystem.getAudioInputStream(turnf);
			turn.open(inputStreamTurn);
			soundList.put("turn",turn);
			
/*----------------------------------------------------------------------------------------------------------------------
			
											SONS PERSONNAGES
			
-----------------------------------------------------------------------------------------------------------------------*/
			
			File attf = new File("ressources/sounds/sound_attack.wav");
			att = AudioSystem.getClip();
			AudioInputStream inputStreamAtt = AudioSystem.getAudioInputStream(attf);
			att.open(inputStreamAtt);
			soundList.put("attack",att);
			
			File movef = new File("ressources/sounds/sound_move.wav");
			move = AudioSystem.getClip();
			AudioInputStream inputStreamMove = AudioSystem.getAudioInputStream(movef);
			move.open(inputStreamMove);
			soundList.put("move",move);
			
			File healf = new File("ressources/sounds/sound_heal.wav");
			heal = AudioSystem.getClip();
			AudioInputStream inputStreamHeal = AudioSystem.getAudioInputStream(healf);
			heal.open(inputStreamHeal);
			soundList.put("heal",heal);
			
			File deff = new File("ressources/sounds/sound_defense.wav");
			def = AudioSystem.getClip();
			AudioInputStream inputStreamDef = AudioSystem.getAudioInputStream(deff);
			def.open(inputStreamDef);
			soundList.put("def",def);
			
			File mattf = new File("ressources/sounds/sound_attackM.wav");
			matt = AudioSystem.getClip();
			AudioInputStream inputStreamAttm = AudioSystem.getAudioInputStream(mattf);
			matt.open(inputStreamAttm);
			soundList.put("mattack",matt);
			
/*----------------------------------------------------------------------------------------------------------------------
			
											SONS SPELL

-----------------------------------------------------------------------------------------------------------------------*/
			
			File arrowf = new File("ressources/sounds/sound_spellArrow.wav");
			spellArrow = AudioSystem.getClip();
			AudioInputStream inputStreamSArrow = AudioSystem.getAudioInputStream(arrowf);
			spellArrow.open(inputStreamSArrow);
			soundList.put("spellMultiArrow",spellArrow);
			
			File boostf = new File("ressources/sounds/sound_spellBoost.wav");
			spellBoost = AudioSystem.getClip();
			AudioInputStream inputStreamSBoost = AudioSystem.getAudioInputStream(boostf);
			spellBoost.open(inputStreamSBoost);
			soundList.put("spellBoost",spellBoost);
			
			File fireBallf = new File("ressources/sounds/sound_spellFireBall.wav");
			spellFireball = AudioSystem.getClip();
			AudioInputStream inputStreamSFire = AudioSystem.getAudioInputStream(fireBallf);
			spellFireball.open(inputStreamSFire);
			soundList.put("spellFireBall",spellFireball);
			
			File shealf = new File("ressources/sounds/sound_spellHeal.wav");
			spellHeal = AudioSystem.getClip();
			AudioInputStream inputStreamSHeal = AudioSystem.getAudioInputStream(shealf);
			spellHeal.open(inputStreamSHeal);
			soundList.put("spellHeal",spellHeal);
			
			File meteoref = new File("ressources/sounds/sound_spellMeteore.wav");
			spellMeteore = AudioSystem.getClip();
			AudioInputStream inputStreamSMeteore = AudioSystem.getAudioInputStream(meteoref);
			spellMeteore.open(inputStreamSMeteore);
			soundList.put("spellMeteore",spellMeteore);
			
			File resurectf = new File("ressources/sounds/sound_spellResurect.wav");
			spellResurect = AudioSystem.getClip();
			AudioInputStream inputStreamSResurect = AudioSystem.getAudioInputStream(resurectf);
			spellResurect.open(inputStreamSResurect);
			soundList.put("spellReanimation",spellResurect);
			
			File rootf = new File("ressources/sounds/sound_spellRoot.wav");
			spellRoot = AudioSystem.getClip();
			AudioInputStream inputStreamSRoot = AudioSystem.getAudioInputStream(rootf);
			spellRoot.open(inputStreamSRoot);
			soundList.put("spellRoot",spellRoot);
			
			File shieldf = new File("ressources/sounds/sound_spellShield.wav");
			spellShield = AudioSystem.getClip();
			AudioInputStream inputStreamSShield = AudioSystem.getAudioInputStream(shieldf);
			spellShield.open(inputStreamSShield);
			soundList.put("spellDivineShield",spellShield);
			
			File sprintf = new File("ressources/sounds/sound_spellSprint.wav");
			spellSprint = AudioSystem.getClip();
			AudioInputStream inputStreamSSprint = AudioSystem.getAudioInputStream(sprintf);
			spellSprint.open(inputStreamSSprint);
			soundList.put("spellSprint",spellSprint);
			
			File icef = new File("ressources/sounds/sound_spellIceField.wav");
			spellIceField = AudioSystem.getClip();
			AudioInputStream inputStreamSIce = AudioSystem.getAudioInputStream(icef);
			spellIceField.open(inputStreamSIce);
			soundList.put("spellIceField",spellSprint);
			
			File lessf = new File("ressources/sounds/sound_spellLessAction.wav");
			spellLessAction = AudioSystem.getClip();
			AudioInputStream inputStreamSLess = AudioSystem.getAudioInputStream(lessf);
			spellLessAction.open(inputStreamSLess);
			soundList.put("spellLessAction",spellLessAction);
			

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void play(String name){
		Clip sound = this.soundList.get(name);
		
		if(sound.isActive()){
			sound.stop();
		}
		sound.setFramePosition(0);
		sound.start();	
	}
	
	public HashMap<String,Clip > getSoundList(){
		return soundList;
	}

}
