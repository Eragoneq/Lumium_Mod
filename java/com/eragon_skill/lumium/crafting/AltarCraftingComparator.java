package com.eragon_skill.lumium.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

public class AltarCraftingComparator implements Comparator{

	final AltarCraftingManager altarCrafting;
	
	public AltarCraftingComparator(AltarCraftingManager acm) {
		this.altarCrafting = acm;
	}
	
	public int compareRecipes(IRecipe recipe1, IRecipe recipe2){
		return recipe1 instanceof AltarShapelessRecipes && recipe2 instanceof AltarShapedRecipes ? 1 : (recipe2 instanceof AltarShapelessRecipes && recipe1 instanceof AltarShapedRecipes ? -1 : (recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe2.getRecipeSize() ? 1 : 0)));
	}
	
	
	@Override
	public int compare(Object o1, Object o2) {
		return compareRecipes((IRecipe) o1, (IRecipe) o2);
	}

}
