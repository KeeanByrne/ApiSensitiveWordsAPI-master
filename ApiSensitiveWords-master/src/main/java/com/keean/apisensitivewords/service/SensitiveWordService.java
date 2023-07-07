package com.keean.apisensitivewords.service;

//----------------------------Import List----------------------------//
import com.keean.apisensitivewords.entity.sensitiveWord;
import com.keean.apisensitivewords.repository.SensitiveWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Pattern;
//----------------------------Import List----------------------------//

@Service
public class SensitiveWordService {
    private final SensitiveWordRepository sensitiveWordRepository;

    @Autowired
    public SensitiveWordService(SensitiveWordRepository sensitiveWordRepository) {
        this.sensitiveWordRepository = sensitiveWordRepository;
    }

    public List<sensitiveWord> getAllSensitiveWords() {
        return sensitiveWordRepository.findAll();
    }


}
