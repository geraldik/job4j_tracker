package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Replace Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        int id = input.askInt("Enter replacing id: ");
        tracker.replace(id, item);
        out.println("Заявка заменена");
        return true;
    }
}