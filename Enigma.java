public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO
        String decrypt = ""; // initializes an empty stirng to hold the decrypted message
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            int inx = rotors[2].indexOf(character);
            character = rotors[1].charAt(inx);
            inx = rotors[2].indexOf(character);
            character = rotors[0].charAt(inx); 
            decrypt = decrypt + character;
            rotate();
        }
        return decrypt;
    }


    
    public String encrypt(String message){
        //TODO
        String encrypt = ""; // initializes an empty strinf to hold the encrypted message
        for (int i = 0; i < message.length(); i++) { // loop through every charater in message
            char character = message.charAt(i);
            int inx = rotors[0].indexOf(character); // this find the specific character and the index from the the inner circular array
            character = rotors[2].charAt(inx); // use the index to find the corresponding character in the outer roto
            inx = rotors[1].indexOf(character); // find the index of the outer rotor
            character = rotors[2].charAt(inx); //this correcspond the middle index with the outer
            encrypt = encrypt + character; // this puts the found character at the end into the empty string
            rotate(); // this rotates the circular array after each character is found
        }
        return encrypt;
    }
    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}

