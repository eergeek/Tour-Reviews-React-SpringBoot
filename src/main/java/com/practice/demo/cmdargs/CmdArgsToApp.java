package com.practice.demo.cmdargs;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class CmdArgsToApp {

    public CmdArgsToApp(ApplicationArguments arguments) {
        // Get All Arguments Passed to App by user
        // including Option and Non-option Arguments
        System.out.println("======= ALL ARGUMENTS WITH NAME and VALUES =========");
        for (String arg: arguments.getSourceArgs()) {
            System.out.println(arg);
        }

        // get the option arguments name (not value) prefixed by "--"
        System.out.println("======== OPTION ARGS Names =======");
        for ( String optionArg: arguments.getOptionNames()) {
            System.out.println(optionArg);
        }

        // get the option arg names and corresponding values
        System.out.println("===== OPTION ARG Name:Value =====");
        for (String optionArg: arguments.getOptionNames()) {
            System.out.printf("%s ---> %s\n", optionArg, arguments.getOptionValues(optionArg));
        }

        // get the non option args
        System.out.println("==== Non Option Args ====");
        for (String nonOptArg: arguments.getNonOptionArgs()) {
            System.out.println(nonOptArg);
        }

        // Can check if certain option is present in args
        System.out.println("*** Check if 'target' option is given as arguments with some values ***");
        if (arguments.containsOption("target")) {
            System.out.println(arguments.getOptionValues("target"));
        }
    }
}
