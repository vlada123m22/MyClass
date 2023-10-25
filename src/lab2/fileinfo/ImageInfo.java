package lab2.fileinfo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageInfo extends FileInfo{
    private int width;
    private int height;

    public ImageInfo(String filePath) throws IOException {
        super(filePath);
        this.fetchImageDimensions();
    }

    private void fetchImageDimensions() {
        File file = new File(super.getFilePath());
        try {
            BufferedImage img = ImageIO.read(file);
            width = img.getWidth();
            height = img.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
            width = -1;
            height = -1;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Image size: " + this.width + "x" + this.height);
    }

}
