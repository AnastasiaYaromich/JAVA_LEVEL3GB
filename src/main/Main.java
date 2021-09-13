public class Main {
    static Object monitor = new Object();
    static char letter = 'A';

    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (monitor) {
                            while (letter != 'A') {
                                monitor.wait();
                            }
                            System.out.print("A");
                            letter = 'B';
                            monitor.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (monitor) {
                            while (letter != 'B') {
                                monitor.wait();
                            }
                            System.out.print("B");
                            letter = 'C';
                            monitor.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (monitor) {
                            while (letter != 'C') {
                                monitor.wait();
                            }
                            System.out.print("C");
                            letter = 'A';
                            monitor.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
