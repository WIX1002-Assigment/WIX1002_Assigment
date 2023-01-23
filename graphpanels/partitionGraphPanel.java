package graphpanels;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class partitionGraphPanel extends JPanel {
	public void paint(Graphics g) {

		//set initial value
		int leftBorder = 100;
		int upBorder =100;
		int yAxislength = 570;
		int xAxislength = 700;

		//set data in y axis
		int mult = 2;
		int EPYC = 138; // 2756/20
		int GPU = 98; // 1951/20
		int Opteron = 225; // 4509/20
		String [] type = {"EPYC","GPU","Opteron"};
		int[] datas = {2756,1951,4509};

		//set data in x axis
		int space = 200;

		Graphics2D g2D = (Graphics2D)g ;

		g2D.setStroke(new BasicStroke(2));
		//y-axis
		g2D.drawLine(leftBorder, upBorder, leftBorder, yAxislength+upBorder);
		//x-axis
		g2D.drawLine(leftBorder,yAxislength+upBorder,xAxislength+leftBorder,yAxislength+upBorder);

		//label x and y axis--------------------------
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("Number of jobs",leftBorder-60 ,upBorder-20 );
		g2D.drawString("Partition", leftBorder+xAxislength+30, upBorder+yAxislength);

		//labl title of graph
		g2D.setFont(new Font("Times Roman",Font.BOLD,40));
		g2D.drawString("Number of jobs by partitions", 350, 70);

		//draw labels on y-axis---------------------
		int labellength = 10;
		int labelspace = 50;

		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("1000", leftBorder-50, yAxislength+upBorder- labelspace * mult +10);
		g2D.drawString("2000", leftBorder-50, yAxislength+upBorder-labelspace*mult*2+10);
		g2D.drawString("3000", leftBorder-50, yAxislength+upBorder-labelspace*mult*3+10);
		g2D.drawString("4000", leftBorder-50, yAxislength+upBorder-labelspace*mult*4+10);
		g2D.drawString("5000", leftBorder-50, yAxislength+upBorder-labelspace*mult*5+10);

		g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder- labelspace * mult, leftBorder-labellength/2+labellength, yAxislength+upBorder- labelspace * mult);
		g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*mult*2, leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*mult*2);
		g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*mult*3, leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*mult*3);
		g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*mult*4, leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*mult*4);

		//draw scale on y axis ------------------
		g2D.setColor(new Color(214, 210, 210));
		g2D.setStroke(new BasicStroke(2));
		g2D.drawLine(leftBorder+5, yAxislength+upBorder- labelspace * mult, leftBorder+xAxislength, yAxislength+upBorder- labelspace * mult);
		g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*mult*2, leftBorder+xAxislength, yAxislength+upBorder-labelspace*mult*2);
		g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*mult*3, leftBorder+xAxislength, yAxislength+upBorder-labelspace*mult*3);
		g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*mult*4, leftBorder+xAxislength, yAxislength+upBorder-labelspace*mult*4);
		g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*mult*5, leftBorder+xAxislength, yAxislength+upBorder-labelspace*mult*5);

		//DRAW BAR CHART------------------------------
		int chartlength = 150;
		int pullinfront = 150;

		g2D.setColor(new Color(195,172,180));
		g2D.fillRect(space+leftBorder-pullinfront, yAxislength-EPYC*mult+upBorder, chartlength, EPYC*mult);
		g2D.setColor(new Color(217,188,184));
		g2D.fillRect(space*2+leftBorder-pullinfront, yAxislength-GPU*mult+upBorder, chartlength, GPU*mult);
		g2D.setColor(new Color(232,225,217));
		g2D.fillRect(space*3+leftBorder-pullinfront, yAxislength-Opteron*mult+upBorder, chartlength, Opteron*mult);

		//labels on x axis-----------------------
		int stringMinus = 100;

		g2D.setColor(Color.black);
		g2D.setFont(new Font("Times Roman",Font.BOLD,15));
		g2D.drawString("EPYC",space+leftBorder-stringMinus ,yAxislength+upBorder+50);
		g2D.drawString("GPU",space*2+leftBorder-stringMinus ,yAxislength+upBorder+50);
		g2D.drawString("Opteron",space*3+leftBorder-stringMinus ,yAxislength+upBorder+50);

		//=====================================table===================================
		int tablex = 1000;
		int tabley = 200;
		int tablewidth = 400;
		int tablelength = 140;
		int tablespace = 35;

		int tablenext = 25;

		g2D.setStroke(new BasicStroke(1));
		g2D.setColor(Color.black);
		//draw the lines for border-----
		g2D.drawLine(tablex, tabley, tablewidth+tablex, tabley);
		g2D.drawLine(tablex, tabley, tablex, tabley+tablelength);
		g2D.drawLine(tablewidth+tablex, tabley, tablewidth+tablex, tabley+tablelength);
		g2D.drawLine(tablex, tabley+tablelength, tablewidth+tablex, tabley+tablelength);

		//draw the lines for inner----
		g2D.drawLine(tablewidth/2+tablex, tabley, tablewidth/2+tablex, tabley+tablelength);

		for(int i = 1; i<5;i++) {
			g2D.drawLine(tablex, tabley+tablespace*i, tablex+tablewidth, tabley+tablespace*i);
		}

		//insert table x and y
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("Partition", tablex+10, tabley+tablenext);
		g2D.drawString("Number of jobs", tablex+10+tablewidth/2, tabley+tablenext);

		//insert data in table x
		for(int i = 0; i<3; i++) {
			g2D.drawString(type[i], tablex+10, tabley+tablenext+tablespace*(i+1));
		}

		// insert data in table y
		for(int i = 0; i<3;i++) {
			int dataaa = datas[i];
			String put = Integer.toString(dataaa);
			g2D.drawString(put, tablex+10+tablewidth/2, tabley+tablenext+tablespace*(i+1));
		}
	}
}
