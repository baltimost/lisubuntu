package com.st.ime; 

import org.avmsc.dtvm.event.*;
import java.awt.*;

public class PyIME extends IME{
    private final static int stateInactive = -1;
    private final static int stateUP = 1;
    private final static int stateDOWN = 2;
    private int curState = stateInactive;
    private int flag = 0;
    
    private int upCursor = 0;
    private int downCursor = 0;
    private int pySize = 5;
    private int hzSize = 5;
    private int lastRetpy = 0;
    private int lastRethz = 0;
    private String[] pys = null;
    private String[] hzs = null;

    private String keys = ""; 
    private String keystemp = ""; 

    private String pyret = "";
    private String pyrettemp = "";
    private String hzret = "";
    private String hzrettemp = "";
    
    //py area
    
    private static int IMEpyxstr = 20;
    private static int IMEpyystr = 46;
    private static int IMEpygap = 14;
    //private static int charw = 14;
    private int[] pyindex = new int[pySize];


    //hz area
                        
    private static int IMEhzxstr = IMEpyxstr;
    private static int IMEhzystr = IMEh - 15;
    private static int IMEhzgap = 75;
//////////////////////////////////////////public/////////////////////////////////////////////
    public void enter(){ 
        resetParam();
        drawBack(); 
    }
    public void leave(){
        resetParam();
       // drawBack(); 
    }
    protected void setHD(boolean isHD){
        if(isHD){
            IMEpyxstr = 25;
            IMEpyystr = 55;
            IMEpygap = 15;

            IMEhzxstr = IMEpyxstr;
            IMEhzystr = IMEh - 15;
            IMEhzgap = 77;
        }
        else{
            IMEpyxstr = 20;
            IMEpyystr = 46;
            IMEpygap = 14;

            IMEhzxstr = IMEpyxstr;
            IMEhzystr = IMEh - 15;
            IMEhzgap = 75;
        }
    }

    
    public int keyProcess(int key){
        //System.out.println("---->>>PyIME processkey.........");
        int message = 2;//default circumstance is keep the ime state
        switch(curState){
            case stateInactive:
                //System.out.println("-- --> > >> >>>>  stateInactive..;;;;;");
                switch(key){
                    case InputEvent.VK_CANCEL:
                        resetParam();
                        return 1;//stateapplication
                    case InputEvent.VK_2:
                    case InputEvent.VK_3:
                    case InputEvent.VK_4:
                    case InputEvent.VK_5:
                    case InputEvent.VK_6:
                    case InputEvent.VK_7:
                    case InputEvent.VK_8:
                    case InputEvent.VK_9:
                        message = act2to9(key);
                        break;
                }
                break;
            case stateUP:
                message = actPY(key);
                break;
            case stateDOWN:
                message = actHZ(key);
                break;
        }
        return message;
    }

///////////////////////////private/////////protected///////////////
    public PyIME(){
        if(DEBUG_TRACE)
            //System.out.println("--->>>>PyIME constructor");
       ime_init();
       /*
       set_PY_return_size(pySize);
       set_HZ_return_size(hzSize);
       */
    }
    private void drawPY(){
        FontMetrics fm = bg.getFontMetrics();
        bg.setColor(unfocusColor);
        
        int pyxtemp = IMEpyxstr; 

        for(int i = 0;i < pySize;i++)
            pyindex[i] = 0;
        for(int i = 0;i < lastRetpy;i++){ 
            pyindex[i] = pyxtemp;
            bg.drawString(pys[i], pyxtemp,IMEpyystr);
            pyxtemp = pyxtemp + fm.stringWidth(pys[i]) + IMEpygap;//variable gap
        }

        /*
        for(int i = 0;i < pySize;i++)
            pyindex[i] = 0;
        for(int i = 0;i < lastRetpy;i++){ 
            pyindex[i] = IMEpyxstr;
            bg.drawString(pys[i], IMEpyxstr,IMEpyystr);
            IMEpyxstr = IMEpyxstr + fm.stringWidth(pys[i]) + IMEpygap;//variable gap
        }
        
        IMEpyxstr = 20;
        */
    }
    private void drawHZ(){
        bg.setColor(unfocusColor);
        for(int i = 0;i < lastRethz;i++)
            bg.drawString((i+1)+"."+hzs[i],IMEhzxstr + IMEhzgap*i,IMEhzystr);//fixed gap
    }
    private void drawUpCursor(int upCur,boolean focus){
        if(focus)
            bg.setColor(focusColor);
        else
            bg.setColor(unfocusColor);
        bg.drawString(pys[upCur],pyindex[upCur],IMEpyystr); 
    }
    private void drawDownCursor(int downCur,boolean focus){
        if(focus)
            bg.setColor(focusColor);
        else
            bg.setColor(unfocusColor);
        bg.drawString((downCur+1)+"."+hzs[downCur],IMEhzxstr + IMEhzgap*downCur,IMEhzystr);
    }
    private void drawLine(int upCur,boolean visible){
        FontMetrics fm = bg.getFontMetrics();
        if(visible)
            bg.setColor(lineColor);
        else
            bg.setColor(backColor);
        bg.fillRect(pyindex[upCur],IMEpyystr + 3,fm.stringWidth(pys[upCur]),lineh);//variable gap and line
    }

    private void UpCursorNext(){
        upCursor++;
      //  drawUpCursor(upCursor-1,false);
        drawUpCursor(upCursor,true);
    }
    private void UpCursorPrevious(){
        upCursor--;
     //   drawUpCursor(upCursor+1,false);
        drawUpCursor(upCursor,true);
    }
    private void DownCursorNext(){
        downCursor++;
        drawDownCursor(downCursor-1,false);
        drawDownCursor(downCursor,true);
    }
    private void DownCursorPrevious(){
        downCursor--;
        drawDownCursor(downCursor+1,false);
        drawDownCursor(downCursor,true);
    }
        
    private void paint(){
    /*
        if(curState == stateUP)
            drawPY();
        drawHZ();
        drawCursor();
        graphics.drawImage(bufferedImage,IMEx,IMEy,null);
        */
        ;
    }
    private void resetParam(){
        curState = stateInactive;
        upCursor = 0;
        downCursor = 0;
        lastRetpy = 0;
        lastRethz = 0;
        pys = null;
        hzs = null;

        keys = ""; 
        keystemp = ""; 

        pyret = "";
        pyrettemp = "";
        hzret = "";
        hzrettemp = "";
    }
    protected void repaint(){
        graphics.drawImage(bufferedImage,IMEx,IMEy,null);
    }
    protected void drawBack(){
        //System.out.println("---->>>>>>PyIME drawBack()");
        super.drawBack();
        bg.setColor(Color.white);
        bg.drawString(Tools.Sinogram[0],IMEetcx,IMEetcy);
    }
        
    private int actPY(int key){
        switch(key){
            case InputEvent.VK_2:
            case InputEvent.VK_3:
            case InputEvent.VK_4:
            case InputEvent.VK_5:
            case InputEvent.VK_6:
            case InputEvent.VK_7:
            case InputEvent.VK_8:
            case InputEvent.VK_9:
                act2to9(key);
                break;
            case InputEvent.VK_0:
                if(keys.length() > 0){
                    keys = keys.substring(0,keys.length() - 1);//Backspace
                    keystemp = keys;
                    if(keys.length() > 0){    
                        pyret = find_PY_first(keys);

                        upCursor = 0;//if enter Backspace ,set the upCursor zero
                        hzret = find_HZ_first(upCursor);//11.8

                        pys = Tools.mysplit(pyret,'*',pySize);
                        lastRetpy = pys.length; 

                        hzs = Tools.hzsplit(hzret,'*',hzSize);
                        lastRethz = hzs.length;
                        //paint();
                        drawBack();
                        drawPY();
                        drawHZ();
                        drawUpCursor(upCursor,true);
                    }
                    else{//if nothing to backspace ,clear everything and set curState into stateInactive
                        drawBack();
                        curState = stateInactive;
                    }
                }
                break;
            case InputEvent.VK_RIGHT:
                if(upCursor + 1 < pySize){//current page;
                    if(upCursor + 1 < lastRetpy){
                        downCursor = 0;//11.9

                        drawBack();
                        drawPY();

                        UpCursorNext();

                        hzret = find_HZ_first(upCursor);//11.8

                        hzs = Tools.hzsplit(hzret,'*',hzSize);
                        lastRethz = hzs.length;

                        drawHZ();


                    }
                }
                else{//go to next page
                    pyrettemp = find_PY_next();
                    if(!(pyrettemp.equals(pyret))){
                        pyret = pyrettemp; 
                        downCursor = 0;//11.9

                        upCursor = 0;        
                        hzret = find_HZ_first(upCursor);//11.8

                        pys = Tools.mysplit(pyret,'*',pySize);
                        lastRetpy = pys.length; 

                        hzs = Tools.hzsplit(hzret,'*',hzSize);
                        lastRethz = hzs.length;
                        //paint();
                        drawBack();
                        drawPY();
                        drawHZ();
                        drawUpCursor(upCursor,true);
                    }
                }
                break;
            case InputEvent.VK_LEFT:
                downCursor = 0;//11.9 

                if(upCursor > 0){//current page

                    drawBack();
                    drawPY();

                    UpCursorPrevious();

                    hzret = find_HZ_first(upCursor);//11.8

                    hzs = Tools.hzsplit(hzret,'*',hzSize);
                    lastRethz = hzs.length;

                    drawHZ();

                }
                else{//goto previous page
                    pyrettemp = find_PY_previous();//try
                    if(!(pyrettemp.equals(pyret))){
                        pyret = pyrettemp; 
                        upCursor = pySize - 1; 
                        hzret = find_HZ_first(upCursor);//11.8

                        pys = Tools.mysplit(pyret,'*',pySize);
                        lastRetpy = pys.length; 
                        hzs = Tools.hzsplit(hzret,'*',hzSize);
                        lastRethz = hzs.length;
                        //paint();
                        drawBack();
                        drawPY();
                        drawHZ();
                        drawUpCursor(upCursor,true);
                    }
                }
                break;
            case InputEvent.VK_DOWN:
            case InputEvent.VK_OK:
                drawUpCursor(upCursor,false);
                drawLine(upCursor,true);
                drawDownCursor(downCursor,true);

                curState = stateDOWN;
                break;

            case InputEvent.VK_CANCEL:
                resetParam();
                //drawBack();
                return 1;//stateapplication
        }
        return 2;//stateime
    }
    private int act2to9(int key){
        int intkey;
        intkey = key - InputEvent.VK_0;//get the value of key
        keystemp = keys;
        keystemp = keystemp + intkey;//assemble keys
        pyrettemp = find_PY_first(keystemp);//try first
       // if(!(pyret.equals(pyrettemp)) || (keys.length() == 0)){//if not reach the end or it's the first key
        if(pyrettemp != null  || (keys.length() == 0)){//if not reach the end or it's the first key
            pyret = pyrettemp;//save the last state
            keys = keystemp;

            downCursor = 0;//11.9when input a new 
            upCursor = 0;
            hzret = find_HZ_first(upCursor);//11.8
            
            try{
            pys = Tools.mysplit(pyret,'*',pySize);
            }catch(Exception e){
                e.printStackTrace();
            }
            lastRetpy = pys.length; 
            hzs = Tools.hzsplit(hzret,'*',hzSize);
            lastRethz = hzs.length;

            //paint();
            drawBack();
            drawPY();
            drawHZ();
            drawUpCursor(upCursor,true);
        }
        curState = stateUP;
        return 2;//stateime
    }
    private int actHZ(int key){
        int intkey;
        switch(key){
            case InputEvent.VK_RIGHT:
                if(downCursor + 1 < hzSize){
                    if(downCursor + 1 < lastRethz){
                        DownCursorNext();
                    }
                }
                else{
                    hzrettemp = find_HZ_next();
                    if(!(hzrettemp.equals(hzret))){
                        hzret = hzrettemp;
                        downCursor = 0;

                        hzs = Tools.hzsplit(hzret,'*',hzSize);
                        lastRethz = hzs.length;
                        //paint();
                        drawBack();
                        drawPY();
                        drawLine(upCursor,true);
                        drawHZ();
                        drawDownCursor(downCursor,true);
                    }
                }
                break;
            case InputEvent.VK_DOWN:
                hzrettemp = find_HZ_next();
                if(!(hzrettemp.equals(hzret))){
                    hzret = hzrettemp;

                    hzs = Tools.hzsplit(hzret,'*',hzSize);
                    lastRethz = hzs.length;
                    //paint();
                    drawBack();
                    drawPY();
                    drawLine(upCursor,true);
                    drawHZ();

                    if(downCursor >= lastRethz)//if the lastRethz is fewer than last downcursor,set downcursor into lastRethz
                        downCursor = lastRethz - 1;
                    drawDownCursor(downCursor,true);
                }
                break;
            case InputEvent.VK_LEFT:
                if(downCursor > 0){
                    DownCursorPrevious();
                }
                else{
                    hzrettemp = find_HZ_previous();
                    if(!(hzrettemp.equals(hzret))){
                        hzret = hzrettemp;
                        downCursor = hzSize - 1;

                        hzs = Tools.hzsplit(hzret,'*',hzSize);
                        lastRethz = hzs.length;
                        //paint();
                        drawBack();
                        drawPY();
                        drawLine(upCursor,true);
                        drawHZ();
                        drawDownCursor(downCursor,true);
                    }
                }
                break;
            case InputEvent.VK_UP:
                hzrettemp = find_HZ_previous();
                if(!(hzrettemp.equals(hzret))){
                    hzret = hzrettemp;

                    hzs = Tools.hzsplit(hzret,'*',hzSize);
                    lastRethz = hzs.length;
                    //paint();
                    drawBack();
                    drawPY();
                    drawLine(upCursor,true);
                    drawHZ();
                    drawDownCursor(downCursor,true);
                }
                else{//if reach the head change state to py
                    drawBack();
                    drawPY();
                    drawHZ();
                    //drawDownCursor(downCursor,false);
                    //drawLine(upCursor,false);
                    drawUpCursor(upCursor,true);
                    
                    curState = stateUP;
                }
                break;
            case InputEvent.VK_CANCEL:
            case InputEvent.VK_0:
                drawBack();
                drawPY();
                drawHZ();
                //drawDownCursor(downCursor,false);
                //drawLine(upCursor,false);
                drawUpCursor(upCursor,true);

                curState = stateUP;
                break;
            case InputEvent.VK_OK:
                try{
                termChar = hzs[downCursor];    
                curState = stateUP;//After input a character,change the state and reset th params;
                resetParam();
                drawBack();
                }catch(Exception e){
                    e.printStackTrace();
                }
                return -1;//it means that current getChar ended
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
                if(intkey <= hzSize){
                    termChar = hzs[intkey - 1];
                    curState = stateUP;//After input a character,change the state and reset th params;
                    resetParam();

                    drawBack();
                    return -1;//it means that current getChar ended
                }
                break;

        }
        return 2;
    }

///////////////////////////////////////////native//////////////////////////////////////////
    public native void ime_init();
    private native void set_PY_return_size(int size); 
    public native String find_PY_first(String key);//public 该为private,just for testing
    public native String find_PY_next();
	public native String find_PY_previous();

    private native void set_HZ_return_size(int size); 
    public native String find_HZ_first(int index);
    public native String find_HZ_next();
	public  native String find_HZ_previous();

    
}
