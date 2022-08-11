package ex1;

import com.newlecture.app.console.NoticeConsole;

import java.sql.SQLException;

public class Program5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        NoticeConsole console = new NoticeConsole();
        //int page=1;

        EXIT:while (true) {

            console.printNoticeList();
            int menu = console.inputNoticeMenu();

            switch (menu) {
                case 1:  // 상세조회
                    break;
                case 2:  // 이전
                    //page--;
                    console.movePrevList();
                    break;
                case 3:  // 다음
                    //page++;
                    console.moveNextList();
                    break;
                case 4:  // 글쓰기
                    break;
                case 5:  // 종료
                    System.out.println("Bye~~");
                    break EXIT;
                default:
                    System.out.println("<<사용방법>> 메뉴는 1~4까지만 입력할 수 있습니다.");
                    break;
            }
        }
    }
}
