package knightminer.inspirations.plugins.jei.smashing;

import knightminer.inspirations.Inspirations;
import knightminer.inspirations.library.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;

public class SmashingRecipeCategory implements IRecipeCategory<SmashingRecipeWrapper> {

	public static final String CATEGORY = Util.prefix("anvil_smashing");
	public static final ResourceLocation BACKGROUND_LOC = Util.getResource("textures/gui/jei/anvil_smashing.png");

	private final IDrawable background;
	private final IDrawableAnimated arrow;

	public SmashingRecipeCategory(IGuiHelper guiHelper) {
		background = guiHelper.createDrawable(BACKGROUND_LOC, 0, 0, 160, 60, 0, 0, 0, 0);

		IDrawableStatic arrowDrawable = guiHelper.createDrawable(BACKGROUND_LOC, 160, 0, 24, 17);
		arrow = guiHelper.createAnimatedDrawable(arrowDrawable, 200, IDrawableAnimated.StartDirection.LEFT, false);
	}

	@Nonnull
	@Override
	public String getUid() {
		return CATEGORY;
	}

	@Nonnull
	@Override
	public String getTitle() {
		return Util.translate("gui.jei.anvil_smashing.title");
	}

	@Nonnull
	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void drawExtras(@Nonnull Minecraft minecraft) {
		arrow.draw(minecraft, 67, 28);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, SmashingRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup items = recipeLayout.getItemStacks();

		items.init(0, true, 43, 29);
		items.set(ingredients);

		items.init(1, false, 97, 29);
		items.set(ingredients);
	}

	@Override
	public String getModName() {
		return Inspirations.modName;
	}
}
