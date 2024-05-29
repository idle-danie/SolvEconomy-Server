package sogong.solveconomy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sogong.solveconomy.apiPayload.ApiResponse;
import sogong.solveconomy.dto.memoDTO.MemoListResponseDTO;
import sogong.solveconomy.dto.memoDTO.MemoRequestDTO;
import sogong.solveconomy.service.memoService.MemoQueryService;
import sogong.solveconomy.service.memoService.MemoService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;
    private final MemoQueryService memoQueryService;

    @GetMapping("")
    public ApiResponse<MemoListResponseDTO> memo(@RequestParam(name = "uid") String uid) {
        MemoListResponseDTO dtos = memoQueryService.getMemos(uid);
        return ApiResponse.onSuccess(dtos);
    }

    @PostMapping("")
    public ApiResponse<String> write(@RequestParam(name = "uid") String uid, @RequestBody MemoRequestDTO dto) {
        memoService.write(uid, dto);
        return ApiResponse.onSuccess("저장 완료");
    }

    @DeleteMapping("{id}")
    public ApiResponse<String> delete(@RequestParam(name = "uid") String uid, @PathVariable(name = "id") Long id) {
        memoService.delete(uid, id);
        return ApiResponse.onSuccess("삭제 완료");
    }

    @PutMapping("{id}")
    public ApiResponse<String> modify(@RequestParam(name = "uid") String uid,
                       @PathVariable(name = "id") Long id,
                       @RequestBody MemoRequestDTO dto) {
        memoService.modify(uid, id, dto);
        return ApiResponse.onSuccess("수정 완료");
    }
}
