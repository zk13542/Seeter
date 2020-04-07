
import java.io.BufferedReader;
import java.io.IOException;
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
    private String state;
    private String cmd;
    private String[] rawArgs;

    ExitCommand exit = new ExitCommand();

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

    }

    public void setViewState(String state) {
        model.setState(state);

    }

    public String getViewState() {
        return model.getState();

    }

    public void setADrafttopic(String drafttopic) {

        model.setDrafttopic(drafttopic);

    }

    public void setAReader(BufferedReader reader) {

        model.setReader(reader);

    }

    public BufferedReader getAReader() {

        return model.getReader();
    }

    public String getADraftTopic() {
        return model.getDrafttopic();
    }

    public void setAInput(String input) {

        model.setInput(input);

    }

    public String getAInput() {
        return model.getInput();
    }

    public List<String> getABodyline() {

        return model.getBodyline();
    }

    public void setABodyline(List bodyline) {

        model.setBodyline(bodyline);
    }

    public void updateView() throws IOException {

        view.printuseroptions(model.getState(), model.getDrafttopic(), model.getBodyline(), model.getReader());

    }

    public String changeStateToDrafting() {
        state = "Drafting";
        return state;
    }

    public String changeStatetoMain() {
        state = "Main";
        return state;
    }

    public void runcmd() {
        cmd = view.getcmd();
        rawArgs = view.getrawArgs();
        System.out.println(cmd);
        System.out.println(rawArgs[0]);

    }
}
