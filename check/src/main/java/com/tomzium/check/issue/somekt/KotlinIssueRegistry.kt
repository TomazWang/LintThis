package com.tomzium.check.issue.somekt

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

/**
 * Created by TomazWang on 2018/08/09.
 *
 *
 * @author Tomaz Wang
 * @since 2018/08/09
 **/

class KotlinIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = mutableListOf(KOTLIN_ISSUE)
}