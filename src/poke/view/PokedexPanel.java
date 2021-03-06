package poke.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import poke.controller.PokedexController;

public class PokedexPanel extends JPanel
{
	private PokedexController appController;
	private SpringLayout appLayout;
	
	private JButton changeButton;
	private JComboBox<String> pokedexDropdown;
	
	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;
	
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;
	
	private ImageIcon pokemonIcon;
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		this.appController = appController;
		
		this.appLayout = new SpringLayout();
		
		pokedexDropdown = new JComboBox<String>();
		
		changeButton = new JButton("Click me");
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");
		
		healthLabel = new JLabel("This pokemon health is");
		numberLabel = new JLabel("This pokemon number is");
		evolveLabel = new JLabel("This pokemon can evolve");
		enhanceLabel = new JLabel("This pokemon enchancement level is");
		attackLabel = new JLabel("This pokemon attack level is");
		nameLabel = new JLabel("My name is");
		imageLabel = new JLabel("Pokemon goes here", pokemonIcon, JLabel.CENTER);
		
		String path = "/poke/view/images/";
		String defaultName = "pokeball";
		String extension = ".jpeg";
		
		pokemonIcon = new ImageIcon(getClass().getResource(path+defaultName+extension));
		
		setupDropdown();
		setupLayout();
		setupListeners();
		setupPanel();
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(appController.buildPokedexTest());
		pokedexDropdown.setModel(temp);
	}
	
	private void setupLayout()
	{
		this.setLayout(appLayout);
		this.add(pokedexDropdown);
		this.add(numberField);
		this.add(nameField);
		this.add(evolveField);
		this.add(attackField);
		this.add(enhancementField);
		this.add(healthField);
		
		this.add(healthLabel);
		this.add(numberLabel);
		this.add(evolveLabel);
		this.add(enhanceLabel);
		this.add(attackLabel);
		this.add(nameLabel);
		this.add(imageLabel);
		
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		//imageLabel.setHorizontalTextPostion(JLabel.CENTER);
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click)
			{
				sendDataToController();
			}
		});
		
		pokedexDropdown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				updateFields(pokedexDropdown.getSelectedIndex());
				changeImageDisplay(name);
			}
		});
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(appController.isInt(attackField.getText()) && appController.isDouble(enhancementField.getText()) && appController.isInt(healthField.getText()))
		{
			String [] data = new String [5];
			data[0] = attackField.getText();
			data[1] = enhancementField.getText();
			data[2] = healthField.getText();
			data[3] = nameField.getText();
			data[4] = evolveField.getText();
			
			appController.updatePokemon(index, data);
		}
	}
	
	private void updateFields(int index)
	{
		String[] data = appController.getPokeData(index);
		attackField.setText(data[0]);
		enhancementField.setText(data[1]);
		healthField.setText(data[2]);
		nameField.setText(data[3]);
		evolveField.setText(data[4]);
		numberField.setText(data[5]);
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/poke/view/images/";
		String defaultName = "pokeball";
		String extension = ".jpeg";
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path+name.toLowerCase() + extension));
		}
		catch(NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path+defaultName+extension));
		}
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private void setupPanel()
	{
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 247, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 31, SpringLayout.WEST, this);
		
		appLayout.putConstraint(SpringLayout.EAST, nameField, -67, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 0, SpringLayout.EAST, nameField);
		
		appLayout.putConstraint(SpringLayout.EAST, evolveField, -67, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.EAST, attackField, -67, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.EAST, enhancementField, -67, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.EAST, healthField, -67, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, -132, SpringLayout.WEST, healthField);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, -5, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 39, SpringLayout.NORTH, this);
		
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -132, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 101, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, healthLabel, -46, SpringLayout.NORTH, numberLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, evolveField, -5, SpringLayout.NORTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolveLabel, 163, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, evolveLabel, -218, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -46, SpringLayout.NORTH, evolveLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, enhancementField, -5, SpringLayout.NORTH, enhanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, enhanceLabel, 46, SpringLayout.SOUTH, evolveLabel);
		appLayout.putConstraint(SpringLayout.EAST, enhanceLabel, -218, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.NORTH, attackField, -5, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -218, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 46, SpringLayout.SOUTH, enhanceLabel);
		
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 53, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 46, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -218, SpringLayout.EAST, this);
		
		appLayout.putConstraint(SpringLayout.WEST, imageLabel, 0, SpringLayout.WEST, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.SOUTH, imageLabel, -39, SpringLayout.NORTH, pokedexDropdown);
	}
}
