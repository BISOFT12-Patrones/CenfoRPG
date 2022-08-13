package com.bisoft12.cenforpg.patterns.Behavioral;
import com.bisoft12.cenforpg.patterns.Behavioral.Memento.CareTaker;
import com.bisoft12.cenforpg.patterns.Behavioral.Memento.Originator;

/************************************************************
 * Patrón: Memento
 * Función: retornar al personaje checkpoint antes de la pelea
 * Participantes:
 * Originator (Originator)
 * Memento (Memento)
 * Vigilante (Vigilante)
 * Gestor (Gestor_Memento)
 ************************************************************/

public class Gestor_Memento {
    private  Character _Personaje;
    private Originator _Creador;
    private CareTaker _Vigilante;

    public Gestor_Memento() {
        this._Creador = new Originator();
        this._Vigilante = new CareTaker();
    }

    public String nuevaPersonaje() {
        this._Personaje = new Character(pLevel, pExperience);
        _Creador.nuevoEstado(pLevel, pExperience);
        Actualizar_Memento();
        return "Personaje ["+pLevel+" "+pExperience+"] instanceados y 'guardados en Memento' \n";
    }

    public String actualizarPersonaje(int pLevel, int pExperience) {
        String mensaje = "Personaje  ["+this._Personaje.getLevel+" "+this._Personaje.getExperience+"]";
        mensaje += _Creador.nuevoEstado(pLevel, pExperience);
        this._Personaje.set_Level(_Creador.obtenerEstado(0));
        this._Personaje.set_Experience(_Creador.obtenerEstado(1));
        return mensaje +"\n";
    }

    /*==========================================================================
     *						 Seccion donde usamos el memento.
     ==========================================================================*/
    public String actualizarPersonajeConMemento(int pLevel, int pExperience,  int ... pArgs ) {
        int opcionales[] = pArgs;
        String mensaje = "Memento actualizado > " ;

        if(opcionales.length > 0)
            mensaje+= actualizarPersonaje (pLevel,pExperience);
        else
            mensaje+= actualizarPersonaje (pLevel,pExperience);
        Actualizar_Memento();
        return mensaje;
    }

    private void Actualizar_Memento() {
        _Vigilante.setMemento( _Creador.crearMemento() );
    }

    public void Restaurar_Memento() {
        _Creador.restaurarMemento( _Vigilante.getMemento() );
    }



}//
