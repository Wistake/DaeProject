    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/*@Table(name="CONFIGURATIONSTATE")
@NamedQueries({
    @NamedQuery(name = "ConfigurationState.all",
            query = "SELECT cs FROM Student cs ORDER BY cs.name")})*/

public enum ConfigurationState {
    ACTIVE, INACTIVE, SUSPENCE;
    
}
