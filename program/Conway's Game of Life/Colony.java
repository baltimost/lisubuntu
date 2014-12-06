//package myGame.GameOfLife;

import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class Colony {
	private JButton[][] cell;
	private JLabel popLab;
	private JLabel genLab;
	private boolean[][] sign;
	private int length;
	private int width;

    /** Randomly decides who's dead, who's alive */    
	public void setCell(){
		Random random = new Random();
		int ranNum;
		for(int i=0;i<width;i++){
            for(int j=0;j<length;j++){
                ranNum = random.nextInt(10);
                if(ranNum == 0){
                    cell[i][j].setBackground(Color.black);
                }
            }
        }
		popLab.setText("<htmL><center><br>Population:<br>"+getPopulation()+"</center></html>");
	}

    public JButton getCell(int latitude, int longitude){
        return cell[latitude][longitude];
    }
    
    public JLabel getLpop(){
    	return popLab;
    }
    
    public JLabel getLgen(){
    	return genLab;
    }
    
    /** Calculates the population of the colony */
    public int getPopulation(){
    	int population = 0;
    	for(int i=0;i<width;i++)
    		for(int j=0;j<length;j++)
    			if(cell[i][j].getBackground().equals(Color.black))
    				population++;
        return population;
    } 

    /** Shows whether a certain cell is alive or not */
	public boolean isAlive(int latitude, int longitude){
		if(cell[latitude][longitude].getBackground().equals(Color.black))
            return true;
        else
            return false;

	}
    
    /** Calculates neighborhood population */
    public int getNeiPop(int latitude, int longitude){
        int i=latitude;
        int j=longitude;
        int sum=0;
        try{
            if(isAlive(i-1,j-1))
                sum++;
        }catch(Exception e){
            ;
        }
        try{
            if(isAlive(i-1,j))
                sum++;
        }catch(Exception e){
            ;
        }
        try{
            if(isAlive(i-1,j+1))
                sum++;
        }catch(Exception e){
            ;
        }
        try{
            if(isAlive(i,j-1))
                sum++;
        }catch(Exception e){
            ;
        }
        try{
            if(isAlive(i,j+1))
                sum++;
        }catch(Exception e){
            ;
        }
        try{
            if(isAlive(i+1,j-1))
                sum++;
        }catch(Exception e){
            ;
        }
        try{
            if(isAlive(i+1,j))
                sum++;
        }catch(Exception e){
            ;
        }
        try{
            if(isAlive(i+1,j+1))
                sum++;
        }catch(Exception e){
            ;
        }
        return sum;
    }

    public int getWidth(){
        return width;
    }

    public int getLength(){
        return length;
    }

    /** According to the Rules of Live, decides whether a cell
     *  should die or not. */
    public boolean Willalive(int sum, boolean isAlive){
        if(isAlive){
            if(sum==2 || sum==3)
                return true;
            else
                return false;
        }
        else{
            if(sum==3)
                return true;
            else
                return false;
        }
    }
    
    /** Let the cells interact with each other according to the rules */
    public void evolve(){
    	for(int g=0;true;g++){
    		for(int i=0;i<width;i++){
    			for(int j=0;j<length;j++){
    				int sum = getNeiPop(i,j);
    				boolean isalive = isAlive(i,j);
    				if(Willalive(sum,isalive)){
    					sign[i][j]=true;
    				}
    				else
    					sign[i][j]=false;
    			}
    		}
    		for(int i=0;i<width;i++){
    			for(int j=0;j<length;j++){
    				if(sign[i][j]){
    					cell[i][j].setBackground(Color.black);
    				}
    				else
    					cell[i][j].setBackground(Color.white);
    				cell[i][j].revalidate();
    			}
    		}
    		genLab.setText("<html><center><br>Generation:<br>"+g+"</center></html>");
    		popLab.setText("<htmL><center><br>Population:<br>"+getPopulation()+"<br></center></html>");
    		try{
    			Thread.sleep(80);
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    	}
    }

	
    /** Initializes the cells of colony. No lives at first. */ 
	private void init(int width, int length){
        this.width = width;
        this.length = length;
		cell = new JButton[width][length];
		sign = new boolean[width][length];
		popLab = new JLabel("Population:");
		genLab = new JLabel("Generation:");
        for(int i=0;i<width;i++)
            for(int j=0;j<length;j++){
                cell[i][j] = new JButton();
                cell[i][j].setBackground(Color.white);
            }
        genLab.setText("<html><center><br>Generation:<br>0</center></html>");
		popLab.setText("<htmL><center><br>Population:<br>0</center></html>");
	}
    
    public void reset(){
        for(int i=0;i<width;i++)
            for(int j=0;j<length;j++){
                cell[i][j].setBackground(Color.white);
                sign[i][j]=false;
            }
        genLab.setText("<html><center><br>Generation:<br>0</center></html>");
		popLab.setText("<htmL><center><br>Population:<br>0</center></html>");
    }
	
	public Colony(int width, int length){
		init(width, length);
	}
}
