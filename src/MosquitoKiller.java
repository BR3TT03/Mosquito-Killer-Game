import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class MosquitoKiller extends Applet implements MouseMotionListener,MouseListener,Runnable {

	Thread t;
	boolean gameOver=false;
	Image bat,mosquito;
	String msg,GameOver="";
	int killer_RectX,killer_RectY;
	Random r=new Random();
	int mx,my,bx=200,by=500,score=0,Miss=0;
	
	public void init() {
		
		
		mx=r.nextInt(1300);
		my=r.nextInt(668);
		/*killer_RectX=bx;
		killer_RectY=by;*/
		bat=getImage(getDocumentBase(),"bat.png");
		mosquito=getImage(getDocumentBase(),"mosquito.png");

		addMouseListener(this);
		addMouseMotionListener(this);
		t=new Thread(this);
		t.start();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		for(;;)
		{
			if(gameOver==false) {
			mx=r.nextInt(1300);
			my=r.nextInt(668);
			try {
				Thread.sleep(1500);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}
	}

	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
			
		if(mx>bx && mx<bx+100 && my>killer_RectY-10 && my<killer_RectY+53 && gameOver==false) {
			mx=r.nextInt(1300);
			my=r.nextInt(668);
			score++;
			repaint();
	}
		else
		{
		  
			if(gameOver==false)
				Miss++;
		   repaint();
		   if(Miss==3) {
	                gameOver=true;
					GameOver="GAME OVER";
					repaint();
					try {Thread.sleep(5);}
					catch(Exception e1) {}
 
		   
		}
	}
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setCursor( new Cursor(Cursor.CROSSHAIR_CURSOR) );
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		bx=e.getX()-35;
		by=e.getY()-20;
		killer_RectX=bx+12;
		killer_RectY=by;
		repaint();
	}
	

	public void paint(Graphics g) {
	
	g.drawImage(mosquito,mx,my,40,40,this);
	g.drawImage(bat,bx,by,100,100,this);
	//g.drawRect(killer_RectX,killer_RectY,53,50);
	g.setFont(new Font("medieval",Font.BOLD,30));
	g.drawString("SCORE: ",0 , 100);
	g.drawString(Integer.toString(score), 140, 100);
	g.drawString("MISS: ",1150 , 100);
	g.drawString(Integer.toString(Miss), 1300, 100);
	g.setFont(new Font("medieval",Font.BOLD,100));
	g.drawString(GameOver, 350, 400);
	
}
}