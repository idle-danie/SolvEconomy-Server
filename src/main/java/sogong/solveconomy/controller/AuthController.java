package sogong.solveconomy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sogong.solveconomy.apiPayload.ApiResponse;
import sogong.solveconomy.dto.userDTO.UserRequestDTO;
import sogong.solveconomy.service.authService.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public ApiResponse<String> join(@RequestBody UserRequestDTO dto) {
        authService.join(dto);
        return ApiResponse.onSuccess("회원가입이 완료되었습니다");
    }

}
