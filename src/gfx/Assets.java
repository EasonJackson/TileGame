package gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 300, height = 300;
	
	public static BufferedImage playerKiyoshi, Katsudo, Shingo, Andore, John, Mari, Meiko, Hana, Anzu, Rijijo;
	public static BufferedImage dirt, grass, stone, tree, river, banks, bridge, bars, flower;
	
	public static void init(){
		
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sarah_hyland_nude.jpg"));
		
		//player = sheet.crop(0, 0, width, height);
		//dirt = sheet.crop(0*width, 0, width, height);
		//grass = sheet.crop(0*width, 0, width, height);
		//stone = sheet.crop(0*width, 0, width, height);
		//tree = sheet.crop(0, height, width, height);
		playerKiyoshi = ImageLoader.loadImage("/textures/Kiyoshi.jpg").getSubimage(357, 273, 130, 130);
		Katsudo = ImageLoader.loadImage("/textures/Katsudo.jpg").getSubimage(357, 273, 130, 130);
		Shingo = ImageLoader.loadImage("/textures/Shingo.jpg").getSubimage(357, 273, 130, 130);
		Andore = ImageLoader.loadImage("/textures/Andore.jpg").getSubimage(357, 273, 130, 130);
		John = ImageLoader.loadImage("/textures/John.jpg").getSubimage(357, 273, 130, 130);
		Mari = ImageLoader.loadImage("/textures/Mari.jpg").getSubimage(357, 273, 130, 130);
		Meiko = ImageLoader.loadImage("/textures/Meiko.jpg").getSubimage(357, 273, 130, 130);
		Hana = ImageLoader.loadImage("/textures/Hana.jpg").getSubimage(357, 273, 130, 130);
		Anzu = ImageLoader.loadImage("/textures/Anzu.jpg").getSubimage(357, 273, 130, 130);
		Rijijo = ImageLoader.loadImage("/textures/Rijijo.jpg").getSubimage(357, 273, 130, 130);
		
		dirt = ImageLoader.loadImage("/textures/Dirt.jpg");
		grass = ImageLoader.loadImage("/textures/Grass.jpg");
		stone = ImageLoader.loadImage("/textures/Stone.jpg");
		tree = ImageLoader.loadImage("/textures/Tree.jpg");
		river = ImageLoader.loadImage("/textures/River.jpg");
		tree = ImageLoader.loadImage("/textures/Tree.jpg");
		//banks = ImageLoader.loadImage("/textures/Banks.jpg");
		bridge = ImageLoader.loadImage("/textures/Bridge.jpg");
		bars = ImageLoader.loadImage("/textures/Bars.png");
		flower = ImageLoader.loadImage("/textures/Flower.jpg");
		
	}
}
