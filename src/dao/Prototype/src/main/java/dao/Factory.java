package dao;

import logic.AdditionalCharges;
import logic.License;
import logic.ObjectOfTaxation;

/**
 * Created by Admon on 05.04.2015.
 */
public class Factory {
    private static TaxpayerDAO taxpayerDAO = null;
    private static TaxDAO taxDAO = null;
    private static LicenseDAO licenseDAO = null;
    private static Factory instance = null;
    private static ObjectOfTaxationDAO objectOfTaxationDAO  = null;
    private static PropertyDAO propertyDAO = null;
    private static AuditDAO auditDAO = null;
    private static ContactDAO contactDAO = null;
    private static AdditionalChargesDAO additionalChargesDAO = null;
    private static CashRegisterDAO cashRegisterDAO = null;
    private static PaymentDAO paymentDAO = null;

    public static PaymentDAO getPaymentDAO() {
        if (paymentDAO == null){
            paymentDAO = new PaymentDAOImplem();
        }
        return paymentDAO;
    }

    public static ReferralDAO getReferralDAO() {
        if (referralDAO == null){
            referralDAO = new ReferralDAOImplem();
        }
        return referralDAO;
    }

    private static ReferralDAO referralDAO = null;
    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public TaxpayerDAO getTaxpayerDAO(){
        if (taxpayerDAO == null){
            taxpayerDAO = new TaxpayerDAOImplem();
        }
        return taxpayerDAO;
    }

    public TaxDAO getTaxDAO(){
        if (taxDAO == null){
            taxDAO = new TaxDAOImplem();
        }
        return taxDAO;
    }

    public LicenseDAO getLicenseDAO(){
        if (licenseDAO == null){
            licenseDAO = new LicenseDAOImplem();
        }
        return licenseDAO;
    }

    public ObjectOfTaxationDAO getObjectOfTaxationDAO(){
        if (objectOfTaxationDAO == null){
            objectOfTaxationDAO = new ObjectOfTaxationDAOImplem();
        }
        return objectOfTaxationDAO;
    }

    public PropertyDAO getPropertyDAO(){
        if (propertyDAO == null){
            propertyDAO = new PropertyDAOImplem();
        }
        return propertyDAO;
    }

    public AuditDAO getAuditDAO(){
        if (auditDAO == null){
            auditDAO = new AuditDAOImplem();
        }
        return auditDAO;
    }

    public ContactDAO getContactDAO(){
        if (contactDAO == null){
            contactDAO = new ContactDAOImplem();
        }
        return contactDAO;
    }

    public AdditionalChargesDAO getAdditionalChargesDAO(){
        if (additionalChargesDAO == null){
            additionalChargesDAO = new AdditionalChargesDAOImplem();
        }
        return additionalChargesDAO;
    }

    public CashRegisterDAO getCashRegisterDAO(){
        if (cashRegisterDAO == null){
            cashRegisterDAO = new CashRegisterDAOImplem();
        }
        return cashRegisterDAO;
    }
}
