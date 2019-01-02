/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import helpers.LicenseState;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author lucas
 */
@XmlRootElement(name = "License")
@NoArgsConstructor
@AllArgsConstructor
public class LicenseDTO implements DTO{
    private @Getter @Setter Integer id;
    private @Getter @Setter String name;
    private @Getter @Setter String endDate;
    private @Getter @Setter String initDate;
    private @Getter @Setter LicenseState state;

    public LicenseDTO(String name, String endDate, String initDate, LicenseState state) {
        this(null, name, endDate, initDate, state);
    }

    @Override
    public void clear() {
        id = null;
        name = null;
        endDate = null;
        initDate = null;
        state = null;
    }

    
}
