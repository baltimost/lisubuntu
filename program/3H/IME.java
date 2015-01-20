package com.st.ime;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

import java.awt.*;


public abstract class IME{
    final static boolean DEBUG_TRACE = true;

    protected final static int maxIME = 4;
    

    protected static int IMEx = 0;
    protected static int IMEy = 0;

    protected static int IMEh = 100;
    protected static int IMEw = 500;
   
    
    protected static int IMEetcx = IMEw - 73;
    protected static int IMEetcy = IMEh/2 + 15;

    protected static String termChar = null;


    protected IME[] subIMEs = null;

    protected static Graphics graphics = null;//graphics of application 
    protected static BufferedImage bufferedImage = null;
    protected static Graphics bg = null;//graphics of bufferedImage
    protected static Toolkit toolkit = Toolkit.getDefaultToolkit(); 
    protected static Image Picbg = toolkit.createImage("/workdir/MBT_resources/classes/app/notepad/bg.gif");

    protected Color backColor = new Color(0,90,255);
    protected Color etcColor = new Color(0,75,206);

    protected Color focusColor = Color.yellow;
    protected Color unfocusColor = Color.white;
    protected Color lineColor = new Color(1,102,203);

    protected int linew = 20;
    protected int lineh = 2;

    protected void addIME(int ime, IME Ime){
        if(subIMEs == null)
            subIMEs = new IME[maxIME];
        subIMEs[ime] = Ime;
    }

    protected void enter(){
        System.out.println("IME enter()");
    }

    protected void leave(){}

    public String getCharacter(){
        return termChar;    
    }
    public Size getDrawRect(){
        Size size = new Size();
        size.setSize(IMEw,IMEh);
        return size;
    }
        

    protected void setHD(boolean isHD){}
    protected void repaint(){}
    


    protected void drawBack(){
        //bg.clearRect(0,0,IMEw,IMEh);
        //Image pic = toolkit.createImage("/workdir/MBT_resources/classes/app/notepad/bg.gif");
        System.out.println("------->>>>>> IME.java picbg" + Picbg);
        bg.drawImage(Picbg,0,0,null);
    }
    protected void clear(){
    /*
        System.out.println(".......IME clear()");
        bg.clearRect(0,0,IMEw,IMEh);
        graphics.drawImage(bufferedImage,IMEx,IMEy,null);
        */
        graphics.clearRect(IMEx,IMEy,IMEw,IMEh);
    }
    abstract public int keyProcess(int key);
}
