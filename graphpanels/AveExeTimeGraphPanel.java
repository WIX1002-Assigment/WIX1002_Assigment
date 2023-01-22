package graphpanels;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class AveExeTimeGraphPanel extends JPanel {
	public void paint(Graphics g) {

		//set initial value
		int leftBorder = 100;
		int upBorder =100;
		int yAxislength = 550;
		int xAxislength = 900;

		//set data in y axis
		int[] datas = {211,231,176,42};
		int mult = 2;
		int multY = 2;
		String [] type = {"<1m","1m to 1h","1h to 24h",">1d"};

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
		g2D.drawString("Number of jobs",leftBorder-60 ,upBorder-25 );
		g2D.drawString("Execution time ", leftBorder+xAxislength+30, upBorder+yAxislength);

		//labl title of graph
		g2D.setFont(new Font("Times Roman",Font.BOLD,40));
		g2D.drawString("Average execution time of jobs ", 370, 70);

		//draw labels on y-axis---------------------
		int labelspace = 50;

		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		int scalee = 0;
		for(int i = 1; i<=5; i++) {
			scalee += 50;
			String scale = Integer.toString(scalee);
			g2D.drawString(scale, leftBorder-50, yAxislength+upBorder-labelspace*multY*i+10);
		}

		//draw scale on y axis ------------------
		g2D.setColor(new Color(214, 210, 210));
		g2D.setStroke(new BasicStroke(2));
		for(int i = 1; i<=5; i++) {
			g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*multY*i, leftBorder+xAxislength, yAxislength+upBorder-labelspace*multY*i);
		}

		//DRAW BAR CHART------------------------------
		int chartlength = 100;
		int pullinfront = 150;

		g2D.setColor(Color.red);
		g2D.fillRect(space+leftBorder-pullinfront, yAxislength-datas[0]*mult+upBorder, chartlength, datas[0]*mult);
		g2D.setColor(Color.yellow);
		g2D.fillRect(space*2+leftBorder-pullinfront, yAxislength-datas[1]*mult+upBorder, chartlength, datas[1]*mult);
		g2D.setColor(Color.green);
		g2D.fillRect(space*3+leftBorder-pullinfront, yAxislength-datas[2]*mult+upBorder, chartlength, datas[2]*mult);
		g2D.setColor(Color.blue);
		g2D.fillRect(space*4+leftBorder-pullinfront, yAxislength-datas[3]*mult+upBorder, chartlength, datas[3]*mult);

		//labels on x axis-----------------------
		int stringMinus = 125;

		g2D.setColor(Color.black);
		g2D.setFont(new Font("Times Roman",Font.BOLD,15));
		for(int i = 0; i<4; i++) {
			g2D.drawString(type[i],space*(i+1)+leftBorder-stringMinus ,yAxislength+upBorder+50);
		}

		//=====================================table===================================
		int tablex = 1000;
		int tabley = 200;
		int tablewidth = 400;
		int tablelength = 175;
		int tablespaceY = 35;
		int tablespaceX = 200;
		int tablenext = 25;

		g2D.setStroke(new BasicStroke(1));
		g2D.setColor(Color.black);
		for(int i = 0; i<3; i++) {
			g2D.drawLine(tablex+tablespaceX*i, tabley, tablex+tablespaceX*i, tabley+tablelength);
		}
		for(int i = 0; i<6; i++) {
			g2D.drawLine(tablex+tablewidth, tabley+tablespaceY*i, tablex, tabley+tablespaceY*i);
		}
		//insert table x and y
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("Execution Time", tablex+10, tabley+tablenext);
		g2D.drawString("Number of jobs", tablex+10+tablewidth/2, tabley+tablenext);

		//insert data in table x
		for(int i = 0; i<4; i++) {
			g2D.drawString(type[i], tablex+10, tabley+tablenext+tablespaceY*(i+1));
		}

		// insert data in table y
		for(int i = 0; i<4;i++) {
			int dataaa = datas[i];
			String put = Integer.toString(dataaa);
			g2D.drawString(put, tablex+10+tablewidth/2, tabley+tablenext+tablespaceY*(i+1));
		}
		g2D.drawString("Average execution time: 7 hours, 26 minutes, 5 seconds", tablex-100, tabley+250);
	}
}
