package TASK_2;
import TASK_1.MainClass;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;


public class MFU {
    final Lock lock = new ReentrantLock();

    public void printDocument(String doc, int pages) {
        lock.lock();
            System.out.println("Начало печати " + doc + "...");
            try {
                for (int i = 0; i < pages; i++) {
                    System.out.print(i + " ");
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println();
                System.out.println("Конец печати " + doc + "! Распечатано " + pages + " страниц(ы)!");
                System.out.println("__________________________________________________________");
                lock.unlock();
            }
        }

    public void scanDocument(String doc, int pages, int source) {
        lock.lock();
        System.out.print("Начало сканирования " + doc + "...");
        switch (source) {
            case 1:
                System.out.println(" Выбран режим сканирования...");
                for (int i = 0; i < 15; i++) {
                    System.out.print(i + " ");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
                System.out.println("Конец сканирования " + doc + "! Отсканировано " + pages + " страниц(ы)!");
                System.out.println("__________________________________________________________");
                break;

                case 2:
                    System.out.println(" Выбран режим ксерокопии...");
                    for (int i = 0; i < pages; i++) {
                        lock.lock();
                        System.out.print(i + " ");
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    }
                    System.out.println();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Конец копирования " + doc + "! Отксерокопировано " + pages + " страниц(ы)!");
                    System.out.println("__________________________________________________________");
                    break;
            }
            lock.unlock();
        }


    public static void main(String[] args) throws InterruptedException {
        MFU mfu = new MFU();

        new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.printDocument("Document_1", 15);
                }
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.printDocument("Document_2", 22);
                }
            }).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.scanDocument("Document_1", 15, 1);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.scanDocument("Document_1", 15, 2);
                }
            }).start();
        }
    }

