package org.mcsg.bot.drawing.painters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import org.mcsg.bot.drawing.AbstractPainter;
import org.mcsg.bot.drawing.ImageTools;
import org.mcsg.bot.util.MapWrapper;

public class Smoke extends AbstractPainter{
	int r=rand.nextInt(255);
	int gc=rand.nextInt(255);
	int b=rand.nextInt(255);
	int a=rand.nextInt(255);

	double x = rand.nextDouble() * width;
	double y = rand.nextDouble() * height;

	double size = rand.nextDouble() * 45 + 1;


	public Smoke( BufferedImage img) {
		super( img);
	}


	@Override

	public void paint(MapWrapper args) {
		
		g.setStroke(new BasicStroke(rand.nextInt(7)));
		
		int stop = rand.nextInt(90000);
		
		/*int minx = rand.nextInt(WIDTH - 750);
		int maxx = rand.nextInt(600) + minx + 150;
		
		int miny = rand.nextInt(HEIGHT - 750);
		int maxy = rand.nextInt(600) + miny + 150;*/
		
		Color color = getRandomColor(true);
		color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 20);
		
		for(int aa = 0; aa < stop; aa++){
			color  = randIncColor(color, 7, false);
			g.setColor(color);

			x += (rand.nextDouble() * size) - (size / 2);
			y += (rand.nextDouble() * size) - (size / 2);
			size += (rand.nextDouble() * 3)  - 1;

			size = ImageTools.limit(size, 10, 50);
			x = ImageTools.limit(x, width, 0);
			y = ImageTools.limit(y, height, 0);
			
			g.fillOval((int)x,(int) y, (int)size, (int)size);
			//g.setColor(g.getColor().brighter());
			g.drawOval((int)x,(int) y, (int)size,(int) size);
		}
		
	}
}