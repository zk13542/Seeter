
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class CommandWords {

    private Map<String, Command> com = new HashMap<>();

    public CommandWords(String topic) {
        com.put("exit", new ExitCommand());
        com.put("fetch", new fetchCommand(topic));

    }

    public Command get(String cmd) {
        return com.get(cmd);

    }

    public boolean isVaildcom(String cmd) {
        return com.containsKey(cmd);

    }
}
