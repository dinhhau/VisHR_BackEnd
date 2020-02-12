package vn.vissoft.portal.services;

import vn.vissoft.portal.entities.PasswordResetToken;

public interface EmailContent {

    String emailSendToApprover(
            String username,
            String fullName,
            String dateBegin,
            String dateEnd,
            String reasonName,
            String description,
            String approver,
            String approverName,
            String managerLv2
    );

    String emailSendToApprovertimework(
            String username,
            String fullName,
            String dateBegin,
            String dateEnd,
            String reasonName,
            String description,
            String approver,
            String approverName,
            String managerLv2
    );

    String emailSendToUser(String sender,
                           String approver,
                           String receiver,
                           String managerLv2,
                           String reason,
                           String approverDate,
                           String dateBegin, String dateEnd, Integer status, String description,String reasonReject);

    String emailSendToUserTimeWork(String sender,
                           String approver,
                           String receiver,
                           String managerLv2,
                           String reason,
                           String approverDate,
                           String dateBegin, String dateEnd, Integer status, String description,String reasonReject);

    String emailWarring(String username,
                        String fullName,
                        String dateBegin,
                        String dateEnd,
                        String reasonName,
                        String description);

    String mailResetPassword(PasswordResetToken token);

    String mailEvaluateKPI();
}
