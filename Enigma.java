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
            int inx = rotors[2].indexOf(message.charAt(i));
            if (inx == -1) {
                break;
            }
            rotors[1].charAt(i);
            inx = rotors[1].indexOf(message.charAt(inx));
            rotors[2].charAt(inx);
            int index = rotors[2].indexOf(message.charAt(inx));
            if (index == -1) {
                break;
            }
            rotors[0].charAt(index); 
            decrypt = decrypt + index;
            rotate();
        }
        return decrypt;
    }


    
    public String encrypt(String message){
        //TODO
        String encrypt = ""; // initializes an empty strinf to hold the encrypted message
        for (int i = 0; i < message.length(); i++) { // loop through every charater in message
        int inx = rotors[0].indexOf(message.charAt(i)); // this find the specific character and the index from the the inner circular array
        if (inx == -1) {
            break;
        }
        rotors[2].charAt(i); // use the index to find the corresponding character in the outer roto
        inx = rotors[1].indexOf(message.charAt(inx)); // find the index of the outer rotor
        rotors[1].charAt(inx); // this gets the middle rotor character at that index
        int index = rotors[1].indexOf(message.charAt(inx)); // this finds the index of the same character in the middle rotor
        if (index == -1) {
            break;
        }
        rotors[2].charAt(index); //this correcspond the middle index with the outer
        encrypt = encrypt + index; // this puts the found character at the end into the empty string
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

