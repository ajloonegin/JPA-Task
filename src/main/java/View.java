import entity.Personnel;
import entity.Vacation;
import service.PersonnelService;
import service.VacationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        boolean isNewOp;
        Scanner sc = new Scanner(System.in);
        PersonnelService personnelService = new PersonnelService();
        VacationService vacationService = new VacationService();

        do {
            System.out.println("pls Select operation:");
            System.out.println("1: Insert personnel");
            System.out.println("2: Find personnel");
            System.out.println("3: Insert vacation of personnel");
            System.out.println("4: Find vacation of personnel");
            System.out.println("5: Update personnel");
            System.out.println("6: Update vacation of personnel");
            System.out.println("7: Delete Personnel");
            System.out.println("8 :delete vacation of personnel");
            System.out.println("9: Exit");

            int inputOp = sc.nextInt();

            switch (inputOp) {
                case 1:
                    System.out.println("Enter national code");
                    Scanner scc = new Scanner(System.in);
                    String ncNextLineOp1 = scc.nextLine();

                    if (personnelService.validateNationalCode(ncNextLineOp1)) {

                        System.out.println("Enter first name");
                        Scanner sc1 = new Scanner(System.in);
                        String fnNextLineOp1 = sc1.nextLine();

                        System.out.println("Enter last name");
                        Scanner sc2 = new Scanner(System.in);
                        String lnNextLineOp1 = sc2.nextLine();

                        System.out.println("Enter city name");
                        Scanner sc3 = new Scanner(System.in);
                        String cnNextLineOP1 = sc3.nextLine();

                        Personnel personnel = new Personnel(ncNextLineOp1, fnNextLineOp1, lnNextLineOp1, cnNextLineOP1);
                        personnelService.addPersonnel(personnel);
                        System.out.println("Personnel added");

                    }
                    break;
                case 2:
                    System.out.println("Enter id number of personnel");
                    Scanner sc4 = new Scanner(System.in);
                    Long idNextLineOp2 = sc4.nextLong();

                    Personnel personnel = personnelService.findPersonnel(idNextLineOp2);
                    System.out.println(personnel);
                    break;
                case 3:
                    System.out.println("enter id number of personnel");
                    Scanner sc5 = new Scanner(System.in);
                    Long idNextLineOp3 = sc5.nextLong();

                    System.out.println("enter date of vacation with yyyy-MM-dd format");
                    Scanner sc6 = new Scanner(System.in);
                    String dateNextLineOp3 = sc6.next();
                    SimpleDateFormat sdfOp3 = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateParseOp3;
                    try {
                        dateParseOp3 = sdfOp3.parse(dateNextLineOp3);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    Personnel p = personnelService.findPersonnel(idNextLineOp3);
                    Vacation v = new Vacation(p, dateParseOp3);
                    vacationService.addVacation(v);
                    break;
                case 4:
                    System.out.println("insert national code of personnel:");
                    Scanner sc7 = new Scanner(System.in);
                    String ncNextLineOp4 = sc7.nextLine();

                    if (personnelService.validateNationalCode(ncNextLineOp4)) {
                        List<Vacation> resultOp4 = vacationService.showVacations(ncNextLineOp4);
                        System.out.println(resultOp4);
                    }
                    break;
                case 5:
                    System.out.println("Enter id number of personnel");
                    Scanner sc8 = new Scanner(System.in);
                    Long idNextLineOp5 = sc8.nextLong();

                    System.out.println("Enter new firstName");
                    Scanner sc9 = new Scanner(System.in);
                    String fnNextLineOp5 = sc9.nextLine();

                    System.out.println("Enter new lastName");
                    Scanner sc10 = new Scanner(System.in);
                    String lnNextLineOp5 = sc10.nextLine();

                    System.out.println("Enter new cityName");
                    Scanner sc100 = new Scanner(System.in);
                    String cnNextLineOp5 = sc100.nextLine();

                    personnelService.updatePersonnel(idNextLineOp5, fnNextLineOp5, lnNextLineOp5, cnNextLineOp5);
                    break;
                case 6:
                    System.out.println("enter id number of personnel:");
                    Scanner sc11 = new Scanner(System.in);
                    Long idNextLineOp6 = sc11.nextLong();

                    System.out.println("Enter old Date");
                    Scanner sc12 = new Scanner(System.in);
                    String oldDateNextLineOp6 = sc12.nextLine();

                    SimpleDateFormat oldSdfOp6 = new SimpleDateFormat("yyyy-MM-dd");
                    Date oldDateParseOp6;
                    try {
                        oldDateParseOp6 = oldSdfOp6.parse(oldDateNextLineOp6);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Enter new Date");
                    Scanner sc13 = new Scanner(System.in);
                    String newDateNextLineOp6 = sc13.nextLine();
                    SimpleDateFormat newSdfOp6 = new SimpleDateFormat("yyyy-MM-dd");
                    Date newDateParseOp6;
                    try {
                        newDateParseOp6 = newSdfOp6.parse(newDateNextLineOp6);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    vacationService.updateVacation(idNextLineOp6, oldDateParseOp6, newDateParseOp6);
                    break;
                case 7:
                    System.out.println("Insert id number of personnel:");
                    Scanner sc14 = new Scanner(System.in);
                    Long idNextLineOp7 = sc14.nextLong();

                    personnelService.deletePersonnel(idNextLineOp7);
                    break;
                case 8:
                    System.out.println("enter id number of Vacation:");
                    Scanner sc15 = new Scanner(System.in);
                    Long idNextLineOp8 = sc15.nextLong();

                    System.out.println("Enter Date of vacation");
                    Scanner sc16 = new Scanner(System.in);
                    String dateNextLineOp8 = sc16.next();

                    SimpleDateFormat sdfOp8 = new SimpleDateFormat("yyyy-MM-dd");
                    Date DateParseOp8;
                    try {

                        DateParseOp8 = sdfOp8.parse(dateNextLineOp8);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    vacationService.deleteVacation(idNextLineOp8, DateParseOp8);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("invalid number");

            }
            System.out.println("run program again?(true/false):");
            Scanner sc17 = new Scanner(System.in);
            Boolean answer = sc17.nextBoolean();
            isNewOp = personnelService.runProgram(answer);


        } while (isNewOp);


    }
}
