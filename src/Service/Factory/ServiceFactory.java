package Service.Factory;

import Service.IAddressService;
import Service.IPersonService;
import Service.Impl.AddressServiceImpl;
import Service.Impl.PersonServiceImpl;

public class ServiceFactory {
    public static IPersonService getIPersonServiceInstance(){
        return new PersonServiceImpl();
    }

    public static IAddressService getIAddressServiceInstance(){
        return new AddressServiceImpl();
    }
}
