package listener;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import junit.framework.TestSuite;
import org.testng.ITestListener;

import java.time.temporal.TemporalField;

import static extentSetup.Extent.extentFlush;
import static extentSetup.Extent.extentUtil;

public class StepListener implements ConcurrentEventListener, ITestListener {
    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
 //   eventPublisher.registerHandlerFor(TestSuite.class, this::testStepsStarted);
        eventPublisher.registerHandlerFor(Throwable.class, this::testStepsStarted);
    eventPublisher.registerHandlerFor(TestCaseStarted.class, this::testCaseStarted);

    eventPublisher.registerHandlerFor(TestCaseFinished.class,  this::handleTestcaseFinished);

    }

    private void testStepsStarted(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }


    private <T> void testStepsStarted(RuntimeException t) {
        System.out.println(t.getCause().getMessage());
    }


    private <T> void testCaseStarted(TestCaseStarted t)
    {
        System.out.println("t.getTestCase().getName()>>"+t.getTestCase().getKeyword());
        System.out.println("t.getInstant()>>"+t.getInstant());
    }

    private <T> void handleTestcaseFinished(TestCaseFinished event)
    {
        TestCase testCase = event.getTestCase();
        Result result = event.getResult();
        Throwable error = event.getResult().getError();
        System.out.println("testCase.getName() "+testCase.getName());
 //       extentUtil(testCase.getName(), testCase.getName(), result.getStatus().toString());

    }

}
