/* for(int x = 0; x < ventas.length; x++){
    for(int y = 0; y < ventas[x].length; y++){
        }
    }
                Para recorrer la matriz */

public class Main {
    public static void main(String[] args) {
        String[][] vinilos = new String[100][3];

        agregarVinilo(vinilos, "Iron Maiden", "Iron Maiden", "1980");
        agregarVinilo(vinilos, "Iron Maiden", "Killers", "1981");
        agregarVinilo(vinilos, "AC-DC", "Back in black", "1980");

        System.out.println("Espacio máximo colección: " + vinilos.length);

        mostrarTotal(vinilos);
        mostrarDisponibles(vinilos);

        String artista = "AC-DC";
        System.out.println("Buscar artista: " + artista);
        mostrarBusquedaArtista(vinilos, artista);

        mostrarColeccion(vinilos);
    }

    public static int totalVinilos(String[][] m) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] != null) {
                count++;
            }
        }
        return count;
    }

    public static void agregarVinilo(String[][] m, String gru, String lp, String ano) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == null) {
                m[i][0] = gru;
                m[i][1] = lp;
                m[i][2] = ano;
                break;
            }
        }
    }

    public static void mostrarColeccion(String[][] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] != null) {
                System.out.println("Fila " + (i+1) + ": " + m[i][0] + " - " + m[i][1] + " - " + m[i][2]);
            }
        }
    }

    public static void mostrarTotal(String[][] m) {
        System.out.println("Hay un total de: " + totalVinilos(m) + " vinilos en la colección");
    }

    public static void mostrarDisponibles(String[][] m) {
        System.out.println("Hay un total de: " + disponibles(m) + " espacios disponibles en la colección");
    }

    public static int disponibles(String[][] m) {
        return m.length - totalVinilos(m);
    }

    public static void mostrarBusquedaArtista(String[][] m, String artista) {
        boolean encontrado = buscarArtista(m, artista);
        if (encontrado) {
            System.out.println("El artista " + artista + " sí está en la colección");
        } else {
            System.out.println("El artista " + artista + " no está en la colección");
        }
    }

    public static boolean buscarArtista(String[][] m, String artista) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] != null && m[i][0].equals(artista)) {
                return true;
            }
        }
        return false;
    }
}
