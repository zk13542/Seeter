
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sep.seeter.net.message.Publish;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
class SendCommand implements Command {

    CLFormatter helper;
    private String user;
    private String drafttopic;
    private List<String> draftlines;

    public SendCommand(String user, String drafttopic, List<String> draftlines) {
        this.user = user;
        this.drafttopic = drafttopic;
        this.draftlines = draftlines;
    }

    @Override
    public void execute() {
        try {
            helper.chan.send(new Publish(user, drafttopic, draftlines));
        } catch (IOException ex) {
            Logger.getLogger(SendCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
