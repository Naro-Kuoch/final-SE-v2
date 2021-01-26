import java.util.*;

public class Contact {
    String firstName, LastName;
    String cid;
    ArrayList<Telephone> phones = new ArrayList<Telephone>();

    public Contact() {

    }

    void addTelephone() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many telephones to add?: ");
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            System.out.printf("Phone number %d: ", i + 1);
            String phone = sc.nextLine();
            System.out.print("Use for: ");
            String purpose = sc.nextLine();
            phones.add(new Telephone(phone, purpose));
        }
    }

    void listTelephone() {
        for (int i = 0; i < phones.size(); i++) {
            System.out.printf("Telephone for %s: %s\n", phones.get(i).useFor, phones.get(i).tel);
        }
    }

    void updateTelephone(String tel) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).tel.equals(tel)) {
                System.out.print("Enter new telephone: ");
                phones.get(i).tel = sc.nextLine();
                System.out.print("Use for: ");
                phones.get(i).useFor = sc.nextLine();
                return;
            }
        }
        System.out.println("This telephone doesn't exit !");
    }

}

class Telephone {
    String tel, useFor;

    public Telephone() {

    }

    public Telephone(String tel, String purpose) {
        this.tel = tel;
        this.useFor = purpose;
    }
}

class ContactList {
    ArrayList<Contact> contacts = new ArrayList<Contact>();
    int id = 0;

    public ContactList() {

    }

    void addContact() {
        id++;
        Scanner sc = new Scanner(System.in);
        Contact c = new Contact();
        System.out.print("\nFirstname: ");
        c.firstName = sc.nextLine();
        System.out.print("Lastname: ");
        c.LastName = sc.nextLine();
        c.addTelephone();
        c.cid = "" + id;
        contacts.add(c);
    }

    void listContacts() {
        System.out.println("\n***List of all Contacts***");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("contact ID: " + contacts.get(i).cid);
            System.out.println("Firstname: " + contacts.get(i).firstName);
            System.out.println("Lastname: " + contacts.get(i).LastName);
            contacts.get(i).listTelephone();

        }
    }

    boolean searchContactID(String id) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).cid.equals(id))
                return true;
        }
        return false;
    }

    void UpdateContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter contact ID: ");
        String id = sc.nextLine();
        if (!searchContactID(id))
            System.out.println("This contact doesn't exist !");
        else{
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).cid.equals(id)) {
                    System.out.print("New firstname: ");
                    contacts.get(i).firstName = sc.nextLine();
                    System.out.print("New lastname: ");
                    contacts.get(i).LastName = sc.nextLine();
                    System.out.print("Enter telphone you want to update: ");
                    contacts.get(i).updateTelephone(sc.nextLine());
                    break;
                }
            }
        }

    }

    void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter contact ID: ");
        String id = sc.nextLine();
        for (int i = 0; i < contacts.size(); i++) {
            contacts.remove(i);
            System.out.println("Contact is delected !");
            break;
        }
        System.out.println("The contact doesn't exit !");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean t = true;
        ContactList cont = new ContactList();
        int opt;
        while (t) {
            System.out.println("1. Add contact\n" + "2. Update contact\n" + "3. Delete contact\n"
                    + "4. List all contacts\n" + "5. exit the program");
            System.out.print("Enter your option: ");
            opt = sc.nextInt();
            if (opt == 1) {
                cont.addContact();
            } else if (opt == 2) {
                cont.UpdateContact();
            } else if (opt == 3) {
                cont.deleteContact();
            } else if (opt == 4) {
                cont.listContacts();
            } else if (opt == 5) {
                t = false;
                System.out.println("You left the program !");
            }
        }

    }
}