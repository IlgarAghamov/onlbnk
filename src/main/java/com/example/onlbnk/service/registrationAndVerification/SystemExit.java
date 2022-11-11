package com.example.onlbnk.service.registrationAndVerification;

public class SystemExit {
    public static void systemExitCode(int i) {
        if (i == 0) {
            System.out.println("You dont have attention");
            System.out.println("Please Try next time");
            System.exit(1);
        }
    }
}
