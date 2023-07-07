    package com.keean.apisensitivewords.controller;

    //--------------------Import List--------------------//
    import com.keean.apisensitivewords.entity.sensitiveWord;
    import com.keean.apisensitivewords.repository.SensitiveWordRepository;
    import org.springframework.http.HttpStatusCode;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.client.RestTemplate;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.regex.Pattern;

    //--------------------Import List--------------------//

    @RestController
    @RequestMapping("/api")
    public class MessageCensorController {

        private final SensitiveWordRepository sensitiveWordRepository;
        private final RestTemplate restTemplate;

        public MessageCensorController(SensitiveWordRepository sensitiveWordRepository, RestTemplate restTemplate) {
            this.sensitiveWordRepository = sensitiveWordRepository;
            this.restTemplate = restTemplate;
        }

        @GetMapping(path = "/isAlive")
        public ResponseEntity<Boolean> isAlive() {
            return ResponseEntity.ok(true);
        }

        @PostMapping(path = "/process-word")
        public String censorMessage(String message) {

            List<sensitiveWord> sensitiveWords = sensitiveWordRepository.findAll();

            List<String> messageWords = Arrays.stream(message.split(" ")).toList();

            List<String> apiSensitiveWords = sensitiveWords.stream().map(sensitiveWord::getWord).toList();

            List<String> wordsToReplace = messageWords.stream().filter(apiSensitiveWords::contains).toList();

            for (String word : wordsToReplace) {
                String replacement = "*".repeat(word.length());
                message = message.replaceAll(word, replacement);
            }

            return message;
        }

    }
