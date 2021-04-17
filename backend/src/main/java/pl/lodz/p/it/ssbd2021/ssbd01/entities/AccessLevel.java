package pl.lodz.p.it.ssbd2021.ssbd01.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Typ Access level reprezentujący poziom dostępu konta aplikacji.
 */
@Entity
@Table(name = "access_levels", uniqueConstraints = {
        @UniqueConstraint(name = "acc_lvl_level_account_pair_unique", columnNames = {"level", "account_id"})})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "level", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
        @NamedQuery(name = "AccessLevel.findAll", query = "SELECT a FROM AccessLevel a"),
        @NamedQuery(name = "AccessLevel.findById", query = "SELECT a FROM AccessLevel a WHERE a.id = :id"),
        @NamedQuery(name = "AccessLevel.findByLevel", query = "SELECT a FROM AccessLevel a WHERE a.level = :level"),
        @NamedQuery(name = "AccessLevel.findByActive", query = "SELECT a FROM AccessLevel a WHERE a.active = :active"),
        @NamedQuery(name = "AccessLevel.findByVersion", query = "SELECT a FROM AccessLevel a WHERE a.version = :version"),
        @NamedQuery(name = "AccessLevel.findByCreationDateTime", query = "SELECT a FROM AccessLevel a WHERE a.creationDateTime = :creationDateTime"),
        @NamedQuery(name = "AccessLevel.findByModificationDateTime", query = "SELECT a FROM AccessLevel a WHERE a.modificationDateTime = :modificationDateTime")})
public class AccessLevel extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "access_levels_generator")
    @SequenceGenerator(name = "access_levels_generator", sequenceName = "access_levels_seq", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Basic(optional = false)
    @Column(name = "active", nullable = false)
    private Boolean active;

    @Basic(optional = false)
    @Column(name = "level", nullable = false, length = 32, updatable = false, insertable = false)
    private String level;

    /**
     * Tworzy nową instancję klasy Access level.
     */
    public AccessLevel() {
    }

    /**
     * Tworzy nową instancję klasy AccessLevel.
     *
     * @param level            nazwa poziomu dostepu
     * @param active           status
     */
    public AccessLevel(String level, Boolean active) {
        this.level = level;
        this.active = active;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.ssbd2021.ssbd01.entities.AccessLevel[ id=" + id + " ]";
    }

}