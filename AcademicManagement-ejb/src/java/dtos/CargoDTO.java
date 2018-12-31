/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "Cargo")
//@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class CargoDTO implements DTO{
    private @Getter @Setter Integer cargoCode;
    private @Getter @Setter String name;

    public CargoDTO(String name) {
        this(null, name);
    }
   
    @Override
    public void clear() {
        cargoCode = null;
        name = null;
    }
}
