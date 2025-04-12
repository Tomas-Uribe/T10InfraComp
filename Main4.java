import javax.crypto.SecretKey;
import java.io.*;

public class Main4 {

    public static void main(String[] args) throws Exception {
        // Leer la llave
        FileInputStream archivo = new FileInputStream("llave.aes");
        ObjectInputStream ois = new ObjectInputStream(archivo);
        SecretKey llave = (SecretKey) ois.readObject();
        ois.close();

        // Leer el texto cifrado
        archivo = new FileInputStream("mensaje_cifrado.aes");
        ois = new ObjectInputStream(archivo);
        byte[] textoCifrado = (byte[]) ois.readObject();
        ois.close();

        // Descifrar
        byte[] textoDescifrado = Simetrico.descifrar(llave, textoCifrado);
        String mensajeFinal = new String(textoDescifrado);

        System.out.println("Mensaje descifrado: " + mensajeFinal);
    }
}
