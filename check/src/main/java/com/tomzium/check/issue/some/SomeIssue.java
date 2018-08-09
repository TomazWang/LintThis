package com.tomzium.check.issue.some;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

/**
 * Created by TomazWang on 2018/08/09.
 *
 * @author Tomaz Wang
 * @since 2018/08/09
 **/

public class SomeIssue {

    public final static Issue ISSUE = Issue.create(
            "SomeIssue",
            "There's some problems.",
            "There's some problems, but not so much hanppening.",
            Category.MESSAGES,
            3,
            Severity.WARNING,
            new Implementation(
                    SomeIssueDetector.class,
                    Scope.JAVA_FILE_SCOPE
            )
    );
}
