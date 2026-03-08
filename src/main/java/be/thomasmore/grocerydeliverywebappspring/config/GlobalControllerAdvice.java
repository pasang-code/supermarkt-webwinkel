package be.thomasmore.grocerydeliverywebappspring.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.net.http.HttpRequest;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("currentUrl")
    public String getCurrentUrl(HttpServletRequest request ){
        return request.getRequestURI();
    }
}
