package Sound;

import java.applet.*;
import java.net.*;

import javax.swing.JApplet;

public class soundManager extends JApplet{

	private AudioClip hoq, boum, rot;
	private URL path;
	
	public soundManager(){
		path = soundManager.class.getResource("sounds/hoquet1.wav");
		hoq = Applet.newAudioClip(path);
		path = soundManager.class.getResource("sounds/boum.wav");
		boum = Applet.newAudioClip(path);
		path = soundManager.class.getResource("sounds/rot.wav");
		rot = Applet.newAudioClip(path);
	}
	
	public void playH(){
		//hoq.play();
	}
	
	public void playB(){
		//boum.play();
	}

	public void playR(){
		//rot.play();
	}
}
