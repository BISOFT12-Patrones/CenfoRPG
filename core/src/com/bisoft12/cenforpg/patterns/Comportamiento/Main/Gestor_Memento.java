package com.bisoft12.cenforpg.patterns.Comportamiento.Main;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.CareTaker;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.Originator;
import com.bisoft12.cenforpg.patterns.Comportamiento.Patron_Memento.objeto.PersonajeOb;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.Gestor.FabricaCharacter;
import com.bisoft12.cenforpg.patterns.Creational.FabricaAbstracta.ProductoAbstracto.Character;

/************************************************************
 * Patrón: Memento
 * Función: retornar al personaje checkpoint antes de la pelea
 * Participantes:
 * Originator (Originator)
 * Memento (Memento)
 * Vigilante (Vigilante)
 * Objeto (PersonajeOb)
 * Gestor (Gestor_Memento)
 ************************************************************/

public class Gestor_Memento {
    private Character _Personaje;
    private PersonajeOb personajeOb;
    private Originator _Creador;
    private CareTaker _Vigilante;
    private FabricaCharacter gestorPlayer = new FabricaCharacter();

    public Gestor_Memento() {
        this._Creador = new Originator();
        this._Vigilante = new CareTaker();
    }

    public void nuevoPersonaje() {
        this._Personaje = gestorPlayer.getCharacter();
       _Creador.nuevoEstado(_Personaje); //Estado de la Casa "Recuperacion"
        Actualizar_Memento();
    }
    public void actualizarPersonaje(Character pCharacter) {
        this.personajeOb.setCharacter(_Creador.obtenerEstado(0));
    }

    /*==========================================================================
     *						 Seccion donde usamos el memento.
     ==========================================================================*/
    public void actualizarPersonajeConMemento(Character pCharacter) {
        Actualizar_Memento();
    }

    private void Actualizar_Memento() {
        _Vigilante.setMemento( _Creador.crearMemento(personajeOb));
    }

    public void Restaurar_Memento() {
        _Creador.restaurarMemento( _Vigilante.getMemento());
    }



}//
