package baseball.constant;

public enum MenuChoice {

    RESTART("1"),
    TERMINATE("2");

    private final String menuChoice;

    MenuChoice(String menuChoice) {
        this.menuChoice = menuChoice;
    }

    public String getMenuChoice() {
        return menuChoice;
    }
}
