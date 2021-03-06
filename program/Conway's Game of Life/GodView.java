//package myGame.GameOfLife;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class GodView extends JFrame{
    private Colony colony;
	private JPanel colonyPane;
	private JPanel infoPane;
	private JButton ranButton;
	private JButton startButton;
	private JButton resetButton;
	private JButton testButton;
	private JLabel popLab;
	private JLabel genLab;
	private JLabel hintLab;
    /** Colony range */
	private int length = 125;
	private int width = 80;
    /** Cell side */
    private int side = 8;
    /** Colony panel */
    private int cx=10, cy=10;
    private int cplength = length*side;
    private int cpwidth = width*side;
    /** Info panel */
    private int ix=cx+cplength+10, iy=cy;
    private int iplength = 160;
    private int ipwidth = cpwidth;
    
    evolveRun eR;
	Thread evolveTh;
	boolean isStarted = false;

	public GodView(){
		setTitle("Conway's Game of Life");
        setLayout(null);
        setSize(cplength+iplength+40,cpwidth+50);
        
        /** Instantiates Colony */
        colony = new Colony(width,length);

		/** Colony Panel */
		colonyPane = new JPanel();
        colonyPane.setLayout(null);
        colonyPane.setBounds(cx,cy,cplength,cpwidth);
		
		/** Information Panel */
		infoPane = new JPanel();
		infoPane.setBackground(Color.orange);
        infoPane.setBounds(ix,iy,iplength,ipwidth);
		
        /** Adds cells to Colony Panel.
         *  And set Listener */
        for(int i=0;i<width;i++){
            for(int j=0;j<length;j++){
                JButton cellNiche = colony.getCell(i,j); 
                cellNiche.setBounds(j*side,i*side,side,side);
                colonyPane.add(cellNiche);
                cellNiche.addActionListener(
                        new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                            	JButton cell = (JButton)e.getSource();
                            	if(cell.getBackground().equals(Color.white))
                                	cell.setBackground(Color.black);
                            	else
                            		cell.setBackground(Color.white);
                                popLab.setText("<htmL><center><br>Population:<br>"+colony.getPopulation()+"<br></center></html>");
                            }
                        });
            }
        }
        
        /** Initializes Information Panel contents */
        hintLab = new JLabel("<html><strong>HINT:</strong></B><br><br>" +
        		"1.<br>Click on Gun&Glider to <br>demonstrate the test <br>sample.<br>" +
        		"2.<br>Click on the grid to  <br>give birth to the cells.<br>" +
        		"3.<br>Click on Random to <br>randomly give birth <br>to the cells.<br>" +
        		"4.<br>Click on Start to <br>start evolve.<br>" +
        		"5.<br>Click on Reset to <br>kill all the cells <br> and stop the game.<br><br></html>");
       // hintLab.setBounds(100,100,130,30);
        testButton = new JButton("Gun&Glider");
        testButton.addActionListener(new testListener());
        
		ranButton = new JButton("   Random  ");
        ranButton.addActionListener(new ranListener());

		startButton = new JButton("     Start      ");
		startButton.setSize(20,20);
        startButton.addActionListener(new startListener());


		popLab = colony.getLpop();
		popLab.setBounds(20,20,150,50);
		genLab = colony.getLgen();

        resetButton = new JButton("    Reset     ");
        resetButton.addActionListener(new resetListener());

        /** Adds components to Information Panel */
        infoPane.add(hintLab);
        infoPane.add(testButton);
        infoPane.add(ranButton);
        infoPane.add(startButton);
        infoPane.add(resetButton);
        infoPane.add(popLab);
        infoPane.add(genLab);
		
        /** Adds panels to Window */
		add(colonyPane);
		add(infoPane);
	}
	
	class testListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				FileReader shapeReader = new FileReader("GunGlider.txt");
				BufferedReader breader = new BufferedReader(shapeReader);
				for(int i=0;i<width;i++){
					String[] line = breader.readLine().split(";");
					for(int j=0;j<length;j++){
						if(line[j].equals("1")){
							colony.getCell(i, j).setBackground(Color.black);
							popLab.setText("<htmL><center><br>Population:<br>"+colony.getPopulation()+"<br></center></html>");
						}
					}
				}
				
			}catch(Exception writerE){
				writerE.printStackTrace();
			}
		}
	}
	
    class ranListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            colony.setCell();
        }
    }
    
    class resetListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	isStarted = false;
            colony.reset();
            if(evolveTh!=null)
            	evolveTh.stop();
        }
    }
    
    class startListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	if(!isStarted){
	        	isStarted = true;
        		eR = new evolveRun();
	        	evolveTh = new Thread(eR);
	        	evolveTh.start();
        	}
        
	        try{
	        	FileWriter shape = new FileWriter("Shape.txt");
	        	for(int i=0;i<width;i++){
	        		String line = "";
	        		for(int j=0;j<length;j++){
	        			if(colony.getCell(i,j).getBackground().equals(Color.black)){
	        				line = line+"1"+";";
	        			}
	        			else
	        				line = line+"0"+";";
	        		}
	        		shape.append(line+"\n");
	        	}
	        	shape.close();
	        }catch(Exception writerE){
	        		writerE.printStackTrace();
	        }
        }
    }
    
    class evolveRun implements Runnable{
    	public void run(){
    		colony.evolve();
    	}
    }

	public static void main(String[] args){
        System.setProperty("java.util.Arrays.useLegacyMergeSort","true");
		GodView godView = new GodView();
		godView.setVisible(true);
		godView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        godView.getContentPane().setBackground(Color.black);
        godView.setResizable(false);
		
	}
}
