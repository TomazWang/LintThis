@file:JvmName("KotlinIssue")
package com.tomzium.check.issue.somekt

import com.android.tools.lint.detector.api.*

/**
 * Created by TomazWang on 2018/08/09.
 *
 *
 * @author Tomaz Wang
 * @since 2018/08/09
 **/

@JvmField
val KOTLIN_ISSUE = Issue.create(
        "KotlinIssue",
        "Some issue written in kotlin",
        "Just some issue here written by kotlin",
        Category.CORRECTNESS,
        3,
        Severity.WARNING,
        Implementation(
                KotlinIssueDetector::class.java,
                Scope.JAVA_FILE_SCOPE
        )
)