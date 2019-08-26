
package icc.identidad;

import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import icc.*;


/**
 *
 * @author mindahrelfen
 */
public class IdentidadTest extends Calificador{

    protected Identidad o;
    protected Random rdm;
    
    protected String[] apellidos = {"Rubio", "Bayo", "Juarez", "Pizarro", "Domingo", "Granados", "Amaya"};
    protected String[] apel = {"RU", "BA", "JU", "PI", "DO", "GR", "AM"};
    protected String[] apell = {"R", "B", "J", "P", "D", "G", "A"};
    protected String[] nombreH = {"Carlos", "Luis", "Ricardo", "Pablo", "Rafael"};
    protected String[] nH = {"C", "L", "R", "P", "R"};
    protected String[] nombreM = {"Diana", "Valentina", "Chloe", "Julia", "Paula"};
    protected String[] nM = {"D", "V", "C", "J", "P"};

    @Override
    public void init(){
        o = new Identidad();
        rdm = new Random();
    }

    @Test
    public void sumaConmutativaTest(){
        int i,a,m,d, aC;
        String ap,am,n,sexo,i_se;
        String sb;
	
        startTest("Curp", "Obtiene el inicio del curp.",1.0);
        sb = "";
        i = rdm.nextInt(apellidos.length);
        ap = apellidos[i];
        sb += apel[i];
        i = rdm.nextInt(apellidos.length);
        am = apellidos[i];
        sb += apell[i];
        if(rdm.nextBoolean()){
            i = rdm.nextInt(nombreH.length);
            n = nombreH[i];
            sb += nH[i];
            sexo = "Hombre";
            i_se = "H";
        }else{
            i = rdm.nextInt(nombreM.length);
            n = nombreM[i];
            sb += nM[i];
            sexo = "Mujer";
            i_se = "M";
        }
        a = (rdm.nextInt(120) + 1900)%100;//Modifico esta operacion para obtener un año entre 2020 >= x >= 1900 ----------------->
	 aC = 1900+a;
/*
Puesto que la CURP FUE INSTAURADA  en 1996 y el registro abarco hasta los casos más conocidos, personajes que vivieron su juventud entre 1910 -1940 
*/ 
        sb += a;
        m = rdm.nextInt(12) + 1;
        sb += m;
        d = rdm.nextInt(28) + 1;
        sb += d;
        sb += i_se;
	System.out.println("--------------------Produccion de CURP-------------------------------");	        
	System.out.println(o.curp(ap,am,n,aC,m,d,i_se)); //Agregué esta línea para verificar el CURP de mi programa antes del test
	System.out.println("--------------------Produccion de sb en Test ----------------------");	
	System.out.println(sb);
	System.out.println("Año:" + a + "\tMes:" + m + "\tDia:" + d);//Muestra los valores registrados
        assertEquals(o.curp(ap,am,n,aC,m,d,i_se), sb);
        addUp(1.0);
        passed();

    }
}
