package tripcruncho.tctest1.view;

import java.io.ByteArrayInputStream;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author Anders Klasson <aklasson@kth.se>
 */
@Named(value = "applicationBean")
@ApplicationScoped
public class ApplicationBean {
/* It requires an Application bean for streaming an image to o:graphicImage 
The requestbean handles the state for the duration of the request
*/
@Inject RequestBean welcomeBean;
    /**
     * Creates a new instance of ImageStreamer
     */
    public ApplicationBean() {
    }
    
    public boolean hasImage(){
        return this.welcomeBean.hasImage();
    }
    
    public String getInputPath(){
        return this.welcomeBean.getInputPath();
    }
    
    public ByteArrayInputStream loadImage(){
        return this.welcomeBean.loadImage();
    }
    
}
