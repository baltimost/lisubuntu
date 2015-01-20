package com.st.ime;

import org.avmsc.dtvm.event.*;
import java.awt.*;

public class NumIME extends IME{
    public int keyProcess(int key){
        int intkey;
        String keys = "";
        switch(key){
            case InputEvent.VK_0:
            case InputEvent.VK_1:
            case InputEvent.VK_2:
            case InputEvent.VK_3:
            case InputEvent.VK_4:
            case InputEvent.VK_5:
            case InputEvent.VK_6:
            case InputEvent.VK_7:
            case InputEvent.VK_8:
            case InputEvent.VK_9:
                intkey = key - InputEvent.VK_0;
                keys = keys + intkey; 
                termChar = keys;
                return -1;
                

            case InputEvent.VK_CANCEL:
                //System.out.println("Say goodbye to NumIME......");
                return 1;
        }
        return 2;
    }
    public void enter(){
        //System.out.println("-_-_-_-_-_-_-_-_-_-_-_123");
        drawBack();
    }
    public void leave(){
        //drawBack();
    }
    protected void repaint(){
        graphics.drawImage(bufferedImage,IMEx,IMEy,null);
    }

    protected void drawBack(){
        super.drawBack();
        bg.setColor(Color.white);
        bg.drawString("123",IMEetcx + 5,IMEetcy);
    }
}

