package com.netflix.nebula.lint.rule.rename

import com.netflix.nebula.lint.rule.GradleLintRule
import groovy.transform.Canonical
import org.codehaus.groovy.ast.expr.MethodCallExpression

@Canonical
class PluginRenamedRule extends GradleLintRule {
    String deprecatedPluginName
    String pluginName

    @Override
    void visitApplyPlugin(MethodCallExpression call, String plugin) {
        if(plugin == deprecatedPluginName) {
            addViolationWithReplacement(call, "plugin $deprecatedPluginName has been renamed to $pluginName",
                    "apply plugin: '$pluginName'")
        }
    }
}