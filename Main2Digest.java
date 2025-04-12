import java.util.Scanner;

public class Main2Digest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo a verificar: ");
        String nombreArchivo = sc.nextLine();

        // Digest MD5 del archivo
        byte[] md5 = Digest.getDigestFile("MD5", nombreArchivo);
        System.out.print("Digest MD5 del archivo: ");
        Digest.imprimirHexa(md5);

        // Digest SHA-1 del archivo
        byte[] sha1 = Digest.getDigestFile("SHA-1", nombreArchivo);
        System.out.print("Digest SHA-1 del archivo: ");
        Digest.imprimirHexa(sha1);
    }
}
