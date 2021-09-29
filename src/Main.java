import com.app.blockchain.model.Blockchain;
import lombok.extern.java.Log;
import model.Miner;

import java.util.logging.Level;

@Log
public class Main {

    public static void main(String[] args) {

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

        log.log(Level.INFO, Blockchain.printBlockchain());
        log.log(Level.INFO, "Is this blockchain valid? " + Blockchain.isChainValid());
    }
}
