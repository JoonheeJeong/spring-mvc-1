package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller;

public class ViewResolver {

    private static final ViewResolver INSTANCE = new ViewResolver();

    private ViewResolver() {
    }

    public static ViewResolver getInstance() {
        return INSTANCE;
    }

    public MyView run(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
