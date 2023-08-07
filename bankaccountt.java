public class bankaccountt {
    import java.util.Scanner;

    public class bankingApplication {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String cname = sc.next();
            String cid = sc.next();

            BankAccount ba = new BankAccount(cname,cid);
            ba.showMenu();
        }


        public static class BankAccount {
            int balance;
            int previousTransaction;
            String customerName;
            String customerID;

            BankAccount(String cname, String cid) {
                customerName = cname;
                customerID = cid;
            }

            void deposit(int amount) {
                if (amount != 0) {
                    balance = balance + amount;
                    previousTransaction = amount;
                }
            }

            void withdraw(int amount) {
                if (amount != 0) {
                    balance = balance - amount;
                    previousTransaction = -amount;
                }
            }

            void getPreviousTransaction() {
                if (previousTransaction > 0) {
                    System.out.println("입금 = " + previousTransaction);
                } else if (previousTransaction < 0) {
                    System.out.println("출금 = " + Math.abs(previousTransaction));
                } else System.out.println("아무런 거래내역 없음");
            }

            void showMenu() {
                String option = null;
                Scanner sc = new Scanner(System.in);

                System.out.println("어서오세요 " + customerName + "님");
                System.out.println("회원님 아이디 : " + customerID);
                System.out.println("잔고확인");
                System.out.println("입금");
                System.out.println("출금");
                System.out.println("이전거래내역");
                System.out.println("종료");

                do {
                    System.out.println("============================");
                    System.out.println("거래하실 용무를 선택하세요");
                    System.out.println("============================");
                    option = sc.next();

                    switch (option) {
                        case "잔고확인":
                            System.out.println("=============");
                            System.out.println("잔고내역 : " + balance);
                            System.out.println("=============");
                            System.out.println('\n');
                            break;
                        case "입금":
                            System.out.println("============");
                            System.out.print("입금 금액을 입력하세요 : ");
                            int amount = sc.nextInt();
                            deposit(amount);
                            System.out.println('\n');
                            break;
                        case "출금":
                            System.out.println("==========");
                            System.out.print("출금 금액을 입력하세요 : ");
                            int amount2 = sc.nextInt();
                            withdraw(amount2);
                            System.out.println('\n');
                            break;
                        case "이전거래내역":
                            System.out.println("============");
                            getPreviousTransaction();
                            System.out.println("============");
                            System.out.println('\n');
                            break;
                        case "종료":
                            System.out.println("****************");
                            break;
                        default:
                            System.out.println("잘못된 입력 방식입니다. 다시 선택해주세요");
                            break;
                    }
                }while (!option.equals("종료"));

                System.out.println("저희 서비스를 이용해주셔서 감사합니다");
            }
        }
    }
}
