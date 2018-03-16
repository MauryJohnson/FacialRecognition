

public class FacialRecog {

	public static void main(String[] args) {
		
		Picture p = new Picture("C:\\Users\\MAURY II\\Desktop\\My Man.jpg");
		
		p.write("C:\\Users\\MAURY II\\Desktop\\My Man Modified.jpg");
		
		
		
		//Used to highlight the person's facial features: mouth, nose, and eyes.
		int width = 100;
		int height = 100;
		// Used to help iterate through the entire picture to look for pixels related to eyes, nose, and mouth
		int Width = p.getWidth();
		int Height = p.getHeight();
		int red;
		int green;
		int blue;
		Pixel pixel;
		for(int i=0; i<Height; i++){
			for(int k =0; k<Width; k++){
				pixel=p.getPixel(k,i);
				red = pixel.getRed();
				green = pixel.getGreen();
				blue = pixel.getBlue();
				//Comparing a pixel's color components to the requirements for the eye! CONTINUE LATER
				if(red>=0&&red<=50&&green>=0&&green<=50&&blue>=0&&blue<=50){
					//System.out.print("Made it" + red + green + blue);
					//System.out.print("This is" + i + "And " + k);
				  Trace(i, k, height, width,p);
				  
				  //Finds area with the greatest number of red pixels traced.
				  FindAverage(i,k,height,width,p);
				  
				}
				
				/* else if ((red>=75&&red<=94&&green>=18&&green<=35&&blue>=0&&blue<=8)){
					 Trace(i, k, height, width,p);
					  
					 
					 FindAverage(i,k,height,width,p);
					
				}*/
				
			}
		}
		
		
		//Restores the dark parts of the image.
		ReTrace(p);
		
		
		p.write("C:\\Users\\MAURY II\\Desktop\\MyManSquared2.jpg");
			
		
	}
	

	public static Picture Trace(int i, int j, int height, int width, Picture p){
		for(int z=0; z<p.getWidth(); z++){
			for(int y=0; y<p.getHeight(); y++){
				if(z==0){
					p.setBasicPixel(j, i, (int)(Math.pow(16, 4)*255+(int)(Math.pow(16, 0)*255)+(int)(Math.pow(16, 2)*0)));
				}
				else if( z == height-1){
					p.setBasicPixel(j, i, (int)(Math.pow(16, 4)*0+(int)(Math.pow(16, 0)*0)+(int)(Math.pow(16, 2)*255)));
				}
				if(y==0){p.setBasicPixel(j, i, (int)(Math.pow(16, 4)*0+(int)(Math.pow(16, 0)*255)+(int)(Math.pow(16, 2)*0)));
				}
				else if(y==width-1){
					p.setBasicPixel(j, i, (int)(Math.pow(16, 4)*255+(int)(Math.pow(16, 0)*0)+(int)(Math.pow(16, 2)*0)));
					}
				}
			}	
			
		
		return p;
	}
	
	public static Picture ReTrace(Picture p){
	
		for(int z=0; z<p.getWidth(); z++){
			for(int y=0; y<p.getHeight(); y++){

					
				 if(p.getPixel(z,y).getRed()>=230&&p.getPixel(z,y).getRed()<=255&&p.getPixel(z,y).getGreen()>=0&&p.getPixel(z,y).getGreen()<=15&&p.getPixel(z,y).getBlue()>=0&&p.getPixel(z, y).getBlue()<=15){	//System.out.print("This is" + i + "And " + k);
					 p.setBasicPixel(z, y, (int)(Math.pow(16, 4)*0+(int)(Math.pow(16, 0)*0)+(int)(Math.pow(16, 2)*0)));
				 }
				}
			}	
			
			
		
		
		return p;
	}
	public static void FindAverage(int i, int j, int height, int width, Picture p){
		int length = 15;
		int length2 = 15;
		int AveragePixel = 0;
		if(i-length>0&&j-length2>0){
			
			i=i-(length/2);
			j=j-(length2)/2;
			
		}
			
		for(int z=i; z<i+length&&z<p.getHeight(); z++){
			for(int c=j; c<j+length2&&c<p.getWidth(); c++){
				if(p.getPixel(c, z).getRed()>=230&&p.getPixel(c, z).getRed()<=255&&p.getPixel(c, z).getGreen()>=0&&p.getPixel(c, z).getGreen()<=15&&p.getPixel(c, z).getBlue()>=0&&p.getPixel(c, z).getBlue()<=15){
					AveragePixel++;
				
				}
				else if(p.getPixel(c, z).getRed()>=230&&p.getPixel(c, z).getRed()<=255&&p.getPixel(c, z).getGreen()>=0&&p.getPixel(c, z).getGreen()<=15&&p.getPixel(c, z).getBlue()>=0&&p.getPixel(c, z).getBlue()<=15){
					AveragePixel++;
					
				}
				
			}
		}
				//Only draw square around an average number of pixels greater than 20 and less than 40.
				if(AveragePixel>=20&&AveragePixel<=50){
					
			
					for(int z=i; z<i+length&&z<p.getHeight(); z++){
						for(int c=j; c<j+length2&&c<p.getWidth(); c++){
							
							if(z==i){
								p.setBasicPixel(c, z, (int)(Math.pow(16, 4)*255+(int)(Math.pow(16, 0)*255)+(int)(Math.pow(16, 2)*0)));
								
							}
							else if( z == i+length-1){
								p.setBasicPixel(c, z, (int)(Math.pow(16, 4)*0+(int)(Math.pow(16, 0)*0)+(int)(Math.pow(16, 2)*255)));
								
							}
							if(c==j){p.setBasicPixel(c, z, (int)(Math.pow(16, 4)*0+(int)(Math.pow(16, 0)*255)+(int)(Math.pow(16, 2)*0)));
								
							}
							else if(c==j+length2-1){
								p.setBasicPixel(c, z, (int)(Math.pow(16, 4)*255+(int)(Math.pow(16, 0)*0)+(int)(Math.pow(16, 2)*0)));
							
								}
							
						}
					}
					
					
					
					
					
				}
		
		
		
	
		
		
		return;
	}

}
