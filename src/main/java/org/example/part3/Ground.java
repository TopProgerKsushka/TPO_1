package org.example.part3;

public class Ground {
    private TunnelNetwork underlyingTunnelNetwork;
    private boolean broken;

    public Ground(TunnelNetwork underlyingTunnelNetwork) {
        this.broken = false;
        this.underlyingTunnelNetwork = underlyingTunnelNetwork;
    }

    public boolean isBroken() {
        return broken;
    }

    public void breakGround() {
        broken = true;
        underlyingTunnelNetwork.reveal();
    }

    public TunnelNetwork getUnderlyingTunnelNetwork() {
        return underlyingTunnelNetwork;
    }
}
