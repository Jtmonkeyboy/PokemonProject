package poke.view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import poke.controller.PokedexController;

public class PokedexPanel extends JPanel
{
	private PokedexController appController;
	private SpringLayout appLayout;
	
	
	public PokedexPanel(PokedexController appController)
	{
		super();
		
		this.appController = appController;
		setupLayout();
		setupListeners();
		setupPanel();
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
	
	private void setupPanel()
	{
		
	}
}
