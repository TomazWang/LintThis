package com.tomzium.check.issue.some;

import com.android.tools.lint.checks.infrastructure.LintDetectorTest;
import com.android.tools.lint.checks.infrastructure.TestLintResult;
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

public class SomeIssueDetectorTest extends LintDetectorTest {

    @Override
    protected Detector getDetector() {
        return new SomeIssueDetector();
    }

    @Override
    protected List<Issue> getIssues() {
        return Collections.singletonList(SomeIssue.ISSUE);
    }

    @Test
    public void testSomeIssue() {
        TestLintResult result = lint().files(
                java(""
                        + "package com.pkg.test;\n"
                        + "\n"
                        + "public class TestClass{\n"
                        + "     public void testMethod(){\n"
                        + "     }\n"
                        + "}\n"
                        + ""))
                .run();

        result.expectWarningCount(1);
        result.expectMatches("src/com/pkg/test/TestClass{.java:1: Warning: Looks not so good here at method \"testMethod\" [SomeIssue]");
    }
}
