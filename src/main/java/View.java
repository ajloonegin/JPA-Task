import entity.Personnel;
//import entity.Vacation;
import service.PersonnelService;
//import service.VacationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class View {
    public static void main(String[] args) {

        boolean isNewOp;

        do {

            System.out.println("pls Select operation:");
            //add personnel to db
            System.out.println("1: Insert personnel");
            //read personnel
            System.out.println("2: Find personnel");
            //add vaation to db
//            System.out.println("3: Entry vacation for a personnel");
            //read vaction
//            System.out.println("4: Show vacation of personnel");
            //update personnel list
            System.out.println("5: Update personnel");
//            System.out.println("6: Update a record of vacation table");
            System.out.println("7: Delete Personnel");
//            System.out.println("8 :delete entity of vacations");
            System.out.println("9: Exit");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter national code");
                    Scanner s1 = new Scanner(System.in);
                    String nc = s1.nextLine();
                    if(PersonnelService.validateNationalCode(nc)){
                        System.out.println("Enter first name");
                        Scanner s2 = new Scanner(System.in);
                        String fn = s2.nextLine();
                        System.out.println("Enter last name");
                        Scanner s3 = new Scanner(System.in);
                        String ln = s3.nextLine();
                        System.out.println("Enter city name");
                        Scanner s4 = new Scanner(System.in);
                        String cn = s4.nextLine();
                        Personnel p12=new Personnel(nc, fn, ln, cn);

                        PersonnelService.addPersonnel(p12);
                        System.out.println("Pesrsonnel added");


                    }
                    break;
                case 2:
                    System.out.println("Enter id number of personnel");
                    Scanner s5 = new Scanner(System.in);
                    Long inputId = s5.nextLong();

                    Personnel pf=PersonnelService.searchPersonnel(inputId);
                    System.out.println(pf);

                    break;
//                case 3:
//                    System.out.println("enter national code of personnel");
//                    Scanner s6 = new Scanner(System.in);
//                    String nc6 = s6.nextLine();
//                    if(PersonnelService.validateNationalCode(nc6)){
//                        System.out.println("enter date of vacation with yyyy-MM-dd format");
//                        Scanner s7 = new Scanner(System.in);
//                        String dateStr = s7.next();
//                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//                        Date date;
//                        try {
//                            date = sdf1.parse(dateStr);
//                        } catch (ParseException e) {
//                            throw new RuntimeException(e);
//                        }
//                        Vacation vv=new Vacation(nc6,date);
//                        if(VacationService.validateAddVacation(vv)){
//                            VacationService.addVacation(vv);
//                        }
//
//                    }
//                    break;
//                case 4:
//                    System.out.println("insert national code of personnel:");
//                    Scanner s8 = new Scanner(System.in);
//                    String nc8 = s8.nextLine();
//                    if(PersonnelService.validateNationalCode(nc8)){
//                        Set<Vacation> res=VacationService.showVacations(nc8);
//                        System.out.println(res);
//                    }
//
//                    break;
                case 5:
                    System.out.println("Enter id number of personnel");
                    Scanner s11 = new Scanner(System.in);
                    Long inputId1 = s11.nextLong();
                    System.out.println("Enter new firstName");
                    Scanner s111 = new Scanner(System.in);
                    String in2 = s111.nextLine();
                    System.out.println("Enter new lastName");
                    Scanner s12 = new Scanner(System.in);
                    String in3 = s12.nextLine();
                    PersonnelService.updatePersonnel(inputId1,in2,in3);
                    break;
//                case 6:
//                    System.out.println("Insert national code of vacation:");
//                    Scanner s14 = new Scanner(System.in);
//                    String nc14 = s14.nextLine();
//                    if(PersonnelService.validateNationalCode(nc14)) {
//                        System.out.println("Enter new National code");
//                        Scanner s15 = new Scanner(System.in);
//                        String in15 = s15.nextLine();
//                        if (PersonnelService.validateNationalCode(in15)) {
//                            System.out.println("Enter old Date");
//                            Scanner s16 = new Scanner(System.in);
//                            String dateStrin = s16.nextLine();
//
//                            SimpleDateFormat sdf12 = new SimpleDateFormat("yyyy-MM-dd");
//                            Date datee1;
//                            try {
//                                datee1 = sdf12.parse(dateStrin);
//                            } catch (ParseException e) {
//                                throw new RuntimeException(e);
//                            }
//                            System.out.println("Enter new Date");
//                            Scanner s26 = new Scanner(System.in);
//                            String dateStri = s26.nextLine();
//                            SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd");
//                            Date datee2;
//                            try {
//                                datee2 = sdf11.parse(dateStri);
//                            } catch (ParseException e) {
//                                throw new RuntimeException(e);
//                            }
//                            Set<Vacation> vu = VacationService.getVacations(nc14);
//                            for (Vacation v : vu) {
//                                System.out.println(v.getDate());
//                                System.out.println(datee1);
//                                if (v.getDate().equals(datee1)) {
//                                    VacationService.updateVacation(v, in15, datee2,datee1);
//
//                                }else{
//                                    System.out.println("nashod");
//                                }
//                            }
//
//                        }
//                    }
//                    break;
                case 7:
                    System.out.println("Insert id number of personnel:");
                    Scanner s17 = new Scanner(System.in);
                    Long inputId3 = s17.nextLong();

                    PersonnelService.deletePersonnel(inputId3);


                    break;
//                case 8:
//                    System.out.println("Insert national code of Vacation:");
//                    Scanner s18 = new Scanner(System.in);
//                    String nc18 = s18.nextLine();
//                    System.out.println("Enter Date of vacation");
//                    Scanner s27 = new Scanner(System.in);
//                    String dateString = s27.next();
//                    SimpleDateFormat sdf13 = new SimpleDateFormat("yyyy-MM-dd");
//                    Date datee3;
//                    try {
//
//                        datee3 = sdf13.parse(dateString);
//                    } catch (ParseException e) {
//                        throw new RuntimeException(e);
//                    }
//                    if(PersonnelService.validateNationalCode(nc18)){
//                        Set<Vacation> vd= VacationService.getVacations(nc18);
//                        for (Vacation v : vd) {
//                            if (v.getDate().equals(datee3)) {
//                                VacationService.deleteVacation(v,datee3);
//
//                            }
//                            else {
//                                System.out.println("this record doesn't exist");
//                            }
//                        }
//
//
//                    }
//                    break;
                case 9:
                    isNewOp=false;
                    break;
                default:
                    System.out.println("invalid number");

            }

            System.out.println("run program again?(true/false):");
            Scanner w=new Scanner(System.in);
            Boolean answer=w.nextBoolean();
            isNewOp=PersonnelService.runProgram(answer);


        } while (isNewOp == true);


    }
}
