
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Controller {

    private Model model;
    private View view;
    private String cmd;
    private String[] rawArgs;

    ExitCommand exit = new ExitCommand();

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

    }

    public void setAReader(BufferedReader reader) {

        model.setReader(reader);

    }

    public BufferedReader getAReader() {

        return model.getReader();
    }

    public void View() throws IOException {

        view.printuseroptions(model.getstate(), model.getdraftTopic(), model.getdraftLines(), model.getReader());

    }

    public void runcmd(String state) {
        cmd = view.getcmd();
        rawArgs = view.getrawArgs();
        if (cmd != null) {
            if ("exit".startsWith(cmd)) {

            } // "Main" state commands
            else if (state.equals("Main")) {
                if ("compose".startsWith(cmd)) {

                } else if ("fetch".startsWith(cmd)) {

                } else if ("list".startsWith(cmd)) {

                } else {
                    System.out.println("Could not parse command/args.");
                }
            } // "Drafting" state commands
            else if (state.equals("Drafting")) {
                if ("body".startsWith(cmd)) {
                    // Add a seet body line

                } else if ("send".startsWith(cmd)) {

                } else if ("discard".startsWith(cmd)) {

                } else {
                    System.out.println("Could not parse command/args.");
                }
            } else {
                System.out.println("Could not parse command/args.");
            }
        } else {
            System.out.println("Could not parse command/args.");
        }
    }
}
