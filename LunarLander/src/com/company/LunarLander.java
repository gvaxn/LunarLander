package com.company;

public class LunarLander {

    private static final int MAX_THRUST_TIME = 3;

    //(b) Thrust from the engine applies 3.5 meters per second (+3.5 m/s^2)
    // of acceleration on the craft.†
    private static final double THRUST_ACCEL = 3.5;

    //(c) Acceleration due to gravity on the moon is −1.62 m/22
    private static final double GRAVITY_ACCEL = -1.62;

    //(d) A fuel pellet requires 3-tenths of a second (0.3 s) to be loaded into the engine.
    private static final double FUEL_LOAD_TIME = 0.3;
    //(e) The craft can undergo a landing with

    //Return values for checkLanding
    private static final int NO_LANDING = 0;
    private static final int SAFE_LANDING = 1;
    private static final int HARD_LANDING = -1;
    private static final int CRASH_LANDING = -2;

    // A velocity beyond −12 m/s is a crash and the craft experiences rapid,
    //unintended disassembly.

    private static final int POSITION_INDEX = 0;
    private static final int VELOCITY_INDEX = 1;
    private static final int TIME_INDEX = 2;

    private final int[] fuelPellets = {45, 45, 45, 45, 45, 45};
    private final int[] indexArray = {0, 3, 1, 4, 2, 5};
    //(b) craft trajectory – an array of two doubles containing the current position and
    //velocity of the lunar lander craft. The craft begins descent toward the moon’s
    //surface and may fire thrust at a height of 500 meters or lower. Assume a random
    //initial downward velocity between −20 and −30 m/s.
    //(c) simulation time – a double variable representing the amount of simulation time
    //that has passed (initially zero). This value may also be stored as a third element
    //in the craft trajectory.
    private final double[] trajectory = {500, 0, 0};


    private int thrustTimeLimit = MAX_THRUST_TIME;
    private double thrust = THRUST_ACCEL;
    private double gravity = GRAVITY_ACCEL;
    private double fuelLoadTime = FUEL_LOAD_TIME;
    private int safeLandingThreshold = SAFE_LANDING;
    private int hardLandingThreshold = HARD_LANDING;

    // Getters and Setters for ThrustTimeLimit
    public void setThrustTimeLimit(int thrustTimeLimit) {
        if (thrustTimeLimit > 0) {
            this.thrustTimeLimit = thrustTimeLimit;
        }
    }
    public int getThrustTimeLimit() {
        return thrustTimeLimit;
    }

    // Getters and Setters for Thrust
    public void setThrust(double thrust) {
        if (thrust > 0 && gravity < 0) {
            this.thrust = thrust;
        }
    }
    public double getThrust() {
        return thrust;
    }

    // Getters and Setters for Gravity
    public void setGravity(double gravity) {
        if (thrust > 0 && gravity < 0) {
            this.gravity = gravity;
        }
    }
    public double getGravity() {
        return gravity;
    }

    // Getters and Setters for FuelLoadTime
    public void setFuelLoadTime(double fuelLoadTime) {
        if (fuelLoadTime > 0) {
            this.fuelLoadTime = fuelLoadTime;
        }
    }
    public double getFuelLoadTime() {
        return fuelLoadTime;
    }

    // Getters and Setters for SafeLandingThreshold
    public void setSafeLandingThreshold(int safeLandingThreshold) {
        if (0 > safeLandingThreshold && safeLandingThreshold > hardLandingThreshold) {
            this.safeLandingThreshold = safeLandingThreshold;
        }
    }
    public double getSafeLandingThreshold() {
        return safeLandingThreshold;
    }

    // Getters and Setters for HardLandingThreshold
    public void setHardLandingThreshold(int hardLandingThreshold) {
        if (0 > safeLandingThreshold && safeLandingThreshold > hardLandingThreshold) {
            this.hardLandingThreshold = safeLandingThreshold;
        }
    }
    public double getHardLandingThreshold() {
        return hardLandingThreshold;
    }

    LunarLander(){
        trajectory[1] = -1 * (Math.random() * 10 + 20);
    }

    public int consumeFuelPellet() {
        int indexCounter = 0;
        int indices = 0;

        for(int i = 0; i < indexArray.length; i++) {
            indices = indexArray[indexCounter];

        }
        fuelPellets[indexCounter]--;
        return indices;
    }

    public int checkLanding() {
        if (trajectory[POSITION_INDEX] > 0)
            return NO_LANDING;
        else {
            if (trajectory[VELOCITY_INDEX] >= safeLandingThreshold)
                return SAFE_LANDING;
            else if (trajectory[VELOCITY_INDEX] >= hardLandingThreshold)
                return HARD_LANDING;
            else
                return CRASH_LANDING;
        }
    }

    public void updateTrajectory(double timeAmount, boolean thrust) {

        double STEP = 0.01;
        double t;


        for (t = 0.0; t < timeAmount; t += STEP) {
            trajectory[POSITION_INDEX] = trajectory[POSITION_INDEX] + trajectory[VELOCITY_INDEX] * STEP;
            trajectory[VELOCITY_INDEX] = trajectory[VELOCITY_INDEX] + (GRAVITY_ACCEL + (thrust ? THRUST_ACCEL : 0)) * STEP;
            }

        trajectory[TIME_INDEX] = trajectory[TIME_INDEX] + timeAmount;

    }

    public int getNumFuelVessels(){
        return fuelPellets.length;
    }

    public int getNumPellets(int index) {
        return fuelPellets[index];
    }

    public double getPosition(){
        return trajectory[0];
    }

    public double getVelocity(){
        return trajectory[1];
    }

    public double getSimulationTime(){
        return trajectory[2];
    }
}

