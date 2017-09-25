package model;

public class Panel {

	// Taille de la fenêtre en pixels
	 public static int WIDTH = 500;
	 public static int HEIGHT = 500;
		
	// Marges en pixels
     public static int MARGIN = 32;
    
    // Echelle: 40 pixels = 1m
     public static double SCALE = 40;
    
	// coordonnees du plan en mètres
	 public static double XMIN = 0;
	 public static double YMIN = 0;
	 public static double XMAX = 10;
	 public static double YMAX = 10;

	 
	 public int GetWIDTH(){
		 return Panel.WIDTH;
	 }
	 
	 public int GetHEIGHT(){
		 return Panel.HEIGHT;
	 }
	 
	 public int GetMARGIN(){
		 return Panel.MARGIN;
	 }
	 
	 public double GetSCALE(){
		 return Panel.SCALE;
	 }
	
	 public double XMIN(){
		 return Panel.XMIN;
	 }
	 
	 public double GetYMIN(){
		 return Panel.YMIN;
	 }
	 
	 public double GetXMAX(){
		 return Panel.XMAX;
	 }
	 
	 public double GetYMAX(){
		 return Panel.YMAX;
	 }
	
		
}
