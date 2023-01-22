package graphpanels;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class usecGraphPanel extends JPanel{
	public void paint(Graphics g) {

		//set initial value
		int leftBorder = 100;
		int upBorder = 100;
		int yAxislength = 600;
		int xAxislength = 800;

		//set data in y axis
		int mult = 2;
		int jun = 1278803/5000; // 1278803/5k
		int jul = 802316/5000; // 802316/5k
		int aug = 799516/5000; // 714/4
		int sep = 696553/5000; // 544/4
		int oct = 1027007/5000; // 374/4
		int nov = 687644/5000; // 0/4
		int dec = 378164/5000; // 317/4
		int avejun = 68; // 234/4
		int avejul = 135; // 352/4
		int aveaug = 63; //392/4
		int avesep = 13; // 640/4
		int aveoct = 125; // 821/4
		int avenov = 168; // 683/4
		int avedec = 93; // 438/4

		int [] datas1 = {1278803,802316,799516,696553,1027007,687644,378164};
		int [] datas2 = {527,554,525,505,550,567,537};

		//set data in x axis
		String [] month = {"June","July","August","September","October","November","December"};
		int space = 100;

		Graphics2D g2D = (Graphics2D)g ;

		g2D.setStroke(new BasicStroke(2));
		//y-axis
		g2D.drawLine(leftBorder+xAxislength, upBorder, leftBorder+xAxislength, yAxislength+upBorder);
		g2D.drawLine(leftBorder, upBorder, leftBorder, yAxislength+upBorder);
		//x-axis
		g2D.drawLine(leftBorder,yAxislength+upBorder,xAxislength+leftBorder,yAxislength+upBorder);

		//label x and y axis--------------------------
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("Total time (usec)",leftBorder-60 ,upBorder-25 );
		g2D.drawString("", leftBorder+xAxislength+30, upBorder+yAxislength);
		g2D.drawString("Average time (usec)",leftBorder-60+xAxislength,upBorder-25 );

		//lable title of graph
		g2D.setFont(new Font("Times Roman",Font.BOLD,37));
		g2D.drawString("Time taken to submit the job in microseconds", 200, 45);

		//draw labels on y-axis---------------------
		int labellength = 10;
		int labelspace = 50;

		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("0", leftBorder-40, yAxislength+upBorder+10);
		g2D.drawString("250k", leftBorder-70, yAxislength+upBorder- labelspace * mult +10);
		g2D.drawString("500k", leftBorder-70, yAxislength+upBorder-labelspace*mult*2+10);
		g2D.drawString("750k", leftBorder-70, yAxislength+upBorder-labelspace*mult*3+10);
		g2D.drawString("1000k", leftBorder-70, yAxislength+upBorder-labelspace*mult*4+10);
		g2D.drawString("1250k", leftBorder-70, yAxislength+upBorder-labelspace*mult*5+10);

		g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder- labelspace * mult, leftBorder-labellength/2+labellength, yAxislength+upBorder- labelspace * mult);
		g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*mult*2, leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*mult*2);
		g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*mult*3, leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*mult*3);
		g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*mult*4, leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*mult*4);
		g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*mult*5, leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*mult*5);

		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("500", leftBorder+xAxislength+30, yAxislength+upBorder);
		g2D.drawString("520", leftBorder+xAxislength+30, yAxislength+upBorder- labelspace * mult +10);
		g2D.drawString("540", leftBorder+xAxislength+30, yAxislength+upBorder-labelspace*mult*2+10);
		g2D.drawString("560", leftBorder+xAxislength+30, yAxislength+upBorder-labelspace*mult*3+10);
		g2D.drawString("580", leftBorder+xAxislength+30, yAxislength+upBorder-labelspace*mult*4+10);
		g2D.drawString("600", leftBorder+xAxislength+30, yAxislength+upBorder-labelspace*mult*5+10);

		//draw scale on y axis ------------------
		g2D.setColor(new Color(214, 210, 210));
		g2D.setStroke(new BasicStroke(2));
		g2D.drawLine(leftBorder+5, yAxislength+upBorder- labelspace * mult, leftBorder+xAxislength, yAxislength+upBorder- labelspace * mult);
		g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*mult*2, leftBorder+xAxislength, yAxislength+upBorder-labelspace*mult*2);
		g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*mult*3, leftBorder+xAxislength, yAxislength+upBorder-labelspace*mult*3);
		g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*mult*4, leftBorder+xAxislength, yAxislength+upBorder-labelspace*mult*4);
		g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*mult*5, leftBorder+xAxislength, yAxislength+upBorder-labelspace*mult*5);

		g2D.setColor(Color.black);
		g2D.drawLine(leftBorder-labellength/2+xAxislength, yAxislength+upBorder- labelspace * mult, leftBorder-labellength/2+labellength+xAxislength, yAxislength+upBorder- labelspace * mult);
		g2D.drawLine(leftBorder-labellength/2+xAxislength, yAxislength+upBorder-labelspace*mult*2, leftBorder-labellength/2+labellength+xAxislength, yAxislength+upBorder-labelspace*mult*2);
		g2D.drawLine(leftBorder-labellength/2+xAxislength, yAxislength+upBorder-labelspace*mult*3, leftBorder-labellength/2+labellength+xAxislength, yAxislength+upBorder-labelspace*mult*3);
		g2D.drawLine(leftBorder-labellength/2+xAxislength, yAxislength+upBorder-labelspace*mult*4, leftBorder-labellength/2+labellength+xAxislength, yAxislength+upBorder-labelspace*mult*4);
		g2D.drawLine(leftBorder-labellength/2+xAxislength, yAxislength+upBorder-labelspace*mult*5, leftBorder-labellength/2+labellength+xAxislength, yAxislength+upBorder-labelspace*mult*5);

		//draw lines for total ------------------------
		g2D.setColor(Color.GREEN);
		g2D.setStroke(new BasicStroke(3));
		// (200,8)& (100,90)
		g2D.drawLine(space+leftBorder, yAxislength-jun*mult+upBorder,space*2+leftBorder ,yAxislength-jul*mult+upBorder);
		// (200,8)& (300,201)
		g2D.drawLine(space*2+leftBorder ,yAxislength-jul*mult+upBorder,space*3+leftBorder ,yAxislength-aug*mult+upBorder);
		//(300,201)&(400,183)
		g2D.drawLine(space*3+leftBorder ,yAxislength-aug*mult+upBorder,space*4+leftBorder ,yAxislength-sep*mult+upBorder);
		//(400,183)&(500,62)
		g2D.drawLine(space*4+leftBorder ,yAxislength-sep*mult+upBorder,space*5+leftBorder ,yAxislength-oct*mult+upBorder);
		//(500,62)&(600,103)
		g2D.drawLine(space*5+leftBorder ,yAxislength-oct*mult+upBorder,space*6+leftBorder ,yAxislength-nov*mult+upBorder);
		//(600,103)&(700,28)
		g2D.drawLine(space*6+leftBorder ,yAxislength-nov*mult+upBorder,space*7+leftBorder ,yAxislength-dec*mult+upBorder);

		//draw lines for average------------------------------------
		g2D.setColor(Color.red);
		g2D.setStroke(new BasicStroke(3));
		// (200,8)& (100,90)
		g2D.drawLine(space+leftBorder, yAxislength-avejun*mult+upBorder,space*2+leftBorder ,yAxislength-avejul*mult+upBorder);
		// (200,8)& (300,201)
		g2D.drawLine(space*2+leftBorder ,yAxislength-avejul*mult+upBorder,space*3+leftBorder ,yAxislength-aveaug*mult+upBorder);
		//(300,201)&(400,183)
		g2D.drawLine(space*3+leftBorder ,yAxislength-aveaug*mult+upBorder,space*4+leftBorder ,yAxislength-avesep*mult+upBorder);
		//(400,183)&(500,62)
		g2D.drawLine(space*4+leftBorder ,yAxislength-avesep*mult+upBorder,space*5+leftBorder ,yAxislength-aveoct*mult+upBorder);
		//(500,62)&(600,103)
		g2D.drawLine(space*5+leftBorder ,yAxislength-aveoct*mult+upBorder,space*6+leftBorder ,yAxislength-avenov*mult+upBorder);
		//(600,103)&(700,28)
		g2D.drawLine(space*6+leftBorder ,yAxislength-avenov*mult+upBorder,space*7+leftBorder ,yAxislength-avedec*mult+upBorder);

		g2D.setColor(Color.green);
		g2D.fillOval(space+leftBorder-5, yAxislength-jun*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*2+leftBorder-5 ,yAxislength-jul*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*3+leftBorder-5 ,yAxislength-aug*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*4+leftBorder-5 ,yAxislength-sep*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*5+leftBorder-5 ,yAxislength-oct*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*6+leftBorder-5 ,yAxislength-nov*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*7+leftBorder-5 ,yAxislength-dec*mult+upBorder-5, 12, 12);

		g2D.setColor(Color.red);
		g2D.fillOval(space+leftBorder-5, yAxislength-avejun*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*2+leftBorder-5 ,yAxislength-avejul*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*3+leftBorder-5 ,yAxislength-aveaug*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*4+leftBorder-5 ,yAxislength-avesep*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*5+leftBorder-5 ,yAxislength-aveoct*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*6+leftBorder-5 ,yAxislength-avenov*mult+upBorder-5, 12, 12);
		g2D.fillOval(space*7+leftBorder-5 ,yAxislength-avedec*mult+upBorder-5, 12, 12);
		//labels on x axis-----------------------
		int stringMinus = 15;

		g2D.setColor(Color.black);
		g2D.setFont(new Font("Times Roman",Font.BOLD,15));
		g2D.drawString("JUN",space+leftBorder-stringMinus ,yAxislength+upBorder+50);
		g2D.drawString("JUL",space*2+leftBorder-stringMinus ,yAxislength+upBorder+50);
		g2D.drawString("AUG",space*3+leftBorder-stringMinus ,yAxislength+upBorder+50);
		g2D.drawString("SEP",space*4+leftBorder-stringMinus ,yAxislength+upBorder+50);
		g2D.drawString("OCT",space*5+leftBorder-stringMinus ,yAxislength+upBorder+50);
		g2D.drawString("NOV",space*6+leftBorder-stringMinus ,yAxislength+upBorder+50);
		g2D.drawString("DEC",space*7+leftBorder-stringMinus ,yAxislength+upBorder+50);

		//label meaning of lines
		g2D.setStroke(new BasicStroke(3));
		g2D.setColor(Color.green);
		g2D.drawLine(350, 100, 450, 100);
		g2D.setColor(Color.red);
		g2D.drawLine(350, 140, 450, 140);
		g2D.setColor(Color.black);
		g2D.drawString("Total time (usec)", 180, 105);
		g2D.drawString("Average time (usec)", 180, 145);


		//=====================================table===================================
		int tablex = 1000;
		int tabley = 200;
		int tablewidth = 390;
		int tablelength = 280;
		int tablespaceY = 35;
		int tablespaceX = 130;
		int tablenext = 25;

		g2D.setStroke(new BasicStroke(1));
		g2D.setColor(Color.black);

		for(int i = 0; i<4; i++) {
			g2D.drawLine(tablex+tablespaceX*i, tabley, tablex+tablespaceX*i, tabley+tablelength);
		}
		for(int i = 0; i<9; i++) {
			g2D.drawLine(tablex+tablewidth, tabley+tablespaceY*i, tablex, tabley+tablespaceY*i);
		}

		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("Month", tablex+10, tabley+tablenext);
		g2D.drawString("Total time", tablex+20+tablewidth/3, tabley+tablenext);
		g2D.drawString("Average time ", tablex+8+tablewidth/3*2, tabley+tablenext);

		//insert data in table x
		for(int i = 0; i<7; i++) {
			g2D.drawString(month[i], tablex+10, tabley+tablenext+tablespaceY*(i+1));
		}

		// insert data in table y
		for(int i = 0; i<7;i++) {
			int dataaa = datas1[i];
			String put = Integer.toString(dataaa);
			g2D.drawString(put, tablex+30+tablewidth/3, tabley+tablenext+tablespaceY*(i+1));
		}

		for(int i = 0; i<7;i++) {
			int dataaa = datas2[i];
			String put = Integer.toString(dataaa);
			g2D.drawString(put, tablex+35+tablewidth/3*2, tabley+tablenext+tablespaceY*(i+1));
		}
	}
}
