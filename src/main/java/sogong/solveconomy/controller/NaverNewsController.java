package sogong.solveconomy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sogong.solveconomy.service.NaverNewsService;

@RestController
@RequestMapping("/api/news")
public class NaverNewsController {

    @Autowired
    private NaverNewsService naverNewsService;

    @GetMapping("/{dictId}")
    public ResponseEntity<String> getNewsByDictId(@PathVariable Long dictId) {
        try {
            String news = naverNewsService.searchNews(dictId);
            return ResponseEntity.ok(news);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}