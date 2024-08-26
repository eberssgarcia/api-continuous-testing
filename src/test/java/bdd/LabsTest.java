package bdd;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ReportsUtil.genarateReports;

public class LabsTest {

    private static final Logger LOGGER = Logger.getLogger(LabsTest.class.getName());

    @BeforeAll
    static void beforeClass() {
        LOGGER.info("Iniciando pruebas...");
    }

    @AfterAll
    static void afterClass() {
        LOGGER.info("Finalizando pruebas...");
    }

    @Test
    void pruebasParalelas() {
        Results results = Runner.path("classpath:bdd")
                .outputCucumberJson(true)
//                .tags("~@ignore")
                .parallel(5);
        genarateReports(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}