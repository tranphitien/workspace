package oop;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class Icons {
	private static ImageDescriptor imgA = AbstractUIPlugin.imageDescriptorFromPlugin("OOP", "icons/imageA.png");
	private static ImageDescriptor imgB = AbstractUIPlugin.imageDescriptorFromPlugin("OOP", "icons/imageB.png");
	private static ImageDescriptor imgA0 = AbstractUIPlugin.imageDescriptorFromPlugin("OOP", "icons/imageA0.png");
	private static ImageDescriptor imgB0 = AbstractUIPlugin.imageDescriptorFromPlugin("OOP", "icons/imageB0.png");
	
	static Image imageA = imgA.createImage();
	static Image imageB = imgB.createImage();
	static Image imageA0 = imgA0.createImage();
	static Image imageB0 = imgB0.createImage();
}
