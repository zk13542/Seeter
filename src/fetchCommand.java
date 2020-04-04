
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sep.seeter.net.message.SeetsReply;
import sep.seeter.net.message.SeetsReq;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class fetchCommand implements Command {

    CLFormatter helper;
    String Topic;

    public fetchCommand(String topic) {
        Topic = topic;
    }

    @Override
    public void execute() {

        try {
            helper.chan.send(new SeetsReq(Topic));
            SeetsReply rep = (SeetsReply) helper.chan.receive();
            System.out.print(helper.formatFetched(Topic, rep.users, rep.lines));
        } catch (IOException ex) {
            Logger.getLogger(fetchCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fetchCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
