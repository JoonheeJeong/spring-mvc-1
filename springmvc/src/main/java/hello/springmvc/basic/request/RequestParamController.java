package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        Integer age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);
        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    // 변수와 파라미터의 이름이 일치하면 파라미터 이름 생략 가능
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // String, Long, int 등 단순 타입의 경우 @RequestParam 생략 가능..
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // required=true가 기본 -> 파라미터가 존재하지 않거나 값이 없으면 400 Bad Request
    // Integer가 아닌 int 같은 기본 타입으로 작성하면 null로 매핑할 수 없어서 역시 500 Internal Server Error
    // 그래도 Optional로 받으면 대응 가능
    // required true라도 빈문자("")면 통과됨 ... -> default value 또는 validation 필요
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Optional<Integer> age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 빈문자("")가 들어와도 defaultValue로 치환된다.
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 일반 Map일 경우 첫 번째로 입력된 값이 지정된다.
    // 하나의 키에 여러 값이 매핑되면 MultiValueMap을 쓰자. -- 값 타입의 List를 값으로 가짐
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
//            @RequestParam Map<String, Object> paramMap) {
            @RequestParam MultiValueMap<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

}
