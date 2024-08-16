
package HostelsDatabase;

public class Test {
    public static void main(String[]args){
        HostelsOP hop = new HostelsOP();
        
       
        hop.update("Peter", 402);
        hop.insert("Mungai", 625, 405, 17500);
        hop.select(401);
        
        
       
    }
    
}
