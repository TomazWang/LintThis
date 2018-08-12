package com.tomzium.check.issue.somekt;

import com.android.tools.lint.checks.infrastructure.LintDetectorTest;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Issue;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * Created by TomazWang on 2018/08/09.
 *
 * @author Tomaz Wang
 * @since 2018/08/09
 **/

public class KotlinIssueDetectorTest extends LintDetectorTest {

    @Override
    protected Detector getDetector() {
        return new KotlinIssueDetector();
    }

    @Override
    protected List<Issue> getIssues() {
        return Collections.singletonList(KotlinIssue.KOTLIN_ISSUE);
    }


    @Test
    public void testKotlinIssue() {
        lint().files(
                java(""
                        + "package com.pkg.test;\n"
                        + "\n"
                        + "@Test\n"
                        + "\n"
                        + "public class TestClass{\n"
                        + "     public void testMethod(){\n"
                        + "     }\n"
                        + "}\n"
                        + ""))
                .run()
                .expectWarningCount(1)
                .expect(""
                        + "src/com/pkg/test/TestClass{.java:3: Warning: no annotation Test allowed! [KotlinIssue]\n"
                        + "@Test\n"
                        + "~~~~~\n"
                        + "0 errors, 1 warnings");
    }


}
