package entities;

import static com.sun.tracing.dtrace.DependencyClass.GROUP;
import entities.UserGroup.GROUP;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class User implements Serializable {//Principal
    
    @Id
    protected @Getter @Setter String username;
    @NotNull(message = "Password não pode estar vazia!")
    protected @Getter @Setter String password;
    @NotNull(message = "Nome não pode estar vazia!")
    protected @Getter @Setter String name;
    @NotNull(message = "Email não pode estar vazia!")
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "{invalid.email}")
    protected @Getter @Setter String email;
    
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    @JoinColumn(name = "USERS_GROUPS")
    protected @Getter @Setter UserGroup group;

    public User(String username, String password, GROUP group, String name, String email) {
        this.username = username;
        this.password = hashPassword(password);
        this.group = new UserGroup(group, this);
        this.name = name;
        this.email = email;
    }
    
    private String hashPassword(String password) {
        char[] encoded = null;
        try {
            ByteBuffer passwdBuffer
                    = Charset.defaultCharset().encode(CharBuffer.wrap(password));
            byte[] passwdBytes = passwdBuffer.array();
            MessageDigest mdEnc = MessageDigest.getInstance("SHA-256");
            mdEnc.update(passwdBytes, 0, password.toCharArray().length);
            encoded = new BigInteger(1, mdEnc.digest()).toString(16).toCharArray();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String(encoded);
    }


    
}
