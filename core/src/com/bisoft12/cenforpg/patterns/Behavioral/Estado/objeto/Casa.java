package com.bisoft12.cenforpg.patterns.Behavioral.Estado.objeto;
import com.bisoft12.cenforpg.patterns.Behavioral.Estado.abstracto.EstadoCasa;
import com.bisoft12.cenforpg.patterns.Behavioral.Estado.concreto.Est_Recuperar;

public class Casa {
    private EstadoCasa objEstadoCasa;
    public Casa() {
        setEstado(new Est_Recuperar());
    }

    public void setEstado( EstadoCasa objEstadoCasa ) {
        this.objEstadoCasa = objEstadoCasa;
    }
    public String mostrar() {
        return this.objEstadoCasa.mostrar();
    }

}//
