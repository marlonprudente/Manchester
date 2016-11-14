/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manchester;

/**
 *
 * @author marlon
 */
public class BinaryConverter {
    
    public String BinaryToText(String binario){
        
        //byte[] encoded = binario.getBytes();
        int charCode = Integer.parseInt(binario, 2);
        String text = new Character((char)charCode).toString();
        System.out.println("print: "+text);
        return text;
    }
    
    public Integer textToBinary(){
        
        return 0;
    }
    
}
