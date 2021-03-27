package hw3.PageObjects;

public interface SelectableElement {
    void select(int what);
    boolean isSelected();
    boolean isVisible();
    String getText();
}