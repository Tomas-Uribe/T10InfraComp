import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;

public class Main4Asimetrico {

    private static final String ALGORITMO = "RSA";

    public static void main(String[] args) {
        try {
            // Recuperar la llave privada desde archivo
            FileInputStream archivo = new FileInputStream("llavePrivada.key");
            ObjectInputStream ois = new ObjectInputStream(archivo);
            PrivateKey llavePrivada = (PrivateKey) ois.readObject();
            ois.close();

            // Recuperar el texto cifrado desde archivo
            archivo = new FileInputStream("mensajeCifrado.dat");
            ois = new ObjectInputStream(archivo);
            byte[] textoCifrado = (byte[]) ois.readObject();
            ois.close();

            // Descifrar con la llave privada
            byte[] textoDescifrado = Asimetrico.descifrar(llavePrivada, ALGORITMO, textoCifrado);

            // Mostrar resultado
            System.out.println("Mensaje descifrado: " + new String(textoDescifrado));

        } catch (Exception e) {
            System.out.println("Ocurrió un error al descifrar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
