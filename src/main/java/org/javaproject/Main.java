package org.javaproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        명언앱 명언앱 = new 명언앱();
        명언앱.실행();
    }
}

class 명언앱 {

    void 실행() {
        System.out.println("== 명언 앱 ==");
        입력();
    }

    void 등록() {
        명언 명언 = new 명언();

    }
    void 종료() {
        return ;
    }

    void 입력() {
        Scanner sc = new Scanner(System.in);
        System.out.print("명령) ");
        String str = sc.next();
        if(str == "종료") 종료();
    }

}

class 명언 {
    int id;
    String 명언;
    String 작가;
}
