
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
    private String state = "Main";
    List<String> draftLines = new LinkedList<>();
    String draftTopic = null;

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

    public void updateView() throws IOException {

        view.printuseroptions(state, draftTopic, draftLines, model.getReader());

    }

    public void runcmd() {
        cmd = view.getcmd();
        rawArgs = view.getrawArgs();
        if (cmd.startsWith("exit")) {
            exit.execute();
        } else if (cmd.startsWith("compose")) {
            state = "drafting";
            draftTopic = rawArgs[0];
        } else {
            System.out.println("Could not parse command/args.");
        }
    }
}
