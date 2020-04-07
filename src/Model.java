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

    private String state;
    private String drafttopic;
    private String input;
    private List<String> bodyline;
    private BufferedReader reader;

    public void setState(String state) {
        this.state = state;

    }

    public String getState() {
        return state;
    }

    public void setDrafttopic(String drafttopic) {

        this.drafttopic = drafttopic;

    }

    public String getDrafttopic() {
        return state;
    }

    public void setInput(String input) {

        this.input = input;

    }

    public String getInput() {
        return input;
    }

    public List<String> getBodyline() {
        return bodyline;
    }

    public void setBodyline(List bodyline) {

        this.bodyline = bodyline;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public BufferedReader getReader() {
        return reader;
    }

}
