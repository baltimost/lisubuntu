package com.st.ime;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

public class Tools{
    public static BufferedImage getBufferedImage(int width, int height){
        BufferedImage bi = null; 
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        bi = gc.createCompatibleImage(width,height);
        return bi;
    }

    public static String[] mysplit(String str, char regex ,int size){
        String[] strings = new String[size];
        String[] retstr;
        int i = 0;
        int j = 0;
        int k = 0;
        for(;i<str.length();){
            if(str.charAt(i) == regex){
                if(i == j){
                    i++;
                    j = i;
                }
                else{
                    strings[k] = str.substring(j,i);
                    k++;
                    j = i;
                }
            }
            else{
                i++;
            }
        }
        if(j != i){//collect the last one
            strings[k] = str.substring(j,i);
            k++;
        }
        retstr = new String[k];
        for(i = 0;i<k;i++){
            retstr[i] = strings[i];
        }
        return retstr;
    }

    public static String[] hzsplit(String str,char regex,int size){
        String[] strings = new String[size];
        String[] retstr;
        int i;
        for(i = 0;(i < str.length()) && str.charAt(i) != regex; i++){
            strings[i] = str.substring(i,i+1);
        }
        retstr = new String[i];
        for(int j = 0;j < i;j++){
            retstr[j] = strings[j];
        }
        return retstr;
    }

    public static final String Sinogram[] = {
        "Æ´Òô",
        "ÊäÈë·¨",
	    "·ûºÅ",
    };
    public static final String Lowgram[] = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz",
    };
    public static final String Capgram[] = {
        "",
        "",
        "ABC",
        "DEF",
        "GHI",
        "JKL",
        "MNO",
        "PQRS",
        "TUV",
        "WXYZ",
    };
    public static final String SymbolDBCgram[] = {
        " ",//space
        ",",
        ".",
        "?",
        "!",
        "'",
        "-",
        "_",
        ":",
        ";",
        "\"",
        "(",
        ")",
        "[",
        "]",
        "{",
        "}",
        "\\",
        "/",
        "~",
        "@",
        "#",
        "^",
        "&",
        "*",
        "%",
        "|",
        "`",
        "+",
        "-",
    };
    public static final String SymbolSBCgram[] = {
        " ",
        "£¬",
        "¡£",
        "£¿",
        "£¡",
        "¡¢",
        "¡­",
        "£º",
        "£»",
        "¡®",
        "¡¯",
        "¡°",
        "¡±",
        "£¨",
        "£©",
        "¡¶",
        "¡·",
        "£Û",
        "£Ý",
        "£û",
        "£ý",
    };
}

