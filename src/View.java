
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
public class View {

    CLFormatter helper;
    String cmd;
    String[] rawArgs;

    public void printuseroptions(String state, String draftTopic, List<String> draftLines, BufferedReader reader) throws IOException {
        // Print user options
        if (state.equals("Main")) {
            System.out.print(helper.formatMainMenuPrompt());
        } else {  // state = "Drafting"
            System.out.print(helper.formatDraftingMenuPrompt(draftTopic, draftLines));
        }
        // Read a line of user input
        String raw = reader.readLine();
        if (raw == null) {
            throw new IOException("Input stream closed while reading.");
        }
        // Trim leading/trailing white space, and split words according to spaces
        List<String> split = Arrays.stream(raw.trim().split("\\ "))
                .map(x -> x.trim()).collect(Collectors.toList());
        String cmd = split.remove(0);  // First word is the command keyword
        String[] rawArgs = split.toArray(new String[split.size()]);
        // Remainder, if any, are arguments
        setcmd(cmd);
        setrawArgs(rawArgs);
    }

    public void setcmd(String cmd) {
        this.cmd = cmd;
    }

    public void setrawArgs(String[] rawArgs) {
        this.rawArgs = rawArgs;
    }

    public String getcmd() {
        return cmd;
    }

    public String[] getrawArgs() {
        return rawArgs;
    }

}
