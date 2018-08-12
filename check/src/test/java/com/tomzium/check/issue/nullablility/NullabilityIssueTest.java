package com.tomzium.check.issue.nullablility;

import org.junit.Test;

import static com.android.tools.lint.checks.infrastructure.TestFiles.java;
import static com.android.tools.lint.checks.infrastructure.TestLintTask.lint;

/**
 * Created by TomazWang on 2018/08/12.
 *
 * @author Tomaz Wang
 * @since 2018/08/12
 **/

public class NullabilityIssueTest {

    @Test
    public void test_nullabilityIssue_should_reportError_when_publicMethodHasNoAnnotation() {
        lint().files(
                java(""
                        + "package com.pkg.test;\n"
                        + "\n"
                        + "public class TestClass{\n"
                        + "     public String testMethod(){\n"
                        + "             return \"hello\";\n"
                        + "     }\n"
                        + "}\n"
                        + "")
                )
                .issues(NullabilityIssue.NULLABILITY_ISSUE)
                .run()
                .expectWarningCount(0)
                .expectErrorCount(1);
    }


    @Test
    public void test_nullabilityIssue_should_beClean_when_publicMethodHasNonNullAnnotation() {
        lint().files(
                java(""
                        + "package com.pkg.test;\n"
                        + "\n"
                        + "public class TestClass{\n"
                        + "\n"
                        + "     @NonNull\n"
                        + "     public String testMethod(){\n"
                        + "             return \"hello\";\n"
                        + "     }\n"
                        + "}\n"
                        + ""))
                .issues(NullabilityIssue.NULLABILITY_ISSUE)
                .run()
                .expectClean();
    }

    @Test
    public void test_nullabilityIssue_should_beClean_when_publicMethodHasNullableAnnotation() {
        lint().files(
                java(""
                        + "package com.pkg.test;\n"
                        + "\n"
                        + "public class TestClass{\n"
                        + "\n"
                        + "     @Nullable\n"
                        + "     public String testMethod(){\n"
                        + "             return \"hello\";\n"
                        + "     }\n"
                        + "}\n"
                        + ""))
                .issues(NullabilityIssue.NULLABILITY_ISSUE)
                .run()
                .expectClean();
    }


    @Test
    public void test_nullabilityIssue_should_beClean_when_publicMethodWithNoReturnValue() {
        lint().files(
                java(""
                        + "package com.pkg.test;\n"
                        + "\n"
                        + "public class TestClass{\n"
                        + "     public void testMethod(){\n"
                        + "     }\n"
                        + "}\n"
                        + ""))
                .issues(NullabilityIssue.NULLABILITY_ISSUE)
                .run()
                .expectClean();
    }


    @Test
    public void test_nullabilityIssue_should_beClean_when_publicMethodWithPrimitiveReturnValue() {
        lint().files(
                java(""
                        + "package com.pkg.test;\n"
                        + "\n"
                        + "public class TestClass{\n"
                        + "     public int testMethod(){\n"
                        + "             return 3;\n"
                        + "     }\n"
                        + "}\n"
                        + ""))
                .issues(NullabilityIssue.NULLABILITY_ISSUE)
                .run()
                .expectClean();
    }

}
