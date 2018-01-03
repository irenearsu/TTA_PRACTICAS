package eus.ehu.adibidea.tta.adb.Modelo;

import java.util.ArrayList;
import java.util.List;

import eus.ehu.adibidea.tta.adb.Business.TestInterface;

/**
 * Created by tta on 1/2/18.
 */

public class Test{

    public List<String> aukerak;
    public String galdera;
    public int zuzena;

    public Test(){

        aukerak = new ArrayList<String>();

    }

    public String getGaldera(){

        return galdera;
    }

    public List<String> getAukerak(){

        return aukerak;
    }

}
