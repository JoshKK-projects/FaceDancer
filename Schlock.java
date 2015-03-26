import java.util.*;
import java.lang.*;
public class Schlock{
	public static int[][]area = new int[25][80];
	public static int rightPP = 1;
	public static int leftPP = 1;
	public static ArrayList<String> danceMoves = new ArrayList<String>();
	public static int xheadCenter=0;	
	public static int yheadCenter=0;	

	public static void main(String [] args){
		for(int i =0;i<25;i++){
			for(int n=0;n<80;n++){
				area[i][n]=0;
			}
		}
		System.out.println("**~!~**WELCOME TO THE AMAZING FACEDANCER 9000**~!~**");
		faceBrace();
		printer();
		System.out.println("**~!~**WELCOME TO THE AMAZING FACEDANCER 9000**~!~**");
		System.out.println("You can combine moves, each line is a different move");
		System.out.println("Movelist - Left:j, Right:k, Smile:o, Frown:p, LineMouth:i,Shout:u");
		System.out.println("Flicker:f, FlickerR:g, FlickerL:d,Eyebounce:t,Eyebounceleft:r,EyebounceRight:y");
		System.out.println("Wink:w,WinkR:e,WinkL:q,WinkR:e,OpenEye:x,OpenEyeL:z,OpenEyeR:c");
		System.out.println("done:DANCE");
		Scanner moveSet = new Scanner(System.in);
		String moves = "";
		while(!"done".equals(moves)){	
			moves = moveSet.next();
			if(!"done".equals(moves)){
				danceMoves.add(moves);	
			}
		}
		printer();
		faceDance();
				
	}
	public static void faceDance(){
		
		for(final String moves:danceMoves){
						
			danceInstructor(moves);
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				System.out.println("You goooooofed!");
			}													
		}
		faceDance();
	}
	public static void danceInstructor(String moves){
		System.out.println(moves);
		for(int i=0;i<moves.length();i++){
			if(moves.charAt(i)=='o'){//why didn't i use a switch statement
				smileFrown(1);
			}
			else if(moves.charAt(i)=='p'){
				smileFrown(2);
			}
			else if(moves.charAt(i)=='i'){
				lineMouth();
			}
			else if(moves.charAt(i)=='u'){
				oFace();
			}
			else if(moves.charAt(i)=='j'){
				moveLeft();
			}
			else if(moves.charAt(i)=='k'){
				moveRight();
			}
			else if(moves.charAt(i)=='f'){
				eyeFlicker(3);
			}
			else if(moves.charAt(i)=='d'){
				eyeFlicker(1);
			}
			else if(moves.charAt(i)=='g'){
				eyeFlicker(2);
			}
			else if(moves.charAt(i)=='t'){
				pupilBounce(3);
			}
			else if(moves.charAt(i)=='r'){
				pupilBounce(1);
			}
			else if(moves.charAt(i)=='y'){
				pupilBounce(2);
			}
			else if(moves.charAt(i)=='w'){
				wink(3);
			}
			else if(moves.charAt(i)=='q'){
				wink(1);
			}
			else if(moves.charAt(i)=='e'){
				wink(2);
			}
			else if(moves.charAt(i)=='x'){
				openEyes(3);
			}
			else if(moves.charAt(i)=='z'){
				openEyes(1);
			}
			else if(moves.charAt(i)=='c'){
				openEyes(2);
			}
		}
		printer();
	}
	public static void faceBrace(){
		for(int i=0;i<20;i++){//top/bottom of face
			area[18][30+i]=5;
			area[2][30+i]=5;
		}
		for(int i=0;i<16;i++){//sides of face
			area[3+i][30]=6;
			area[3+i][50]=6;
		}
		for(int i=0;i<4;i++){
			area[5][i+33]=1;
			area[8][i+33]=1;//left eye horizontal
			area[5][i+43]=1;
			area[8][i+43]=1;//right eye horizontal

			area[5+i][33]=2;
			area[5+i][37]=2;//left eye vertical
			area[5+i][43]=2;
			area[5+i][47]=2;//right eye vertical
		}
		area[6][35]=7;//pupils
		area[6][45]=71;
		for(int i=0;i<3;i++){
			area[10+i][40-i]= 3;//bridge of nose
		}
		area[13][38]=33;//other bit of nose
		area[13][39]=33;
		for(int i=0;i<10;i++){//mouth
			area[15][35+i] = 11;
		}
	}
	public static void printer(){
		for(int i =0;i<25;i++){
			for(int n=0;n<80;n++){
				if(area[i][n]==0){
					System.out.print(' ');
				}
				else if(area[i][n]==1){
					System.out.print('-');//eyebits
				}
				else if(area[i][n]==11){
					System.out.print('-');//mouth
				}
				else if(area[i][n]==111){
					System.out.print('-');//lazyass pupil holder
				}
				else if(area[i][n]==2){
					System.out.print('|');//eyebits
				}
				else if(area[i][n]==3){
					System.out.print('/');//nose
				}
				else if(area[i][n]==33){
					System.out.print('-');//nose
				}
				else if(area[i][n]==4){//left eye
					System.out.print('*');
				}
				else if(area[i][n]==41){//right eye
					System.out.print('*');
				}
				else if(area[i][n]==5){
					System.out.print('_');//top/bottom headbits
				}
				else if(area[i][n]==6){
					System.out.print('|');//side of headbits
				}
				else if(area[i][n]==7){//left eye
					System.out.print('#');
				}
				else if(area[i][n]==71){//right eye
					System.out.print('#');
				}
			}
		}
	}
	public static void oFace(){
		for(int i =0;i<25;i++){
			for(int n=0;n<80;n++){
				if(area[i][n]==11){
					area[i][n]=0;
				}
			}
		}
		area[15+1][37+xheadCenter]=11;
		area[15+1][42+xheadCenter]=11;
		
		area[15][37+xheadCenter]=11;
		area[15][42+xheadCenter]=11;

		area[15+(-1)][38+xheadCenter]=11;	
		area[15+(-1)][39+xheadCenter]=11;
		area[15+(-1)][40+xheadCenter]=11;
		area[15+(-1)][41+xheadCenter]=11;


		area[15+(+2)][38+xheadCenter]=11;	
		area[15+(+2)][39+xheadCenter]=11;
		area[15+(+2)][40+xheadCenter]=11;
		area[15+(+2)][41+xheadCenter]=11;
		
	}
	public static void lineMouth(){
		for(int i =0;i<25;i++){
			for(int n=0;n<80;n++){
				if(area[i][n]==11){
					area[i][n]=0;
				}
			}
		}
		for(int i=0;i<10;i++){//mouth
			area[15][35+i+xheadCenter] = 11;
		}
	}
	public static void smileFrown(int sf){
		int go=1;
		int mod=0;
		if(sf==1){
			mod = -1;
		}
		else if(sf==2){
			mod = 1;
		}
		for(int i =0;i<25;i++){
			for(int n=0;n<80;n++){
				if(area[i][n]==11){
					area[i][n]=0;
				}
			}
		}
		area[15+mod][35+xheadCenter]=11;
		area[15+mod][44+xheadCenter]=11;
		
		area[15][36+xheadCenter]=11;
		area[15][37+xheadCenter]=11;
		area[15][42+xheadCenter]=11;
		area[15][43+xheadCenter]=11;

		area[15+(mod*-1)][38+xheadCenter]=11;	
		area[15+(mod*-1)][39+xheadCenter]=11;
		area[15+(mod*-1)][40+xheadCenter]=11;
		area[15+(mod*-1)][41+xheadCenter]=11;

	}
	public static void eyeFlicker(int eyes){
		for(int i =0;i<25;i++){
			for(int n=0;n<80;n++){
				if(area[i][n]==4&&(eyes==1 || eyes==3)){
					area[i][n]=7;
				}
				else if(area[i][n]==7&&(eyes==1 || eyes==3)){
					area[i][n]=4;
				}
				else if(area[i][n]==41&&(eyes==2 || eyes==3)){
					area[i][n]=71;
				}
				else if(area[i][n]==71&&(eyes==2 || eyes==3)){
					area[i][n]=41;
				}
			}
		}
	}
	public static void pupilBounce(int eyes){
		int movedL = 1;
		int movedR = 1;
		for(int i =0;i<25;i++){
			for(int n=0;n<80;n++){
				if((area[i][n]==4 || area[i][n]==7)&&movedL==1&&(eyes==1 || eyes==3)){
					System.out.println(i+" "+leftPP+" "+area[i][n]+" "+area[i+leftPP][n]+" "+n);
					area[i+leftPP][n]=area[i][n];
					area[i][n]=0;
					leftPP*=-1;
					movedL--;
				}
				else if((area[i][n]==41 || area[i][n]==71) && movedR==1&&(eyes==2 || eyes==3)){
					System.out.println("D");
					area[i+rightPP][n]=area[i][n];
					area[i][n]=0;
					rightPP*=-1;
					movedR--;
				}
			}
		}
		
	}
	
	public static void moveLeft(){
		for(int i =0;i<25;i++){
			for(int n=0;n<80;n++){
				if(area[i][n]!=0){
					area[i][n-6] = area[i][n];
					area[i][n] = 0;
				}
			}
		}
		xheadCenter-=6;//MOVE TO TEACH SKAGS SCOPE
	}
	public static void moveRight(){
		for(int i =24;i>0;i--){
			for(int n=79;n>0;n--){
				if(area[i][n]!=0){
					area[i][n+6] = area[i][n];
					area[i][n] = 0;
				}
			}
		}
		xheadCenter+=6;//THIS ONE TOO
	}
	public static void wink(int winks){
		for(int i =0;i<25;i++){
			for(int n=0;n<80;n++){
				if(area[i][n]==1 || area[i][n]==2){
					area[i][n]=0;
				}
			}
		}
		if(winks==1){
			for(int i =0;i<25;i++){
				for(int n=0;n<80;n++){
					if(area[i][n]==4||area[i][n]==7){
						area[i][n]=111;
						area[i][n+1]=111;
						area[i][n+2]=111;
						area[i][n-1]=111;
						area[i][n-2]=111;
						for(int j=0;j<4;j++){
							area[5][j+43+xheadCenter]=1;
							area[8][j+43+xheadCenter]=1;
							area[5+j][43+xheadCenter]=2;
							area[5+j][47+xheadCenter]=2;
						}					
					}
				}
			}
		}
		if(winks==2){
			for(int i =0;i<25;i++){
				for(int n=0;n<80;n++){
					if(area[i][n]==41||area[i][n]==71){
						area[i][n]=111;
						area[i][n+1]=111;
						area[i][n+2]=111;
						area[i][n-1]=111;
						area[i][n-2]=111;
						for(int j=0;j<4;j++){
							area[5][j+33+xheadCenter]=1;
							area[8][j+33+xheadCenter]=1;
							area[5+j][33+xheadCenter]=2;
							area[5+j][37+xheadCenter]=2;
						}					
					}
				}
			}
		}
		if(winks==3){
			for(int i =0;i<25;i++){
				for(int n=0;n<80;n++){
					if(area[i][n]==4||area[i][n]==7 || area[i][n]==41 || area[i][n]==71){
						area[i][n]=111;
						area[i][n+1]=111;
						area[i][n+2]=111;
						area[i][n-1]=111;
						area[i][n-2]=111;					
					}
				}
			}
		}
			
	}
	public static void openEyes(int opens){
		for(int i=0;i<25;i++){
			for(int n=0;n<80;n++){
				if(area[i][n]==1 || area[i][n]==2 || area[i][n]==111){
					area[i][n]=0;
				}
			}
		}
		if(opens==1 || opens==3){
			for(int i=0;i<4;i++){
					area[5][i+33+xheadCenter]=1;
					area[8][i+33+xheadCenter]=1;
					area[5+i][33+xheadCenter]=2;
					area[5+i][37+xheadCenter]=2;
					area[6][35+xheadCenter]=7;
			}	
		}
		if(opens==2 || opens==3){
			for(int i=0;i<4;i++){
					area[5][i+43+xheadCenter]=1;
					area[8][i+43+xheadCenter]=1;
					area[5+i][43+xheadCenter]=2;
					area[5+i][47+xheadCenter]=2;
					area[6][45+xheadCenter]=7;
			}	
		}
		if(opens==1){
			area[6][45]=111;
			area[6][45+1+xheadCenter]=111;
			area[6][45+2+xheadCenter]=111;
			area[6][45-1+xheadCenter]=111;
			area[6][45-2+xheadCenter]=111;
		}
		if(opens==2){
			area[6][35]=1;
			area[6][35+1+xheadCenter]=111;
			area[6][35+2+xheadCenter]=111;
			area[6][35-1+xheadCenter]=111;
			area[6][35-2+xheadCenter]=111;
		}
	}
	
}