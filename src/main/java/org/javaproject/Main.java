package org.javaproject;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        명언앱 명언앱 = new 명언앱();
        명언앱.실행();
    }
}

class 명언앱 {

    static int count = 1;
    List<명언> 명언집 = new ArrayList<>();
    Map<Integer, 명언> 명언집2 = new HashMap<>();
    void 실행() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("명령) ");
            String str = sc.nextLine().trim();
            switch (str) {
                case "등록" :
                    등록();
                    break;
                case "종료" :
                    종료();
                case "목록" :
                    목록();
            }
        }
    }

    void 등록() {
        Scanner sc = new Scanner(System.in);
        명언 명언 = new 명언();
        System.out.print("명언 : ");
        명언.명언 = sc.nextLine();
        System.out.print("작가 : ");
        명언.작가 = sc.nextLine();
        명언.id = count++;
        System.out.println(명언.id + "번 명언이 등록되었습니다.");
        명언집.add(명언);
        명언집2.put(명언.id, 명언);

    }
    void 종료() {
        return ;
    }

    void 입력() {
        Scanner sc = new Scanner(System.in);
        System.out.print("명령) ");
        String str = sc.nextLine().trim();
        if(str == "종료") 종료();
        if(str == "등록") 등록();
    }

    void 목록() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(Map.Entry<Integer,명언> entry : 명언집2.entrySet()) {
            System.out.println(entry.getKey() + " / " + entry.getValue().작가 + " / " + entry.getValue().명언);
        }
    }

    void 삭제() {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        명언집2.remove(i);
        System.out.println(i+"번 명언이 삭제되었습니다.");
    }

    void 수정() {

    }

}

class 명언 {
    int id;
    String 명언;
    String 작가;

    public int getId() {
        return id;
    }

    public String get명언() {
        return 명언;
    }

    public String get작가() {
        return 작가;
    }
}
