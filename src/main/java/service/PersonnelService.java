package service;

import dao.PersonnelDao;
import dao.VacationDao;
import entity.Personnel;

public class PersonnelService {
    PersonnelDao personnelDao = new PersonnelDao();


    public boolean addPersonnel(Personnel p) {
        try {
            personnelDao.insert(p);
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public Personnel findPersonnel(Long id) {
        return personnelDao.findPersonnelById(id);

    }

    public void updatePersonnel(Long id, String fn, String ln, String cn) {
        Personnel p = findPersonnel(id);

        personnelDao.update(buildPersonnel(p, fn, ln, cn));

    }

    public Personnel buildPersonnel(Personnel personnel, String fn, String ln, String cn) {
        System.out.println("Before Updation");
        System.out.println("personnel FirstName = " + personnel.getFirstName());
        System.out.println("personnel LastName = " + personnel.getLastName());
        System.out.println("personnel CityName = " + personnel.getCityName());
        personnel.setFirstName(fn);
        personnel.setLastName(ln);
        personnel.setCityName(cn);
        System.out.println("After Updation");
        System.out.println("personnel FirstName = " + personnel.getFirstName());
        System.out.println("personnel LastName = " + personnel.getLastName());
        System.out.println("personnel CityName = " + personnel.getCityName());
        return personnel;

    }

    public void deletePersonnel(Long id) {

        personnelDao.deleteById(id);

    }

    public boolean validateNationalCode(String nc) {

        int check = Character.getNumericValue(nc.charAt(9));
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(nc.charAt(i)) * (10 - i);
        }
        int remainder = sum % 11;
        if (nc == null || !nc.matches("^\\d{10}$")) {
            System.out.println("National code is not valid");
            return false;
        } else if ((remainder < 2 && check == remainder) || (remainder >= 2 && check + remainder == 11)) {

            return true;
        } else {
            System.out.println("National code is not valid");
            return false;
        }


    }

    public boolean runProgram(Boolean ans) {

        if (ans.equals(true)) {
            return true;
        } else if (ans.equals(false)) {
            return false;
        } else {
            System.out.println("input isn't true or false ");
            return false;
        }

    }

}
