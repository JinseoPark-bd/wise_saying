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
            String[] command = str.split("\\?", 2);
            switch (command[0]) {
                case "등록" :
                    등록();
                    break;
                case "종료" :
                    종료();
                    return;
                case "목록" :
                    목록();
                    break;
                case "삭제" :
                    삭제(command[1]);
                    break;
                case "수정" :
                    수정(command[1]);
                    break;
            }
        }
    }

    void 등록() {
        Scanner sc = new Scanner(System.in);
        System.out.print("명언 : ");
        String 명언1 = sc.nextLine();
        System.out.print("작가 : ");
        String 작가1 = sc.nextLine();
        명언 명언 = new 명언(count++,명언1, 작가1);

        System.out.println(명언.getId() + "번 명언이 등록되었습니다.");
        명언집.add(명언);
        명언집2.put(명언.getId(), 명언);

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
            System.out.printf("%d / %s / %s\n",entry.getKey(), entry.getValue().get작가(), entry.getValue().get명언());
        }
    }

    void 삭제(String command) {
        String[] commands = command.split("=",2);
        int id = Integer.parseInt(commands[1]);
        if(!명언집2.containsKey(id)) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return ;
        }
        명언집2.remove(id);
        System.out.println(id+"번 명언이 삭제되었습니다.");
    }

    void 수정(String command) {
        Scanner sc = new Scanner(System.in);
        String[] commands = command.split("=",2);
        int id = Integer.parseInt(commands[1]);
        if(!명언집2.containsKey(id)) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return ;
        }
        System.out.printf("명언(기존) : %s\n", 명언집2.get(id).get명언());
        System.out.print("명언 : ");
        String 명언 = sc.nextLine();
        System.out.printf("작가(기존) : %s\n", 명언집2.get(id).get작가());
        System.out.print("작가 : ");
        String 작가 = sc.nextLine();
        명언집2.put(id,new 명언(id,명언,작가));
    }
}

class 명언 {
    private int id;
    private String 명언;
    private String 작가;

    public 명언() {

    }
    public 명언(int id, String 명언, String 작가) {
        this.id = id;
        this.명언 = 명언;
        this.작가 = 작가;
    }

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
