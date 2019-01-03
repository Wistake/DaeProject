package dtos;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "SupportMaterial")
@NoArgsConstructor
public class SupportMaterialDTO implements DTO {
    
    private @Getter @Setter Integer id;
    
    private @Getter @Setter String filepath;

    private @Getter @Setter String desiredName;
    
    private @Getter @Setter String mimeType;
    
    private @Getter @Setter Integer configurationCode;
    
    private @Getter @Setter String templateName;

    public SupportMaterialDTO(Integer id, String filepath, String desiredName, String mimeType, Integer configurationCode) {
        this.id = id;
        this.filepath = filepath;
        this.desiredName = desiredName;
        this.mimeType = mimeType;
        this.configurationCode = configurationCode;
    }

    public SupportMaterialDTO(Integer id, String filepath, String desiredName, String mimeType, String templateName) {
        this.id = id;
        this.filepath = filepath;
        this.desiredName = desiredName;
        this.mimeType = mimeType;
        this.templateName = templateName;
    }
    
    @Override
    public void clear() {
        id = null;
        filepath= null;
        desiredName= null;
        mimeType= null;
        configurationCode = null;
        templateName=null;
    }
}
