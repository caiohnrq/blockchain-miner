package model;

import com.app.blockchain.model.Blockchain;
import lombok.extern.java.Log;

import java.util.Random;
import java.util.logging.Level;

import static com.app.blockchain.model.Node.connectToNode;

@Log
public class Miner extends Thread{

    private Thread t;
    private Blockchain blockchain;
    private final String minerId;
    private static int qtd = 0;
    private static int manyBlocks = 0;

    public Miner(String id){
        this.minerId = id;
        increaseMinersQtd();
    }

    public void start(){
        if (t == null) {
            t = new Thread(this, getMinerId());
            log.log(Level.INFO, String.format("%s trying to connect to the blockchain ...", getMinerId()));
            blockchain = connectToNode();
            t.start();
        }
    }

    public void run(){
        log.log(Level.INFO, String.format("%s started mining ...", getMinerId()));
        manyBlocks();
        try {
            for(var i = 0; i < manyBlocks; i++){
                Blockchain.mineBlock(getMinerId());
                Thread.sleep(new Random().nextInt(100));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public static int getQtd(){
        return qtd;
    }

    private static void increaseMinersQtd() {
        qtd++;
    }

    private static int manyBlocks(){
        manyBlocks = new Random().nextInt(10);
        return manyBlocks;
    }

    public String getMinerId() {
        return minerId;
    }
}
