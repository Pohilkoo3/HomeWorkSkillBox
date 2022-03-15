package Methods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

public class Command
{
    private HashSet<String> command;

    public Command() {
       initCommand();
    }

    public String getCommand(String text){
        String result = "";
        for (String element : command) {
            if (text.startsWith(element)){
                result = element;
            }
        }return result;

    }

    private void initCommand(){
        command = new HashSet<>();
            List<String> lines = null;
            try {
                lines = Files.readAllLines(Paths.get("data/command.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            command.addAll(lines);

    }


}
