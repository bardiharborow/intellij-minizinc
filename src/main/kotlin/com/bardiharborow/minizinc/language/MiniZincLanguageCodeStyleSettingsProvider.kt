package com.bardiharborow.minizinc.language

import com.intellij.lang.Language
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider

class MiniZincLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider() {
    override fun getCodeSample(settingsType: SettingsType): String {
        // From https://www.minizinc.org/
        return """
            include "globals.mzn";

            % Pack n squares of side length 1..n into as small an area as possible
            int: n = 6;

            % Side length of each square
            set of int: POSITION = 1..sum(size);

            % Position of each square
            array [int] of int: size = [i | i in 1..n];
            array [1..n] of var POSITION: x;
            array [1..n] of var POSITION: y;

            % Squares must not overlap
            constraint diffn(x, y, size, size);

            % Compute total width and height
            var int: total_width :: output = max (i in 1..n) (x[i] + size[i]);
            var int: total_height :: output = max (i in 1..n) (y[i] + size[i]);

            % Minimize total area
            solve minimize total_width * total_height;

            include "visualise.mzn";
        """
            .trimIndent()
    }

    override fun customizeSettings(
        consumer: CodeStyleSettingsCustomizable,
        settingsType: SettingsType,
    ) {
        //        if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
        //            consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS");
        //        }

        consumer.showAllStandardOptions()

        super.customizeSettings(consumer, settingsType)
    }

    override fun getApplicableLanguages(): List<Language> {
        return listOf(language)
    }

    override fun getLanguage(): Language {
        return MiniZincLanguage.INSTANCE
    }
}
