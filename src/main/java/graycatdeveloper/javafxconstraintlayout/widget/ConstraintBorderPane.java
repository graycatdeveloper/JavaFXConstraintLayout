package graycatdeveloper.javafxconstraintlayout.widget;

import javafx.beans.NamedArg;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.BorderPane;

public class ConstraintBorderPane extends BorderPane implements ConstraintLayout.Impl {

    private final StringProperty
        //constraintBaselineToBaseline = new SimpleStringProperty(),
        //constraintLeftToLeft = new SimpleStringProperty(),
        //constraintLeftToRight = new SimpleStringProperty(),
        //constraintRightToLeft = new SimpleStringProperty(),
        //constraintRightToRight = new SimpleStringProperty(),
        constraintTopToTop = new SimpleStringProperty(),
        constraintTopToBottom = new SimpleStringProperty(),
        constraintBottomToTop = new SimpleStringProperty(),
        constraintBottomToBottom = new SimpleStringProperty(),
        constraintStartToEnd = new SimpleStringProperty(),
        constraintStartToStart = new SimpleStringProperty(),
        constraintEndToStart = new SimpleStringProperty(),
        constraintEndToEnd = new SimpleStringProperty(),
        constraintWidth = new SimpleStringProperty(),
        constraintHeight = new SimpleStringProperty();

    /*@Override
    public void setConstraintBaseline_toBaselineOf(@NamedArg("constraintBaseline_toBaselineOf") String value) {
        constraintBaselineToBaseline.set(value);
    }

    @Override
    public void setConstraintLeft_toLeftOf(@NamedArg("constraintLeft_toLeftOf") String value) {
        constraintLeftToLeft.set(value);

    }

    @Override
    public void setConstraintLeft_toRightOf(@NamedArg("constraintLeft_toRightOf") String value) {
        constraintLeftToRight.set(value);

    }

    @Override
    public void setConstraintRight_toLeftOf(@NamedArg("constraintRight_toLeftOf") String value) {
        constraintRightToLeft.set(value);

    }

    @Override
    public void setConstraintRight_toRightOf(@NamedArg("constraintRight_toRightOf") String value) {
        constraintRightToRight.set(value);
    }*/

    @Override
    public void setConstraintTop_toTopOf(@NamedArg("constraintTop_toTopOf") String value) {
        constraintTopToTop.set(value);
    }

    @Override
    public void setConstraintTop_toBottomOf(@NamedArg("constraintTop_toBottomOf") String value) {
        constraintTopToBottom.set(value);
    }

    @Override
    public void setConstraintBottom_toTopOf(@NamedArg("constraintBottom_toTopOf") String value) {
        constraintBottomToTop.set(value);
    }

    @Override
    public void setConstraintBottom_toBottomOf(@NamedArg("constraintBottom_toBottomOf") String value) {
        constraintBottomToBottom.set(value);
    }

    @Override
    public void setConstraintStart_toEndOf(@NamedArg("constraintStart_toEndOf") String value) {
        constraintStartToEnd.set(value);
    }

    @Override
    public void setConstraintStart_toStartOf(@NamedArg("constraintStart_toStartOf") String value) {
        constraintStartToStart.set(value);
    }

    @Override
    public void setConstraintEnd_toStartOf(@NamedArg("constraintEnd_toStartOf") String value) {
        constraintEndToStart.set(value);
    }

    @Override
    public void setConstraintEnd_toEndOf(@NamedArg("constraintEnd_toEndOf") String value) {
        constraintEndToEnd.set(value);
    }

    @Override
    public void setConstraintWidth(String value) {
        constraintWidth.set(value);
    }

    @Override
    public void setConstraintHeight(String value) {
        constraintHeight.set(value);
    }

    /*@Override
    public String getConstraintBaseline_toBaselineOf() {
        return constraintBaselineToBaseline.get();
    }

    @Override
    public String getConstraintLeft_toLeftOf() {
        return constraintLeftToLeft.get();
    }

    @Override
    public String getConstraintLeft_toRightOf() {
        return constraintLeftToRight.get();
    }

    @Override
    public String getConstraintRight_toLeftOf() {
        return constraintRightToLeft.get();
    }

    @Override
    public String getConstraintRight_toRightOf() {
        return constraintRightToRight.get();
    }*/

    @Override
    public String getConstraintTop_toTopOf() {
        return constraintTopToTop.get();
    }

    @Override
    public String getConstraintTop_toBottomOf() {
        return constraintTopToBottom.get();
    }

    @Override
    public String getConstraintBottom_toTopOf() {
        return constraintBottomToTop.get();
    }

    @Override
    public String getConstraintBottom_toBottomOf() {
        return constraintBottomToBottom.get();
    }

    @Override
    public String getConstraintStart_toEndOf() {
        return constraintStartToEnd.get();
    }

    @Override
    public String getConstraintStart_toStartOf() {
        return constraintStartToStart.get();
    }

    @Override
    public String getConstraintEnd_toStartOf() {
        return constraintEndToStart.get();
    }

    @Override
    public String getConstraintEnd_toEndOf() {
        return constraintEndToEnd.get();
    }

    @Override
    public String getConstraintWidth() {
        return constraintWidth.get();
    }

    @Override
    public String getConstraintHeight() {
        return constraintHeight.get();
    }

    /*@Override
    public StringProperty constraintBaselineToBaselineOfProperty() {
        return constraintBaselineToBaseline;
    }

    @Override
    public StringProperty constraintLeftToLeftOfProperty() {
        return constraintLeftToLeft;
    }

    @Override
    public StringProperty constraintLeftToRightOfProperty() {
        return constraintLeftToRight;
    }

    @Override
    public StringProperty constraintRightToLeftOfProperty() {
        return constraintRightToLeft;
    }

    @Override
    public StringProperty constraintRightToRightOfProperty() {
        return constraintRightToRight;
    }*/

    @Override
    public StringProperty constraintTopToTopOfProperty() {
        return constraintTopToTop;
    }

    @Override
    public StringProperty constraintTopToBottomOfProperty() {
        return constraintTopToBottom;
    }

    @Override
    public StringProperty constraintBottomToTopOfProperty() {
        return constraintBottomToTop;
    }

    @Override
    public StringProperty constraintBottomToBottomOfProperty() {
        return constraintBottomToBottom;
    }

    @Override
    public StringProperty constraintStartToEndOfProperty() {
        return constraintStartToEnd;
    }

    @Override
    public StringProperty constraintStartToStartOfProperty() {
        return constraintStartToStart;
    }

    @Override
    public StringProperty constraintEndToStartOfProperty() {
        return constraintEndToStart;
    }

    @Override
    public StringProperty constraintEndToEndOfProperty() {
        return constraintEndToEnd;
    }

    @Override
    public StringProperty constraintWidthProperty() {
        return constraintWidth;
    }

    @Override
    public StringProperty constraintHeightProperty() {
        return constraintHeight;
    }

}
