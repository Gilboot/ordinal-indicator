package com.github.ordinals;

import java.util.Locale;


/**
 * Contains rules defined by the country and those defined by the language
 * as obtained from the locale
 */
public class RuleSetOwner {

    private final RuleSet languageRuleSet;
    private final RuleSet countryRuleSet;


    public RuleSetOwner(final Locale locale) {
        String country  = locale.getCountry();
        String language = locale.getLanguage();

        languageRuleSet = new XMLParser().parse(language);
        countryRuleSet  = new XMLParser().parse(country);

    }

    Rule getMatchingRule(int value) {
        Rule match = languageRuleSet.getMatchingRule(value);
        if(match == null) {
            match = countryRuleSet.getMatchingRule(value);
        }
        return match;
    }
    
}
