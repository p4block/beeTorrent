package beeTorrent.utils;

import static beeTorrent.utils.ioUtils.*;

public class docUtils {

    // Help helper
    public static void printHelp(String input){
        switch(input){
            case "jar":
                ep("java -jar beeTorrent.jar -t || -p || -i");
                ep("-t tracker mode \n-p peer mode \n-i interactive shell");
                break;
            case "masterShell":
                ep("Available commands:");
                ep("(start || stop) (peer || tracker) <port>");
                ep("shell (peer || tracker)");
                ep("exit");
                ep("help");
                break;
            case "peerShell":
                ep("Available commands:");
                ep("send COMMAND PAYLOAD");
                ep("ping");
                ep("exit");
                ep("help");
                break;
            case "trackerShell":
                ep("Available commands:");
                ep("list (peers || files)");
                ep("exit");
                ep("help");
                break;
            case "start":
                ep("Missing what to start");
                break;
            case "stop":
                ep("Missing what to stop");
                break;
            case "welcome":
                ep("\n=== beeTorrent CLI launcher ===\n");
                break;
        }
    }
}
