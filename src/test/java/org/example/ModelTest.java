package org.example;

import org.example.part3.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ModelTest extends Assert {
    static Person zafod;
    static Person marwin;
    static TunnelNetwork network;
    static Tunnel f1;
    static Tunnel f2;
    static Ground ground;
    static Whale whale;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Before
    public void createSpace() {
        System.setOut(new PrintStream(outContent));
        zafod = new Person("Zafod", 10);
        marwin = new Person("Marwin", 55);

        network = new TunnelNetwork();
        f1 = network.getRootTunnel().addFork();
        f1.addFork();
        f1.addFork();
        f2 = network.getRootTunnel().addFork();
        f2.addFork();
        f2.addFork().addFork();
        f2.addFork();
        ground = new Ground(network);

        whale = new Whale();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void cleanUpException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Cannot do anything with unrevealed tunnel");
        //throw new RuntimeException("What happened?");
        f1.cleanUp(1);
    }

    @Test
    public void shineException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Cannot do anything with unrevealed tunnel");
        f1.shineATorch();
        //throw new RuntimeException("What happened?");
    }

    @Test
    public void whaleDrop() {
        whale.dropTo(ground);
        assertEquals(ground.isBroken(), true);

        for (Tunnel cur : ground.getUnderlyingTunnelNetwork().getRootTunnel().getForks()) {
            assertEquals(cur.isRevealed(), true);
        }

        for (Tunnel cur : ground.getUnderlyingTunnelNetwork().getRootTunnel().getForks()) {
            assertEquals(cur.isOverwhelmed(), true);
        }
    }
    @Test
    public void checkCleanUp() {
        whale.dropTo(ground);
        assertEquals(false, zafod.cleanUpTunnel(network.getRootTunnel()));
        assertEquals(true, marwin.cleanUpTunnel(network.getRootTunnel()));
    }

    @Test
    public void checkShine() {
        whale.dropTo(ground);
        marwin.cleanUpTunnel(network.getRootTunnel());

        zafod.shineATorch(network.getRootTunnel());
        assertEquals("Cannot see anything", outContent.toString().strip());
    }
}
