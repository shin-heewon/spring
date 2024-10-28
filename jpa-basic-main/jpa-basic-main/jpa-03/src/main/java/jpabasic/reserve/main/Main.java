package jpabasic.reserve.main;

import jakarta.persistence.EntityExistsException;
import jpabasic.reserve.app.*;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.LocalDateTime;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static NewUserService newUserService = new NewUserService();
    private static GetUserService getUserService = new GetUserService();
    private static ChangeNameService changeNameService = new ChangeNameService();
    private static RemoveUserService removeUserService = new RemoveUserService();

    
    public static void main(String[] args) throws IOException {
         EMF.init();
      // 명령어 : new, get, change name, remove, exit 이용해서 어플리케이션 완성하기
        System.out.println("메뉴 입력하기");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String command = bf.readLine();
        String line;

        switch (command){
            case "new":{
                System.out.println("이메일과 이름을 입력하세요.");
                line = bf.readLine(); handleNew(line);
            }
            case "get":{
                System.out.println("찾고자 하는 user 이메일을 입력하세요.");  line = bf.readLine(); handleGet(line);
            }
            case "change name":{
                System.out.println("이름을 변경할 user 이메일과 변경하고자 하는 이름을 입력하세요.");
                line = bf.readLine(); handleChangeName(line);
            }
            case "remove":{
                System.out.println("삭제할 이메일을 입력하세요.");
                line = bf.readLine(); handleRemove(line);
            }
            case "exit":{
                EMF.close();
                break;
            }
        }

    }

    private static void handleNew(String line) {
        String[] v = line.substring(0).split(" ");
        User u = new User(v[0], v[1], LocalDateTime.now());
        try {
            newUserService.saveNewUser(u);
            logger.info("새 사용자 저장: {}", u);
        } catch (EntityExistsException e) {
            logger.info("사용자가 이미 존재함: {}", u.getEmail());
        }
    }

    private static void handleGet(String line) {

        getUserService.getUser(line);
    }

    private static void handleChangeName(String line) {
        String[] v = line.substring(0).split(" ");
        changeNameService.changeName(v[0], v[1]);

    }

    private static void handleRemove(String email) {
        removeUserService.removeUser(email);
    }
}
