package tripcruncho.tctest1.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

/**
 *
 * @author Anders Klasson <aklasson@kth.se>
 */
public class ImageCreator {

    private final File inputDir;
    private final String[] fileTypes;
    private File inputFile;
    private String fileType;
    private boolean fileExists;


    public ImageCreator(String id) {
        inputDir = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")).getParentFile().getParentFile();
        fileTypes = ImageIO.getWriterFormatNames();
        findFile(id);
    }

    private void findFile(String id) {
        boolean hit = false;
        for (String fileType : fileTypes) {
            File tmpInputFile = new File(inputDir + "/" + id + "." + fileType);
            if (tmpInputFile.exists()) {
                inputFile = tmpInputFile;
                this.fileType = fileType;
                hit = true;
                break;
            }
        }
        this.fileExists = hit;
    }
    
    public boolean getFileExists(){
        return this.fileExists;
    }
    
    public String getInputDir() {
        return inputDir.toString();
    }

    public ByteArrayInputStream CreateImage(String title, String description) {
        title = (title != null && title.length() > 0) ? title : "no title provided";
        description = (description != null && description.length() > 0) ? description : "no description provided";

        try {
            final BufferedImage image = ImageIO.read(inputFile);
            Graphics g = image.getGraphics();
            Font header = new Font("Sans-Serif", Font.BOLD, 40);
            Font plain = new Font("Serif", Font.PLAIN, 35);
            g.setFont(header);
            g.setColor(Color.red);
            g.drawString(title, 100, 100);
            g.setColor(Color.blue);
            g.setFont(plain);
            g.drawString(description, 100, 150);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, fileType, baos);
            return new  ByteArrayInputStream (baos.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }
}
