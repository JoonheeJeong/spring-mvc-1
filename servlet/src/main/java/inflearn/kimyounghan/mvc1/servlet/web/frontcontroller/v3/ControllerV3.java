package inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.v3;

import inflearn.kimyounghan.mvc1.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
