import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//      File file = new File("123/4");
//      file.mkdirs();

//        File newFile = new File("123/text.txt");
//        try {
//            newFile.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (newFile.exists()) {
//            System.out.println("file exists");
//        }
//
//        File newFile1 = new File("123/text1.txt");
//        File newFile2 = new File("123/text2.txt");
//        File newFile3 = new File("123/text3.txt");
//        File newFile4 = new File("123/text4.txt");
//        File newFile5 = new File("123/text5.txt");
//        File newFile6 = new File("123/text6.txt");
//
//        try {
//            newFile1.createNewFile();
//            newFile2.createNewFile();
//            newFile3.createNewFile();
//            newFile4.createNewFile();
//            newFile5.createNewFile();
//        newFile6.createNewFile();
 //       } catch (IOException e) {
 //           e.printStackTrace();
 //      }
//        if (newFile1.exists()) {
//            System.out.println("file exists");
//        }

        try {
            readToByteArr();
            joinFiles();
            readByPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль.
    public static void readToByteArr() throws IOException {
        System.out.println("Task 1: ");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("123/text.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
            System.out.print((char)x);
        }
        System.out.println();
        byte[] bytes = out.toByteArray();
        System.out.println(Arrays.toString(bytes));
        System.out.println();
        out.close();
    }


    //    2. Последовательно сшить 5 файлов в один (файлы примерно 100
    //    байт). Может пригодиться следующая конструкция:
    //    ArrayList<InputStream> al = new ArrayList<>();
    //    Enumeration<InputStream> e = Collections.enumeration(al);
      public static void joinFiles() throws IOException {
          System.out.println("Task 2: ");
          ArrayList<InputStream> al = new ArrayList<>();
          al.add(new FileInputStream("123/text1.txt"));
          al.add(new FileInputStream("123/text2.txt"));
          al.add(new FileInputStream("123/text3.txt"));
          al.add(new FileInputStream("123/text4.txt"));
          al.add(new FileInputStream("123/text5.txt"));

          BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
          BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"));

          int x;
          while ((x = in.read()) != -1) {
              out.write(x);
              System.out.print((char)x);
          }
          in.close();
          out.close();
      }

    //    3. Написать консольное приложение, которое умеет постранично читать текстовые
    //    файлы (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов),
    //    программа выводит ее в консоль. Контролируем время выполнения: программа не должна
    //    загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
    public static void readByPage() throws IOException {
        System.out.println("Task 3: ");
        long a = System.currentTimeMillis();
        final int SIZE_OF_PAGE = 1800;
        RandomAccessFile raf = new RandomAccessFile("123/text6.txt", "rw");
        Scanner scan = new Scanner(System.in);
        System.out.print("Выберите страницу, с которой начнется чтение: ");
        int page = scan.nextInt() - 1;
        raf.seek(page * SIZE_OF_PAGE);
        byte[] bytes = new byte[1800];
        raf.read(bytes);
        System.out.println(new String(bytes));
        raf.close();
        System.out.println(System.currentTimeMillis() - a);
    }
}
