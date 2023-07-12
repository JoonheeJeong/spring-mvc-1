package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {

    private final String viewName;
    private final Map<String, Object> model;

    public ModelView(String viewName) {
        this.viewName = viewName;
        this.model = new HashMap<>();
    }

    public ModelView(String viewName, Map<String, Object> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public void setAttribute(String name, Object value) {
        model.put(name, value);
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
