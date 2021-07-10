package lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabApplication {
    public static void main(String[] args) {
        for (int count = 1; count <= 10; count++) {
            System.out.println("로깅 재밌어 " + count);
        }

        Logger logger = LoggerFactory.getLogger(LabApplication.class);
        for (int count = 1; count <= 10; count++) {
            logger.info("SLF4J-API를 사용하는 로깅 재밌어 {}", count);
        }

        for (int count = 1; count <= 10; count++) {
            logger.info("SLF4J-API와 Logback 로깅 재밌어 {}", count);
        }
    }
}
