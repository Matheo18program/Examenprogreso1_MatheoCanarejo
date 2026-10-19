public class CuentaAcceso {

    private static int totalCuentasCreadas = 0;
    private static final int MAX_INTENTOS = 3;

    private final int id;
    private String nombreUsuario;
    private int intentosIncorrectos;

    public CuentaAcceso(int id, String nombreUsuario) {

        if (id > 0 && nombreValido(nombreUsuario)) {
            this.id = id;
            this.nombreUsuario = nombreUsuario;
            this.intentosIncorrectos = 0;
            totalCuentasCreadas++;
        } else {
            this.id = 0;
            this.nombreUsuario = "Sin nombre";
            this.intentosIncorrectos = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getIntentosIncorrectos() {
        return intentosIncorrectos;
    }


    public boolean setNombreUsuario(String nombreUsuario) {
        if (nombreValido(nombreUsuario)) {
            this.nombreUsuario = nombreUsuario;
            return true;
        }
        return false;
    }

    public static int getTotalCuentasCreadas() {
        return totalCuentasCreadas;
    }

    public boolean registrarIntento(boolean correcto) {
        if (estaBloqueada()) {
            return false;
        }
        if (correcto) {
            intentosIncorrectos = 0;
            return true;
        }
        intentosIncorrectos++;
        return false;
    }

    public boolean estaBloqueada() {
        return intentosIncorrectos >= MAX_INTENTOS;
    }

    private static boolean nombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
}
