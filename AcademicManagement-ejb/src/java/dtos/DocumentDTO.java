package dtos;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "Document")
//@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class DocumentDTO implements DTO {
    
    private @Getter @Setter Integer id;
    
    private @Getter @Setter String filepath;

    private @Getter @Setter String desiredName;
    
    private @Getter @Setter String mimeType;

    public DocumentDTO(int id, String filepath, String desiredName, String mimeType) {
        this.id = id;
        this.filepath = filepath;
        this.desiredName = desiredName;
        this.mimeType = mimeType;
    }
    
    public DocumentDTO(String filepath, String desiredName, String mimeType) {
        this(-1, filepath, desiredName, mimeType);
    }

    @Override
    public void clear() {
        id = null;
        filepath= null;
        desiredName= null;
        mimeType= null;

    }
}
