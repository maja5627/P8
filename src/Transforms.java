 // P8 Assignment
// Author: Mat Jackson
// Date:   Oct 14, 2018
// Class:  CS163
// Email:  mat1121@rams.colostate.edu
public class Transforms implements ImageInterface{
	PictureLibrary picLib = null;
	int picWidth = 0;
	int picHeight = 0; 
	int[][] image;
	
	 public Transforms(){
	        //Instantiate PictureLibrary object
		 picLib = new PictureLibrary();
		 
	    }
	
	@Override
	public void readImage(String inFile) {
		  try {
			  picLib.readPGM(inFile);
			 picHeight = picLib.getHeight();
			 picWidth = picLib.getWidth();
			 image = picLib.getData();
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
	}

	@Override
	public void writeImage(String outFile) {
		 try {
		       picLib.setData(image);
		       picLib.writePGM(outFile);
		       
		    } catch (Exception e) {
		        System.out.println(e.getMessage());
		    }
		
	}

	@Override
	public int[][] imageData() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public void decode() {
		for (int i = 0 ; i < image.length ; i++) {
			for (int j = 0; j < image[i].length ; j++) {
			
			int upperBits = image[i][j] / 16;
			int lowerBits = image[i][j] % 16; 
			
			upperBits = 15 - upperBits;
			
			image[i][j] = (upperBits * 16) + lowerBits;
 			
 				
			}
		}
	}
		
	

	@Override
	public void swap() {
		for (int i = 0 ; i < image.length ; i++) {
			for (int j = 0; j < image[i].length ; j++) {
			int newPixcel = 0; 
			int upperBits = image[i][j] / 16;
			int middleBits = image[i][j];
			int lowerBits = image[i][j] % 16;
			newPixcel = (lowerBits<<6)|middleBits|(upperBits>>6);
		
 		
			}
		}
	}

	@Override
	public void mirror() {
		for (int i = 0 ; i < image.length ; i++) {
			for (int j = 0; j < image[i].length ; j++) {
				int placeHolder [] ;
				placeHolder = new int [i];
				
				
				
				
				}
			}
		}
	

	@Override
	public void exchange() {
		
		
		
	}
}