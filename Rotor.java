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
        this.rotorValues = rotorValues.charAt(rotorValues.length() - 1) + rotorValues.substring(0 , rotorValues.length() - 1); // this rotates the screen by moving the first character to the end
        if (rotorValues.charAt(0) == startChar) {
            return true;
        }
        return false;
    }
    

    public int indexOf(char c){
        //TODO
        return this.rotorValues.indexOf(c); // this returns the index character c in rotor values.
    }

    public char charAt(int idx){
        //TODO
        return this.rotorValues.charAt(idx); // this returns the character at the given index called inx
    }
}
    
