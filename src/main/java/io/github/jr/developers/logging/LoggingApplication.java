package io.github.jr.developers.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"brave", "io.github.jr"})
@RestController
@Log4j2 // private static final Logger log = LogManager.getLogger(LoggingApplication.class); 생성
public class LoggingApplication {
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

    @PostMapping("/user")
    public User insert(@RequestBody User user) throws JsonProcessingException {
        log.info("[logging] start : " + new ObjectMapper().writeValueAsString(user));
        User user1 = userRepository.save(user);
        log.info("[logging] end : " + new ObjectMapper().writeValueAsString(user1));
        return user1;
    }
}
