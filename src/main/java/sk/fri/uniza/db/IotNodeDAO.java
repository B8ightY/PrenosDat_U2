package sk.fri.uniza.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import sk.fri.uniza.model.Field;
import sk.fri.uniza.model.HouseHold;
import sk.fri.uniza.model.IotNode;

import java.util.List;

public class IotNodeDAO extends AbstractDAO<IotNode> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public IotNodeDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public IotNode create(IotNode iotNode) {
        // Skusil som aj vytvorit novy objekt IotNode a ulozit data pomocou jeho metod
        /*System.out.println("Name: " + _iotNode.getName());
        System.out.println("Household: " + _iotNode.getHouseHold().getCity());

        HouseHold houseHold = currentSession().get(HouseHold.class, _iotNode.getHouseHold().getId());

        IotNode iotNode = new IotNode();
        iotNode.setName(_iotNode.getName());
        iotNode.setHouseHold(houseHold);*/

        currentSession().save(iotNode);
        return iotNode;
    }

    public IotNode findById(Long id) {
        return get(id);
    }

    public IotNode update(IotNode iotNode) {
        return (IotNode) currentSession().merge(iotNode);
    }

    public List<IotNode> findByHouseHold(Long houseHoldId) {
        return list(namedQuery("IotNode_findByHouseHoldId"));
    }

    public List<IotNode> allIotNodes() {
        return list(namedQuery("IotNode_All"));
    }
}
