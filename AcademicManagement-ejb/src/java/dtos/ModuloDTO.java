/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lucas
 */
@NoArgsConstructor
@AllArgsConstructor
public class ModuloDTO implements DTO{
    private @Getter @Setter Integer idModulo;
    private @Getter @Setter String nameM;
    private @Getter @Setter Integer configurationCode;

    public ModuloDTO(String nameM, Integer configurationCode) {
        this(null, nameM, configurationCode);
    }
    @Override
    public void clear() {
        idModulo= null;
        nameM = null;
        configurationCode=null;
    }
    
}
