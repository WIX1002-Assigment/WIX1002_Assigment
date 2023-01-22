package graphpanels;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class errorbyUserGraphPanel extends JPanel{
	public void paint(Graphics g) {

		//set data to be modified
		int xAxisnum = 24;
		String nameX = "Number of error";
		String nameY = "Number of user";
		String title = "Number of errors by users";
		int scaleYnum = 6;
		int scaleYdiff = 1;
		int scaleYini = 0;

		//draw labels on y-axis---------------------
		int labellength = 10;
		int labelspace = 83;

		//set initial value
		int leftBorder = 100;
		int upBorder = 150;
		int yAxislength = 498;
		int xAxislength = 800;

		//set data in y axis
		int[] yVar = {6,3,3,6,1,1,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,1};
		int[] yyVar = {24,21,12,11,10,9,6,5,4,4,4,4,4,4,3,3,3,2,2,2,1,1,1,1,1,1};

		//set data in x axis
		String[] xxxVar = {"mk_98","htt_felicia","aah","han","fairus","hongvin","shahreeza","hva170037","f4ww4z","roland","janvik ","lin0618","manoj","noraini","lobbeytan","liew.wei.shiung","farhatabjani","tingweijing","aznul","chiuling","xinpeng","hass","fahmi8","kurk","yatyuen.lim","ongkuanhung"};
		int mult = 83;
		int[] xxVar = new int [24];
		String[] xVar = new String [24];
		for(int i = 0; i<24; i++) {
			xxVar[i] = i+1;
			xVar[i] = Integer.toString(xxVar[i]);
		}
		int space = 32;

		Graphics2D g2D = (Graphics2D)g ;

		g2D.setStroke(new BasicStroke(2));
		//y-axis
		g2D.drawLine(leftBorder, upBorder, leftBorder, yAxislength+upBorder);
		//x-axis
		g2D.drawLine(leftBorder,yAxislength+upBorder,xAxislength+leftBorder,yAxislength+upBorder);

		//label x and y axis--------------------------
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		g2D.drawString(nameY,leftBorder-60 ,upBorder-30 );
		g2D.drawString(nameX, leftBorder+xAxislength+30, upBorder+yAxislength);

		//lable title of graph
		g2D.setFont(new Font("Times Roman",Font.BOLD,40));
		g2D.drawString(title, 300, 70);

		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		int scale = scaleYini;
		for(int i = 0; i<scaleYnum; i++) {
			scale += scaleYdiff;
			String scalee = Integer.toString(scale);
			g2D.drawString(scalee, leftBorder-50, yAxislength+upBorder-labelspace*(i+1)+10);
		}

		for(int i = 0; i<scaleYnum; i++) {
			g2D.drawLine(leftBorder-labellength/2, yAxislength+upBorder-labelspace*(i+1), leftBorder-labellength/2+labellength, yAxislength+upBorder-labelspace*(i+1));
		}

		//draw graph lines---------------------------------------
		g2D.setStroke(new BasicStroke(3));
		g2D.setColor(Color.GREEN);
		for(int i = 0; i<xAxisnum-1; i++) {
			g2D.drawLine(space*(i+1)+leftBorder, yAxislength-yVar[i]*mult+upBorder,space*(i+2)+leftBorder ,yAxislength-yVar[(i+1)]*mult+upBorder);
		}

		//draw dots on graph -----------------------
		g2D.setColor(Color.red);
		for(int i = 0; i<xAxisnum; i++) {
			g2D.fillOval(space*(i+1)+leftBorder-5, yAxislength-yVar[i]*mult+upBorder-5, 10, 10);
		}

		//labels on x axis-----------------------
		g2D.setColor(Color.black);
		g2D.setFont(new Font("Times Roman",Font.BOLD,20));
		for(int i = 0; i<xAxisnum; i++) {
			g2D.drawString(xVar[i],space*(i+1)+leftBorder-10 ,yAxislength+upBorder+50);
		}

		//=====================================table===================================
		int tablex = 1100;
		int tabley = upBorder-35;
		int tablewidth = 400;
		int tablelength = 25*(26+1);
		int tablespaceY = 25;
		int tablespaceX = 200;
		int tablenext = 25;

		g2D.setStroke(new BasicStroke(1));
		g2D.setColor(Color.black);
		for(int i = 0; i<3; i++) {
			g2D.drawLine(tablex+tablespaceX*i, tabley, tablex+tablespaceX*i, tabley+tablelength);
		}
		for(int i = 0; i<(26+2);i++) {
			g2D.drawLine(tablex, tabley+tablespaceY*i, tablex+tablewidth, tabley+tablespaceY*i);
		}// insert data in table y

		g2D.setFont(new Font("Times Roman",Font.BOLD,15));
		for(int i = 0; i<26;i++) {
			int dataaa = yyVar[i];
			String put = Integer.toString(dataaa);
			g2D.drawString(put, tablex+10+tablewidth/2, tabley+tablenext+tablespaceY*(i+1)-5);
		}
		for(int i = 0; i<26; i++) {

			g2D.drawString(xxxVar[i], tablex+10, tabley+tablenext+tablespaceY*(i+1)-5);
		}
		g2D.drawString("User", tablex+10, tabley+tablenext-5);
		g2D.drawString("Number of error", tablex+10+tablewidth/2, tabley+tablenext-5);
	}
}

