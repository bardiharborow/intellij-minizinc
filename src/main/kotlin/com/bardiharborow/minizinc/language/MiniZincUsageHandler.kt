package com.bardiharborow.minizinc.language

import com.intellij.find.usages.api.UsageHandler
import com.intellij.find.usages.api.UsageOptions
import org.jetbrains.annotations.Nls

@Suppress("UnstableApiUsage")
class MiniZincUsageHandler(val name: String) : UsageHandler {
    override fun getSearchString(
        p0: UsageOptions
    ): @Nls(capitalization = Nls.Capitalization.Title) String = name
}
