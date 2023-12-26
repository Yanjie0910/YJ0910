/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva3q1;

/**
 *
 * @author YJ
 */
public class VIVA3Q1 {

static class Phantom {
    private double accuracy;
    private double critRate;
    
    public Phantom() {
        accuracy = 1.00;
        critRate = 1.00;
    }
    
    public Phantom(double accuracy, double critRate) {   //constructor
        if (accuracy>=0&&accuracy<=1){
            this.accuracy=accuracy;
        }
        if (critRate>=0&&critRate<=1){
            this.critRate=critRate;
        }
        else{
             System.out.println("Accuracy and critRate should be between 0 and 1");
        }
    }
    // accessor and mutator methods
    public double getAccuracy() {
        return accuracy;
    }
    
    public double getCritRate() {
        return critRate;
    }
    
    public void setAccuracy(double accuracy) {
        if (accuracy>0&&accuracy<1){
            this.accuracy=accuracy;
        }
    }
    
    public void setCritRate(double critRate) {
        if (critRate>0&&critRate<1) {
            this.critRate=critRate;
        }
    }
    
    public int damage(BlackMage blackMage) {
        int hit;
        double totalAccuracy = accuracy*(1-blackMage.getEvasion());
        double totalCritRate = critRate-blackMage.getCritResistance();
        double random = Math.random();
        if (random<totalAccuracy){
            if (random<totalCritRate){
                hit = 2;
            }else{
                hit = 4;
            }
        }else{
            hit = 0;
        }
        blackMage.setCurrentHp(blackMage.getCurrentHp()-hit);
        return hit;
    }
    
    public String toString(int hit, BlackMage blackMage) {
        String output ="";
        if (blackMage.getCurrentHp()>=0){
            switch(hit){
                case 0:
                    output = "[MISS] Phantom has dealt 0 damage to the Black Mage (" + blackMage.getCurrentHp() + "/" + blackMage.getHp() + ")";
                    break;
                case 2:
                    output = "[NORM] Phantom has dealt 2 damage to the Black Mage (" + blackMage.getCurrentHp() + "/" + blackMage.getHp() + ")";
                    break;
                case 4:
                    output = "[CRIT] Phantom has dealt 4 damage to the Black Mage (" + blackMage.getCurrentHp() + "/" + blackMage.getHp() + ")";
                    break;
            }
            if (blackMage.getCurrentHp() == 0) {
                output += "\nThe Black Mage is defeated...";
            }
        }
        return output;
    }
}

static class BlackMage {
    private int hp;
    private int currentHp;
    private double evasion;
    private double critResistance;
    
    public BlackMage() {
        hp = 100;
        currentHp = hp;
        evasion = 5.0/100.0;
        critResistance = 10.0/100.0;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getCurrentHp() {
        return currentHp;
    }
    
    public double getEvasion() {
        return evasion;
    }
    
    public double getCritResistance() {
        return critResistance;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
    
    public void setEvasion(double evasion) {
        this.evasion = evasion;
    }
    
    public void setCritResistance(double critResistance) {
        this.critResistance = critResistance;
    }
}
    
    public static void main(String[] args) {
        Phantom phantom = new Phantom();
        BlackMage blackMage = new BlackMage();
        System.out.println("The epic battle begins!");
        while (blackMage.getCurrentHp()>0) {
            int hit = phantom.damage(blackMage);
            System.out.println(phantom.toString(hit,blackMage));
        } 
    }
}
        
        
