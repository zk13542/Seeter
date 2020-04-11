
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
    List<String> input;

    public void printuseroptions(String state, String draftTopic, List<String> draftLines, BufferedReader reader) throws IOException {

        if (state.equals("Main")) {
            System.out.print(CLFormatter.formatMainMenuPrompt());
        } else {  // state = "Drafting"
            System.out.print(CLFormatter.formatDraftingMenuPrompt(draftTopic, draftLines));
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
