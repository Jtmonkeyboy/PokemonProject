package poke.controller;

import poke.model.Pokemon;
import poke.model.Charizard;
import poke.model.Mewtwo;
import poke.model.Pikachu;
import poke.model.Squirtle;
import poke.model.Venusaur;
import poke.view.PokedexFrame;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PokedexController
{
	private ArrayList<Pokemon> pokemonList;
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
	}
	
	public void start()
	{
		
	}
	
	public void addPokemon()
	{
		
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		return pokemonList;
	}
	
	public void setPokemonList(ArrayList<Pokemon> pokemonList)
	{
		this.pokemonList = pokemonList;
	}
	
	public boolean isInt(String sample)
	{
		boolean isValid = false;
		
		try
		{
			Integer.parseInt(sample);
			isValid = true;
		}
		
		catch(NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "This variable has to be an integer.");
		}
		return isValid;
	}
	
	public boolean isDouble(String sample)
	{
		boolean isValid = false;
		
		try
		{
			Double.parseDouble(sample);
			isValid = true;
		}
		
		catch(NumberFormatException error)
		{
			JOptionPane.showMessageDialog(null, "This variable has to be an integer.");
		}
		return isValid;
	}
}
