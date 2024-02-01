import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Cette classe implémente une gestion d'événements sur la case de la sortie du
 * labyrinthe.
 * Elle prend en paramètre une case à cocher (JCheckBox) représentant la sortie
 * du labyrinthe.
 */
public class CheckBoxSortieListener implements ItemListener {
    JCheckBox checkBoxThesee;

    public CheckBoxSortieListener(JCheckBox checkBoxThesee) {
        this.checkBoxThesee = checkBoxThesee;
    }

    /**
     * Désélectionne la case à cocher "checkBoxThesee" si l'état de l'élément change
     * pour être sélectionné.
     * 
     * @param itemEvent
     */
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
            this.checkBoxThesee.setSelected(false);
        }
    }
}
