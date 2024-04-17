package service;

import dao.PersonnelDao;
import entity.Personnel;

import java.util.Set;

public class PersonnelService {
    static PersonnelDao personnelDao = new PersonnelDao();
    //canedit
    //cansave
    //validation
    //nationalcode format checker
    //canread-is a personnel?


    //add personnel to storage
    public static boolean addPersonnel(Personnel p) {
        try {
            personnelDao.save(p);
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }


    //search personnel of storage
    public static Personnel searchPersonnel(Long id) {
        return personnelDao.get(id);

    }

    public static void updatePersonnel(Long id, String fn, String ln) {

        personnelDao.update(id, fn, ln);

    }

    public static void deletePersonnel(Long id) {


        personnelDao.delete(id);

    }

    public static Personnel getPersonnel(Long id) {
        Personnel pers = personnelDao.get(id);

        return pers;
    }


    public static boolean validateAddPersonnel(Personnel p) {
        if (p == null) {
            System.out.println("p is null!");
            return false;
        }
        return true;

    }

    public static boolean validateNationalCode(String nc) {

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

    public static boolean runProgram(Boolean ans) {

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
