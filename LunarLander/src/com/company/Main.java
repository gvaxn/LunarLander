package com.company;

import java.util.Scanner;

public class Main extends LunarLander {

    public static void main(String[] args) {


        LunarLander[] array = new LunarLander[3];

        for (int i = 0; i < array.length; i++) {
            array[i] = new LunarLander();
            array[i].setThrust(3.5);
            array[i].setThrustTimeLimit(3);
            array[i].setGravity(-1.62);
            array[i].setSafeLandingThreshold(1);
            array[i].setHardLandingThreshold(-1);
            array[i].setFuelLoadTime(.3);
        }

        array[0].setSafeLandingThreshold(-10);
        array[0].setHardLandingThreshold(-15);

        array[1].setFuelLoadTime(.1);
        array[1].setThrust(4.25);

        boolean checkLanding = false;

        double simFuelLoad = 0.3;

        Scanner in = new Scanner(System.in);

        boolean repeat = false;
        double userTime = 0.0;
        double userTimeThrust;
        int count = 0;

        double posA;
        double posB;
        double posC;

        double velA;
        double velB;
        double velC;

        double simTime;
        double fuelLoadTime = 0;
        int checkLanding1;

        String choice1;
        String landing;

        double[] trajectoryA = new double[3];
        double[] trajectoryB = new double[3];
        double[] trajectoryC = new double[3];

        int fuelFor1 = array[0].getNumPellets(0);


        while (!checkLanding) {

            if (array[0].getPosition() <= 0.0 && array[1].getPosition() <= 0.0 && array[2].getPosition() <= 0.0) {
                checkLanding = true;
            }

            System.out.println("Which Lander do you want to use? Lander 1, 2, or 3.");
            System.out.print("> ");
            int choice = in.nextInt();
            switch (choice) {

                case 1:
                    array[0].getPosition();

                    if (array[0].getPosition() <= 0.00) {

                        posA = 0.0;
                        velA = array[0].getVelocity();
                        simTime = array[0].getSimulationTime();
                        trajectoryA = new double[]{posA, velA, simTime};
                        printTrajectory(trajectoryA);
                        printFuelStatus(fuelFor1);
                        System.out.println("Can't use this Lander!");

                    } else {
                        System.out.println("Do you want to thrust, free fall, or repeat");
                        in.nextLine();

                    }
                    choice1 = in.nextLine();

                    if (choice1.equalsIgnoreCase("Thrust")) {

                        System.out.println("How long do you want to thrust for? (Maximum Thrust Time is 3 seconds)");
                        userTimeThrust = in.nextDouble();
                        in.nextLine();

                        if (userTimeThrust <= array[0].getThrustTimeLimit()) {

                            array[0].updateTrajectory(userTimeThrust, true);
                            array[0].consumeFuelPellet();
                        } else {
                            System.out.println("You can not thrust for longer then 3 seconds!");
                            array[0].consumeFuelPellet();
                            array[0].updateTrajectory(array[0].getThrustTimeLimit(), true);
                        }
                        simFuelLoad = array[0].getSimulationTime() + .3;


                        repeat = true;

                        array[1].updateTrajectory(userTimeThrust, false);
                        array[2].updateTrajectory(userTimeThrust, false);

                        if (array[0].getPosition() <= 0.00) {
                            posA = 0.0;
                            velA = array[0].getVelocity();
                            simTime = array[0].getSimulationTime() + simFuelLoad;
                            trajectoryA = new double[]{posA, velA, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryA);

                        } else {

                            posA = array[0].getPosition();
                            velA = array[0].getVelocity();
                            simTime = array[0].getSimulationTime() + simFuelLoad;
                            trajectoryA = new double[]{posA, velA, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryA);
                        }
                        break;

                    } else if (choice1.equalsIgnoreCase("Free Fall")) {
                        System.out.println("How long do you what to Free Fall for?");

                        userTime = in.nextDouble();
                        in.nextLine();

                        array[0].updateTrajectory(userTime, false);

                        repeat = false;

                        array[1].updateTrajectory(userTime, false);
                        array[2].updateTrajectory(userTime, false);


                        if (array[0].getPosition() <= 0.00) {
                            posA = 0.0;
                            velA = array[0].getVelocity();
                            simTime = array[0].getSimulationTime();
                            trajectoryA = new double[]{posA, velA, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryA);

                        } else {

                            posA = array[0].getPosition();
                            velA = array[0].getVelocity();
                            simTime = array[0].getSimulationTime();
                            trajectoryA = new double[]{posA, velA, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryA);
                        }
                        break;

                    } else {
                        if (repeat) {
                            array[0].consumeFuelPellet();

                            array[0].updateTrajectory(3.0, true);

                            System.out.println("Repeating thrust again...\n");

                            array[1].updateTrajectory(3, false);
                            array[2].updateTrajectory(3, false);

                        } else {
                            array[0].updateTrajectory(userTime, false);

                            System.out.println("Repeating Free Fall again for " + userTime + " seconds...\n");

                            array[1].updateTrajectory(userTime, false);
                            array[2].updateTrajectory(userTime, false);
                        }

                        if (array[0].getPosition() <= 0.00) {
                            posA = 0.0;
                            velA = array[0].getVelocity();
                            simTime = array[0].getSimulationTime();
                            trajectoryA = new double[]{posA, velA, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryA);

                        } else {

                            posA = array[0].getPosition();
                            velA = array[0].getVelocity();
                            simTime = array[0].getSimulationTime();
                            trajectoryA = new double[]{posA, velA, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryA);
                        }
                        break;
                    }
                case 2:
                    array[1].getPosition();

                    if (array[1].getPosition() <= 0.00) {

                        posB = 0.0;
                        velB = array[1].getVelocity();
                        simTime = array[1].getSimulationTime();
                        trajectoryB = new double[]{posB, velB, simTime};
                        printTrajectory(trajectoryB);
                        printFuelStatus(fuelFor1);
                        System.out.println("Can't use this Lander!");

                    } else {
                        System.out.println("Do you want to thrust, free fall, or repeat");
                        in.nextLine();

                    }
                    choice1 = in.nextLine();

                    if (choice1.equalsIgnoreCase("Thrust")) {

                        System.out.println("How long do you want to thrust for? (Maximum Thrust Time is 3 seconds)");
                        userTimeThrust = in.nextDouble();
                        in.nextLine();

                        if (userTimeThrust <= array[1].getThrustTimeLimit()) {

                            array[1].updateTrajectory(userTimeThrust, true);
                            array[1].consumeFuelPellet();
                        } else {
                            System.out.println("You can not thrust for longer then 3 seconds!");
                            array[1].consumeFuelPellet();
                            array[1].updateTrajectory(array[1].getThrustTimeLimit(), true);
                        }
                        simFuelLoad = array[1].getSimulationTime() + .3;


                        repeat = true;

                        array[0].updateTrajectory(userTimeThrust, false);
                        array[2].updateTrajectory(userTimeThrust, false);

                        if (array[1].getPosition() <= 0.00) {
                            posB = 0.0;
                            velB = array[1].getVelocity();
                            simTime = array[1].getSimulationTime() + simFuelLoad;
                            trajectoryB = new double[]{posB, velB, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryB);

                        } else {

                            posB = array[1].getPosition();
                            velB = array[1].getVelocity();
                            simTime = array[1].getSimulationTime() + simFuelLoad;
                            trajectoryB = new double[]{posB, velB, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryB);
                        }
                        break;

                    } else if (choice1.equalsIgnoreCase("Free Fall")) {
                        System.out.println("How long do you what to Free Fall for?");

                        userTime = in.nextDouble();
                        in.nextLine();

                        array[1].updateTrajectory(userTime, false);

                        repeat = false;

                        array[0].updateTrajectory(userTime, false);
                        array[2].updateTrajectory(userTime, false);


                        if (array[1].getPosition() <= 0.00) {
                            posB = 0.0;
                            velB = array[1].getVelocity();
                            simTime = array[1].getSimulationTime();
                            trajectoryB = new double[]{posB, velB, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryB);

                        } else {

                            posB = array[1].getPosition();
                            velB = array[1].getVelocity();
                            simTime = array[1].getSimulationTime();
                            trajectoryB = new double[]{posB, velB, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryB);
                        }
                        break;

                    } else {
                        if (repeat) {
                            array[1].consumeFuelPellet();

                            array[1].updateTrajectory(3.0, true);

                            System.out.println("Repeating thrust again...\n");

                            array[0].updateTrajectory(3, false);
                            array[2].updateTrajectory(3, false);

                        } else {
                            array[1].updateTrajectory(userTime, false);

                            System.out.println("Repeating Free Fall again for " + userTime + " seconds...\n");

                            array[0].updateTrajectory(userTime, false);
                            array[2].updateTrajectory(userTime, false);
                        }

                        if (array[1].getPosition() <= 0.00) {
                            posB = 0.0;
                            velB = array[1].getVelocity();
                            simTime = array[1].getSimulationTime();
                            trajectoryB = new double[]{posB, velB, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryB);

                        } else {

                            posB = array[1].getPosition();
                            velB = array[1].getVelocity();
                            simTime = array[1].getSimulationTime();
                            trajectoryB = new double[]{posB, velB, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryB);
                        }
                        break;
                    }
                case 3:

                    array[2].getPosition();

                    if (array[2].getPosition() <= 0.00) {

                        posC = 0.0;
                        velC = array[2].getVelocity();
                        simTime = array[2].getSimulationTime();
                        trajectoryC = new double[]{posC, velC, simTime};
                        printTrajectory(trajectoryC);
                        printFuelStatus(fuelFor1);
                        System.out.println("Can't use this Lander!");

                    } else {
                        System.out.println("Do you want to thrust, free fall, or repeat");
                        in.nextLine();

                    }
                    choice1 = in.nextLine();

                    if (choice1.equalsIgnoreCase("Thrust")) {

                        System.out.println("How long do you want to thrust for? (Maximum Thrust Time is 3 seconds)");
                        userTimeThrust = in.nextDouble();
                        in.nextLine();

                        if (userTimeThrust <= array[2].getThrustTimeLimit()) {

                            array[2].updateTrajectory(userTimeThrust, true);
                            array[2].consumeFuelPellet();
                        } else {
                            System.out.println("You can not thrust for longer then 3 seconds!");
                            array[2].consumeFuelPellet();
                            array[2].updateTrajectory(array[2].getThrustTimeLimit(), true);
                        }
                        simFuelLoad = array[2].getSimulationTime() + .3;


                        repeat = true;

                        array[0].updateTrajectory(userTimeThrust, false);
                        array[1].updateTrajectory(userTimeThrust, false);

                        if (array[2].getPosition() <= 0.00) {
                            posC = 0.0;
                            velC = array[1].getVelocity();
                            simTime = array[1].getSimulationTime() + simFuelLoad;
                            trajectoryC = new double[]{posC, velC, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryC);

                        } else {

                            posC = array[2].getPosition();
                            velC = array[2].getVelocity();
                            simTime = array[2].getSimulationTime() + simFuelLoad;
                            trajectoryC = new double[]{posC, velC, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryC);
                        }
                        break;

                    } else if (choice1.equalsIgnoreCase("Free Fall")) {
                        System.out.println("How long do you what to Free Fall for?");

                        userTime = in.nextDouble();
                        in.nextLine();

                        array[2].updateTrajectory(userTime, false);

                        repeat = false;

                        array[0].updateTrajectory(userTime, false);
                        array[1].updateTrajectory(userTime, false);


                        if (array[2].getPosition() <= 0.00) {
                            posC = 0.0;
                            velC = array[2].getVelocity();
                            simTime = array[2].getSimulationTime();
                            trajectoryC = new double[]{posC, velC, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryC);

                        } else {

                            posC = array[2].getPosition();
                            velC = array[2].getVelocity();
                            simTime = array[2].getSimulationTime();
                            trajectoryC = new double[]{posC, velC, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryC);
                        }
                        break;

                    } else {
                        if (repeat) {
                            array[2].consumeFuelPellet();

                            array[2].updateTrajectory(3.0, true);

                            System.out.println("Repeating thrust again...\n");

                            array[0].updateTrajectory(3, false);
                            array[1].updateTrajectory(3, false);

                        } else {
                            array[2].updateTrajectory(userTime, false);

                            System.out.println("Repeating Free Fall again for " + userTime + " seconds...\n");

                            array[0].updateTrajectory(userTime, false);
                            array[1].updateTrajectory(userTime, false);
                        }

                        if (array[2].getPosition() <= 0.00) {
                            posC = 0.0;
                            velC = array[2].getVelocity();
                            simTime = array[2].getSimulationTime();
                            trajectoryC = new double[]{posC, velC, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryC);

                        } else {

                            posC = array[2].getPosition();
                            velC = array[2].getVelocity();
                            simTime = array[2].getSimulationTime();
                            trajectoryC = new double[]{posC, velC, simTime};
                            printFuelStatus(fuelFor1);
                            printTrajectory(trajectoryC);
                        }
                        break;
                    }
            }
        }
        printTrajectory(trajectoryA);
        System.out.println("Trajectory for craft 1");
        printTrajectory(trajectoryB);
        System.out.println("Trajectory for craft 2");
        printTrajectory(trajectoryC);
        System.out.println("Trajectory for craft 3");
        System.out.println();
        printFuelStatus(fuelFor1);
        
    }

        public static void printFuelStatus ( int fuel){
            int sum = 0;
            for (int idx = 0; idx < 6; idx++) {
                System.out.print(idx + ": ");
                sum += fuel;
                for (int i = 0; i < fuel; i++)
                    System.out.print("|");
                System.out.println();
            }
            System.out.println("Total Fuel: " + sum);
        }


        public static void printTrajectory(double[] trajectory){
            System.out.println("POS: " + String.format("%.2f", trajectory[0]) +
                    "\tVEL: " + String.format("%.2f", trajectory[1]) +
                    "\tTIME: " + String.format("%.2f", trajectory[2]));

        }

}
