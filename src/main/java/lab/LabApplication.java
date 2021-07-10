package lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabApplication {
    public static void main(String[] args) {
        for (int count = 1; count <= 100; count++) {
            System.out.println("로깅 재밌어 " + count);
        }

        Logger logger = LoggerFactory.getLogger(LabApplication.class);
        for (int count = 1; count <= 100; count++) {
            logger.info("SLF4J-API를 사용하는 로깅 재밌어 {}", count);
        }
    }
}
