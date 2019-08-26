
package icc;
import icc.*;
import java.util.*;

/**
 *
 * @author mindahrelfen
 */
public class Prueba {

    public static void main(String[] s){
	if(Wilkomen()==false){
	System.exit(0);
	}
    }
	public static boolean Wilkomen(){//Funcion de Bienvenida, permite seleccionar entre generar el CURP o Salir del programa
	Scanner ns = new Scanner(System.in);
	for(int x=0 ; x<=60; x++){
	System.out.print("*");
	}
	System.out.println("\n\t\tSistema Nacional de CURP");

	for(int x=0 ; x <=60 ;x++){//Genera lineas de definicion para hacer atractivo el programa
	System.out.print("-");
	}
	System.out.println("\n\t\t  Gobierno de México");
	for(int x=0 ; x<=60; x++){//Genera la linea de Definicion baja
	System.out.print("*");
	}
	System.out.println("\n\t\t Menú de acceso");
	System.out.println("\n\t\t Escribe G y presiona enter para Generar tu CURP--------------Escribe S  y presiona Enter para salir***********************");
	String ac = ns.nextLine();//Recibe El caracter necesario para acceder o salir
	boolean q=false;//Se inicializa un boolean que permitirá entrar o salir del programa

	switch(ac){//EL  permite evaluar un valor en diferentes casos
	case "G"://Caso G >> Permite el acceso al programa
	q=true;
	System.out.println("\t\tBienvenido al sistema de generación de Clave De Registro de Población");
	System.out.println("\t\tPara Ingresar los datos, deberá escribir lo solicitado y presionar enter, al finalizar recibirá su CURP");
	System.out.println("\t\tPresione Enter para continuar, tras ingresar sus datos");
	toAcces();//Llama a la funcion toAcces();
	break;

	case "S"://Sale del programa 
	System.out.println("\t\t-------Saliendo del programa--------");
	q=false;//Coloca el valor false en la variable q
	break;
	default ://En caso de un valor no permitido, cierra el programa
	System.out.println("\t\tCaracter Ingresado no válido - Recuerda usar mayúsculas");
	System.out.println("\t\t Cerrando Programa por seguridad [Codigo 0000] - Reinice el programa para continuar - FALLO DE INGRESO [0002]");
	}

	return q;//Regresa el valor de Booleano
}

public static String toAcces(){//ESta funcion invoca a la Funcion Curp en Identidad.java
	Identidad id = new Identidad();//Se genera el objeto Identidad
	Scanner sc = new Scanner(System.in);//Se genera el objeto scanner que permite al usuario ingresar información
	String apellidoPaterno, apellidoMaterno, Nombre, sexo; //Se generan las variables String de Apellido Paterno, Apellido materno, nombre y sexo
	int year=0,month=0, day=0;//Inicializa las variables de año, mes día
	System.out.println("\t\t Recuerde que al ingresar los datos puede hacerlo con Mayúsculas y/o minúsculas");
	System.out.println("\t\tIngrese Nombre:");
	Nombre= sc.nextLine();//EL usuario ingresa información de tipo String
	System.out.println("\t\tIngrese Apellido Paterno:");
	apellidoPaterno = sc.nextLine();//El usuario ingresa información tipo String
	System.out.println("\t\tIngrese Apellido Materno");
	apellidoMaterno = sc.nextLine();//El usuario ingresa informacion tipo String
	System.out.println("Para seleccionar sexo, escriba <-----H----> Hombre, escriba M<------M------> Mujer");
	sexo = sc.nextLine();// EL usuario ingresa Información tipo String
	try{// Aisla el posible error que puede provocar el No ingresar un numero para una variable tipo String y ejecuta lo que se encuentra en catch
	System.out.println("Ingrese el número de año de Nacimiento");
	year  = sc.nextInt();//El usuario ingresa informacion tipo Int
	System.out.println("Ingrese el número de mes de Nacimiento");
	month = sc.nextInt();//El usuario ingresa informacion tipo Int
	System.out.println("Ingrese el número día de Nacimiento");
	day   = sc.nextInt();//El usuario ingresa informacion tipo Int
	}catch(Exception D){
	System.out.println("Error posiblemente no ingresaste un número");//Excepcion en caso de que no se ingrese un numero
	System.out.println("FALLO CRITICO - ERROR H[0002] ");
	System.out.println("Reinicie el programa, ----------NaN----------");	
	return "0";	
	}
	System.out.println("************************\tGobierno de Mexico\t***********************");
	Printer(apellidoPaterno, apellidoMaterno, Nombre,year, month,day , sexo);//Imprime los datos ingresados
	System.out.println("\t\t\t\tTu CURP es: " + id.curp(apellidoPaterno, apellidoMaterno, Nombre, year, month, day,sexo));//Imprime el CURP generado desde la Identidad.java
	System.out.println("************************\t\t\t\t************************");	
	return id.curp(apellidoPaterno, apellidoMaterno, Nombre, year, month, day,sexo);//Devuelve el CURP generado desde Identidad.java, en la funcion String to Acces()

	}

public static void Printer(String ap, String am, String N, int Anio, int mes, int jour, String sexo){//Imprime los letreros de Informacion del programa
	String anio =Integer.toString(Anio);
	 String m   = Integer.toString(mes);
	 String dia =Integer.toString(jour);
	System.out.println("Nombre:\t" + N.toUpperCase());
	System.out.println("Apellido Paterno:\t" + ap.toUpperCase());
	System.out.println("Apellido Materno:\t" + am.toUpperCase());
	System.out.println("|--------- Fecha de Nacimiento ---------|");
	System.out.println("\t\t\t"+dia + "/" + m + "/" + anio);
	System.out.println("|_______________________________________|");	
	System.out.println("Sexo:\t" + sexo.toUpperCase());

}


}
