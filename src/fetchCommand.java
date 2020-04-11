
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
            System.out.print(formatFetched(Topic, rep.users, rep.lines));
        } catch (IOException ex) {
            Logger.getLogger(fetchCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fetchCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String formatFetched(String topic, List<String> users, List<String> fetched) {
        StringBuilder b = new StringBuilder("Fetched: #");
        b.append(topic);
        Iterator<String> it = fetched.iterator();
        for (String user : users) {
            b.append("\n");
            b.append(String.format("%12s", user));
            b.append("  ");
            b.append(it.next());
        };
        b.append("\n");
        return b.toString();
    }
}
