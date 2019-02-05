package com.fa2id.app.console;

/**
 * @author farid
 * www.fa2id.com
 */
class Constants {

    final static String LINE_SEPARATOR_TEXT = "=====================================================";
    final static String TITLE_TEXT = "=================CURRENCY CONVERTER==================";
    final static String END_TEXT = "=======================FINISH========================";
    final static String PROMPT_MENU_TEXT = "Please, write and option number and press ENTER...";
    final static String PROMPT_TO_CURRENCY_TEXT = "Please, write currency ID (e.g. CAD) and press ENTER "
            + "(CONVERT TO THIS CURRENCY)...\"";
    final static String PROMPT_AMOUNT_TEXT = "Please, write the amount that you want to convert " +
            "and press ENTER...";
    final static String WRONG_INPUT_TEXT = "Wrong input. Please, try again!";
    final static String AFTER_CONVERSION_TEXT = "Amount converted->";
    private final static String NEW_LINE = "\n";
    final static String MENU_TITLE_TEXT = NEW_LINE + "-> MENU" + NEW_LINE;
    final static String PROMPT_FROM_CURRENCY_TEXT = LINE_SEPARATOR_TEXT + NEW_LINE
            + "Please, write currency ID (e.g. USD) and press ENTER (CONVERT FROM THIS CURRENCY)...";
    private final static String MENU_OPTIONS = NEW_LINE
            + "|1| Convert" + NEW_LINE
            + "|2| List of currencies" + NEW_LINE
            + "|3| End Application" + NEW_LINE;
    final static String MENU_TEXT = "This application is a currency converter." + NEW_LINE
            + "Please choose an option:" + NEW_LINE + MENU_OPTIONS;

}
