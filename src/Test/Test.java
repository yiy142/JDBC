package Test;

import Service.Factory.ServiceFactory;
import Service.IAddressService;
import Service.IPersonService;

import vo.Person;
import vo.Address;

public class Test {
    public static void main(String args[]){
        Person p1 = new Person();
        p1.setPersonId(1);
        p1.setLastName("Yang");
        p1.setFirstName("Yi");

        Person p2 = new Person();
        p2.setPersonId(2);
        p2.setLastName("Ma");
        p2.setFirstName("Jack");

        Address a1 = new Address();
        a1.setAddressId(3);
        a1.setPersonId(1);
        a1.setState("CA");
        a1.setCity("SAN DIEGO");

        Address a2 = new Address();
        a2.setAddressId(4);
        a2.setPersonId(2);
        a2.setState("ZJ");
        a2.setCity("HANG ZHOU");

        IPersonService personService = ServiceFactory.getIPersonServiceInstance();
        IAddressService addressService = ServiceFactory.getIAddressServiceInstance();
        try{
            System.err.println(personService.insert(p1));
            System.err.println(personService.insert(p2));
            System.err.println(addressService.insert(a1));
            System.err.println(addressService.insert(a2));

            System.err.println("----------------------");
            for (Person vo :personService.list()){
                Address addr = personService.match(vo.getPersonId());
                System.err.println (vo);
                System.err.println(addr);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                personService.close();
                addressService.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
