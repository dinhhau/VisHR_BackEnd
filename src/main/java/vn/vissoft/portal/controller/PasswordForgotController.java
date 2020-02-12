package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.vissoft.portal.entities.PasswordResetToken;
import vn.vissoft.portal.entities.User;
import vn.vissoft.portal.repositories.TokenRepository;
import vn.vissoft.portal.services.EmailContent;
import vn.vissoft.portal.services.ExtenalService;
import vn.vissoft.portal.services.UserService;
import java.util.UUID;

@Controller
@RequestMapping("forgot-password")
public class PasswordForgotController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private EmailContent emailContent;

    @Autowired
    ExtenalService extenalService;

    @Transactional
    @PostMapping("/{email}")
    public ResponseEntity<Void> processForgotPasswordForm(@PathVariable(name = "email") String email) {

        User user = userService.findByEmail(email);

        PasswordResetToken token = new PasswordResetToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        token.setExpiryDate(30);
        token.setStatus(1);
        tokenRepository.save(token);

        String contentEmail = emailContent.mailResetPassword(token);

        String subject = "Mail cấp lại mật khẩu người dùng!";
        extenalService.mailResetPassword(contentEmail, subject, user.getEmail().split(" "));

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("findEmail/{email}")
    public ResponseEntity<User> getTimeOffByUserID(@PathVariable("email") String email) {
        User user = userService.findByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
