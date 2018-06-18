import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java. util.*;
import java.lang.Integer;
public class test{
	static int [][] arry;
	
	public static void getimageRGB(BufferedImage p_rgb) throws IOException{
		//read rgb
		int[] argb = new int[4];
		int width = p_rgb.getWidth();
		int height = p_rgb.getHeight();
		int minx = p_rgb.getMinX();
        int miny = p_rgb.getMinY();
		int[][] arry_p = new int[height][width];
		arry = new int[height][width];
		System.out.println("w:"+width+",h:"+height+".");
		//System.out.println("minx:"+minx+"miny:"+miny+".");
		for(int j = miny;j < height; j++){
			//System.out.printf("c%2d: ",j);
			for (int i = minx;i < width; i++){
				int pixel = p_rgb.getRGB(i, j); 
                argb[0] = (pixel & 0xff0000) >> 16;
                argb[1] = (pixel & 0xff00) >> 8;
                argb[2] = (pixel & 0xff);
				arry_p[j][i] = pixel;
				arry[j][i] = pixel;
				//System.out.println("i=" + i + ",j=" + j + ":(" + argb[0] + ","+ argb[1] + "," + argb[2] + "),pixel="+arry_p[i][j]);
				//System.out.print(arry_p[j][i]);
				//System.out.print(" ,");
				//setRGB
				//p_rgb.setRGB(j, i, 123);
			}
			//System.out.println(" ");
		}
	}
	
	public static void cal(){
		int[][] count = new int [arry.length*arry[0].length][2];
		//
		for(int x = 0;x<count.length;x++){
			count[x][0]=0;
			count[x][1]=0;
		}
		//
		int cal_count =0;
		int newone =0;
		boolean set = false;
		for(int j = 0 ; j < arry.length ; j++){
			for(int i = 0; i< arry[j].length ; i++){
				for(int c=0;c<count.length;c++){
					
					if(arry[j][i]==count[c][0]){
						count[c][1]=count[c][1]+1;
						//System.out.println("count +"+c);
						c=count.length;
					}
					if(c==(count.length-1)){
						count[newone][0]=arry[j][i];
						count[newone][1]=count[newone][1]+1;
						newone++;
						//System.out.println("count new"+newone);
					}
					
					//System.out.println(cal_count+1);
					//cal_count++;
					/*else if{
						count[c][0]=arry[j][i];
						count[c][1]++;
						System.out.println("count new"+c);
					}*/
				}
			}
		}
		//
		for(int z = 0 ;z<count.length ;z++){
			if(count[z][0]!=0){
			System.out.println(count[z][0]+":"+count[z][1]);
			}
		}
		System.out.println("input messege(interge):");
		Scanner keyin = new Scanner(System.in);
		int mes = keyin.nextInt();
		String msg = Integer.toBinaryString(mes);
		//System.out.println("your messege:"+msg);
		/*開始找處最多的p值,然後把msg放進去*/
		int s =2;
		System.out.println("get messege:"+msg.charAt(1));
		
	}
	
	public static void main(String[] args) throws IOException{
		int msg=0;//to bin 
		BufferedImage p1 = null;
		File f = null;
		
		//read file
		try{
			f = new File("tt.png");//
			p1 = ImageIO.read(f);
			//System.out.println("read success");
		}catch(IOException e){
			System.out.println("Error:"+e);
		}
		getimageRGB(p1);
		cal();
		
		//write
		/*try{
			f = new File("output.png");
			ImageIO.write(p1,"png",f);
			System.out.println("print success");
		}catch(IOException e){
			System.out.println("Error:"+e);
		}*/
	}
}