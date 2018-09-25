package mihai;

import org.slf4j.MDC;
import org.apache.naming.*;

public class Slf4jRunnable implements Runnable{

    private final Transfer tx;

    public Slf4jRunnable(Transfer tx) {
        this.tx = tx;
    }

    public void run() {
        MDC.put("transaction.id", tx.getTransactionId());
        MDC.put("transaction.sender", tx.getSender());
        new Slf4TransferService().transfer(tx.getAmount());
        MDC.clear();
    }
}
