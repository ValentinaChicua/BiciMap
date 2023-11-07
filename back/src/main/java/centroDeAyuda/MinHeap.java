package centroDeAyuda;
/*
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MinHeap {
    private HelpRequest[]heap;
    private int size;
    private int capacity;

    public MinHeap() {
        this.capacity = 10000;
        this.size = 0;
        this.heap = new HelpRequest[10000];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private boolean isLeaf(int i) {
        return i >= size / 2 && i < size;
    }

    private void swap(int i, int j) {
        HelpRequest temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(HelpRequest value) {

        capacity++;
        size++;
        int i = size - 1;
        heap[i] = value;

        while (i != 0 && heap[i].priority < heap[parent(i)].priority) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print("prioridad "+heap[i].priority+" mensaje: "+heap[i].description + " ");
        }
        System.out.println();
    }

    public int extractMin() {
        if (size <= 0) {
            System.out.println("El heap está vacío. No se puede extraer ningún elemento.");
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            size--;
            return heap[0].priority;
        }

        int min = heap[0].priority;
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);

        return min;
    }

    private void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < size && heap[left].priority < heap[i].priority)
            smallest = left;
        if (right < size && heap[right].priority < heap[smallest].priority)
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }
    public void enviarCorreo(HelpRequest solicitud, String destinatario) {
        final String usuario = "bicimapsun@gmail.com"; // Cambia esto por tu dirección de correo electrónico
        final String contraseña = "lmtc ircv fiws enhf"; // Cambia esto por tu contraseña

        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true"); // Habilita STARTTLS
        propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Configura confianza en el servidor SMTP de Gmail
        propiedades.put("mail.smtp.port", "587"); // Configura el puerto SMTP para TLS

        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contraseña);
            }
        });

        try {
            Message mensaje = new MimeMessage(sesion);
            mensaje.setFrom(new InternetAddress(usuario));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mensaje.setSubject("Nueva solicitud de ayuda");
            mensaje.setText("Prioridad: " + solicitud.priority + "\nDescripción: " + solicitud.description);

            Transport.send(mensaje);
            System.out.println("Correo electrónico enviado con éxito.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }




}
*/