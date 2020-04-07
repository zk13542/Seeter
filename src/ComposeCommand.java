/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class ComposeCommand implements Command {

    String[] args;

    public ComposeCommand(String[] args) {
        this.args[0] = args[0];
        this.args[1] = args[1];
        this.args[2] = args[2];
    }

    @Override
    public void execute() {
        args[1] = "Drafting";
        args[2] = args[0];
    }

}
