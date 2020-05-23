package com.F20Grp7.comms.impl;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;


public class RobComProgramNodeView implements SwingProgramNodeView<RobComProgramNodeContribution>{

	private final ViewAPIProvider apiProvider;
	private JTextField ipAddress = new JTextField();
	private JTextField hostName = new JTextField();
	private JButton b1 = new JButton();
	
	
	public RobComProgramNodeView(ViewAPIProvider apiProvider) {
		this.apiProvider = apiProvider;
	}
	

	
	private JComboBox<Integer> ioComboBox = new JComboBox<Integer>();
	private JSlider durationSlider = new JSlider();
	
	public void setIpAdressSize(JTextField ipAdress) {
		ipAdress.setSize(2, 2);
	}
	@Override
	public void buildUI(JPanel panel, ContributionProvider<RobComProgramNodeContribution> provider) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JFrame frame=new JFrame();
	    frame.setSize(400,400);
	    frame.setTitle("Robot Client");
	    

	    JLabel lablename=new JLabel("Enter IpAdress:");
	    JTextField tname=new JTextField(10);
	    tname.setColumns(45);

	    JLabel lableemail=new JLabel("Enter Port: ");
	    JTextField email=new JTextField(5);
	    email.setColumns(45);
	   

	    JButton login=new JButton();
	    JButton create=new JButton();
	    JButton send = new JButton();
	    
	    login.setPreferredSize(new Dimension(90,30));
	    login.setText(" Connect    ");
	    
	    create.setPreferredSize(new Dimension(90,30));
	    create.setText(" Disconnet ");
	    
	    send.setPreferredSize(new Dimension(90,30));
	    send.setText(" Send Position ");

	    panel.add(create, provider);
	    panel.add(createSpacer(5));
	    panel.add(login, provider);
	    panel.add(createSpacer(20));
	    panel.add(lablename, provider);
	    panel.add(createSpacer(5));
	    panel.add(tname, provider);
	    panel.add(createSpacer(5));
	    panel.add(lableemail, provider);
	    panel.add(createSpacer(5));
	    panel.add(email, provider);
	    panel.add(createSpacer(20));
	    panel.add(send, provider);



	    frame.add(panel);
	    frame.setVisible(true);
	    
	    /*
		panel.add(createDescription("Enter IP Adress: "));
		panel.add(createSpacer(5));
		panel.add(ipAddress);
		panel.add(createSpacer(20));
		
		
		ipAddress.setSize(1,2);
		
		panel.add(createDescription("Enter Host: "));
		panel.add(createSpacer(5));
		panel.add(hostName, provider);
		panel.add(createSpacer(20));
		
		hostName.setSize(2, 1);
		
		panel.add(createDescription("Connect"));
		panel.add(createSpacer(5));
		panel.add(b1, provider);
		
		b1.setSize(3, 3);*/
		
		
		
		/*panel.add(createDescription("Select which output to Light Up:"));
		panel.add(createSpacer(5));
		panel.add(createIOComboBox(ioComboBox, provider));
		panel.add(createSpacer(20));
		panel.add(createDescription("Select the duration of the Light Up:"));
		panel.add(createSpacer(5));
		panel.add(createDurationSlider(durationSlider, 0, 10, provider));*/
	}
	
	
	/*public void Jframe() {
		
		 	JFrame frame=new JFrame();
		    JPanel panel=new JPanel();
		    frame.setSize(400,400);
		    frame.setTitle("Registration");
		    


		    JLabel lablename=new JLabel("Enter your name");
		    JTextField tname=new JTextField(30);
		    tname.setColumns(45);

		    JLabel lableemail=new JLabel("Enter your Email");
		    JTextField email=new JTextField(30);
		    email.setColumns(45);
		    JLabel lableaddress=new JLabel("Enter your address");
		    JTextField address=new JTextField(30);
		    address.setColumns(45);
		    address.setFont(Font.getFont(Font.SERIF));
		    JLabel lablepass=new JLabel("Enter your password");
		    JTextField pass=new JTextField(30);
		    pass.setColumns(45);

		    JButton login=new JButton();
		    JButton create=new JButton();
		    login.setPreferredSize(new Dimension(90,30));
		    login.setText("Login");
		    create.setPreferredSize(new Dimension(90,30));
		    create.setText("Create");



		    panel.add(lablename);
		    panel.add(tname);
		    panel.add(lableemail);
		    panel.add(email);
		    panel.add(lableaddress);
		    panel.add(address);
		    panel.add(lablepass);
		    panel.add(pass);
		    panel.add(create);
		    panel.add(login);



		    frame.add(panel);
		    frame.setVisible(true);
		  }
	*/
	
	
	
	public void setIOComboBoxItems(Integer[] items) {
		ioComboBox.removeAllItems();
		ioComboBox.setModel(new DefaultComboBoxModel<Integer>(items));
	}
	
	public void setIOComboBoxSelection(Integer item) {
		ioComboBox.setSelectedItem(item);
	}
	
	public void setDurationSlider(int value) {
		durationSlider.setValue(value);
	}
	
	private Box createDescription(String desc) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel label = new JLabel(desc);
		
		box.add(label);
		
		return box;
	}
	
	/*
	private Box createIOComboBox(final JComboBox<Integer> combo,
			final ContributionProvider<RobComProgramNodeContribution> provider) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel label = new JLabel(" digital_out ");
		
		combo.setPreferredSize(new Dimension(104, 30));
		combo.setMaximumSize(combo.getPreferredSize());
		
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					provider.get().onOutputSelection((Integer) e.getItem());
				}
			}
		});
		
		box.add(label);
		box.add(combo);
		
		return box;
	}*/
	

	/*
	private Box createDurationSlider(final JSlider slider, int min, int max,
			final ContributionProvider<RobComProgramNodeContribution> provider) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		slider.setMinimum(min);
		slider.setMaximum(max);
		slider.setOrientation(JSlider.HORIZONTAL);
		
		slider.setPreferredSize(new Dimension(275, 30));
		slider.setMaximumSize(slider.getPreferredSize());
		
		final JLabel value = new JLabel(Integer.toString(slider.getValue())+" s");
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int newValue = slider.getValue();
				value.setText(Integer.toString(newValue)+" s");
				provider.get().onDurationSelection(newValue);
			}
		});
		
		box.add(slider);
		box.add(value);
		
		return box;
	}
	*/
	private Component createSpacer(int height) {
		return Box.createRigidArea(new Dimension(0, height));
	}

}