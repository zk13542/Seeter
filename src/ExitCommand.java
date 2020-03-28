/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Thanks for using, see you soon.");
        System.exit(0);
    }

}
