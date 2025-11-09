import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {
    String encrypt(String filename) throws IOException{
        FileInputStream f = new FileInputStream(filename);
        String[] a = filename.split("\\.");
        FileOutputStream f2 = new FileOutputStream("Encrypted."+a[a.length-1]);
        int i = f.read();
        while (i != -1) {
            f2.write(i+1);
            i = f.read();
        }
        System.out.println("Encryption done successfully");
        System.out.println("Encrypted file name : Encrypted."+a[a.length-1]);

        f.close();
        f2.close();

        return "Encrypted."+a[a.length-1];
    }

    void decrypt(String filename) throws IOException {
        FileInputStream f = new FileInputStream(filename);
        String[] a = filename.split("\\.");
        FileOutputStream f2 = new FileOutputStream("Decrypted."+a[a.length-1]);
        int i = f.read();
        while (i != -1) {
            f2.write(i-1);
            i = f.read();
        }
        System.out.println("Decryption done successfully");
        f.close();
        f2.close();
    }

    public static void main(String[] args)  {
        System.out.print("Enter the file name : ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        FileEncryptionDecryption fh = new FileEncryptionDecryption();

        try{
            String a = fh.encrypt(filename);
            fh.decrypt(a);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
