package ex1;

import com.newlecture.app.console.NoticeConsole;

import java.sql.SQLException;

public class Program5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        NoticeConsole console = new NoticeConsole();

        EXIT:while (true) {

            console.printNoticeList();
            int menu = console.inputNoticeMenu();

            switch (menu) {
                case 1:  // ����ȸ
                    break;
                case 2:  // ����
                    break;
                case 3:  // ����
                    break;
                case 4:  // �۾���
                    break;
                case 5:  // ����
                    System.out.println("Bye~~");
                    break EXIT;
                default:
                    System.out.println("<<�����>> �޴��� 1~4������ �Է��� �� �ֽ��ϴ�.");
                    break;
            }
        }
    }
}
