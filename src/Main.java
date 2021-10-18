import com.app.blockchain.model.Blockchain;
import lombok.extern.java.Log;
import model.Miner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@Log
public class Main {

    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
            creatingMiners();

            if(endSession()) {
                log.log(Level.INFO, Blockchain.printBlockchain());
                log.log(Level.INFO, "Is this blockchain valid? " + Blockchain.isChainValid());
            }
    }

    public static boolean endSession(){
        THREAD_POOL.shutdown();
        try {
            return THREAD_POOL.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            log.log(Level.INFO, "Threads ended with error");
            return false;
        }
    }

    private static void creatingMiners() {
        log.log(Level.INFO, String.format("Miners mining in this blockchain: %s", Miner.getQtd()));
        var miner = new Miner(String.format("Miner Nº: %s", Miner.getQtd()+1));
        miner.start();

        log.log(Level.INFO, String.format("Miners mining in this blockchain: %s", Miner.getQtd()));
        var miner2 = new Miner(String.format("Miner Nº: %s", Miner.getQtd()+1));
        miner2.start();

        log.log(Level.INFO, String.format("Miners mining in this blockchain: %s", Miner.getQtd()));
        var miner3 = new Miner(String.format("Miner Nº: %s", Miner.getQtd()+1));
        miner3.start();

        log.log(Level.INFO, String.format("Miners mining in this blockchain: %s", Miner.getQtd()));
        var miner4 = new Miner(String.format("Miner Nº: %s", Miner.getQtd()+1));
        miner4.start();

        log.log(Level.INFO, String.format("Miners mining in this blockchain: %s", Miner.getQtd()));
        var miner5 = new Miner(String.format("Miner Nº: %s", Miner.getQtd()+1));
        miner5.start();

        THREAD_POOL.execute(miner);
        THREAD_POOL.execute(miner2);
        THREAD_POOL.execute(miner3);
        THREAD_POOL.execute(miner4);
        THREAD_POOL.execute(miner5);
    }
}