package ru.lg.SovietMod.Blocks.Bedside;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiBedside extends GuiContainer
{
   private static final ResourceLocation TEXTURE = new ResourceLocation("soviet:textures/gui/bedside.png");
   
   public GuiBedside(Container inventorySlotsIn)
   {
       super(inventorySlotsIn);
   }

   @Override
   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
   {
	   this.drawDefaultBackground();
       mc.renderEngine.bindTexture(TEXTURE);
       int x = (this.width - this.xSize) / 2;
       int y = (this.height - this.xSize) / 2;
       drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
   }
}