package graycatdeveloper.javafxconstraintlayout.widget;

import javafx.beans.property.StringProperty;

interface ConstraintLayoutImpl {

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

    void setConstraintWidth(String value);
    void setConstraintHeight(String value);

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

    String getConstraintWidth();
    String getConstraintHeight();

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

    StringProperty constraintWidthProperty();
    StringProperty constraintHeightProperty();
    
}
