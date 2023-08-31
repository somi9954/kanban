package models.member;

public class MemberServiceManager {

    private static MemberServiceManager instance;

    private MemberServiceManager() {}

    public static MemberServiceManager getInstance() {
        if (instance == null) {
            instance = new MemberServiceManager();
        }

        return instance;
    }

    public UsersDao usersDao() {
        return new UsersDao();
    }

    public JoinValidator joinValidator() {
        return new JoinValidator(usersDao());
    }

    public JoinService joinService() {
        return new JoinService(usersDao(), joinValidator());
    }
}