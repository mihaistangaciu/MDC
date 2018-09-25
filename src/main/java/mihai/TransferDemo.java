package mihai;

import org.apache.naming.factory.TransactionFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransferDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Transfer tx = new Transfer("transactionId"+i, "Sender"+i, i*15);
            Runnable task = new Slf4jRunnable(tx);
            executor.submit(task);
        }
        executor.shutdown();
    }
}
