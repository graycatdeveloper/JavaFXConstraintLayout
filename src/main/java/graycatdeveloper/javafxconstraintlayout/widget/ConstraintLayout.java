package graycatdeveloper.javafxconstraintlayout.widget;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.List;

public class ConstraintLayout extends AnchorPane {

    public interface Impl {

        void setConstraintWidth(String value);
        void setConstraintHeight(String value);
        void setConstraintPadding(String value);
        void setConstraintMargin(String value);
        //void setConstraintBaseline_toBaselineOf(String value);
        //void setConstraintLeft_toLeftOf(String value);
        //void setConstraintLeft_toRightOf(String value);
        //void setConstraintRight_toLeftOf(String value);
        //void setConstraintRight_toRightOf(String value);
        void setConstraintTop_toTopOf(String value);
        void setConstraintTop_toBottomOf(String value);
        void setConstraintBottom_toTopOf(String value);
        void setConstraintBottom_toBottomOf(String value);
        void setConstraintStart_toEndOf(String value);
        void setConstraintStart_toStartOf(String value);
        void setConstraintEnd_toStartOf(String value);
        void setConstraintEnd_toEndOf(String value);

        String getConstraintWidth();
        String getConstraintHeight();
        String getConstraintPadding();
        String getConstraintMargin();
        //String getConstraintBaseline_toBaselineOf();
        //String getConstraintLeft_toLeftOf();
        //String getConstraintLeft_toRightOf();
        //String getConstraintRight_toLeftOf();
        //String getConstraintRight_toRightOf();
        String getConstraintTop_toTopOf();
        String getConstraintTop_toBottomOf();
        String getConstraintBottom_toTopOf();
        String getConstraintBottom_toBottomOf();
        String getConstraintStart_toEndOf();
        String getConstraintStart_toStartOf();
        String getConstraintEnd_toStartOf();
        String getConstraintEnd_toEndOf();

        StringProperty constraintWidthProperty();
        StringProperty constraintHeightProperty();
        StringProperty constraintPaddingProperty();
        StringProperty constraintMarginProperty();
        //StringProperty constraintBaselineToBaselineOfProperty();
        //StringProperty constraintLeftToLeftOfProperty();
        //StringProperty constraintLeftToRightOfProperty();
        //StringProperty constraintRightToLeftOfProperty();
        //StringProperty constraintRightToRightOfProperty();
        StringProperty constraintTopToTopOfProperty();
        StringProperty constraintTopToBottomOfProperty();
        StringProperty constraintBottomToTopOfProperty();
        StringProperty constraintBottomToBottomOfProperty();
        StringProperty constraintStartToEndOfProperty();
        StringProperty constraintStartToStartOfProperty();
        StringProperty constraintEndToStartOfProperty();
        StringProperty constraintEndToEndOfProperty();
    }

    private double oldChildSizeSum, newChildSizeSum;

    @Override
    protected void layoutChildren() {
        final List<Pane> children = getManagedChildren();
        final HashMap<String, Pane> map = new HashMap<>();
        newChildSizeSum = 0;
        children.forEach(child -> {
            map.put("#" + child.getId(), child);
            Bounds bounds = child.getBoundsInParent();
            newChildSizeSum += bounds.getMinX() + bounds.getMaxX() + bounds.getMinY() + bounds.getMaxY() +
                    bounds.getMinZ() + bounds.getMaxZ() + bounds.getWidth() + bounds.getHeight();
        });

        for (int index = 0; index < children.size(); index++) {
            Pane child = children.get(index);

            Impl impl = (Impl) child;

            if (impl.getConstraintWidth() != null && !impl.getConstraintWidth().equals("0")) {
                final double width = getWidth() * parseSize(impl.getConstraintWidth());
                child.setPrefWidth(width);
                //child.setMinWidth(width);
                //child.setMaxWidth(width);
            }

            if (impl.getConstraintHeight() != null && !impl.getConstraintHeight().equals("0")) {
                final double height = getHeight() * parseSize(impl.getConstraintHeight());
                child.setPrefWidth(height);
                //child.setMinWidth(height);
                //child.setMaxWidth(height);
            }

            if (impl.getConstraintPadding() != null) {
                String[] values = impl.getConstraintPadding().split(" ");
                //child.setPadding(values.length == 1 ? new Insets(Double.valueOf(values[0])) :
                //new Insets(Double.valueOf(values[0]), Double.valueOf(values[1]), Double.valueOf(values[2]), Double.valueOf(values[3])));
            }

            Margin margin = new Margin();
            if (impl.getConstraintMargin() != null) {
                String[] values = impl.getConstraintMargin().split(" ");
                if (values.length == 1) {
                    margin.top = margin.end = margin.bottom = margin.start = Double.valueOf(values[0]);
                } else {
                    margin.top = Double.valueOf(values[0]);
                    margin.end = Double.valueOf(values[1]);
                    margin.bottom = Double.valueOf(values[2]);
                    margin.start = Double.valueOf(values[3]);
                }
            }

            /*if (impl.getConstraintBaseline_toBaselineOf() != null) {}
            if (impl.getConstraintLeft_toLeftOf() != null) {}
            if (impl.getConstraintLeft_toRightOf() != null) {}
            if (impl.getConstraintRight_toLeftOf() != null) {}
            if (impl.getConstraintRight_toRightOf() != null) {}*/

            constraintOf(map, impl.getConstraintTop_toTopOf(), new Constraint() {
                @Override public void pane(Pane pane) {
                    setTopAnchor(child, pane.getBoundsInParent().getMinY());
                }
                @Override public void parent() {
                    setTopAnchor(child, 0.);
                }
            });

            constraintOf(map, impl.getConstraintTop_toBottomOf(), new Constraint() {
                @Override public void pane(Pane pane) {
                    setTopAnchor(child, pane.getBoundsInParent().getMaxY());
                }
                @Override public void parent() {
                    setTopAnchor(child, 0.);
                }
            });

            constraintOf(map, impl.getConstraintBottom_toTopOf(), new Constraint() {
                @Override public void pane(Pane pane) {
                    setBottomAnchor(child, getHeight() - pane.getBoundsInParent().getMinY());
                }
                @Override public void parent() {
                    setTopAnchor(child, 0.);
                }
            });

            constraintOf(map, impl.getConstraintBottom_toBottomOf(), new Constraint() {
                @Override public void pane(Pane pane) {
                    setBottomAnchor(child, getHeight() - pane.getBoundsInParent().getMaxY());
                }
                @Override public void parent() {
                    setBottomAnchor(child, 0.);
                }
            });

            constraintOf(map, impl.getConstraintStart_toEndOf(), new Constraint() {
                @Override public void pane(Pane pane) {
                    Double value = getLeftAnchor(pane) != null ? getLeftAnchor(pane) + pane.getWidth() : pane.getBoundsInParent().getMaxX();
                    //System.out.println("Start_toEndOf: " + value);
                    setLeftAnchor(child, value);
                }
                @Override public void parent() {
                    setRightAnchor(child, 0.);
                }
            });

            constraintOf(map, impl.getConstraintStart_toStartOf(), new Constraint() {
                @Override public void pane(Pane pane) {
                    setLeftAnchor(child, pane.getBoundsInParent().getMinX());
                }
                @Override public void parent() {
                    setLeftAnchor(child, 0.);
                }
            });

            constraintOf(map, impl.getConstraintEnd_toStartOf(), new Constraint() {
                @Override public void pane(Pane pane) {
                    //System.out.println("pane.LeftAnchor[" + getLeftAnchor(pane) + "] == child.MaxX[" + child.getBoundsInParent().getMaxX());
                    //if (getLeftAnchor(pane) != null && getLeftAnchor(pane) == child.getBoundsInParent().getMaxX()) {
                    //System.out.println("Skip: " + child.getWidth());
                    //setLeftAnchor(child, getLeftAnchor(pane) - child.getWidth());
                    //child.setPrefWidth(getWidth() - getLeftAnchor(child) - getRightAnchor(pane) + pane.getWidth());
                    //} else {
                    Double value = getWidth() - pane.getBoundsInParent().getMinX();
                    System.out.println("End_toStartOf: " + value);
                    setRightAnchor(child, value);
                    //child.setPrefWidth(value);
                    //}
                }
                @Override public void parent() {
                    setLeftAnchor(child, 0.);
                }
            });

            constraintOf(map, impl.getConstraintEnd_toEndOf(), new Constraint() {
                @Override public void pane(Pane pane) {
                    setRightAnchor(child, pane.getBoundsInParent().getMinX());
                }
                @Override public void parent() {
                    setRightAnchor(child, 0.);
                }
            });

            //setTopAnchor(child, (getTopAnchor(child) != null ? getTopAnchor(child) : child.getBoundsInParent().getMinY()) + margin.top);
            //setRightAnchor(child, (getRightAnchor(child) != null ? getRightAnchor(child) : child.getBoundsInParent().getMaxX()) + margin.end);
            //setBottomAnchor(child, (getBottomAnchor(child) != null ? getBottomAnchor(child) : child.getBoundsInParent().getMaxY()) + margin.bottom);
            //setLeftAnchor(child, (getLeftAnchor(child) != null ? getLeftAnchor(child) : child.getBoundsInParent().getMaxY()) + margin.start);
        }

        super.layoutChildren();

        //System.out.println("newChildSizeSum[" + newChildSizeSum + "] != oldChildSizeSum[" + oldChildSizeSum + "]");
        if (newChildSizeSum != oldChildSizeSum) {
            oldChildSizeSum = newChildSizeSum;
            Platform.runLater(this::requestLayout);
        }
    }

    private double parseSize(String value) {
        return Double.valueOf(value.contains("%") ? "0." + value.replace("%","") : value);
    }

    private interface Constraint {
        void pane(Pane pane);
        void parent();
    }

    private final class Margin {
        private double top, end, bottom, start;
    }

    private void constraintOf(HashMap<String, Pane> map, String value, Constraint constraint) {
        if (value == null) return;
        if (value.startsWith("#")) {
            constraint.pane(map.get(value));
        } else
        if (value.equalsIgnoreCase("parent")) {
            constraint.parent();
        }
    }
}