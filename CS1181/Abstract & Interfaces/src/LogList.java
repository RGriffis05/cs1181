import java.util.ArrayList;
import java.util.List;

public class LogList extends ArrayList<String>{
    private List<String> list = new ArrayList<>();

    public boolean addLog(String newLog){
        return this.list.add(newLog);
        // return this.add(newLog);
    }

    public void printEveryOther(){
        for(int i = 0; i < this.list.size(); i+= 2){
                System.out.println(this.list.get(i));
        }
    }

}
