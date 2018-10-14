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
	   // original pixel = 114 = 0b01110010
	   // upper two bits of original = 0b01110010 & 0b11000000 = 0b01000000
	   // middle four bits of original = 0b01110010 & 0b00111100 = 0b00110000
	   // lower two bits of original = 0b01110010 & 0b00000011 = 0b00000010
	   // new pixel = (lower << 6) | middle | (upper >> 6)
	    
	    
		for (int i = 0 ; i < image.length ; i++) {
			for (int j = 0; j < image[i].length ; j++) {
			    
			    int originalPixel = image[i][i];
			    int newPixel = 0; 
			    
			    
			    
			    
			
			int upperBits = image[i][j] / 32;
			int middleBits = image[i][j];
			int lowerBits = image[i][j] % 32;
			newPixel = (lowerBits<<6)|middleBits|(upperBits>>6);
		
 		
			}
		}
	}

	@Override
	public void mirror() {
	    //;Calling mirror reverses the image top to bottom. 
	    //To reverse top to bottom, exchange the first row for the last row, the second row for the second to last row, and so on until the entire image is reversed.
		
	    // 
	    //
	    //image[height][width] 
	    
	    // ########## i = 0 
	    // ########## i = 1 
	    
	    // ########## i = height - 1
	    // ########## i = height - 0
	    int height = image.length; 
	    
	    for (int i = 0; i < height / 2; i++) {
	        int width = image[i].length;
	        
	        for(int j = 0; j < width; j++){ 
	            int temp = image[i][j];
	            image[i][j] = image[height-i-1][width-j-1];
	            image[height-i-1][width-j-1] = temp;
	        }
	    }
	    
	   
		}
	

	@Override
	public void exchange() {
		
		
		
	}
}