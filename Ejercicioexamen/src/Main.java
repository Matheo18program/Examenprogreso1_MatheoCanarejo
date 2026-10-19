//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CuentaAcceso c = new CuentaAcceso(1, ";Usuario A");
        System.out.println("Intentos: " + c.getIntentosIncorrectos()
                + " | Bloqueada: " + c.estaBloqueada());

        System.out.println("Intento incorrecto: " + c.registrarIntento(false)
                + " | Intentos: " + c.getIntentosIncorrectos());

        System.out.println("Intento correcto: " + c.registrarIntento(true)
                + " | Intentos: " + c.getIntentosIncorrectos());

        c.registrarIntento(false);
        c.registrarIntento(false);
        c.registrarIntento(false);
        System.out.println("Tras 3 incorrectos, bloqueada: " + c.estaBloqueada());

        System.out.println("Correcto tras bloqueo: " + c.registrarIntento(true)
                + " | Intentos: " + c.getIntentosIncorrectos());

        CuentaAcceso invalida = new CuentaAcceso(0, "X");
        System.out.println("Cuenta inválida, id: " + invalida.getId());

        boolean cambio = c.setNombreUsuario("   ");
        System.out.println("Cambio de nombre aceptado: " + cambio);
        System.out.println("Nombre conservado: " + c.getNombreUsuario());

        System.out.println("Cuentas creadas: " + CuentaAcceso.getTotalCuentasCreadas());
    }
}