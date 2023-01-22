package graphpanels;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class CpuGraphPanel extends JPanel{
	public void paint(Graphics g) {

		//set initial value
		int leftBorder = 100;
		int upBorder = 100;
		int yAxislength = 580;
		int xAxislength = 780;

		//set data in y axis
		int mult = 2;
		int cpu1 = 258; // 1031/4
		int cpu2 = 0; // 0/4
		int cpu3 = 179; // 714/4
		int cpu4 = 136; // 544/4
		int cpu5 = 94; // 374/4
		int cpu6 = 0; // 0/4
		int cpu7 = 79; // 317/4
		int cpu8 = 59; // 234/4
		int cpu9 = 88; // 352/4
		int cpu10 = 98; //392/4
		int cpu11 = 160; // 640/4
		int cpu12 = 205; // 821/4
		int cpu13 = 171; // 683/4
		int cpu14 = 110; // 438/4
		int cpu15 = 147; // 587/4
		int [] datas = {1031,0,714,544,374,0,317,234,352,392,640,821,683,438,587};

		//set data in x axis
		int space = 50;

		Graphics2D g2D = (Graphics2D)g ;

		//label x and y axis--------------------------
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("Number of jobs",leftBorder-60 ,upBorder-20 );
		g2D.drawString("Type of CPU", leftBorder+xAxislength+30, upBorder+yAxislength);

		//lable title of graph
		g2D.setFont(new Font("Times Roman",Font.BOLD,40));
		g2D.drawString("Number of jobs allocated to nodelist (CPU)", 300, 70);

		//draw labels on y-axis---------------------
		int labellength = 10;
		int labelspace = 50;
		int dataa = 0;
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		for(int i = 1; i<6; i++) {
			dataa = dataa+200;
			String data = Integer.toString(dataa);
			g2D.drawString(data, leftBorder-50, yAxislength+upBorder-labelspace*mult*i+10);
		}

		for(int i = 0; i<5; i++) {
			g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*mult*i, leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*mult*i);
		}

		//draw scale on y axis ------------------
		g2D.setColor(new Color(214, 210, 210));
		g2D.setStroke(new BasicStroke(2));
		for(int i = 0; i<6; i++) {
			g2D.drawLine(leftBorder+5, yAxislength+upBorder-labelspace*mult*i, leftBorder+xAxislength, yAxislength+upBorder-labelspace*mult*i);
		}

		//DRAW BAR CHART------------------------------
		int chartlength = 50;
		int chartleft = 48;

		g2D.setColor(Color.red);
		g2D.fillRect(space+leftBorder-chartleft, yAxislength-cpu1*mult+upBorder, chartlength, cpu1*mult);
		g2D.setColor(Color.yellow);
		g2D.fillRect(space*2+leftBorder-chartleft, yAxislength-cpu2*mult+upBorder, chartlength, cpu2*mult);
		g2D.setColor(Color.green);
		g2D.fillRect(space*3+leftBorder-chartleft, yAxislength-cpu3*mult+upBorder, chartlength, cpu3*mult);
		g2D.setColor(Color.blue);
		g2D.fillRect(space*4+leftBorder-chartleft, yAxislength-cpu4*mult+upBorder, chartlength, cpu4*mult);
		g2D.setColor(new Color(232, 85, 237));
		g2D.fillRect(space*5+leftBorder-chartleft, yAxislength-cpu5*mult+upBorder, chartlength, cpu5*mult);
		g2D.setColor(Color.red);
		g2D.fillRect(space*6+leftBorder-chartleft, yAxislength-cpu6*mult+upBorder, chartlength, cpu6*mult);
		g2D.setColor(Color.yellow);
		g2D.fillRect(space*7+leftBorder-chartleft, yAxislength-cpu7*mult+upBorder, chartlength, cpu7*mult);
		g2D.setColor(Color.green);
		g2D.fillRect(space*8+leftBorder-chartleft, yAxislength-cpu8*mult+upBorder, chartlength, cpu8*mult);
		g2D.setColor(Color.blue);
		g2D.fillRect(space*9+leftBorder-chartleft, yAxislength-cpu9*mult+upBorder, chartlength, cpu9*mult);
		g2D.setColor(new Color(232, 85, 237));
		g2D.fillRect(space*10+leftBorder-chartleft, yAxislength-cpu10*mult+upBorder, chartlength, cpu10*mult);
		g2D.setColor(Color.red);
		g2D.fillRect(space*11+leftBorder-chartleft, yAxislength-cpu11*mult+upBorder, chartlength, cpu11*mult);
		g2D.setColor(Color.yellow);
		g2D.fillRect(space*12+leftBorder-chartleft, yAxislength-cpu12*mult+upBorder, chartlength, cpu12*mult);
		g2D.setColor(Color.green);
		g2D.fillRect(space*13+leftBorder-chartleft, yAxislength-cpu13*mult+upBorder, chartlength, cpu13*mult);
		g2D.setColor(Color.blue);
		g2D.fillRect(space*14+leftBorder-chartleft, yAxislength-cpu14*mult+upBorder, chartlength, cpu14*mult);
		g2D.setColor(new Color(232, 85, 237));
		g2D.fillRect(space*15+leftBorder-chartleft, yAxislength-cpu15*mult+upBorder, chartlength, cpu15*mult);

		//labels on x axis-----------------------
		int stringMinus = 35;

		g2D.setColor(Color.black);
		g2D.setFont(new Font("Times Roman",Font.BOLD,12));

		for(int i = 1; i<16;i++) {
			int numm = i;
			String num = Integer.toString(numm) ;
			g2D.drawString("CPU"+num,space*i+leftBorder-stringMinus ,yAxislength+upBorder+50);
		}

		g2D.setStroke(new BasicStroke(2));
		//y-axis
		g2D.drawLine(leftBorder, upBorder, leftBorder, yAxislength+upBorder);
		//x-axis
		g2D.drawLine(leftBorder,yAxislength+upBorder,xAxislength+leftBorder,yAxislength+upBorder);

		//=====================================table===================================
		int tablex = 1100;
		int tabley = upBorder+50;
		int tablewidth = 400;
		int tablelength = 560;
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

		for(int i = 1; i<16;i++) {
			g2D.drawLine(tablex, tabley+tablespace*i, tablex+tablewidth, tabley+tablespace*i);
		}
		//insert table x and y
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString("Type of Cpu", tablex+10, tabley+tablenext);
		g2D.drawString("Number of jobs", tablex+10+tablewidth/2, tabley+tablenext);

		//insert data in table x
		int cpuu = 0;
		for(int i = 1; i<16; i++) {
			cpuu = cpuu+1;
			String cpu = Integer.toString(cpuu);
			g2D.drawString("Cpu"+cpu, tablex+10, tabley+tablenext+tablespace*i);
		}

		// insert data in table y
		for(int i = 0; i<15;i++) {
			int dataaa = datas[i];
			String put = Integer.toString(dataaa);
			g2D.drawString(put, tablex+10+tablewidth/2, tabley+tablenext+tablespace*(i+1));
		}
	}
}

