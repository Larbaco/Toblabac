/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Desk
 */
public class Bot {

    private String name;
    private String status;
    private String account;
    private int hp;
    private int mp;
    private int sp;

    // get a 100x100px screenshot around the last clicked position
    private static BufferedImage getScreenshot() throws AWTException {
        // get the last clicked position from the keyboard hook
        int x = KeyboardHook.coordX;
        int y = KeyboardHook.coordY;
        if (x == 0 && y == 0) {
            x += 50;
            y += 50;
        }
        // get the screenshot
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Robot robot = new Robot();
        BufferedImage screen = robot.createScreenCapture(new Rectangle(screenSize));
        // Check the boundaries to ensure that i will not get an subimage out of the
        // bounds of the screen
        if (x - 50 < 0) {
            x = 50;
        }
        if (y - 50 < 0) {
            y = 50;
        }
        if (x + 50 > screenSize.getWidth()) {
            x = (int) screenSize.getWidth() - 50;
        }
        if (y + 50 > screenSize.getHeight()) {
            y = (int) screenSize.getHeight() - 50;
        }
        BufferedImage subImage = screen.getSubimage(x - 50, y - 50, 100, 100);
        screen.createGraphics().drawImage(subImage, 0, 0, null);
        // save the captured image to the windows clipboard
        // Get the system clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // Create a transferable image (the captured screenshot)
        // and put it on the system clipboard
        TransferableImage trans = new TransferableImage(subImage);
        clipboard.setContents(trans, null);
        return subImage;
    }

    private static Color getDominantColor(Image image) {
        // Create a PixelReader from the image
        PixelReader pixelReader = image.getPixelReader();

        // Count occurrences of each color in the image
        Map<Color, Integer> colorCount = new HashMap<>();

        // Iterate through all pixels in the image
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                javafx.scene.paint.Color color = pixelReader.getColor(x, y);
                // Convert the color to a JavaFX Color
                Color awtColor = new Color((float) color.getRed(), (float) color.getGreen(), (float) color.getBlue());
                // Increment the count for this color
                colorCount.put(awtColor, colorCount.getOrDefault(color, 0) + 1);
            }
        }
        // Find the color with the highest count
        int maxCount = 0;
        Color dominantColor = Color.BLACK; // Default to black if the image is empty

        for (Map.Entry<Color, Integer> entry : colorCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                dominantColor = entry.getKey();
            }
        }

        return dominantColor;
    }

    public static Color identify() {
        try {
            System.out.println("Identifying...");
            BufferedImage screenshot = getScreenshot();
            // convert the screenshot to an Image
            Image screenshotImage = SwingFXUtils.toFXImage(screenshot, null);
            Color color = getDominantColor(screenshotImage);
            System.out.println(color);
            System.out.println("Identification done!");
            return color;
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }

}