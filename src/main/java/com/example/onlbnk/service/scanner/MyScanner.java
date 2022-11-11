package com.example.onlbnk.service.scanner;

import java.util.Scanner;

public class MyScanner {
        public static String scannerSystemFor2() {
            String result = null;
            try {
                boolean scannerBoolean = false;
                while (!scannerBoolean) {
                    Scanner scanner = new Scanner(System.in);
                    String numberForSystem = scanner.nextLine();
                    switch (numberForSystem) {
                        case "1":
                            result = "1";
                            scannerBoolean = true;
                            break;
                        case "2":
                            result = "2";
                            scannerBoolean = true;
                            break;
                        default:
                            System.out.println("Input error");
                            System.out.println("Please try again");
                    }
                }
            } catch (Exception e) {
                System.out.println("Input error");
                System.out.println("Please try again");
            }
            return result;

        }
        public static String scannerSystemFor3() {
            String result =null;
            try {
                boolean scannerBoolean=false;
                while (!scannerBoolean){
                    Scanner scanner = new Scanner(System.in);
                    String numberForSystem = scanner.nextLine();
                    switch (numberForSystem){
                        case "1":
                            result ="1";
                            scannerBoolean=true;
                            break;
                        case "2":
                            result ="2";
                            scannerBoolean=true;
                            break;
                        case "3":
                            result ="3";
                            scannerBoolean=true;
                            break;
                        default:
                            System.out.println("Input error");
                            System.out.println("Please try again");
                    }
                }
            }catch(Exception e){
                System.out.println("Input error");
                System.out.println("Please try again");
            }
            return result;

        }
    }

