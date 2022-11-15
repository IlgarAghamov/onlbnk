package com.example.onlbnk.service.registrationAndVerification;

import com.example.onlbnk.model.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class Verification {
    public void verification(List<CustomUser> user) throws ClassNotFoundException {
        Scanner scannerVerification = new Scanner(System.in);
        int m = 3;
        System.out.println("Please enter login");
        boolean a1 = false;
        while (a1 != true) {
            CountOfAttention.countOfAttentions(m);
            String enteredLogin = scannerVerification.nextLine();
            for (CustomUser s1 : user) {
                if (s1.getUserLogin().equals(enteredLogin)) {
                    System.out.println("Login is true ");
                    System.out.println("Please enter password");

                    while (a1 != true) {
                        CountOfAttention.countOfAttentions(m);
                        String enterPassword = scannerVerification.nextLine();
                        if (s1.getUserPassword().equals(enterPassword)) {
                            System.out.println("Password is true");
                            System.out.println("Welcome");
                            a1 = true;
                        } else {
                            if (m != 1) {
                                System.out.println("Password not true");
                                System.out.println("Please try again ");
                            }
                        }
                        m--;
                        SystemExit.systemExitCode(m);
                    }
                }
            }
            if (a1 != true) {
                if (m != 1) {
                    System.out.println("Login not true");
                    System.out.println("Please enter login again");
                }
                m--;
            }
            SystemExit.systemExitCode(m);
        }
    }
}
