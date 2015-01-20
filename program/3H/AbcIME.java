package com.st.ime;

import org.avmsc.dtvm.event.*;
import java.awt.*;

public class AbcIME extends IME{
    private int cursor = 0; 
    private String engret = null; 
    private int lastkey = 0;

    private final static int stateCapital = 1;
    private final static int stateLower = 2;
    private int curState = stateLower;
    private int message = curState; 

    private static String Enggram[] = Tools.Lowgram;

    
    private static int IMEabcx = 80;
    private static int IMEabcy = 46;
    private static int IMEabcdx = IMEabcx;
    private static int IMEabcdy = IMEh - 15;
    private static int IMEabcgap = 24;

    protected void setHD(boolean isHD){
        if(isHD){
            IMEabcx = 100;
            IMEabcy = 55;
            IMEabcdx = IMEabcx;
            IMEabcdy = IMEh - 15;
            IMEabcgap = 29;
        }
        else{
            IMEabcx = 80;
            IMEabcy = 45;
            IMEabcdx = IMEabcx;
            IMEabcdy = IMEh - 15;
            IMEabcgap = 24;
        }
    }

    public int keyProcess(int key){
        int intkey = 0;
        switch(key){
            case InputEvent.VK_UP:
                if(curState == stateCapital){
                    curState = stateLower;
                    Enggram = Tools.Lowgram;
                }
                else{ 
                    curState = stateCapital;
                    Enggram = Tools.Capgram;
                }
                drawEtc(curState);
                resetParam();
                bg.setColor(backColor);
                
                drawBack();
                break;
            case InputEvent.VK_2:
            case InputEvent.VK_3:
            case InputEvent.VK_4:
            case InputEvent.VK_5:
            case InputEvent.VK_6:
            case InputEvent.VK_7:
            case InputEvent.VK_8:
            case InputEvent.VK_9:
                intkey = key - InputEvent.VK_0;
                if(intkey == lastkey){
                    try{
                        engret = (Enggram[intkey]).substring(cursor,cursor+1);
                    }catch(StringIndexOutOfBoundsException e){
                        cursor = 0;
                        engret = (Enggram[intkey]).substring(cursor,cursor+1);
                    }
                    drawLetter(intkey);
                    cursor++;
                    //System.out.println(" -->> -->> -->> Eng result 1 " + engret);
                }
                else{//if enter another key, output the last key
                    lastkey = intkey;//save the last key
                    termChar = engret;
                    cursor = 0;
                    engret = (Enggram[intkey]).substring(cursor,cursor+1);//the next
                    drawLetter(intkey);
                    cursor++;
                    //System.out.println(" -->> -->> -->> Eng result 2 " + engret);
                    if(termChar != null)//when termChar is not null, tell the application to print the character
                        return -1;
                }
                break;
            case InputEvent.VK_OK:
                termChar = engret;
                engret = null;
                cursor = 0;
                drawBack();
                return -1;
                /*
            case InputEvent.VK_0://output space
                if(engret != null){
                    termChar = engret + " ";
                    drawBack();
                }
                else
                    termChar = " ";
                engret = null;
                cursor = 0;
                return -1;
                */
            case InputEvent.VK_0://back space
                resetParam();
                bg.setColor(backColor);

                drawBack();
                break;
                
            case InputEvent.VK_CANCEL:
                //System.out.println("Say goodbye to AbcIME.............");

                resetParam();
                return 1;
        }
        //System.out.println("))<< ))<< ))<< ))<< the edge of ENG.............");
        return 2;
    }
    public void enter(){
        //System.out.println("-_-_-_-_-_-_-_-_-_-_-_abc");

        resetParam();
        Enggram = Tools.Lowgram;
        curState = stateLower;
        message = curState; 
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
        drawEtc(curState);
    }
    private void drawEtc(int state){
        bg.setColor(Color.white);
        if(state == stateCapital)
            bg.drawString("ABC",IMEetcx,IMEetcy);
        else
            bg.drawString("abc",IMEetcx+5,IMEetcy);   
    }
    private void drawLetter(int key){
        drawBack();
        bg.setColor(backColor);
       // bg.setColor(Color.blue);
       
     //   bg.fillRect(IMEabcx-5,IMEabcy-20,30,25);
        bg.setColor(unfocusColor);
        bg.drawString(engret,IMEabcx,IMEabcy);

        bg.setColor(backColor);
       // bg.fillRect(IMEabcdx-5,IMEabcdy-20,90,25);
        bg.setColor(unfocusColor);
        try{
            for(int i = 0; ;i++){
                bg.drawString((Enggram[key]).substring(i,i+1),IMEabcdx + i*IMEabcgap,IMEabcdy);
            }
        }catch(StringIndexOutOfBoundsException e){
            ;
        }
        bg.setColor(focusColor);
        bg.drawString(engret,IMEabcdx + cursor*IMEabcgap,IMEabcdy);

            
    }
    private void resetParam(){
        termChar = null;
        cursor = 0; 
        engret = null; 
        lastkey = 0;
    }
}

