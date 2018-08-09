package com.tomzium.check.issue.some;

import com.android.tools.lint.client.api.UElementHandler;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.JavaContext;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.uast.UElement;
import org.jetbrains.uast.UMethod;

/**
 * Created by TomazWang on 2018/08/09.
 *
 * @author Tomaz Wang
 * @since 2018/08/09
 **/

public class SomeIssueDetector extends Detector implements Detector.UastScanner {

    @Nullable
    @Override
    public List<Class<? extends UElement>> getApplicableUastTypes() {
        return Collections.singletonList(UMethod.class);
    }

    @Nullable
    @Override
    public UElementHandler createUastHandler(final JavaContext context) {
        return new UElementHandler(){
            @Override
            public void visitMethod(UMethod node) {
                String name = node.getName();
                report(node, name, context);
            }
        };
    }

    private void report(UMethod node, String name, JavaContext context) {
        context.report(SomeIssue.ISSUE, context.getLocation(node), String.format("Looks not so good here at method \"%s\"", name));
    }
}
