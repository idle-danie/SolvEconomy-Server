package sogong.solveconomy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sogong.solveconomy.domain.Dict;
import sogong.solveconomy.dto.DictResponseDTO;
import sogong.solveconomy.service.DictService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @GetMapping
    public ResponseEntity<List<DictResponseDTO>> getAllDicts() {
        List<DictResponseDTO> dicts = dictService.getAllDicts();
        return ResponseEntity.ok(dicts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dict> getDictById(@PathVariable Long id) {
        Optional<Dict> dict = dictService.getDictById(id);
        return dict.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Dict>> searchDicts(@RequestParam String keyword) {
        List<Dict> dicts = dictService.searchDicts(keyword);
        return ResponseEntity.ok(dicts);
    }

    @GetMapping("/random")
    public ResponseEntity<Dict> getRandomDict() {
        Dict dict = dictService.getRandomDict();
        if (dict == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dict);
    }
}