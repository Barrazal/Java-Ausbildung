package com.github.barrazal.panzerhq;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;

public class Tank extends GameObject {

    public static final double TURNING_VELOCITY = 0.03;
    public static final double DRIVING_VELOCITY = 2.00;
    public static final int AMMO_LOADING_TIME = 50;

    private Shape transformedTankBody = new RoundRectangle2D.Double();

    private double turningVelocity = TURNING_VELOCITY;
    private double drivingVelocity = DRIVING_VELOCITY;

    private double deltaMovingAngle = 0;
    private double angleCannon = 0;
    private double deltaAngleCannon = 0;
    private boolean ableToShoot = true;
    private int loadingTime = AMMO_LOADING_TIME;
    private int ammoLoadingTimer = AMMO_LOADING_TIME;
    private Color turretColor = new Color(160, 184, 98);
    private Color cannonColor = new Color(72, 94, 10);

    private int energy = 10;
    private int energyStart = 10;
    private boolean paintTankStatusBar = true;

    public Tank(Coordinate position, double width, double height, double movingAngle, double movingDistance) {
        super(position, width, height);

        setMovingAngle(movingAngle);
        setMovingDistance(movingDistance);
    }

    public Shape getTransformedTankBody() {
        return transformedTankBody;
    }

    public void setTransformedTankBody(Shape transformedTankBody) {
        this.transformedTankBody = transformedTankBody;
    }

    public double getTurningVelocity() {
        return turningVelocity;
    }

    public void setTurningVelocity(double turningVelocity) {
        this.turningVelocity = turningVelocity;
    }

    public double getDrivingVelocity() {
        return drivingVelocity;
    }

    public void setDrivingVelocity(double drivingVelocity) {
        this.drivingVelocity = drivingVelocity;
    }

    public double getAngleCannon() {
        return angleCannon;
    }

    public void setAngleCannon(double angle) {
        this.angleCannon = angle;
    }

    public boolean isAbleToShoot() {
        return ableToShoot;
    }

    public void setAbleToShoot(boolean ableToShoot) {
        this.ableToShoot = ableToShoot;
        ammoLoadingTimer = loadingTime;
    }

    public int getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(int loadingTime) {
        this.loadingTime = loadingTime;
    }

    public Color getTurretColor() {
        return turretColor;
    }

    public void setTurretColor(Color turretColor) {
        this.turretColor = turretColor;
    }

    public Color getCannonColor() {
        return cannonColor;
    }

    public void setCannonColor(Color cannonColor) {
        this.cannonColor = cannonColor;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergyStart() {
        return energyStart;
    }

    public void setEnergyStart(int energyStart) {
        this.energyStart = energyStart;
    }

    public boolean isPaintTankStatusBar() {
        return paintTankStatusBar;
    }

    public void setPaintTankStatusBar(boolean paintTankStatusBar) {
        this.paintTankStatusBar = paintTankStatusBar;
    }


    public void turnTankRight() {
        deltaMovingAngle = turningVelocity;
    }

    public void turnTankLeft() {
        deltaMovingAngle = -turningVelocity;
    }

    public void stopTurningTank() {
        deltaMovingAngle = 0;
    }


    public void turnCannonRight() {
        deltaAngleCannon = turningVelocity * 1.3;
    }

    public void turnCannonLeft() {
        deltaAngleCannon = -turningVelocity * 1.3;
    }

    public void stopTurningCannon() {
        deltaAngleCannon = 0;
    }

    public void accelerateTank() {
        setMovingDistance(drivingVelocity);
    }

    public void decelerateTank() {
        setMovingDistance(-drivingVelocity / 2);
    }

    public void stopTank() {
        setMovingDistance(0);
    }

    @Override
    public boolean touches(GameObject other) {
        Coordinate otherPosition = other.getObjectPosition();
        double otherCenterX = otherPosition.getX() + other.getWidth() / 2;
        double otherCenterY = otherPosition.getY() + other.getHeight() / 2;

        return getTransformedTankBody().contains(otherCenterX, otherCenterY);
    }

    @Override
    public void makeMove() {
        double newMovingAngle = getMovingAngle() + deltaMovingAngle;
        if (newMovingAngle < 0) {
            newMovingAngle = newMovingAngle + 2 * Math.PI;
        }
        if (newMovingAngle > 2 * Math.PI) {
            newMovingAngle = newMovingAngle - 2 * Math.PI;
        }
        setMovingAngle(newMovingAngle);
        moveCannon();
        if (ammoLoadingTimer > 0) {
            ammoLoadingTimer = ammoLoadingTimer - 1;
        } else {
            setAbleToShoot(true);
        }
        super.makeMove();
    }

    public void moveCannon() {
        angleCannon = angleCannon + deltaAngleCannon;
        if (angleCannon < 0) {
            angleCannon = angleCannon + 2 * Math.PI;
        }
        if (angleCannon > 2 * Math.PI) {
            angleCannon = angleCannon - 2 * Math.PI;
        }
    }

    public Missile shoot() {
        double tankCenterX = getObjectPosition().getX() + getWidth() * 0.5;
        double tankCenterY = getObjectPosition().getY() + getHeight() * 0.5;
        double cannonLength = getWidth() * 0.8;

        double missileSize = getWidth() * 0.12;
        double missileAngle = getAngleCannon() + getMovingAngle();

        Coordinate missleDirection = GameObject.polarToCartesianCoordinates(missileAngle);
        double cannonEndX = missleDirection.getX() * cannonLength;
        double cannonEndY = missleDirection.getY() * cannonLength;

        Coordinate missileStartPosition = new Coordinate(tankCenterX + cannonEndX - missileSize / 2, tankCenterY + cannonEndY - missileSize / 6);

        Missile missile = new Missile(missileStartPosition, missileSize, missileAngle, 5);
        setAbleToShoot(false);
        return missile;
    }

    @Override
    protected void paintMe(java.awt.Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (isPaintTankStatusBar()) {
            paintTankStatusBar(g2d);
        }
        paintTank(g2d);
    }

    private void paintTank(Graphics2D g2d) {
        RoundRectangle2D tankBody = new RoundRectangle2D.Double(getObjectPosition().getX() + getWidth() * 0.05,
                getObjectPosition().getY(),
                getWidth() * 0.9, getHeight(), 15, 8);

        RoundRectangle2D tankTrackLeft = new RoundRectangle2D.Double(getObjectPosition().getX(),
                getObjectPosition().getY(),
                getWidth(), getHeight() * 0.3, 15, 8);

        RoundRectangle2D tankTrackRight = new RoundRectangle2D.Double(getObjectPosition().getX(),
                getObjectPosition().getY() + getHeight() * 0.7,
                getWidth(), getHeight() * 0.3, 15, 8);

        RoundRectangle2D tankCannon = new RoundRectangle2D.Double(getObjectPosition().getX() + getWidth() * 0.5,
                getObjectPosition().getY() + getHeight() * 0.41,
                getWidth() * 0.8, getHeight() * 0.18, 5, 5);

        RoundRectangle2D tankTurret = new RoundRectangle2D.Double(getObjectPosition().getX() + getWidth() * 0.14,
                getObjectPosition().getY() + getHeight() * 0.1,
                getWidth() * 0.65, getHeight() * 0.8, 15, 8);

        AffineTransform transform = new AffineTransform();
        transform.rotate(getMovingAngle(), tankBody.getCenterX(), tankBody.getCenterY());

        g2d.setColor(Color.GRAY);
        Shape transformed = transform.createTransformedShape(tankBody);
        g2d.fill(transformed);

        setTransformedTankBody(transformed);

        g2d.setColor(Color.BLACK);
        transformed = transform.createTransformedShape(tankTrackLeft);
        g2d.fill(transformed);
        transformed = transform.createTransformedShape(tankTrackRight);
        g2d.fill(transformed);

        transform.rotate(getAngleCannon(), tankBody.getCenterX(), tankBody.getCenterY());

/* ToDo:  https://www.programmierenlernenhq.de/panzer-und-steuerung-des-java-spiels-programmieren/
         stop Line 265!

*/

    }
}
