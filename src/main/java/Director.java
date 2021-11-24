import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Director {
    private String nombre;
    private String nacionalidad;
    private String genero;

    private static final String XML_DIRECTOR = "src/main/java/Directores.xml";
    private static final String CSV_DIRECTOR = "src/main/java/Directores.csv";
    private static final String TXT_DIRECTOR = "src/main/java/Directores.txt";

    public Director() {

    }

    public Director(String nombre, String nacionalidad, String genero) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Director{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public String imprimeSinCampos() {
        return nombre + " " + nacionalidad + " " + genero;
    }

    //Método para guarda en .txt
    public  void escribeDirector(Director director) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(TXT_DIRECTOR);
            pw = new PrintWriter(fichero);
            pw.println(director.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println("Director guardado en TXT");
    }

    //Method write Arralist of Directors
    public void writeDirector(ArrayList<Director> lista) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(TXT_DIRECTOR);
            pw = new PrintWriter(fichero);
            for (Director director : lista) {
                pw.println(director.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println("Lista de directores guardada en TXT");
    }

    //Método lee de .txt
    public  void leeDirector() {
        FileReader fichero = null;
        BufferedReader br = null;
        try {
            fichero = new FileReader(TXT_DIRECTOR);
            br = new BufferedReader(fichero);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //Lee de .txt y devuelve arrayList de directores
    public  ArrayList<Director> leeDirectorArrayList() {
        FileReader fichero = null;
        BufferedReader br = null;
        ArrayList<Director> lista = new ArrayList<Director>();
        try {
            fichero = new FileReader("src/main/java/Director.txt");
            br = new BufferedReader(fichero);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Director director = new Director(datos[0], datos[1], datos[2]);
                lista.add(director);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lista;
    }

    //Guarda en .xml ArrayList de directores
    public void writeDirectorXML(ArrayList<Director> lista) {

        Cinemateca cinemateca = new Cinemateca();
        cinemateca.setDirectores(lista);

        try {
            JAXBContext context = JAXBContext.newInstance(Cinemateca.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(cinemateca, new File(XML_DIRECTOR));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("Lista de directores guardada en XML");
    }

    //Guarda en .csv ArrayList de directores
    public void writeDirectorCSV(ArrayList<Director> lista) {
        try {
            FileWriter fichero = new FileWriter(CSV_DIRECTOR);
            PrintWriter pw = new PrintWriter(fichero);
            for (Director director : lista) {
                pw.append(director.toString());
                pw.append("\n");
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Lista de directores guardada en CSV");
    }

    //Lee de .xml y devuelve arrayList de directores
    public  ArrayList<Director> leeDirectorXML() {
        List<Director> lista = null;
        //Cinemateca cinemateca = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Cinemateca.class);
            Unmarshaller u = context.createUnmarshaller();
            Cinemateca cinemateca = (Cinemateca) u.unmarshal(new FileReader(XML_DIRECTOR));
            lista = cinemateca.getDirectores();
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista.toArray().length == 0 ? null : new ArrayList<Director>(lista);
    }

    //Lee de .csv y devuelve arrayList de directores
    public  ArrayList<Director> leeDirectorCSV() {
        ArrayList<Director> lista = new ArrayList<Director>();
        FileReader fichero = null;
        BufferedReader br = null;
        try {
            fichero = new FileReader(CSV_DIRECTOR);
            br = new BufferedReader(fichero);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Director director = new Director(datos[0], datos[1], datos[2]);
                lista.add(director);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lista;
    }

    //Metodo para guardar director en .txt añadiendo al final del fichero
    public void writeDirector(Director director) {
        try {
            FileWriter fichero = new FileWriter(TXT_DIRECTOR, true);
            PrintWriter pw = new PrintWriter(fichero);
            pw.append(director.toString());
            pw.append("\n");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Director guardado en TXT");
    }

    //Lee en .txt y guarda en .xml
    public void leeDirectorTXT() {
        ArrayList<Director> lista = new ArrayList<Director>();
        FileReader fichero = null;
        BufferedReader br = null;
        try {
            fichero = new FileReader(TXT_DIRECTOR);
            br = new BufferedReader(fichero);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Director director = new Director(datos[0], datos[1], datos[2]);
                lista.add(director);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        writeDirectorXML(lista);
        System.out.println("Lista de directores guardada en XML");
    }

    //lee .txt y devuelve arrayList de directores
    public ArrayList<Director> DirectorTxtToArrayList() {
        ArrayList<Director> lista = new ArrayList<Director>();
        FileReader fichero = null;
        BufferedReader br = null;
        try {
            fichero = new FileReader(TXT_DIRECTOR);
            br = new BufferedReader(fichero);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Director director = new Director(datos[0], datos[1], datos[2]);
                lista.add(director);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lista;
    }

}

