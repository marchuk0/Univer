package com.educate;

//Який принцип S.O.L.I.D. порушено? Виправте!

/*Зверніть увагу на клас EmailSender. Крім того, що за допомогою методу Send, він відправляє повідомлення,
він ще і вирішує як буде вестися лог. В даному прикладі лог ведеться через консоль.
Якщо трапиться так, що нам доведеться міняти спосіб логування, то ми будемо змушені внести правки в клас EmailSender.
Хоча, здавалося б, ці правки не стосуються відправки повідомлень. Очевидно, EmailSender виконує кілька обов'язків і,
щоб клас ні прив'язаний тільки до одного способу вести лог, потрібно винести вибір балки з цього класу.*/

//Dependency inversion principle is violated
//class EmailSender should use Logger class? that is configured elsewhere, or have Logger Interface as a constructor parameter

class Email {
    public String theme;
    public String from;
    public String to;

    public Email(String from, String to, String theme) {
        this.theme = theme;
        this.from = from;
        this.to = to;
    }
}

class EmailSender {
    System.Logger logger;

    public EmailSender(System.Logger logger) {
        this.logger = logger;
    }

    public void Send(Email email) {
        // ... sending...
        logger.log(System.Logger.Level.INFO, "Email from '" + email.from + "' to '" + email.to + "' was send");
    }
}

public class Solid2 {
    public static void Main(String[] args) {
        Email e1 = new Email("Me", "Vasya", "Who are you?");
        Email e2 = new Email("Vasya", "Me", "vacuum cleaners!");
        Email e3 = new Email("Kolya", "Vasya", "No! Thanks!");
        Email e4 = new Email("Vasya", "Me", "washing machines!");
        Email e5 = new Email("Me", "Vasya", "Yes");
        Email e6 = new Email("Vasya", "Petya", "+2");

        EmailSender es = new EmailSender();
        es.Send(e1);
        es.Send(e2);
        es.Send(e3);
        es.Send(e4);
        es.Send(e5);
        es.Send(e6);
    }
}