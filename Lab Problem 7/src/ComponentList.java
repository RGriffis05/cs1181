import javax.swing.*;
import java.util.ArrayList;

/**
 * A generic list of JComponents that is itself a JPanel.
 * Maintains an internal list of components and displays them.
 *
 * @param <T> The type of JComponent to store.
 */
public class ComponentList<T extends JComponent> extends JPanel {
    private ArrayList<T> components;

    /**
     * No-argument constructor. Creates an empty ComponentList.
     */
    public ComponentList() {
        components = new ArrayList<>();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Default vertical layout
    }

    /**
     * Constructor that initializes the ComponentList with items from an ArrayList.
     *
     * @param list ArrayList of components to add initially.
     */
    public ComponentList(ArrayList<T> list) {
        this();
        for (T comp : list) {
            add(comp);
        }
    }

    /**
     * Adds a new component to the list and the panel.
     *
     * @param comp The component to add.
     */
    public void add(T comp) {
        components.add(comp);
        super.add(comp);
        revalidate();
        repaint();
    }

    /**
     * Sets the component at the specified index to a new component.
     * The panel will refresh to display the new component at the index.
     *
     * @param idx  The index to replace.
     * @param comp The new component.
     */
    public void setComponentAtIndex(int idx, T comp) {
        components.set(idx, comp);
        refreshPanel();
    }

    /**
     * Removes all components from both the internal list and the panel.
     */
    @Override
    public void removeAll() {
        components.clear();
        super.removeAll();
        revalidate();
        repaint();
    }

    /**
     * Helper method to refresh all items in the panel from the internal list.
     * Called after any update to the list that affects the display order or contents.
     */
    private void refreshPanel() {
        super.removeAll();
        for (T comp : components) {
            super.add(comp);
        }
        revalidate();
        repaint();
    }
}