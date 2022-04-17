import java.util.Scanner;
import java.lang.Math;


public class MenuPrincipal {
    public static void main(String[] args) {
        EJECUCIONMENUPRINCIPAL();
    }

    public static void MENUPRINCIPAL(){
        System.out.println("--------------------MENU--------------------");
        System.out.println("1. Operaciones aritmeticas");
        System.out.println("2. Ecuación cuadratica");
        System.out.println("3. Figuras geometricas");
        System.out.println("4. Sistema ecuaciones lineales");
        System.out.println("5. Ecuación de la recta");
        System.out.println("6. Salir");
    }

    public static void EJECUCIONMENUPRINCIPAL(){
        MENUPRINCIPAL();
        int opcion;
        do{
        opcion= ingresar();
        switch (opcion) {
            case 1 -> ejecucion1();
            case 2 -> ejecucion2();
            case 3 -> ejecucion3();
            case 4 -> ejecucion4();
            case 5 -> ejecucion5();
            case 6 -> {
                System.out.println("Programa Finalizado, Saludos PROFE!");
            }
            default -> mostrarError();
        }
        }while(opcion!=6);

    }
    public static void ejecucion1(){
        int repetir=0;
        do{
            int operacion=0;
            operacion = selecionOpciones(7);
            switch (operacion) {
                case 1 -> System.out.println(sumar());
                case 2 -> System.out.println(restar());
                case 3 -> System.out.println(multiplicar());
                case 4 -> System.out.println(dividir());
                case 5 -> compararNumeros();
                case 6 -> System.out.println(potenciaDeUnNumero());
                case 7 -> System.out.println(porcentajeDeUnNumero());
            }
            System.out.println("¿Desea realizar otra operación? Presione 1 para SI o 2 para NO");
            repetir = ingresar();
        }while(repetir==1);
        EJECUCIONMENUPRINCIPAL();
    }
    public static void mostrarError() {
        System.err.println("Opción inválida");
        System.err.println("Ingrese un número válido");
    }

    public static int ingresar() {
        Scanner teclado = new Scanner(System.in);
        int entrada;
        do {
            try {
                entrada = teclado.nextInt();
                break;
            } catch (Exception e) {
                mostrarError();
                teclado.nextLine();
            }
        } while (true);
        return entrada;
    }

    public static int selecionOpciones(int cantOP) {
        int opcion = 0;
        do {
            try {
                menu();
                opcion = validarRangodeNumero(pedirDatoNumerico(), cantOP);
                if (opcion <= 0 || opcion >= cantOP + 1) {
                    System.out.println("No existe esa opción");
                    System.out.println("Selecione una correcta");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("No es una expresión numérica");
                System.out.println("Por favor inténtelo nuevamente");
            }
        } while (opcion <= 0 || opcion >= cantOP + 1);
        return opcion;
    }

    private static void menu() {
        System.out.println("-----MENU-----");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. El mayor y menor de 2 números");
        System.out.println("6. Potencia de un número");
        System.out.println("7. Porcentaje de un número");
    }

    public static int validarRangodeNumero(int numero1, int limite) {
        if (numero1 < 0) {
            System.out.println("No se admiten números negativos");
        } else if (numero1 > limite) {  // recordar definir un limite
            System.out.println("No se admiten números mayores a 7");
            numero1 = -1;
        }
        return numero1;
    }

    public static int pedirDatoNumerico() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("INGRESE UNA ENTRADA VALIDA");
        return  teclado.nextInt();
    }

    private static int sumar(){
        int n1;
        int n2;
        System.out.println("Ingrese los números a sumar: ");
        n1 = ingresar();
        n2 = ingresar();
        return n1+n2;
    }

    public static int restar(){
        int n1;
        int n2;
        System.out.println("Ingrese los números a restar: ");
        n1 = ingresar();
        n2 = ingresar();
        return n1-n2;
    }

    public static int multiplicar(){
        System.out.println("Ingrese los números a mutiplicar: ");
        int n1 = ingresar();
        int n2 = ingresar();
        return n1*n2;
    }

    public static double dividir(){
        System.out.println("Ingrese los números a dividir: ");
        double resultado;
        int n1 = ingresar();
        int n2 = ingresar();
        do {
            if(n2==0) {
                System.out.println("Error, no se puede dividir entre 0");
                System.out.println("Ingrese los numeros nuevamente: ");
                n1 = ingresar();
                n2 = ingresar();
            }
        }while(n2==0);
        resultado = (double) n1 / n2;
        return resultado;
    }

    public static void compararNumeros(){
        System.out.println("Ingrese los números a comparar: ");
        int n1 = ingresar();
        int n2 = ingresar();
        if(n1>n2){
            System.out.println("El mayor es "+n1);
        }else{
            System.out.println("El mayor es "+n2);
        }
        if(n1<n2){
            System.out.println("El menor es "+n1);
        }else{
            System.out.println("El menor es "+n2);
        }
    }

    public static int potenciaDeUnNumero(){
        int base;
        int exponente;
        System.out.println("Ingrese la base: ");
        base = ingresar();
        System.out.println("Ingrese el exponente: ");
        exponente = ingresar();
        int pow = (int) Math.pow(base, exponente);
        return (pow);
    }

    public static int porcentajeDeUnNumero() {
        int numero;
        int porcentaje;
        int resultado=0;
        System.out.println("Ingrese el número: ");
        numero = ingresar();
        System.out.println("Ingrese el porcentaje: ");
        porcentaje = ingresar();
        resultado = ((numero * porcentaje) / 100);
        return resultado;
    }

    public static void ejecucion2(){
        int opcion=2;
        do {
            System.out.println("la ecuacion debe estar dada : Ax^2+Bx+C=0");
            System.out.println("ingrese A");
            int a = ingresar();
            System.out.println("ingrese B");
            int b = ingresar();
            System.out.println("ingrese C");
            int c = ingresar();

            double resultados[] = ecuacion2Grado(a, b, c);

            if (resultados == null) {
                System.out.println("No tiene solucion");
            } else {
                for (int i = 0; i < resultados.length; i++) {
                    System.out.println("El resultado es: ");
                    System.out.println(resultados[i]);
                }
            }
            System.out.println("[1] Volver al Menu Principal");
            System.out.println("[2] Resolver otra ecuacion");
            opcion=ingresar();
        }while(opcion==2);
        EJECUCIONMENUPRINCIPAL();
    }

    public static double[] ecuacion2Grado(int a, int b, int c) {
        double discriminante = (Math.pow(b, 2) - (4 * a * c));
        if (discriminante >= 0) {

            double soluciones[];
            if (discriminante == 0) {

                soluciones = new double[1];
                soluciones[0] = ((-b) - (4 * a * c)) / (2 * a);

            } else {
                soluciones = new double[2];
                soluciones[0] = ((-b) + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                soluciones[1] = ((-b) - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
            }
            return soluciones;
        } else {
            return null;
        }
    }

    public static void ejecucion3() {
        int opcion;
        do {
            desplegarMenu();
            opcion = ingresar();
            ejecutar(opcion);
        } while (!finalizar(opcion));
    }

    public static int ejecutarFigura() {
        int opcion;
        do {
            menufigura();
            opcion = ingresar();
            seleccionOperacion(opcion);
        } while (opcion > 3 || opcion < 1);
        return opcion;
    }

    public static int ejecutarCuerpo() {
        int opcion;
        do {
            menuCuerpo();
            opcion = ingresar();
            seleccionOperacion(opcion);
        } while (opcion > 3 || opcion < 1);
        return opcion;
    }

    public static void desplegarMenu() {
        System.out.println("--------------Seleccione la figura o cuerpo a calcular--------------");
        System.out.println("1. Cuadrado");
        System.out.println("2. Cubo");
        System.out.println("3. Rectangulo");
        System.out.println("4. Circulo");
        System.out.println("5. Esfera");
        System.out.println("6. Cono");
        System.out.println("7. Salir");
    }

    public static void menufigura() {
        System.out.println("Ingrese la operacion a realizar");
        System.out.println("1. Area");
        System.out.println("2. Perimetro");
        System.out.println("3. Volver al menu anterior");
    }

    public static void menuCuerpo() {
        System.out.println("Ingrese la operacion a realizar");
        System.out.println("1. Area");
        System.out.println("2. Volumen");
        System.out.println("3. Volver al menu anterior");
    }

    public static boolean esValida(int opcion) {
        return opcion < 4 && opcion > 0;
    }

    public static void ejecutar(int opcion) {
        switch (opcion) {
            case 1 -> Cuadrado();
            case 2 -> cubo();
            case 3 -> Rectangulo();
            case 4 -> Circulo();
            case 5 -> Esfera();
            case 6 -> Cono();
            case 7 -> EJECUCIONMENUPRINCIPAL();
            default -> mostrarError();
        }
    }

    public static int seleccionOperacion(int opcion) {
        int operacion = -1;
        switch (opcion) {
            case 1 -> operacion = 1;
            case 2 -> operacion = 2;
            case 3 -> ejecucion3();
            default -> mostrarError();
        }
        return operacion;
    }


    public static int entradaPositiva(){
        int a;
        do{
            a=ingresar();
            if(a<1) {
                mostrarError();
            }
        }while(a<1);
        return a;
    }

    public static double entradaDecimalPositiva(){
        double a;
        do{
            a=ingresarDecimal();
            if(a<1) {
                mostrarError();
            }
        }while(a<1);
        return a;
    }

    public static double ingresarDecimal() {
        Scanner teclado = new Scanner(System.in);
        double entrada;
        do {
            try {
                entrada = teclado.nextDouble();
                break;
            } catch (Exception e) {
                mostrarError();
                teclado.nextLine();
            }
        } while (true);
        return entrada;
    }

    public static boolean finalizar(int opcion) {
        return opcion == 7;
    }

    public static void Cuadrado() {
        int seleccionado = ejecutarFigura();
        if (seleccionado == 1) {
            aCuadrado();
        } else if (seleccionado == 2) {
            pCuadrado();
        }
    }

    public static void aCuadrado() {
        System.out.println("Ingrese la medida de un lado del cuadrado");
        int a = entradaPositiva();
        int resultado;
        resultado = (int) Math.pow(a, 2);
        System.out.println("El area del cuadrado es: " + resultado);
    }

    public static void pCuadrado() {
        System.out.println("Ingrese la medida de un lado del cuadrado");
        int a = entradaPositiva();
        int resultado = (a * 4);
        System.out.println("El perimetro del cuadrado es: " + resultado);
    }

    public static void cubo() {
        int seleccionado = ejecutarCuerpo();
        if (seleccionado == 1) {
            aCubo();
        } else if (seleccionado == 2) {
            vCubo();
        }
    }

    public static void aCubo() {
        System.out.println("Ingrese la medida de un lado del cubo");
        int resultado;
        int a = entradaPositiva();
        resultado = 6 * ((int) Math.pow(a, 2));
        System.out.println("El area del Cubo es: " + resultado);
    }

    public static void vCubo() {
        System.out.println("Ingrese la medida de un lado del cubo");
        int resultado;
        int a = entradaPositiva();
        resultado = (int) Math.pow(a, 3);
        System.out.println("El volumen del cubo es: " + resultado);
    }

    public static void Rectangulo() {
        int seleccionado = ejecutarFigura();
        if (seleccionado == 1) {
            aRectangulo();
        } else if (seleccionado == 2) {
            pRectangulo();
        }
    }

    public static void aRectangulo() {
        System.out.println("Ingrese la medida del largo del rectangulo");
        int largo = entradaPositiva();
        System.out.println("Ingrese la medida del ancho del rectangulo");
        int ancho = entradaPositiva();
        int resultado;
        resultado = (largo * ancho);
        System.out.println("El area del Rectangulo es: " + resultado);
    }

    public static void pRectangulo() {
        System.out.println("Ingrese la medida del largo del rectangulo");
        int largo = entradaPositiva();
        System.out.println("Ingrese la medida del ancho del rectangulo");
        int ancho = entradaPositiva();
        int resultado;
        resultado = ((largo * 2) + (ancho * 2));
        System.out.println("El Perimetro del Rectangulo es: " + resultado);
    }

    public static void Circulo() {
        int seleccionado = ejecutarFigura();
        if (seleccionado == 1) {
            aCirculo();
        } else if (seleccionado == 2) {
            pCirculo();
        }
    }

    public static void aCirculo() {
        System.out.println("Ingrese el radio del circulo");
        double radio = entradaDecimalPositiva();
        double resultado;
        resultado = (Math.PI) * (Math.pow(radio, 2));
        System.out.println("El area del circulo es: " + resultado);
    }

    public static void pCirculo() {
        System.out.println("Ingrese el radio del circulo");
        double radio = entradaDecimalPositiva();
        double resultado;
        resultado = (2 * (Math.PI)) * radio;
        System.out.println("El perimetro del circulo es: " + resultado);
    }

    public static void Esfera() {
        int seleccionado = ejecutarCuerpo();
        if (seleccionado == 1) {
            aEsfera();
        } else if (seleccionado == 2) {
            vEsfera();
        }
    }

    public static void aEsfera() {
        System.out.println("Ingrese el radio de la esfera");
        double radio = entradaDecimalPositiva();
        double resultado;
        resultado = 4 * (Math.PI * (Math.pow(radio, 2)));
        System.out.println("El area de la esfera es: " + resultado);
    }

    public static void vEsfera() {
        System.out.println("Ingrese el radio de la circunferencia");
        double radio = entradaDecimalPositiva();
        double resultado;
        resultado = (4 / 3) * (Math.PI * (Math.pow(radio, 3)));
        System.out.println("El volumen de la esfera es: " + resultado);
    }

    public static void Cono() {
        int seleccionado = ejecutarCuerpo();
        if (seleccionado == 1) {
            aCono();
        } else if (seleccionado == 2) {
            vCono();
        }
    }

    public static void aCono() {
        System.out.println("Ingrese el radio de la base del cono");
        double radio = entradaDecimalPositiva();
        System.out.println("Ingrese el valor de la generatriz del cono");
        int generatriz = entradaPositiva();
        double resultado;
        resultado = Math.PI * radio * (radio + generatriz);
        System.out.println("El area de la esfera es: " + resultado);
    }

    public static void vCono() {
        System.out.println("Ingrese el radio de la base del cono");
        double radio = entradaDecimalPositiva();
        System.out.println("Ingrese el valor de la altura del cono");
        int altura = entradaPositiva();
        double resultado;
        resultado = ((Math.PI * Math.pow(radio, 2)) * altura) / 3;
        System.out.println("El area de la esfera es: " + resultado);
    }

    public static void ejecucion4(){
        int opcion=2;
        do {
            Scanner teclado = new Scanner(System.in);
            double A, B, C, D, E, F, X, Y;

            System.out.println("Las ecuaciones estan dadas por:");
            System.out.println("Ax + By = C");
            System.out.println("y");
            System.out.println("Dx + Ey = F");
            System.out.println("");

            System.out.println("Ingrese el valor para A: ");
            A = teclado.nextDouble();
            System.out.println("Ingrese el valor para B: ");
            B = teclado.nextDouble();
            System.out.println("Ingrese el valor para C: ");
            C = teclado.nextDouble();
            System.out.println("Ingrese el valor para D: ");
            D = teclado.nextDouble();
            System.out.println("Ingrese el valor para E: ");
            E = teclado.nextDouble();
            System.out.println("Ingrese el valor para F: ");
            F = teclado.nextDouble();

            X = (C * E - B * F) / (A * E - B * D);
            Y = (A * F - C * D) / (A * E - B * D);

            System.out.println("El valor de X es: " + X);
            System.out.println("El valor de Y es: " + Y);
            System.out.println("");
            System.out.println("[1] Volver al Menu Principal");
            System.out.println("[2] Resolver otra ecuacion");
            opcion=ingresar();
        }while(opcion==2);
        EJECUCIONMENUPRINCIPAL();
    }

    public static void ejecucion5(){
        int opcion=2;
        do {
            ejecucionEcuacionRecta();
            System.out.println("[1] Volver al Menu Principal");
            System.out.println("[2] Resolver otra ecuacion");
            opcion=ingresar();
        }while(opcion==2);
        EJECUCIONMENUPRINCIPAL();
    }
    public static void ejecucionEcuacionRecta(){
            System.out.println("Calculo de pendiente");
            System.out.println("ingrese x1");
            int x1 = ingresar();
            System.out.println("ingrese y1");
            int y1 = ingresar();
            System.out.println("ingrese x2");
            int x2 = ingresar();
            System.out.println("ingrese y1");
            int y2 = ingresar();
            int denominador=(x2 - x1);
            do{
                if(denominador==0){
                    System.out.println("No se puede divir por cero");
                    System.out.println("ingrese los valores de las coordenadas nuevamente");
                    x1=ingresar();
                    y1 = ingresar();
                    x2 = ingresar();
                    y2 = ingresar();
                    denominador=(x2 - x1);
                }
            }while(denominador==0);

            int m = (y2 - y1) /denominador;

            int b = y1 - (m * x1);

            System.out.println("La ecuación de la recta para los puntos p1(" + x1 + ", " + y1 + ") y p2(" + x2 + ", " + y2 + ") es:");
            System.out.println("y = " + m + "x + " + b);
            System.out.println("");
    }

}

