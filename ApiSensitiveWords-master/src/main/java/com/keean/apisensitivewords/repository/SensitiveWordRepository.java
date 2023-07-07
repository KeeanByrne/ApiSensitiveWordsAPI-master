package com.keean.apisensitivewords.repository;

//----------------------------Import List----------------------------//
import com.keean.apisensitivewords.entity.sensitiveWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//----------------------------Import List----------------------------//


public interface SensitiveWordRepository extends JpaRepository<sensitiveWord, Long> {
    List<sensitiveWord> findByWordContaining(String keyword);
}
