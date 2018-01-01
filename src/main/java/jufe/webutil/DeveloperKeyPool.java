package jufe.webutil;
import java.util.Random;
import java.util.ArrayList;

public class DeveloperKeyPool {
private ArrayList<String> keys;
public DeveloperKeyPool()
{
	keys = new ArrayList<String>();
	keys.add("00a4149c4250ebe1bff5abbca39c303a");
	keys.add("b5b44d28f2ccfbeac59f6ae715369c8d");
	keys.add("7e4b55511441ee663f27ca1d20a94e3b");
	keys.add("c7f88eae86704a0d6f9b56b3c11ba566");
	keys.add("3be3d19db3ef184806837b00df8ca630");
}
public String getKey()
{
	Random ramdon = new Random();
	int index = ramdon.nextInt(keys.size());
	return keys.get(index);
}
}
