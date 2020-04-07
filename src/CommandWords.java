/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;

/**
 *
 * @author Admin
 */
public class CommandWords {

    String cmd;
    ExitCommand exit = new ExitCommand();

    public CommandWords(String cmd) {
        this.cmd = cmd;

    }

    public void CheckCommand() {
        if ("exit".startsWith(cmd)) {
            exit.execute();
        }
    }
}
