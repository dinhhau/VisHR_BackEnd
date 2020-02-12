package vn.vissoft.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.vissoft.portal.entities.PasswordResetToken;
import vn.vissoft.portal.entities.User;
import vn.vissoft.portal.helper.ApiResponse;
import vn.vissoft.portal.repositories.TokenRepository;
import vn.vissoft.portal.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/reset-password")
public class PasswordResetController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping("/getToken/{token}")
    public ResponseEntity<ApiResponse> getToken(@PathVariable(name = "token") String token) {
        ApiResponse object = new ApiResponse();
        PasswordResetToken token1 = tokenRepository.findByToken(token);
        object.setCode(200);
        object.setErrors(null);
        object.setStatus(true);
        object.setData(token1);
        return new ResponseEntity<ApiResponse>(object, HttpStatus.OK);
    }

    @PostMapping("/{token}")
    public ResponseEntity<Void> handlePasswordReset(@PathVariable(name = "token") String token, @RequestParam String password) {

        PasswordResetToken token1 = tokenRepository.findByToken(token);
        User user = token1.getUser();
        user.setPassword(password);
        userService.updatePassword(user);
        tokenRepository.delete(token1);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
