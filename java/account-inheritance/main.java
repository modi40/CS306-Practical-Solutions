class Account {
    String custname;
    int accno;

    Account() {
        custname = "Default Customer";
        accno = 1001;
    }

    Account(String custname, int accno) {
        this.custname = custname;
        this.accno = accno;
    }
}

class SavingAccount extends Account {
    double savingbal;
    double minbal;

    SavingAccount() {
        super();
        savingbal = 5000.0;
        minbal = 1000.0;
    }

    SavingAccount(String custname, int accno, double savingbal, double minbal) {
        super(custname, accno);
        this.savingbal = savingbal;
        this.minbal = minbal;
    }
}

class AccountDetail extends SavingAccount {
    double depositamt;
    double withdrawalamt;

    AccountDetail() {
        super();
        depositamt = 0.0;
        withdrawalamt = 0.0;
    }

    AccountDetail(String custname, int accno, double savingbal, double minbal, double depositamt, double withdrawalamt) {
        super(custname, accno, savingbal, minbal);
        this.depositamt = depositamt;
        this.withdrawalamt = withdrawalamt;
    }

    void displayCustomerDetails() {
        System.out.println("--- Customer Account Details ---");
        System.out.println("Customer Name: " + custname);
        System.out.println("Account Number: " + accno);
        System.out.println("Savings Balance: " + savingbal);
        System.out.println("Minimum Balance: " + minbal);
        System.out.println("Deposit Amount: " + depositamt);
        System.out.println("Withdrawal Amount: " + withdrawalamt);
        double currentBal = savingbal + depositamt - withdrawalamt;
        System.out.println("Current Total Balance: " + currentBal);
    }
}

class Main {
    public static void main(String[] args) {
        AccountDetail acc = new AccountDetail("Suresh Deshmukh", 204561, 25000.0, 2000.0, 7500.0, 3000.0);
        acc.displayCustomerDetails();
    }
}
