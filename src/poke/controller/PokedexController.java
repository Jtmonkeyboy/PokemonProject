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
	private PokedexFrame appFrame;
	
	public PokedexController()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public void addPokemon()
	{
		pokemonList.add(new Charizard());
		pokemonList.add(new Pikachu());
		pokemonList.add(new Squirtle());
		pokemonList.add(new Mewtwo());
		pokemonList.add(new Venusaur());
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		return pokemonList;
	}
	
	public void setPokemonList(ArrayList<Pokemon> pokemonList)
	{
		this.pokemonList = pokemonList;
	}
	
	public void updatePokemon(int index, String [] data)
	{
		if(data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
		}
	}
	
	public String[] getPokeData(int index)
	{
		String[] stats = new String[6];
		Pokemon selection = pokemonList.get(index);
		stats[0] = Integer.toString(selection.getAttackPoints());
		stats[1] = Double.toString(selection.getEnhancementModifier());
		stats[2] = Integer.toString(selection.getHealthPoints());
		stats[3] = selection.getName();
		stats[4] = Boolean.toString(selection.isCanEvolve());
		stats[5] = selection.getNumber() + "";
		
		return stats;
	}
	
	public String[] buildPokedexTest()
	{
		String [] names = new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		
		return names;
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
