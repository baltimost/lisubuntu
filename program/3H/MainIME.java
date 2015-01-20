package com.st.ime;

import org.avmsc.dtvm.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainIME extends IME{
    protected final static int statePY = 0;
    protected final static int stateABC = 1;
    protected final static int stateNUM = 2;
    protected final static int stateSYMBOL = 3;
    protected static int curState = statePY;

    private static MainIME mainIme = null;

    public static MainIME getInstance(){
        if(mainIme == null)
            mainIme = new MainIME();
        return mainIme;
    }
    public void setHD(boolean isHD){
        System.out.println("----->>>>>> setHD " + isHD);
        if(isHD){
            IMEh = 120;
            IMEw = 570;
            IMEetcx = IMEw - 103;
            IMEetcy = IMEh/2 + 20;
            
            subIMEs[statePY].setHD(isHD);
            subIMEs[stateABC].setHD(isHD);
            subIMEs[stateSYMBOL].setHD(isHD);



            bufferedImage = Tools.getBufferedImage(IMEw, IMEh);
            bg = bufferedImage.getGraphics();
            bg.setFont(new Font("default",Font.PLAIN,36));
            Picbg = toolkit.createImage("/workdir/MBT_resources/classes/app/journal/bg.png");
        }
        else{
            IMEh = 100;
            IMEw = 500;
            IMEetcx = IMEw - 73;
            IMEetcy = IMEh/2 + 15;
            
            subIMEs[statePY].setHD(isHD);
            subIMEs[stateABC].setHD(isHD);
            subIMEs[stateSYMBOL].setHD(isHD);



            bufferedImage = Tools.getBufferedImage(IMEw, IMEh);
            bg = bufferedImage.getGraphics();
            bg.setFont(new Font("default",Font.PLAIN,24));
            Picbg = toolkit.createImage("/workdir/MBT_resources/classes/app/notepad/bg.gif");
        }
    }

    private MainIME(){
        System.out.println("----->>>>>> MainIME ");
        if(DEBUG_TRACE)
            //System.out.println("--->>>MainIME constructor");
        bufferedImage = Tools.getBufferedImage(IMEw, IMEh);
        bg = bufferedImage.getGraphics();
        bg.setFont(new Font("default",Font.PLAIN,24));//set the size of character


        addIME(statePY, new PyIME());
        addIME(stateABC, new AbcIME());
        addIME(stateNUM, new NumIME());
        addIME(stateSYMBOL, new SymbolIME());
    }
    
    public void setDrawParams(Graphics g, int x, int y){
        graphics = g;
        IMEx = x;
        IMEy = y;
    }
    public void repaint(){
        ;
    }
    public String getCharacter(){
       // return subIMEs[curState].getCharacter(); 
       return termChar;
    }
    public void enter(){
        if(DEBUG_TRACE)
            //System.out.println("--->>>MainIME enter()");
        subIMEs[curState].enter();
        graphics.drawImage(bufferedImage,IMEx,IMEy,null);
    }
    public void leave(){
        //System.out.println("---->>>>>MainIME leave()");
        clear();
    }

    public int keyProcess(int key){
        if(curState == stateSYMBOL){
            
            int msg1 = curState;
            try{
            curState = subIMEs[curState].keyProcess(key);
            }catch(Exception e){
                e.printStackTrace();
            }
            boolean ret = ((SymbolIME)(subIMEs[msg1])).getIsInput();
  
            if(msg1 != curState){
                subIMEs[msg1].leave();
                subIMEs[curState].repaint();
            }
            if(ret){
                return -1;//if input put something, tell application to draw it 
            }
            else{
                return 2;
            }
        }
        else{
            if(key == InputEvent.VK_COLORED_KEY_1){//enter green key to switch ime mode
                int msg = curState;
                if(curState < 2)
                    curState++;
                else
                    curState = statePY;
                if(msg !=curState){
                    subIMEs[msg].leave();//leave last ime mode
                    subIMEs[curState].enter();//enter current ime mode
                    graphics.drawImage(bufferedImage,IMEx,IMEy,null);
                }
                return 2;
            }
            else if(key == InputEvent.VK_COLORED_KEY_2){//enter yellow key to input symbol
                int mode = curState; 
                curState = stateSYMBOL;
                ((SymbolIME)(subIMEs[curState])).setMode(mode);
                subIMEs[curState].enter();
                return 2;
            }
            else{
                int message = subIMEs[curState].keyProcess(key);
                graphics.drawImage(bufferedImage,IMEx,IMEy,null);
                return message;
            }
        }
    }
}
