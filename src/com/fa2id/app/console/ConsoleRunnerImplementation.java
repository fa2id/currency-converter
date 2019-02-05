package com.fa2id.app.console;

import com.fa2id.app.currency.Currencies;
import com.fa2id.app.currency.CurrencyConverter;
import com.fa2id.app.currency.CurrencyConverterImplementation;
import com.fa2id.app.user.UserInteraction;
import com.fa2id.app.user.UserInteractionImplementation;

import java.text.DecimalFormat;

/**
 * @author farid
 * www.fa2id.com
 */
public class ConsoleRunnerImplementation implements ConsoleRunner {

    private final UserInteraction userInteraction;


    public ConsoleRunnerImplementation() {
        userInteraction = new UserInteractionImplementation();
    }


    @Override
    public void runTitle() {
        userInteraction.printOutput(Constants.LINE_SEPARATOR_TEXT);
        userInteraction.printOutput(Constants.TITLE_TEXT);
        userInteraction.printOutput(Constants.LINE_SEPARATOR_TEXT);
    }

    @Override
    public void runMenu() {
        while (true) {
            userInteraction.printOutput(Constants.MENU_TITLE_TEXT);
            userInteraction.printOutput(Constants.MENU_TEXT);
            userInteraction.printOutput(Constants.PROMPT_MENU_TEXT);
            String choice = userInteraction.getInput();
            switch (choice) {
                case "1":
                    convertAmount();
                    break;
                case "2":
                    printCurrencies();
                    break;
                case "3":
                    return;
                default:
                    userInteraction.printOutput(Constants.WRONG_INPUT_TEXT);
                    break;
            }
        }
    }


    @Override
    public void runPrint(final String text) {
        userInteraction.printOutput(text);
    }


    @Override
    public void runEnding() {
        userInteraction.printOutput(Constants.LINE_SEPARATOR_TEXT);
        userInteraction.printOutput(Constants.END_TEXT);
        userInteraction.printOutput(Constants.LINE_SEPARATOR_TEXT);
    }


    private void printCurrencies() {
        userInteraction.printOutput(Constants.LINE_SEPARATOR_TEXT);
        Currencies currencies = Currencies.getInstance();
        currencies.getDatabase().forEach((id, currency) -> userInteraction.printOutput(currency.toString()));
        userInteraction.printOutput(Constants.LINE_SEPARATOR_TEXT);
    }


    private void convertAmount() {
        userInteraction.printOutput(Constants.LINE_SEPARATOR_TEXT);
        userInteraction.printOutput(Constants.PROMPT_FROM_CURRENCY_TEXT);
        String fromCurrencyId = userInteraction.getInput();
        userInteraction.printOutput(Constants.PROMPT_TO_CURRENCY_TEXT);
        String toCurrencyId = userInteraction.getInput();
        double amount;
        while (true) {
            try {
                userInteraction.printOutput(Constants.PROMPT_AMOUNT_TEXT);
                final String amountString = userInteraction.getInput();
                if (amountString.isEmpty() || amountString.contains(" ") || amountString.contains("-"))
                    continue;
                final double amountFromString = Double.valueOf(amountString);
                final DecimalFormat decimalFormat = new DecimalFormat("#.##");
                amount = Double.valueOf(decimalFormat.format(amountFromString));
            } catch (Exception e) {
                userInteraction.printOutput(Constants.WRONG_INPUT_TEXT);
                continue;
            }
            break;
        }
        CurrencyConverter currencyConverter = new CurrencyConverterImplementation();
        try {
            final double convertedAmount = currencyConverter.convert(amount, fromCurrencyId, toCurrencyId);
            userInteraction.printOutput(Constants.AFTER_CONVERSION_TEXT);
            userInteraction.printOutput(amount + " " + fromCurrencyId
                    + "= " + String.valueOf(convertedAmount) + " " + toCurrencyId);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        } finally {
            userInteraction.printOutput(Constants.LINE_SEPARATOR_TEXT);
        }
    }
}
