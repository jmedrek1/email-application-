package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName, lastName, password, department, email, altEmail, companySuffix = "examplecompany.com";
    private int mailboxCapacity = 500, defaultPasswordLength = 10;

    //constructor to receive first and last
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //call method asking for department - return department
        this.department = setDepartment();

        //call method that return random pwd
        this.password = randomPassword(this.defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //ask for department
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {return "sales";}
        else if (depChoice == 2) {return "dev";}
        else if (depChoice == 3) {return "acct";}
        else {return "none";}
    }

    //generate random pwd
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    //set alternate email
    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    //change pwd
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {return mailboxCapacity;}
    public String getAltEmail() {return altEmail;}
    public String getPassword() {return password;}

    public void showInfo() {
        System.out.println("DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb");
    }

}
