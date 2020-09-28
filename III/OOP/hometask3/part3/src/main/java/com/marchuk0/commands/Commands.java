package com.marchuk0.commands;

import com.marchuk0.Converter;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Commands {

    private static Converter converter;
    @ShellMethod("Initialize")
    public void init(@ShellOption Double usd, @ShellOption Double eur){
        converter = new Converter(usd, eur);
    }
    @ShellMethod("UAH to USD")
    public void uahToUsd(@ShellOption(help = "amount") Double value) {
        System.out.println(converter.uahToUsd(value));
    }

    @ShellMethod("UAH to EUR")
    public void uahToEur(@ShellOption(help = "amount") Double value) {
        System.out.println(converter.uahToEur(value));
    }

    @ShellMethod("USD to UAH")
    public void usdToUah(@ShellOption(help = "amount") Double value) {
        System.out.println(converter.usdToUah(value));
    }

    @ShellMethod("EUR to UAH")
    public void eurToUah(@ShellOption(help = "amount") Double value) {
        System.out.println(converter.eurToUah(value));
    }


}