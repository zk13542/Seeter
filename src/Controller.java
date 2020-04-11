
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<String> input;
    private String line;
    private List<String> draftlines = new LinkedList<>();

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

        view.printuseroptions(model.getstate(), model.getdraftTopic(), draftlines, model.getReader());

    }

    public void runcmd(String state) {
        input = view.getinput();
        cmd = input.remove(0);  // First word is the command keyword
        rawArgs = input.toArray(new String[input.size()]);
        // Remainder, if any, are arguments 

        if ("exit".equals(cmd)) {
            model.setdone(true);
        } // "Main" state commands
        else if (state.equals("Main")) {
            if ("compose".startsWith(cmd) && rawArgs.length != 0) {
                docompose(rawArgs[0]);
            } else if ("fetch".startsWith(cmd) && rawArgs.length != 0) {
                fetchCommand fetch = new fetchCommand(rawArgs[0]);
                fetch.execute();
            } else if ("list".equals(cmd)) {
                ListCommand list = new ListCommand();
                list.execute();
            } else {
                System.out.println("Could not parse command/args.");
            }
        } // "Drafting" state commands
        else if (state.equals("Drafting")) {
            if ("body".startsWith(cmd) && rawArgs.length != 0) {
                dobody(rawArgs);
            } else if ("send".equals(cmd)) {
                SendCommand send = new SendCommand(model.getuser(), model.getdraftTopic(), draftlines);
                send.execute();
                model.setstate("Main");
                model.setdraftTopic(null);

            } else if ("discard".equals(cmd)) {
                model.setstate("Main");
                model.setdraftLines(null);
                model.setdraftTopic(null);

            } else {
                System.out.println("Could not parse command/args.");
            }
        }
    }

    public void docompose(String arg) {
        model.setstate("Drafting");
        model.setdraftTopic(arg);
    }

    public void dobody(String[] args) {
        line = Arrays.stream(args).collect(Collectors.joining());
        draftlines.add(line);
    }
}
