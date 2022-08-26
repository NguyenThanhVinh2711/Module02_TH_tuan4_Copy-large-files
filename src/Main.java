import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    //Cách ghi file 1
    private static void copyFileUsingJava7File(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    //Cách ghi file 2
    private static void copyFileUsingSteam(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter source file : ");
        String sourcePath = input.nextLine();
        System.out.println("Enter dest file : ");
        String destPath = input.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
//            copyFileUsingJava7File(sourceFile, destFile);
//            System.out.println("Copy completed.");
            copyFileUsingSteam(sourceFile,destFile);
            System.out.println("Copy completed");
        } catch (IOException e) {
            System.out.println("Can't copy that file!");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
