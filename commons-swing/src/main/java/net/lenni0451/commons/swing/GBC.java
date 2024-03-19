package net.lenni0451.commons.swing;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * A wrapper for {@link GridBagConstraints} to make it easier to use.
 */
public class GBC {

    //Size
    public static final int RELATIVE = GridBagConstraints.RELATIVE;
    public static final int REMAINDER = GridBagConstraints.REMAINDER;
    //Fill
    public static final int HORIZONTAL = GridBagConstraints.HORIZONTAL;
    public static final int NONE = GridBagConstraints.NONE;
    public static final int BOTH = GridBagConstraints.BOTH;
    public static final int VERTICAL = GridBagConstraints.VERTICAL;
    //Anchor
    public static final int CENTER = GridBagConstraints.CENTER;
    public static final int NORTH = GridBagConstraints.NORTH;
    public static final int NORTHEAST = GridBagConstraints.NORTHEAST;
    public static final int EAST = GridBagConstraints.EAST;
    public static final int SOUTHEAST = GridBagConstraints.SOUTHEAST;
    public static final int SOUTH = GridBagConstraints.SOUTH;
    public static final int SOUTHWEST = GridBagConstraints.SOUTHWEST;
    public static final int WEST = GridBagConstraints.WEST;
    public static final int NORTHWEST = GridBagConstraints.NORTHWEST;
    public static final int PAGE_START = GridBagConstraints.PAGE_START;
    public static final int PAGE_END = GridBagConstraints.PAGE_END;
    public static final int LINE_START = GridBagConstraints.LINE_START;
    public static final int LINE_END = GridBagConstraints.LINE_END;
    public static final int FIRST_LINE_START = GridBagConstraints.FIRST_LINE_START;
    public static final int FIRST_LINE_END = GridBagConstraints.FIRST_LINE_END;
    public static final int LAST_LINE_START = GridBagConstraints.LAST_LINE_START;
    public static final int LAST_LINE_END = GridBagConstraints.LAST_LINE_END;
    public static final int BASELINE = GridBagConstraints.BASELINE;
    public static final int BASELINE_LEADING = GridBagConstraints.BASELINE_LEADING;
    public static final int BASELINE_TRAILING = GridBagConstraints.BASELINE_TRAILING;
    public static final int ABOVE_BASELINE = GridBagConstraints.ABOVE_BASELINE;
    public static final int ABOVE_BASELINE_LEADING = GridBagConstraints.ABOVE_BASELINE_LEADING;
    public static final int ABOVE_BASELINE_TRAILING = GridBagConstraints.ABOVE_BASELINE_TRAILING;
    public static final int BELOW_BASELINE = GridBagConstraints.BELOW_BASELINE;
    public static final int BELOW_BASELINE_LEADING = GridBagConstraints.BELOW_BASELINE_LEADING;
    public static final int BELOW_BASELINE_TRAILING = GridBagConstraints.BELOW_BASELINE_TRAILING;

    /**
     * Create a new GBC with the parent set to null.<br>
     * The {@code add} methods will throw an {@link IllegalStateException} if used.
     *
     * @return The new GBC
     */
    public static GBC create() {
        return create(null);
    }

    /**
     * Create a new GBC with the parent set to the specified container.
     *
     * @param parent The parent container
     * @return The new GBC
     */
    public static GBC create(final Container parent) {
        return new GBC(parent);
    }

    /**
     * Add a filler component that will fill the remaining horizontal space.<br>
     * This will align all components to the top of the container.<br>
     * The required {@code gridy} will be calculated automatically.
     *
     * @param parent The parent container
     * @return The next {@code gridy} value
     */
    public static int fillVerticalSpace(final Container parent) {
        GridBagLayout layout = (GridBagLayout) parent.getLayout();
        int gridy = 0;
        for (Component component : parent.getComponents()) {
            GridBagConstraints gbc = layout.getConstraints(component);
            if (gbc.gridy > gridy) gridy = gbc.gridy;
        }
        GBC.create(parent).gridy(++gridy).anchor(GridBagConstraints.WEST).weighty(1).fill(GridBagConstraints.HORIZONTAL).add(Box.createHorizontalGlue());
        return ++gridy;
    }


    private final Container parent;
    private final GridBagConstraints constraints;

    private GBC(final Container parent) {
        this.parent = parent;
        this.constraints = new GridBagConstraints();
    }

    /**
     * Set the {@code gridx} of the constraints.
     *
     * @param gridx The gridx
     * @return This GBC
     * @see GridBagConstraints#gridx
     */
    public GBC gridx(final int gridx) {
        this.constraints.gridx = gridx;
        return this;
    }

    /**
     * Set the {@code gridy} of the constraints.
     *
     * @param gridy The gridy
     * @return This GBC
     * @see GridBagConstraints#gridy
     */
    public GBC gridy(final int gridy) {
        this.constraints.gridy = gridy;
        return this;
    }

    /**
     * Set the {@code gridx} and {@code gridy} of the constraints.
     *
     * @param gridx The gridx
     * @param gridy The gridy
     * @return This GBC
     * @see GridBagConstraints#gridx
     * @see GridBagConstraints#gridy
     */
    public GBC grid(final int gridx, final int gridy) {
        this.constraints.gridx = gridx;
        this.constraints.gridy = gridy;
        return this;
    }

    /**
     * Set the {@code gridwidth} of the constraints.
     *
     * @param gridwidth The gridwidth
     * @return This GBC
     * @see GridBagConstraints#gridwidth
     */
    public GBC width(final int gridwidth) {
        this.constraints.gridwidth = gridwidth;
        return this;
    }

    /**
     * Set the {@code gridheight} of the constraints.
     *
     * @param gridheight The gridheight
     * @return This GBC
     * @see GridBagConstraints#gridheight
     */
    public GBC height(final int gridheight) {
        this.constraints.gridheight = gridheight;
        return this;
    }

    /**
     * Set the {@code gridwidth} and {@code gridheight} of the constraints.
     *
     * @param gridwidth  The gridwidth
     * @param gridheight The gridheight
     * @return This GBC
     * @see GridBagConstraints#gridwidth
     * @see GridBagConstraints#gridheight
     */
    public GBC size(final int gridwidth, final int gridheight) {
        this.constraints.gridwidth = gridwidth;
        this.constraints.gridheight = gridheight;
        return this;
    }

    /**
     * Set the {@code weightx} of the constraints.
     *
     * @param weightx The weightx
     * @return This GBC
     * @see GridBagConstraints#weightx
     */
    public GBC weightx(final double weightx) {
        this.constraints.weightx = weightx;
        return this;
    }

    /**
     * Set the {@code weighty} of the constraints.
     *
     * @param weighty The weighty
     * @return This GBC
     * @see GridBagConstraints#weighty
     */
    public GBC weighty(final double weighty) {
        this.constraints.weighty = weighty;
        return this;
    }

    /**
     * Set the {@code weightx} and {@code weighty} of the constraints.
     *
     * @param weightx The weightx
     * @param weighty The weighty
     * @return This GBC
     * @see GridBagConstraints#weightx
     * @see GridBagConstraints#weighty
     */
    public GBC weight(final double weightx, final double weighty) {
        this.constraints.weightx = weightx;
        this.constraints.weighty = weighty;
        return this;
    }

    /**
     * Set the {@code anchor} of the constraints.
     *
     * @param anchor The anchor
     * @return This GBC
     * @see GridBagConstraints#anchor
     */
    public GBC anchor(final int anchor) {
        this.constraints.anchor = anchor;
        return this;
    }

    /**
     * Set the {@code fill} of the constraints.
     *
     * @param fill The fill
     * @return This GBC
     * @see GridBagConstraints#fill
     */
    public GBC fill(final int fill) {
        this.constraints.fill = fill;
        return this;
    }

    /**
     * Set the {@code insets} of the constraints.
     *
     * @param insets The insets
     * @return This GBC
     * @see GridBagConstraints#insets
     */
    public GBC insets(final Insets insets) {
        this.constraints.insets = insets;
        return this;
    }

    /**
     * Set the {@code insets} of the constraints to the same value for all sides.
     *
     * @param all The value for all sides
     * @return This GBC
     * @see GridBagConstraints#insets
     */
    public GBC insets(final int all) {
        this.constraints.insets = new Insets(all, all, all, all);
        return this;
    }

    /**
     * Set the {@code insets} of the constraints to the same value for the top and bottom and the same value for the left and right.
     *
     * @param topBottom The value for the top and bottom
     * @param leftRight The value for the left and right
     * @return This GBC
     * @see GridBagConstraints#insets
     */
    public GBC insets(final int topBottom, final int leftRight) {
        this.constraints.insets = new Insets(topBottom, leftRight, topBottom, leftRight);
        return this;
    }

    /**
     * Set the {@code insets} of the constraints.
     *
     * @param top    The value for the top
     * @param left   The value for the left
     * @param bottom The value for the bottom
     * @param right  The value for the right
     * @return This GBC
     * @see GridBagConstraints#insets
     */
    public GBC insets(final int top, final int left, final int bottom, final int right) {
        this.constraints.insets = new Insets(top, left, bottom, right);
        return this;
    }

    /**
     * Set the {@code ipadx} of the constraints.
     *
     * @param ipadx The ipadx
     * @return This GBC
     * @see GridBagConstraints#ipadx
     */
    public GBC ipadx(final int ipadx) {
        this.constraints.ipadx = ipadx;
        return this;
    }

    /**
     * Set the {@code ipady} of the constraints.
     *
     * @param ipady The ipady
     * @return This GBC
     * @see GridBagConstraints#ipady
     */
    public GBC ipady(final int ipady) {
        this.constraints.ipady = ipady;
        return this;
    }

    /**
     * Set the {@code ipadx} and {@code ipady} of the constraints.
     *
     * @param ipadx The ipadx
     * @param ipady The ipady
     * @return This GBC
     * @see GridBagConstraints#ipadx
     * @see GridBagConstraints#ipady
     */
    public GBC ipad(final int ipadx, final int ipady) {
        this.constraints.ipadx = ipadx;
        this.constraints.ipady = ipady;
        return this;
    }

    /**
     * Add the specified component to the parent container with the constraints.
     *
     * @param component The component to add
     * @return This GBC
     */
    public GBC add(final Component component) {
        if (this.parent == null) throw new IllegalStateException("Cannot add component without parent");
        this.parent.add(component, this.constraints);
        return this;
    }

    /**
     * Add the specified component to the parent container with the constraints.<br>
     * The runnable will be called before the component is added to the parent container.
     *
     * @param component The component to add
     * @param runnable  The runnable to configure the component
     * @return This GBC
     */
    public GBC add(final Component component, final Runnable runnable) {
        if (this.parent == null) throw new IllegalStateException("Cannot add component without parent");
        runnable.run();
        this.parent.add(component, this.constraints);
        return this;
    }

    /**
     * Add the specified component to the parent container with the constraints.<br>
     * The consumer will be called before the component is added to the parent container.
     *
     * @param component The component to add
     * @param consumer  The consumer to configure the component
     * @param <C>       The type of the component
     * @return This GBC
     */
    public <C extends Component> GBC add(final C component, final Consumer<C> consumer) {
        if (this.parent == null) throw new IllegalStateException("Cannot add component without parent");
        consumer.accept(component);
        this.parent.add(component, this.constraints);
        return this;
    }

    /**
     * Add the component created by the supplier to the parent container with the constraints.
     *
     * @param supplier The supplier to create the component
     * @return This GBC
     */
    public GBC add(final Supplier<Component> supplier) {
        if (this.parent == null) throw new IllegalStateException("Cannot add component without parent");
        this.parent.add(supplier.get(), this.constraints);
        return this;
    }

    /**
     * @return The constraints
     */
    public GridBagConstraints get() {
        return this.constraints;
    }

}
