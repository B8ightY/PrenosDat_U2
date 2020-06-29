package sk.fri.uniza.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;

@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "IotNode_findByHouseHoldId",
                query = "from IotNode where household_id = :id"),
        @org.hibernate.annotations.NamedQuery(
                name = "IotNode_All",
                query = "from IotNode"),
})

@Entity
public class IotNode {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotEmpty
    private String Name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "household_id", nullable = false)
    private HouseHold houseHold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public HouseHold getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(HouseHold houseHold) {
        this.houseHold = houseHold;
    }
}
