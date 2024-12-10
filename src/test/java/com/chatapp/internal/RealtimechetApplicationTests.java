package com.chatapp.internal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.chatapp.internal.RealtimechetApplication;

@SpringBootTest(classes = RealtimechetApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class RealtimechetApplicationTests {

    @Test
    void contextLoads() {
        // テストコンテキストが正常にロードされることを確認
    }

}
