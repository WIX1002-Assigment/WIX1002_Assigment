package graphpanels;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GpuGraphPanel extends JPanel{
	public void paint(Graphics g) {

		//set initial value
		int leftBorder = 100;
		int upBorder = 150;
		int yAxislength = 470;
		int xAxislength = 600;

		//set data in y axis
		int mult = 2;
		int gpu1 = 57; // 226/4
		int gpu2 = 161; // 643/4
		int gpu3 = 52; // 207/4
		int gpu4 = 75; // 298/4
		int gpu5 = 148; // 591/4
		int [] datas = {226,643,207,298,591};

		//set data in x axis
		int space = 100;

		Graphics2D g2D = (Graphics2D)g ;

		g2D.setStroke(new BasicStroke(2));
		//y-axis
		g2D.drawLine(leftBorder, upBorder, leftBorder, yAxislength+upBorder);
		//x-axis
		g2D.drawLine(leftBorder,yAxislength+upBorder,xAxislength+leftBorder,yAxislength+upBorder);

		//label x and y axis--------------------------
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("Number of jobs",leftBorder-60 ,upBorder-20 );
		g2D.drawString("Type of GPU", leftBorder+xAxislength+30, upBorder+yAxislength);

		//labl title of graph
		g2D.setFont(new Font("Times Roman",Font.BOLD,40));
		g2D.drawString("Number of jobs allocated to nodelist (GPU)", 300, 70);

		//draw labels on y-axis---------------------
		int labellength = 10;
		int labelspace = 50;

		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("200", leftBorder-50, yAxislength+upBorder- labelspace * mult +10);
		g2D.drawString("400", leftBorder-50, yAxislength+upBorder-labelspace*mult*2+10);
		g2D.drawString("600", leftBorder-50, yAxislength+upBorder-labelspace*mult*3+10);
		g2D.drawString("800", leftBorder-50, yAxislength+upBorder-labelspace*mult*4+10);

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

		//DRAW BAR CHART------------------------------
		g2D.setColor(Color.red);
		g2D.fillRect(space+leftBorder-40, yAxislength-gpu1*mult+upBorder, 80, gpu1*mult);
		g2D.setColor(Color.yellow);
		g2D.fillRect(space*2+leftBorder-40, yAxislength-gpu2*mult+upBorder, 80, gpu2*mult);
		g2D.setColor(Color.green);
		g2D.fillRect(space*3+leftBorder-40, yAxislength-gpu3*mult+upBorder, 80, gpu3*mult);
		g2D.setColor(Color.blue);
		g2D.fillRect(space*4+leftBorder-40, yAxislength-gpu4*mult+upBorder, 80, gpu4*mult);
		g2D.setColor(new Color(232, 85, 237));
		g2D.fillRect(space*5+leftBorder-40, yAxislength-gpu5*mult+upBorder, 80, gpu5*mult);

		//labels on x axis-----------------------
		g2D.setColor(Color.black);
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("GPU1",space+leftBorder-30 ,yAxislength+upBorder+50);
		g2D.drawString("GPU2",space*2+leftBorder-30 ,yAxislength+upBorder+50);
		g2D.drawString("GPU3",space*3+leftBorder-30 ,yAxislength+upBorder+50);
		g2D.drawString("GPU4",space*4+leftBorder-30 ,yAxislength+upBorder+50);
		g2D.drawString("GPU5",space*5+leftBorder-30 ,yAxislength+upBorder+50);

		//=====================================table===================================
		int tablex = 1000;
		int tabley = upBorder+50;
		int tablewidth = 400;
		int tablelength = 210;
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
		for(int i = 1; i<7;i++) {
			g2D.drawLine(tablex, tabley+tablespace*i, tablex+tablewidth, tabley+tablespace*i);
		}

		//insert table x and y
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("Type of Gpu", tablex+10, tabley+tablenext);
		g2D.drawString("Number of jobs", tablex+10+tablewidth/2, tabley+tablenext);

		//insert data in table x
		int gpuu = 0;
		for(int i = 1; i<6; i++) {
			gpuu += 1;
			String gpu = Integer.toString(gpuu);
			g2D.drawString("Gpu"+gpu, tablex+10, tabley+tablenext+tablespace*(i));
		}

		// insert data in table y
		for(int i = 0; i<5;i++) {
			int dataaa = datas[i];
			String put = Integer.toString(dataaa);
			g2D.drawString(put, tablex+10+tablewidth/2, tabley+tablenext+tablespace*(i+1));
		}
	}
}
