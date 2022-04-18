package org.example.part3;

public class TunnelNetwork {
    private Tunnel rootTunnel;

    public TunnelNetwork() {
        this.rootTunnel = new Tunnel();
    }

    public void reveal() {
        rootTunnel.reveal();
    }

    public boolean isRevealed() {
        return rootTunnel.isRevealed();
    }

    public void overwhelm() {
        rootTunnel.overwhelm();
    }

    public Tunnel getRootTunnel() {
        return rootTunnel;
    }
}
