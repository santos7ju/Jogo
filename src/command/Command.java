package command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

public interface Command {

	public void execute(Object[] obj) throws FileNotFoundException, IOException, ParseException;

}
