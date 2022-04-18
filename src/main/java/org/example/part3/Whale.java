package org.example.part3;

public class Whale {
    public void dropTo(Ground g) {
        g.breakGround();
        g.getUnderlyingTunnelNetwork().overwhelm();
    }
}
