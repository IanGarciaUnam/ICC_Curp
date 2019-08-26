package icc;
import icc.*;


/*
*@author Ian Israel Garcia Vazquez
*
*/

public class Identidad {




public String curp(String apellidoPaterno, String apellidoMaterno, String Nombre, int year, int month, int day, String sexo ){//la funcion curp genera el CUrp con las variables aquí solicitadas


String apellido_Paterno = apellidoPaterno.toUpperCase();//Convierte el Stringrecibido en Mayúsculas
String apellido_Materno = apellidoMaterno.toUpperCase();//COnvierte el String recibido en Mayúsculas
String Nombre_n = Nombre.toUpperCase();//Convierte el String Recibido en mayúsculas

String dia, mes, anio,se, sexo_1;//Se inicializa las variables String dia, mes, anio
se = sexo.toUpperCase();//Convierte el String Recibido en Mayúsculas
StringBuilder s = new StringBuilder(apellido_Paterno);//Este objeto permite concatenar cadenas en una previamente construida

s.insert(2, apellido_Materno);//concatena la cadena apellido_Materno 
s.insert(3, Nombre_n); //concatena la cadena Nombre_n en el espacio 3

StringBuilder tempo = new StringBuilder();//Permite agregar cadenas de texto a una previamente construida (concatenar)
tempo.ensureCapacity(10);//El máxio de capacidad sera de 10 caracteres
if(year < 1900  || year > 2019){//El año es inexistente
System.out.println("Error------------------123");
System.out.println("Año no encontrado, reingrese datos");
System.out.println("ERROR EN :" + Integer.toString(year));//La persona ingreso su anio de forma incorrecta 
}else{
anio = Integer.toString(year);//convierte el int year a String 
tempo.insert(0,anio);//Se concatena en el espacio 0 de la cadena anio

}

if(month >13 || month < 1){//El mes es inexistente y envíamos letreros de error

System.out.println("Error------------------100");
System.out.println("Mes inexistente, reingresa tus datos por favor");
System.out.println("ERROR EN :" + Integer.toString(month));

}else{
mes = Integer.toString(month);//Convierte a String el Int Month


if(month < 10){ //Si el mes es menor a 10 se agrega un 0 al proceso de concatenacion y despues el numero
tempo.insert(4,"0");
tempo.insert(5,mes);
}else{
tempo.insert(4,mes);
	}
}


if(day > 31  || day < 1){//Si el dia es inexistente se envían letreros de error

System.out.println("Error------------------101");
System.out.println("Día no existente, reingresa tus datos por favor");
System.out.println("ERROR EN :" + Integer.toString(month));//Se convierte a String el Int month
}else{
dia = Integer.toString(day);//Convierte el int day a String y queda contenido en la variable dia
if(day<10){//Si el dia es menor a 10 agrega un cero al proceso de concatenacion y despues el numero del dia
tempo.insert(6,"0");
tempo.insert(7,dia);
}else{
tempo.insert(6,dia);//inserta el numero de dia a dos digitos
}

tempo.delete(0,2);//elimina los primeros dos caracteros de la segunda cadena que solo contiene los numeros de la fecha de nacimiento
s.insert(4, tempo.toString());//Inserta la segunda concatenacion en la primera, antes conviertiendola a un String
s.insert(10,se);//Se concatena el sexo al CURP
int n = s.length();//Inicializa una variable local que contiene la extensión del StringBuilder S

s.delete(11, n);//Borra todos los caracteres sobrantes, desde el 11 hasta el final de la extensión
}




return s.toString();//retorna el StringBuilder, convertido en String
}
}


