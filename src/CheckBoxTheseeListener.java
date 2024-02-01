import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Cette classe implémente l'interface ItemListener pour gérer les événements
 * liés à une JCheckBox.
 * Elle prend en paramètre la JCheckBox de la sortie, qui sera cochée ou
 * décochée.
 */
public class CheckBoxTheseeListener implements ItemListener {

    JCheckBox checkBoxSortie;

    public CheckBoxTheseeListener(JCheckBox checkBoxSortie) {
        this.checkBoxSortie = checkBoxSortie;
    }

    /**
     * La méthode vérifie si un élément a été sélectionné.
     * Si oui, elle décoche la case de la sélection de la sortie.
     * 
     * @param itemEvent
     */
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
            this.checkBoxSortie.setSelected(false);
        }
    }
}