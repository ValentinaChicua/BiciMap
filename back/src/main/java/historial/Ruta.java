package historial;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ruta {
    private String inicioRuta;
    private String finRuta;
    private Date momento;

    public Ruta() {
        this.momento = new Date();
    }


    public String getInicioRuta() {
        return inicioRuta;
    }

    public void setInicioRuta(String inicioRuta) {
        this.inicioRuta = inicioRuta;
    }

    public String getFinRuta() {
        return finRuta;
    }

    public void setFinRuta(String finRuta) {
        this.finRuta = finRuta;
    }

    public String getMomento() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(momento);
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }
}





