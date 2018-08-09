package com.tomzium.check.issue.somekt

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UAnnotation
import org.jetbrains.uast.UElement

/**
 * Created by TomazWang on 2018/08/09.
 *
 *
 * @author Tomaz Wang
 * @since 2018/08/09
 **/

class KotlinIssueDetector : Detector(), Detector.UastScanner {
    
    override fun getApplicableUastTypes(): List<Class<out UElement>>? = mutableListOf(UAnnotation::class.java)
    
    override fun createUastHandler(context: JavaContext): UElementHandler? = object: UElementHandler(){
        
        private fun report(node: UElement, name:String){
            context.report(KOTLIN_ISSUE, context.getLocation(node), "no annotation $name allowed!")
        }
        
        override fun visitAnnotation(node: UAnnotation) {
            report(node, if(node.qualifiedName != null) node.qualifiedName!! else "")
        }
        
        
        
    }
    
    
}