/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;


/**
 *
 * @author sergi
 */
public class SoftwareDTO {
    private long id;
    private String baseVersion;
    private String name;
    
    public void reset(){
        id = 0;
        name = null;
        baseVersion = null;
    }
    
    
}
