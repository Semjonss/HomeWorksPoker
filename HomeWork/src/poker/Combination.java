package poker;

public enum Combination {
    ROYAL_FLUSH("Royal Flush"), STRAIGHT_FLUSH("Straight Flush"),
    FOUR_OF_A_KIND("Four of a Kind"), FULL_HOUSE("Full House"),
    FLUSH("Flush"), STRAIGHT("Straight"),
    THREE_OF_A_KIND("Three of a Kind"), TWO_PAIR("Two-pair"),
    ONE_PAIR("One-pair"), HIGH_CARD("High Card");

    private String nameCombination;

    Combination(String name) {

        this.nameCombination = name;
    }

    public String getName() {
        return nameCombination;
    }
}