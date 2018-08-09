package com.tomzium.check.issue.some;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * Created by TomazWang on 2018/08/09.
 *
 * @author Tomaz Wang
 * @since 2018/08/09
 **/

public class SomeIssueRegistry extends IssueRegistry {

    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Collections.singletonList(SomeIssue.ISSUE);
    }
}
