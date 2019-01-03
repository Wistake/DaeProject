package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SUPPORTMATERIALS ")
@NamedQueries({
    @NamedQuery(name = "SupportMaterial.all", query = "SELECT d FROM SupportMaterial d WHERE d.configuration.code = :code")
})
@NoArgsConstructor
public class SupportMaterial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter int id;
    
    private @Getter @Setter String filepath;

    private @Getter @Setter String desiredName;
    
    private @Getter @Setter String mimeType;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    private @Getter @Setter Configuration configuration;
    
    /*@ManyToOne(cascade = CascadeType.REMOVE)
    private @Getter @Setter Template template;*/

    public SupportMaterial(String filepath, String desiredName, String mimeType, Configuration configuration) {
        this.filepath = filepath;
        this.desiredName = desiredName;
        this.mimeType = mimeType;
        this.configuration = configuration;
        this.configuration.addSupportMaterials(this);
    }

    /*public SupportMaterial(String filepath, String desiredName, String mimeType, Template template) {
        this.filepath = filepath;
        this.desiredName = desiredName;
        this.mimeType = mimeType;
        this.template = template;
        this.template.addSupportMaterials(this);
    }*/
    


    
    
    
}
