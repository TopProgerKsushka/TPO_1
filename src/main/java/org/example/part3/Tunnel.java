package org.example.part3;

import java.util.ArrayList;

public class Tunnel {
    public static final int CLEANING_SKILL_NEEDED_TO_CLEANUP = 50;
    private boolean revealed;
    private boolean overwhelmed;
    private Tunnel parentTunnel;
    private ArrayList<Tunnel> forks;

    public Tunnel() {
        revealed = false;
        overwhelmed = false;
        parentTunnel = null;
        forks = new ArrayList<>();
    }

    public Tunnel(Tunnel parentTunnel) {
        this();
        this.parentTunnel = parentTunnel;
    }

    public Tunnel addFork() {
        Tunnel fork = new Tunnel(this);
        forks.add(fork);
        return fork;
    }

    public ArrayList<Tunnel> getForks() {
        return forks;
    }

    public void reveal() {
        revealed = true;
        for (Tunnel fork : forks) {
            fork.reveal();
        }
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void overwhelm() {
        overwhelmed = true;
        for (Tunnel fork : forks) {
            fork.overwhelm();
        }
    }

    public boolean cleanUp(int cleaningSkill) {
        if (!revealed) {
            throw new RuntimeException("Cannot do anything with unrevealed tunnel");
        } else if (parentTunnel != null && parentTunnel.overwhelmed) {
            throw new RuntimeException("Cannot clean up a tunnel which parent tunnel is overwhelmed");
        } else {
            if (cleaningSkill >= CLEANING_SKILL_NEEDED_TO_CLEANUP) {
                overwhelmed = false;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isOverwhelmed() {
        return overwhelmed;
    }

    public void shineATorch() {
        if (!revealed) {
            throw new RuntimeException("Cannot do anything with unrevealed tunnel");
         } else if (overwhelmed) {
            throw new RuntimeException("Connot shine a torch to an overwhelmed tunnel");
        } else {
            System.out.println("Cannot see anything");
        }
    }
}
