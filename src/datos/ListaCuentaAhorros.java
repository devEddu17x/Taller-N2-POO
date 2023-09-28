package datos;
import entidades.CuentaAhorro;
import java.util.ArrayList;
public class ListaCuentaAhorros {
    private static ArrayList <CuentaAhorro> listaCuentaAhorros = new ArrayList<>();

    public static void agregarCuentaAhorro(CuentaAhorro cuentita){
        listaCuentaAhorros.add(cuentita);
        cuentita.toString();
    }

    public static void deposito(int indice, double deposito){
        listaCuentaAhorros.get(indice).depositar(deposito);
        System.out.println("Deposito exitoso.\n");
    }

    public static void mostrarCuentas(){
        System.out.println("\nA continuacion se muestran todas las cuentas...\n");
        System.out.println("INDICE\tSALDO SN INTERESES\tSALDO CON INTERESES\n");
        for (CuentaAhorro cuenta : listaCuentaAhorros){
            System.out.println(cuenta.toString());
        }
    }

    public static void mostrarInteresesMensuales(){
        int i = 1;
        for (CuentaAhorro cuentita : listaCuentaAhorros){
            System.out.println("Cuenta N° "+i+". Interes mensual: "+cuentita.calcularInteresMes());
            i++;
        }
    }

    public static void actualizarSaldoMasIntereses(){
        for (CuentaAhorro cuentita : listaCuentaAhorros){
            cuentita.depositar(0);
        }
    }

    public static int getTamaño(){
        return listaCuentaAhorros.size();
    }
    
}
