
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sep.seeter.net.channel.ClientChannel;
import sep.seeter.net.message.Message;

/**
 * A helper class for the current prototype {@link Client client}.  <i>E.g.</i>,
 * for formatting Command Line messages.
 */
public class CLFormatter {

    static ClientChannel chan;  // Client-side channel for talking to a Seeter server

    CLFormatter(String host, int port) {
        this.chan = new ClientChannel(host, port);
    }

    /* Interact with Seeter server */
    private void send(Message msg) throws IOException {
        this.chan.send(msg);
    }

    private Message receive() throws IOException, ClassNotFoundException {
        return this.chan.receive();
    }

    /* Following are the auxiliary methods for formatting the UI text */
    static String formatDrafting(String topic, List<String> lines) {
        StringBuilder b = new StringBuilder("#");
        b.append(topic);
        int i = 1;
        for (String x : lines) {
            b.append("\n");
            b.append(String.format("%12d", i++));
            b.append("  ");
            b.append(x);
        };
        return b.toString();
    }

}
