import java.util.Stack;

public class UndoManager {
    Stack<Runnable> actions = new Stack<>();

    public void addUndoAction(Runnable action) {
        actions.push(action);
    }

    public void undoLastAction() {
        if (!actions.isEmpty()) {
            Runnable action = actions.pop();
            action.run();
        } else {
            System.out.println("No action to undo.");
        }
    }
}
