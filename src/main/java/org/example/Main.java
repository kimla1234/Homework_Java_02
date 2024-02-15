package org.example;

class Define {
    void print(String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println();
    }

    public synchronized void printWelcome(String chars) {
        this.print(chars);
    }

    public synchronized void printStar(String chars) {
        this.print(chars);
    }


    class Reader1 extends Thread {
        private final String string;

        public Reader1(String string) {
            this.string = string;
        }
    }
}
    public class Main {
        public static void main(String[] arg) throws InterruptedException {
            Define reader = new Define();
            Thread thread = new Thread(() ->
                    reader.print("WELCOME TO CSTAD!"));
            Thread thread1 = new Thread(() ->
                    reader.print("***************************************"));
            Thread thread2 = new Thread(() ->
                    reader.print("Don't give up this opportunity, Do you best first!"));
            Thread thread3 = new Thread(() ->
                    reader.print("-------------------------------------"));
            Thread thread4 = new Thread(() -> {
                reader.print("Downloading............. Finished");
                System.out.print("Download Completed 100%");
            });

            try {
                thread.start();
                thread.join();
                thread1.start();
                thread1.join();
                thread2.start();
                thread2.join();
                thread3.start();
                thread3.join();
                thread4.start();
                thread4.join();


            } catch (Exception exception) {

            }
        }
    }


