import java.util.Random;

public class TestCronometro {

    public static void main(String[] args) {

        double[] numeros = new double[100000];

        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextDouble() * 100000;
        }

        Cronometro cronometro = new Cronometro();

        cronometro.inicia();

        for (int i = 0; i < numeros.length - 1; i++) {

            int indiceMinimo = i;

            for (int j = i + 1; j < numeros.length; j++) {

                if (numeros[j] < numeros[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            double temporal = numeros[i];
            numeros[i] = numeros[indiceMinimo];
            numeros[indiceMinimo] = temporal;
        }

        cronometro.detener();

        System.out.println("Tiempo de ordenamiento: "
                + cronometro.lapsoDeTiempo()
                + " milisegundos");
    }
}
