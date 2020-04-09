/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.io.BufferedReader;
import java.util.*;

public class Model {

    private BufferedReader reader;
    private String drafttopic;
    private List<String> draftlines;
    private String state;
    private boolean done;

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setdraftTopic(String drafttopic) {
        this.drafttopic = drafttopic;
    }

    public void setdraftLines(List<String> draftlines) {
        this.draftlines = draftlines;
    }

    public String getdraftTopic() {
        return drafttopic;
    }

    public List<String> getdraftLines() {
        return draftlines;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public String getstate() {
        return state;
    }

    public void setdone(boolean done) {
        this.done = done;
    }

    public boolean getdone() {
        return done;
    }

}
