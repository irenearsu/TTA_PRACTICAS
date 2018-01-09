package eus.ehu.adibidea.tta.adb.Business;

import eus.ehu.adibidea.tta.adb.Modelo.Test;

/**
 * Created by tta on 1/3/18.
 */

public class TestExample implements TestInterface{

    public TestExample(){

    }

    @Override
    public Test getTest() {

        Test testa = new Test();

        testa.galdera="¿Cuál de las siguientes opciones NO se indica en el fichero de manifiesto de la app?";
        testa.aukerak.add("Versión de la aplicación");
        testa.aukerak.add("Listado de componentes de la aplicación");
        testa.aukerak.add("Opciones del menú de ajustes");
        testa.aukerak.add("Nivel mínimo de la API Android requerida");
        testa.aukerak.add("Nombre del paquete java de la aplicación");
        testa.zuzena=3;

        testa.adviceType="audio";
        testa.advice="http://u017633.ehu.eus:28080/static/ServidorTta/AndroidManifest.mp4";

        return testa;
    }
}
