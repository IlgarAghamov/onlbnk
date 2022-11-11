package com.example.onlbnk.service.registrationAndVerification;

import com.example.onlbnk.model.User;
import com.example.onlbnk.service.scanner.MyScanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class Registration {
    public void registration(List<User> registration) {
        System.out.println("You want to register?");
        System.out.println("If yes click 1 ,otherwise 2");

        int numberForRegistration = 3;
        switch (MyScanner.scannerSystemFor2()) {
            case "1":
                Scanner sc = new Scanner(System.in);
                System.out.println("Let's start");
                CountOfAttention.countOfAttentions(numberForRegistration);
                System.out.println("Please enter login ");
                System.out.println("Login must not be more than 20 characters");
                boolean loginException = false;
                String login = sc.nextLine();
                while (!loginException) {
                    if (registration.isEmpty()) {
                        loginException = true;
                    } else {
                        for (User user : registration) {
                            if (login.equals(user.getUserLogin())) {
                                System.out.println("Login busy");
                                System.out.println("Please try again");
                                login = sc.nextLine();
                            } else {
                                loginException = true;
                            }
                        }
                    }
                }
                System.out.println("Enter password and confirm ");
                System.out.println("They must match");
                String password = sc.nextLine();
                String confirm = sc.nextLine();
                while (numberForRegistration > 0) {
                    Scanner s = new Scanner(System.in);
                    Scanner s1 = new Scanner(System.in);
                    if (login.length() > 20) {
                        numberForRegistration--;
                        if (numberForRegistration != 0) {
                            CountOfAttention.countOfAttentions(numberForRegistration);
                            System.out.println("Login must not be more than 20 characters");
                            System.out.println("Enter login again");
                            login = s1.nextLine();
                        }
                    } else if (!password.equals(confirm)) {
                        numberForRegistration--;
                        if (numberForRegistration != 0) {
                            CountOfAttention.countOfAttentions(numberForRegistration);
                            System.out.println("Passwords do not match");
                            System.out.println("Enter pass and confirm again");
                            password = s.nextLine();
                            confirm = s.nextLine();
                        }
                    } else if (login.length() < 20) {
                        System.out.println("Ok, you are registered");
                        numberForRegistration = -1;
                        break;
                    }
                    SystemExit.systemExitCode(numberForRegistration);
                }

                break;
            case "2":
                System.out.println("Thanks for visiting us");
                System.exit(1);
                break;
        }
    }
}
