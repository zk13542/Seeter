
import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import sep.seeter.net.message.TopicsReply;
import sep.seeter.net.message.TopicsReq;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class ListCommand implements Command {

    CLFormatter helper;

    public ListCommand() {
    }

    @Override
    public void execute() {
        try {
            helper.chan.send(new TopicsReq());
            TopicsReply rep = (TopicsReply) helper.chan.receive();
            System.out.print(formatTopics(rep.topics));
        } catch (IOException ex) {
            Logger.getLogger(ListCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String formatTopics(Set<String> topics) {
        StringBuilder b = new StringBuilder("Topic list: #");
        for (String topic : topics) {
            b.append("\n");
            b.append(String.format("%12s", topic));
            b.append("  ");
        };
        b.append("\n");
        return b.toString();
    }

}
