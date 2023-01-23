package graphpanels;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class frame1 extends JFrame implements ActionListener{

	JLabel label;

	JButton Bcpu;
	JButton Bgpu;
	JButton Berror;
	JButton Bpartition;
	JButton Busec;
	JButton Bjob;
	JButton BAveExeTime;
	JButton BTimeLimitMonth;
	JButton Bkilljob;
	JButton Bexit0;
	JButton BjobAllo;
	JButton BjobC;
	JButton BerrorU;

	JButton pre1;
	JButton pre2;
	JButton pre3;
	JButton pre4;
	JButton pre5;
	JButton pre6;
	JButton pre7;
	JButton pre8;
	JButton pre9;
	JButton pre10;
	JButton pre11;
	JButton pre12;
	JButton pre13;

	CpuGraphPanel Gcpu;
	GpuGraphPanel Ggpu;
	JobCompletedGraphPanel Gjob;
	partitionGraphPanel Gpartition;
	usecGraphPanel Gusec;
	errorGraphPanel Gerror;
	AveExeTimeGraphPanel GAveExeTime;
	TimeLimitMonthGraphPanel GTimeLimitMonth;
	killjobGraphPanel Gkilljob;
	exit0GraphPanel Gexit0;
	jobAllocatedGraphPanel GjobAllo;
	jobcreatedGraphPanel GjobC;
	errorbyUserGraphPanel GerrorU;

	frame1(){
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);

		//button of metrics----------------------------
		Bcpu = new JButton();
		Bgpu = new JButton();
		Berror = new JButton();
		Bpartition = new JButton();
		Busec = new JButton();
		Bjob = new JButton();
		BAveExeTime = new JButton();
		BTimeLimitMonth = new JButton();
		Bkilljob = new JButton();
		Bexit0 = new JButton();
		BjobAllo = new JButton();
		BjobC= new JButton();
		BerrorU = new JButton();

		//coordination of previous page button-------------------------------
		int px = 1200;
		int py = 10;
		int psx = 150;
		int psy = 100;

		int ButtonWidth = 300;
		int ButtonLength = 120;

		int ButtonspaceY = 150;
		int ButtonspaceX = 350;

		int leftborder = 100;
		int upborder = 100;

		BjobC.setBounds(leftborder, upborder, ButtonWidth, ButtonLength);
		BTimeLimitMonth.setBounds(leftborder, upborder+ButtonspaceY, ButtonWidth, ButtonLength);
		Bcpu.setBounds(leftborder, upborder+ButtonspaceY*2, ButtonWidth, ButtonLength);
		BjobAllo.setBounds(leftborder+ButtonspaceX, upborder, ButtonWidth, ButtonLength);
		Bpartition.setBounds(leftborder+ButtonspaceX, upborder+ButtonspaceY, ButtonWidth, ButtonLength);
		Bgpu.setBounds(leftborder+ButtonspaceX, upborder+ButtonspaceY*2, ButtonWidth, ButtonLength);
		Bjob.setBounds(leftborder+ButtonspaceX*2, upborder, ButtonWidth, ButtonLength);
		Berror.setBounds(leftborder+ButtonspaceX*2, upborder+ButtonspaceY, ButtonWidth, ButtonLength);
		BAveExeTime.setBounds(leftborder+ButtonspaceX*2, upborder+ButtonspaceY*2, ButtonWidth, ButtonLength);
		Bkilljob.setBounds(leftborder+ButtonspaceX*3, upborder, ButtonWidth, ButtonLength);
		BerrorU.setBounds(leftborder+ButtonspaceX*3, upborder+ButtonspaceY, ButtonWidth, ButtonLength);
		Busec.setBounds(leftborder+ButtonspaceX*3, upborder+ButtonspaceY*2, ButtonWidth, ButtonLength);
		Bexit0.setBounds(leftborder, upborder+ButtonspaceY*3, ButtonWidth, ButtonLength);

		Bcpu.addActionListener(this);
		Bgpu.addActionListener(this);
		Berror.addActionListener(this);
		Bpartition.addActionListener(this);
		Busec.addActionListener(this);
		Bjob.addActionListener(this);
		BAveExeTime.addActionListener(this);
		BTimeLimitMonth.addActionListener(this);
		Bkilljob.addActionListener(this);
		Bexit0.addActionListener(this);
		BjobAllo.addActionListener(this);
		BjobC.addActionListener(this);
		BerrorU.addActionListener(this);

		this.add(Bcpu);
		this.add(Bgpu);
		this.add(Berror);
		this.add(Bpartition);
		this.add(Busec);
		this.add(Bjob);
		this.add(BAveExeTime);
		this.add(BTimeLimitMonth);
		this.add(Bkilljob);
		this.add(Bexit0);
		this.add(BjobAllo);
		this.add(BjobC);
		this.add(BerrorU);

		//Set the background
		label = new JLabel();
		label.setIcon(new ImageIcon("background.jpg"));
		label.setBounds(0, 0, 0, 0);
		this.add(label);
		label.setVisible(true);

		Color blue = new Color(207,226,243);
		Color purple = new Color (217,210,233);
		Color red = new Color(244,204,204);
		Color yellow = new Color(255,242,204);

		Bcpu.setText("<html><center><b>Number of jobs allocated<br>to nodelist (CPU)</b></center></html>");
		Bcpu.setBackground(red);
		Bcpu.setOpaque(true);
		Bcpu.setFont(new Font("Serif", Font.PLAIN, 20));

		Bgpu.setText("<html><center><b>Number of jobs allocated<br> to nodelist (GPU)</b></center></html>");
		Bgpu.setBackground(red);
		Bgpu.setOpaque(true);
		Bgpu.setFont(new Font("Serif", Font.PLAIN, 20));

		Berror.setText("<html><center><b>Number of errors<br>by month</b></center></html>");
		Berror.setBackground(purple);
		Berror.setOpaque(true);
		Berror.setFont(new Font("Serif", Font.PLAIN, 20));

		Bpartition.setText("<html><center><b>Number of jobs <br>by partitions</b></center></html>");
		Bpartition.setBackground(purple);
		Bpartition.setOpaque(true);
		Bpartition.setFont(new Font("Serif", Font.PLAIN, 20));

		Busec.setText("<html><center><b>Average time taken to <br>submit job in usec</b></center></html>");
		Busec.setBackground(red);
		Busec.setOpaque(true);
		Busec.setFont(new Font("Serif", Font.PLAIN, 20));

		Bjob.setText("<html><center><b>Number of jobs<br>completed by month</b></center></html>");
		Bjob.setBackground(blue);
		Bjob.setOpaque(true);
		Bjob.setFont(new Font("Serif", Font.PLAIN, 20));

		BAveExeTime.setText("<html><center><b>Average execution <br> time of jobs</b></center></html>");
		BAveExeTime.setBackground(red);
		BAveExeTime.setOpaque(true);
		BAveExeTime.setFont(new Font("Serif", Font.PLAIN, 20));

		BTimeLimitMonth.setText("<html><center><b>Number of jobs <br> exceeded time limit</b><center></html>");
		BTimeLimitMonth.setBackground(purple);
		BTimeLimitMonth.setOpaque(true);
		BTimeLimitMonth.setFont(new Font("Serif", Font.PLAIN, 20));

		Bkilljob.setText("<html><center><b>Number of jobs <br>killed by month</b></center></html>");
		Bkilljob.setBackground(blue);
		Bkilljob.setOpaque(true);
		Bkilljob.setFont(new Font("Serif", Font.PLAIN, 20));

		Bexit0.setText("<html><center><b>Number of jobs completed <br>with exit status 0</b></center></html>");
		Bexit0.setBackground(yellow);
		Bexit0.setOpaque(true);
		Bexit0.setFont(new Font("Serif", Font.PLAIN, 20));

		BjobAllo.setText("<html><center><b>Number of jobs <br>allocated by month</b></center></html>");
		BjobAllo.setBackground(blue);
		BjobAllo.setOpaque(true);
		BjobAllo.setFont(new Font("Serif", Font.PLAIN, 20));

		BjobC.setText("<html><center><b>Number of jobs <br>submitted by month</b></center></html>");
		BjobC.setBackground(blue);
		BjobC.setOpaque(true);
		BjobC.setFont(new Font("Serif", Font.PLAIN, 20));

		BerrorU.setText("<html><center><b>Number of error <br>caused by user</b></center></html>");
		BerrorU.setBackground(purple);
		BerrorU.setOpaque(true);
		BerrorU.setFont(new Font("Serif", Font.PLAIN, 20));

		Color light = new Color(208,213,247);

		//previous page button -----------------------------------
		pre1 = new JButton();
		pre1.setVisible(false);
		pre1.setBackground(light);
		pre1.setOpaque(true);
		pre1.setBounds(px, py, psx, psy);
		pre1.addActionListener(this);
		pre1.setText("Previous page");
		this.add(pre1);

		pre2 = new JButton();
		pre2.setVisible(false);
		pre2.setBackground(light);
		pre2.setOpaque(true);
		pre2.setBounds(px, py, psx, psy);
		pre2.addActionListener(this);
		pre2.setText("Previous page");
		this.add(pre2);

		pre3 = new JButton();
		pre3.setVisible(false);
		pre3.setBackground(light);
		pre3.setOpaque(true);
		pre3.setBounds(px, py, psx, psy);
		pre3.addActionListener(this);
		pre3.setText("Previous page");
		this.add(pre3);

		pre4 = new JButton();
		pre4.setVisible(false);
		pre4.setBackground(light);
		pre4.setOpaque(true);
		pre4.setBounds(px, py, psx, psy);
		pre4.addActionListener(this);
		pre4.setText("Previous page");
		this.add(pre4);

		pre5 = new JButton();
		pre5.setBackground(light);
		pre5.setOpaque(true);
		pre5.setVisible(false);
		pre5.setBounds(px, py, psx, psy);
		pre5.addActionListener(this);
		pre5.setText("Previous page");
		this.add(pre5);

		pre6 = new JButton();
		pre6.setBackground(light);
		pre6.setOpaque(true);
		pre6.setVisible(false);
		pre6.setBounds(px, py, psx, psy);
		pre6.addActionListener(this);
		pre6.setText("Previous page");
		this.add(pre6);

		pre7 = new JButton();
		pre7.setVisible(false);
		pre7.setBackground(light);
		pre7.setOpaque(true);
		pre7.setBounds(px, py, psx, psy);
		pre7.addActionListener(this);
		pre7.setText("Previous page");
		this.add(pre7);

		pre8 = new JButton();
		pre8.setVisible(false);
		pre8.setBackground(light);
		pre8.setOpaque(true);
		pre8.setBounds(px, py, psx, psy);
		pre8.addActionListener(this);
		pre8.setText("Previous page");
		this.add(pre8);

		pre9 = new JButton();
		pre9.setVisible(false);
		pre9.setBackground(light);
		pre9.setOpaque(true);
		pre9.setBounds(px, py, psx, psy);
		pre9.addActionListener(this);
		pre9.setText("Previous page");
		this.add(pre9);

		pre10 = new JButton();
		pre10.setVisible(false);
		pre10.setBackground(light);
		pre10.setOpaque(true);
		pre10.setBounds(px, py, psx, psy);
		pre10.addActionListener(this);
		pre10.setText("Previous page");
		this.add(pre10);

		pre11 = new JButton();
		pre11.setVisible(false);
		pre11.setBackground(light);
		pre11.setOpaque(true);
		pre11.setBounds(px, py, psx, psy);
		pre11.addActionListener(this);
		pre11.setText("Previous page");
		this.add(pre11);

		pre12 = new JButton();
		pre12.setVisible(false);
		pre12.setBackground(light);
		pre12.setOpaque(true);
		pre12.setBounds(px, py, psx, psy);
		pre12.addActionListener(this);
		pre12.setText("Previous page");
		this.add(pre12);

		pre13 = new JButton();
		pre13.setVisible(false);
		pre13.setBackground(light);
		pre13.setOpaque(true);
		pre13.setBounds(px, py, psx, psy);
		pre13.addActionListener(this);
		pre13.setText("Previous page");
		this.add(pre13);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==Bcpu) {
			setVisible1();
			Gcpu = new CpuGraphPanel();
			this.add(Gcpu);
			pre1.setVisible(true);

		}
		if(e.getSource()==Bgpu) {
			setVisible1();
			Ggpu = new GpuGraphPanel();
			this.add(Ggpu);
			pre2.setVisible(true);
		}
		if(e.getSource()==Berror) {
			setVisible1();
			Gerror = new errorGraphPanel();
			this.add(Gerror);
			pre3.setVisible(true);
		}
		if(e.getSource()==Bpartition) {
			setVisible1();
			Gpartition = new partitionGraphPanel();
			this.add(Gpartition);
			pre4.setVisible(true);
		}
		if(e.getSource()==Busec) {
			setVisible1();
			Gusec = new usecGraphPanel();
			this.add(Gusec);
			pre5.setVisible(true);
		}
		if(e.getSource()==Bjob) {
			setVisible1();
			Gjob = new JobCompletedGraphPanel();
			this.add(Gjob);
			pre6.setVisible(true);
		}
		if(e.getSource()==BAveExeTime) {
			setVisible1();
			GAveExeTime = new AveExeTimeGraphPanel();
			this.add(GAveExeTime);
			pre7.setVisible(true);
		}
		if(e.getSource()==BTimeLimitMonth) {
			setVisible1();
			GTimeLimitMonth = new TimeLimitMonthGraphPanel();
			this.add(GTimeLimitMonth);
			pre8.setVisible(true);
		}
		if(e.getSource()==Bkilljob) {
			setVisible1();
			Gkilljob = new killjobGraphPanel();
			this.add(Gkilljob);
			pre9.setVisible(true);
		}
		if(e.getSource()==Bexit0) {
			setVisible1();
			Gexit0 = new exit0GraphPanel();
			this.add(Gexit0);
			pre10.setVisible(true);
		}
		if(e.getSource()==BjobAllo) {
			setVisible1();
			GjobAllo = new jobAllocatedGraphPanel();
			this.add(GjobAllo,BorderLayout.CENTER);
			pre11.setVisible(true);
		}
		if(e.getSource()==BjobC) {
			setVisible1();
			GjobC = new jobcreatedGraphPanel();
			this.add(GjobC);
			pre12.setVisible(true);
		}
		if(e.getSource()==BerrorU) {
			setVisible1();
			GerrorU = new errorbyUserGraphPanel();
			this.add(GerrorU);
			pre13.setVisible(true);
		}
		if(e.getSource()==pre1) {
			setVisible2();
			pre1.setVisible(false);
			Gcpu.setVisible(false);
		}
		if(e.getSource()==pre2) {
			setVisible2();
			pre2.setVisible(false);
			Ggpu.setVisible(false);
		}
		if(e.getSource()==pre3) {
			setVisible2();
			pre3.setVisible(false);
			Gerror.setVisible(false);
		}
		if(e.getSource()==pre4) {
			setVisible2();
			pre4.setVisible(false);
			Gpartition.setVisible(false);
		}
		if(e.getSource()==pre5) {
			setVisible2();
			pre5.setVisible(false);
			Gusec.setVisible(false);
		}
		if(e.getSource()==pre6) {
			setVisible2();
			pre6.setVisible(false);
			Gjob.setVisible(false);
		}
		if(e.getSource()==pre7) {
			setVisible2();
			pre7.setVisible(false);
			GAveExeTime.setVisible(false);
		}
		if(e.getSource()==pre8) {
			setVisible2();
			pre8.setVisible(false);
			GTimeLimitMonth.setVisible(false);
		}
		if(e.getSource()==pre9) {
			setVisible2();
			pre9.setVisible(false);
			Gkilljob.setVisible(false);
		}
		if(e.getSource()==pre10) {
			setVisible2();
			pre10.setVisible(false);
			Gexit0.setVisible(false);
		}
		if(e.getSource()==pre11) {
			setVisible2();
			pre11.setVisible(false);
			GjobAllo.setVisible(false);
		}
		if(e.getSource()==pre12) {
			setVisible2();
			pre12.setVisible(false);
			GjobC.setVisible(false);
		}
		if(e.getSource()==pre13) {
			setVisible2();
			pre13.setVisible(false);
			GerrorU.setVisible(false);
		}
	}

	private void setVisible2() {
		label.setVisible(true);
		Bcpu.setVisible(true);
		Bgpu.setVisible(true);
		Berror.setVisible(true);
		Bpartition.setVisible(true);
		Busec.setVisible(true);
		Bjob.setVisible(true);
		BAveExeTime.setVisible(true);
		BTimeLimitMonth.setVisible(true);
		Bkilljob.setVisible(true);
		Bexit0.setVisible(true);
		BjobAllo.setVisible(true);
		BjobC.setVisible(true);
		BerrorU.setVisible(true);
	}

	private void setVisible1() {
		this.setBackground( new Color(217, 246, 250));
		label.setVisible(false);
		Bcpu.setVisible(false);
		Bgpu.setVisible(false);
		Berror.setVisible(false);
		Bpartition.setVisible(false);
		Busec.setVisible(false);
		Bjob.setVisible(false);
		BAveExeTime.setVisible(false);
		BTimeLimitMonth.setVisible(false);
		Bkilljob.setVisible(false);
		Bexit0.setVisible(false);
		BjobAllo.setVisible(false);
		BjobC.setVisible(false);
		BerrorU.setVisible(false);
	}
}
