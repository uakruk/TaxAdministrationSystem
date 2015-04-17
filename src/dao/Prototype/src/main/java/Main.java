import dao.Factory;
import logic.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admon on 27.03.2015.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        Taxpayer man = new Taxpayer();
        man.setFullName("Heinz");
        man.setTaxpayer_id(3000l);
        ObjectOfTaxation ob = new ObjectOfTaxation();
        ob.setTitle("Auto");
        CashRegister c = new CashRegister();
        c.setID(12334);
        ob.getCashRegisters().add(c);
        c.setObjectOfTaxation(ob);
        man.getObjectOfTaxations().add(ob);
        ob.setTaxpayer(man);
        Factory.getInstance().getTaxpayerDAO().addTaxpayer(man);
    }
}
