
import java.io.BufferedReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
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
public class View {

    CLFormatter helper;
    List<String> input;
    private static final String RESOURCE_PATH = "resources/Message";
    private final ResourceBundle strings;

    public View() {
        strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("en", "GB"));
    }

    public void printuseroptions(String state, String draftTopic, List<String> draftLines, BufferedReader reader) throws IOException {
        String pattern = strings.getString("formatDraftingMenuPrompt");
        String message = MessageFormat.format(pattern, CLFormatter.formatDrafting(draftTopic, draftLines));
        if (state.equals("Main")) {
            System.out.print(strings.getString("formatMainMenuPrompt"));
        } else {  // state = "Drafting"
            System.out.print(message);
        }
        // Read a line of user input
        String raw = reader.readLine();
        if (raw == null) {
            throw new IOException("Input stream closed while reading.");
        }
        // Trim leading/trailing white space, and split words according to spaces
        List<String> split = Arrays.stream(raw.trim().split("\\ ")).map(x -> x.trim()).collect(Collectors.toList());
        setinput(split);

    }

    public void setinput(List<String> input) {
        this.input = input;
    }

    public List<String> getinput() {
        return input;
    }

}
