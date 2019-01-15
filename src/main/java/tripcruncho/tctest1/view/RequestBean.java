package tripcruncho.tctest1.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import tripcruncho.tctest1.util.ImageCreator;

/**
 *
 * @author Anders Klasson <aklasson@kth.se>
 */
@Named(value = "requestBean")
@RequestScoped
public class RequestBean {

    private final ImageCreator creator;

    String id;
    String title;
    String desc;

    public RequestBean() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.creator = new ImageCreator(id);
        id = req.getParameter("background_image_id");
        title = req.getParameter("title_text");
        desc = req.getParameter("description_text");
    }

    public boolean hasImage() {
        return creator.getFileExists();
    }

    public ByteArrayInputStream loadImage() {
        return creator.CreateImage(title, desc);
    }

    public String getInputPath() {
        return creator.getInputDir();
    }
}
