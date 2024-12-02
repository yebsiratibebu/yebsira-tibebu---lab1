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

 

    //outer -> middle (same space)
    //middle -> outer (same letter)
    //outer -> inner (same space)
    public String decrypt(String message){        
        //TODO
        System.out.println("Decrypting message: " + message); 
        String decrypt = ""; // initializes an empty stirng to hold the decrypted message
        for (int i = 0; i < message.length(); i++) { // loop through every character in message
            char character = message.charAt(i); // we find the character at index i
            int inx = rotors[2].indexOf(character); // this finds the specific character and the index from the outer circular array
            character = rotors[1].charAt(inx); // use the index to find the correspondinf character in the middle rotor
            inx = rotors[2].indexOf(character); // finds the index of the new character in the outer rotor
            character = rotors[0].charAt(inx);  // uses the index to find the correspoiding character in the inner rotor
            decrypt = decrypt + character; // this then appends the found character at the end into the empty string
            rotate(); // this rotates the circular array after each character is found
        }
        System.out.println("Decrypted result: " + decrypt); 
        return decrypt; // returns the decrypted character
    }


    // inner -> outer (same space)
    // outer -> middle (same letter)
    //middle -> outer (same space)
    public String encrypt(String message){
        //TODO
        String encrypt = ""; // initializes an empty strinf to hold the encrypted message
        for (int i = 0; i < message.length(); i++) { // loop through every charater in message
            char character = message.charAt(i); // we find the character at index i
            int inx = rotors[0].indexOf(character); // this find the specific character and the index from the the inner circular array
            character = rotors[2].charAt(inx); // use the index to find the corresponding character in the outer roto
            inx = rotors[1].indexOf(character); // find the index of the new character in the middle rotor
            character = rotors[2].charAt(inx); //uses the index to find the corresponding character in the outer roto
            encrypt = encrypt + character; // this the appends the found character at the end into the empty string
            rotate(); // this rotates the circular array after each character is found
        }
        return encrypt; // returns the encrypted character
    }
    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}

