@file:JvmName("NullabilityIssue")

package com.tomzium.check.issue.nullablility

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiPrimitiveType
import com.intellij.psi.PsiType
import org.jetbrains.uast.UMethod


/**
 * Created by TomazWang on 2018/08/12.
 *
 *
 * @author Tomaz Wang
 * @since 2018/08/12
 **/

@JvmField
val NULLABILITY_ISSUE = Issue.create(
        "NullabilityIssue",
        "Please annotate the nullability of public methods.",
        "For the interactions between Kotlin and Java, please specify the nullability of return value of any public method.",
        Category.USABILITY,
        6,
        Severity.ERROR,
        Implementation(
                NullabilityIssueDetector::class.java,
                Scope.JAVA_FILE_SCOPE
        )
)


class NullabilityIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = mutableListOf(NULLABILITY_ISSUE)
}


class NullabilityIssueDetector : Detector(), Detector.UastScanner {
    
    override fun getApplicableUastTypes() = mutableListOf(UMethod::class.java)
    
    override fun createUastHandler(context: JavaContext) = NullabilityIssueAnnotationVisitor(context)
}

class NullabilityIssueAnnotationVisitor(private val context: JavaContext) : UElementHandler() {
    
    private val NULLABILITY_ANNOTATIONS = arrayOf("NonNull", "Nullable")
    
    override fun visitMethod(node: UMethod) {
        
        val psiMethod = node.psi
        
        if (isPublic(psiMethod) and !isIgnoredType(psiMethod.returnType)) {
            processAnnotations(node)
        }
        
    }
    
    /** Returns true if the type is a primitive type.  */
    private fun isIgnoredType(psiType: PsiType?): Boolean = if (psiType == null) false else psiType is PsiPrimitiveType
    
    private fun isPublic(method: PsiMethod) = method.modifierList.hasModifierProperty(PsiModifier.PUBLIC)
    
    private fun processAnnotations(method: UMethod) {
        
        val annotations = context.evaluator
                .getAllAnnotations(method, false)
                .mapNotNull { it.qualifiedName?.split(".")?.lastOrNull() }
                .distinct()
        
        
        if (!annotations.any(NULLABILITY_ANNOTATIONS::contains)) {
            report(method)
        }
    }
    
    private fun report(node: UMethod) {
        val methodName = node.name
        context.report(NULLABILITY_ISSUE,
                context.getLocation(node),
                "Method $methodName should annotated with @Nullable or @NonNull")
    }
}





