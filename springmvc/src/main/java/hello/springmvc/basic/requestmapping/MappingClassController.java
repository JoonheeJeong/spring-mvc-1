package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/mapping/users")
@RestController
public class MappingClassController {

    @GetMapping
    public String findUsers() {
        return "GET /mapping/users";
    }

    @PostMapping
    public String addUser() {
        return "POST /mapping/users";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "GET /mapping/users/" + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "PATCH /mapping/users/" + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "DELETE /mapping/users/" + userId;
    }

}
