import java.util.Scanner;

class Chat {
    private static final Object lock = new Object();
    private static String message;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sender thread
        Thread senderThread = new Thread(() -> {
            while (true) {
                System.out.print("You: ");
                String userInput = scanner.nextLine();
                synchronized (lock) {
                    message = userInput;
                    lock.notify(); // Notify the receiver thread
                }

                if ("bye".equalsIgnoreCase(userInput) || "exit".equalsIgnoreCase(userInput)) {
                    break;
                }
            }
        });

        // Receiver thread
        Thread receiverThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        lock.wait(); // Wait for notification from the sender thread
                        if ("bye".equalsIgnoreCase(message) || "exit".equalsIgnoreCase(message)) {
                            break;
                        }
                        System.out.println("Other user: " + message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        System.out.println("Chat started. Type 'bye' or 'exit' to end the chat.");

        senderThread.start();
        receiverThread.start();

        try {
            // Wait for threads to finish
            senderThread.join();
            receiverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Chat ended.");
    }
}
h
public class chatApplication {
    public static void main(String[] args) {
        Chat.main(args);
    }
}
