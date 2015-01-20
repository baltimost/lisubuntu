package com.st.ime;

import org.avmsc.dtvm.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;

public class SymbolIME extends IME{
    private static int IMEsymx = 20;
    private static int IMEsymy = 46;
    private static int IMEsymdx = IMEsymx;
    private static int IMEsymdy = IMEh - 15;
    private static int symgap = 44;
    private static int maxcol = 9;
    private static int maxrow;
    private static int lastmaxcol;
    private int rowid = 0;
    private int colid = 0;
    private String Symbolgram[];

    private static BufferedImage symbolBufImage = null;
    private static Graphics symbolbg = null;
    private static Image Picfocus = toolkit.createImage("/workdir/MBT_resources/classes/app/notepad/24focus.gif");
    private static Image Picunfocus = toolkit.createImage("/workdir/MBT_resources/classes/app/notepad/24unfocus.gif");
    private static final int charw24 = 18;
    private static final int charw36 = 36;

    private int symbolmode = 0;
    private boolean isInput = false;
    
    protected SymbolIME(){
        symbolBufImage = Tools.getBufferedImage(IMEw,IMEh);
        symbolbg = symbolBufImage.getGraphics();
        symbolbg.setFont(new Font("default",Font.PLAIN,24));
    }

    protected void setMode(int mode){
        symbolmode = mode;
        if(mode == MainIME.statePY)
            Symbolgram = Tools.SymbolSBCgram;
        else
            Symbolgram = Tools.SymbolDBCgram;
        maxrow = Symbolgram.length/maxcol;
        if(Symbolgram.length%maxcol != 0){
            maxrow++;
            lastmaxcol = Symbolgram.length%maxcol;
        }
        //System.out.println("SSyymmbbooll: maxrow = " + maxrow);
        //System.out.println("SSyymmbbooll: lastmaxcol = " + lastmaxcol);
    }
    protected boolean getIsInput(){
        return isInput;
    }
    protected void setHD(boolean isHD){
        if(isHD){
            IMEsymx = 25;
            IMEsymy = 55;
            symgap = 50;
            IMEsymdx = IMEsymx;
            IMEsymdy = IMEh - 15;

            try{
            symbolBufImage = Tools.getBufferedImage(IMEw,IMEh);
            symbolbg = symbolBufImage.getGraphics();
            symbolbg.setFont(new Font("default",Font.PLAIN,36));
            //Picbg = toolkit.createImage("/workdir/MBT_resources/classes/app/journal/bg.png");
            Picfocus = toolkit.createImage("/workdir/MBT_resources/classes/app/journal/36focus.gif");
            Picunfocus = toolkit.createImage("/workdir/MBT_resources/classes/app/journal/36unfocus.gif");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            IMEsymx = 20;
            IMEsymy = 46;
            symgap = 44;
            IMEsymdx = IMEsymx;
            IMEsymdy = IMEh - 15;

            try{
            symbolBufImage = Tools.getBufferedImage(IMEw,IMEh);
            symbolbg = symbolBufImage.getGraphics();
            symbolbg.setFont(new Font("default",Font.PLAIN,24));
            //Picbg = toolkit.createImage("/workdir/MBT_resources/classes/app/journal/bg.png");
            Picfocus = toolkit.createImage("/workdir/MBT_resources/classes/app/notepad/24focus.gif");
            Picunfocus = toolkit.createImage("/workdir/MBT_resources/classes/app/notepad/24unfocus.gif");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    public int keyProcess(int key){
        int message = MainIME.curState;
        switch(key){
            case InputEvent.VK_CANCEL:
            case InputEvent.VK_COLORED_KEY_2:
                //System.out.println(" $ $ $ $ say goodbye to Symbol");
                message = symbolmode; 
                break;
            case InputEvent.VK_RIGHT:
                if(rowid < maxrow-1){
                    if(colid < maxcol-1){
                        colNext();
                    }
                    else{
                        colid = 0;
                        rowid++;
                        drawBack();
                        drawSymbol();
                        drawCol(colid,true);
                    }
                }
                else{
                    if(colid < lastmaxcol-1){
                        colNext();
                    }
                }
                //System.out.println("colid:"+colid);    
                //System.out.println("rowid:"+rowid);    
                break;
            case InputEvent.VK_LEFT:
                if(rowid > 0){
                    if(colid > 0){
                        colPrevious();
                    }
                    else{
                        colid = maxcol-1;
                        rowid--;
                        drawBack();
                        drawSymbol();
                        drawCol(colid,true);
                    }
                }
                else{
                    if(colid > 0){
                        colPrevious();
                    }
                }
                //System.out.println("colid:"+colid);    
                //System.out.println("rowid:"+rowid);    
                break;
            case InputEvent.VK_DOWN:
                if(rowid < maxrow-1){
                    rowid++;
                }
                if(rowid == maxrow-1){
                    if(colid > lastmaxcol-1)
                        colid = lastmaxcol-1;
                }
                drawBack();
                drawSymbol();
                drawCol(colid,true);
                //System.out.println("colid:"+colid);    
                //System.out.println("rowid:"+rowid);    
                break;
            case InputEvent.VK_UP:
                if(rowid > 0){
                    rowid--;
                }
                drawBack();
                drawSymbol();
                drawCol(colid,true);
                //System.out.println("colid:"+colid);    
                //System.out.println("rowid:"+rowid);    
                break;
            case InputEvent.VK_OK:
                //System.out.println(" $ $ $ $ OKOKOKOKOKO");
                //termChar = "?"; 
                termChar = Symbolgram[rowid*maxcol + colid];
                isInput = true;
                message = symbolmode;
                break;
                
        }
        graphics.drawImage(symbolBufImage,IMEx,IMEy,null);//move it
        return message;
    }
   
    public void enter(){
        //System.out.println(" >> >>>> >>>>> >>>>＞symbol enter "); 
        isInput = false;
        rowid = 0;
        colid = 0;
        drawBack();
        drawSymbol();
        drawCol(colid,true);
        graphics.drawImage(symbolBufImage,IMEx,IMEy,null);//move it
    }
    public void leave(){
        //drawBack();
    }
    protected void drawBack(){
        symbolbg.clearRect(0,0,IMEw,IMEh);
        symbolbg.drawImage(Picbg,0,0,null);
        symbolbg.setColor(Color.white);
        symbolbg.drawString(Tools.Sinogram[2],IMEetcx,IMEetcy);
    }
    protected void drawSymbol(){
        symbolbg.setColor(unfocusColor);
        if(rowid == maxrow-1){
            for(int i = 0 ;i < lastmaxcol;i++){
                symbolbg.drawString(Symbolgram[rowid*maxcol+i],IMEsymdx + symgap*i,IMEsymdy);
            }
        }
        else{
            for(int i = 0 ;i < maxcol;i++){
                symbolbg.drawString(Symbolgram[rowid*maxcol+i],IMEsymdx + symgap*i,IMEsymdy);
            }
        }
        if(rowid == 0)
            symbolbg.drawImage(Picunfocus,IMEsymdx,IMEsymdy-charw24,null);
    }
    protected void drawCol(int col,boolean focus){
        if(focus){
            symbolbg.setColor(focusColor);
            if(rowid == 0 && col == 0)
                symbolbg.drawImage(Picfocus,IMEsymdx,IMEsymdy-charw24,null);
        }
        else{
            symbolbg.setColor(unfocusColor);
            if(rowid == 0 && col == 0)
                symbolbg.drawImage(Picunfocus,IMEsymdx,IMEsymdy-charw24,null);
        }
        symbolbg.drawString(Symbolgram[rowid*maxcol+col],IMEsymdx + symgap*col,IMEsymdy);
    }
    protected void colNext(){
        colid++;
        drawCol(colid-1,false);
        drawCol(colid,true);
    }
    protected void colPrevious(){
        colid--;
        drawCol(colid+1,false);
        drawCol(colid,true);
    }
}

