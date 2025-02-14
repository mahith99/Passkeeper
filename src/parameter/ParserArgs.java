package parameter;

import java.util.ArrayList;
import java.util.List;

public class ParserArgs {
    List<Options> optList = new ArrayList<Options>();
    List<String> argsList = new ArrayList<String>();

    public ParserArgs(String[] args){

        for (int i = 0; i < args.length; i++){
            
            switch (args[i].charAt(0)) {
                case '-': 
                    if(args[i].length() == 1 || args[i].length() > 2)
                        this.errorMessage(args[i]);
                    else {
                        if(args.length-1 != i) 
                            this.optList.add(new Options(args[i], args[i+1]));
                        else
                            this.optList.add(new Options(args[i]));
                    }
                    break;
                default: 
                    argsList.add(args[i]);
                    break;
            }
        }
        
    }

    public List<String> getArgsList(){
        return this.argsList;
    }
    
    public List<Options> getOptList() {
        return this.optList;
    }

    private void errorMessage(String arg){
        throw new IllegalArgumentException("Expected arg after length: "+arg);
    }
}
