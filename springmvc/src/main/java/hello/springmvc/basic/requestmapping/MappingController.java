package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {


    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("hello-basic");
        return "ok";
    }

    // 일치하는 메소드가 없으면 405 Method Not Allowed
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("/mapping-get-v1");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("/mapping-get-v2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
//    public String mappingPath(@PathVariable String userId) {
//        log.info("/mapping/{}", userId);
        log.info("/mapping/{}", data);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
        log.info("/mapping/users/{}/orders/{}", userId, orderId);
        return "ok";
    }

    // 조건에 일치하지 않으면 400 Bad Request
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("/mapping-param");
        return "ok";
    }

    // 조건에 일치하지 않으면 404 Not Found
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("/mapping-header");
        return "ok";
    }

    // 조건에 일치하지 않으면 415 Unsupported Media Type
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsume() {
        log.info("/mapping-consume");
        return "ok";
    }

    // 조건에 일치하지 않으면 406 Not Acceptable
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduce() {
        log.info("/mapping-produce");
        return "ok";
    }

}
