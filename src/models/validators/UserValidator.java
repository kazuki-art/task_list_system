package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;

public class UserValidator {
    public static List<String> validate(User e, Boolean mailaddress_duplicate_check_flag, Boolean password_check_flag) {
        List<String> errors = new ArrayList<String>();

        String mailaddress_error = _validateMailaddress(e.getMailaddress(), mailaddress_duplicate_check_flag);
        if(!mailaddress_error.equals("")) {
            errors.add(mailaddress_error);
        }

        String name_error = _validateName(e.getName());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String password_error = _validatePassword(e.getPassword(), password_check_flag);
        if(!password_error.equals("")) {
            errors.add(password_error);
        }

        return errors;

}

    private static String _validateMailaddress(String mailaddress, Boolean mailaddress_duplicate_check_flag) {
        // TODO 自動生成されたメソッド・スタブ
        if(mailaddress == null || mailaddress.equals("")) {
            return "メールアドレスを入力してください。";
        }
        if(mailaddress_duplicate_check_flag) {
            EntityManager em = DBUtil.createEntityManager();
            long users_count = (long)em.createNamedQuery("checkRegisteredMailaddress", Long.class)
                                           .setParameter("mailaddress", mailaddress)
                                             .getSingleResult();
            em.close();
            if(users_count > 0) {
                return "入力されたメールアドレスの情報はすでに存在しています。";
            }
        }

        return "";
    }

    private static String _validateName(String name) {
        // TODO 自動生成されたメソッド・スタブ
        if(name == null || name.equals("")) {
            return "氏名を入力してください。";
        }

        return "";
    }

    private static String _validatePassword(String password, Boolean password_check_flag) {
        // TODO 自動生成されたメソッド・スタブ
        if(password_check_flag && (password == null || password.equals(""))) {
            return "パスワードを入力してください。";
        }
        return "";
    }
    }
