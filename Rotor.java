public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO
        this.rotorValues = this.rotorValues.substring(1) + this.rotorValues.charAt(0); // this rotates the screen by moving the first character to the end
        return this.rotorValues.charAt(0) == this.startChar; // this returns that the value would be true if the first character mathcing the the first starting character basically this code removes the first character and adds it to the end of the string          
    }
    

    public int indexOf(char c){
        //TODO
    }

    public char charAt(int idx){
        //TODO
    }
}
    
