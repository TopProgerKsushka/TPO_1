package org.example.part3;

public class Person {
    private String name;
    private int cleaningSkill;

    public Person(String name, int cleaningSkill) {
        this.name = name;
        this.cleaningSkill = cleaningSkill;
    }

    public boolean cleanUpTunnel(Tunnel tunnel) {
        return tunnel.cleanUp(this.cleaningSkill);
    }

    public void shineATorch(Tunnel tunnel) {
        tunnel.shineATorch();
    }
}
